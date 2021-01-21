package io.github.willqi.nvs;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerQuitEvent;
import cn.nukkit.event.server.DataPacketReceiveEvent;
import cn.nukkit.event.server.DataPacketSendEvent;
import cn.nukkit.level.GameRules;
import cn.nukkit.network.protocol.*;
import cn.nukkit.plugin.PluginBase;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;
import io.github.willqi.nvs.versions.*;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class NVSAPIBase extends PluginBase implements Listener, NVSAPI {

    private final Map<UUID, Integer> oldProtocolOnlinePlayers = new HashMap<>();

    private static final Map<Integer, ProtocolHandler> protocolVersionSupport = new HashMap<>();
    private static final Set<Integer> supportedProtocolVersions = new HashSet<>();

    private static final ProtocolHandler LATEST_OLD_PROTOCOL_HANDLER;
    private static final ProtocolHandler LATEST_PROTOCOL_HANDLER = new ProtocolHandlerLatest();

    private static final List<SendPacket> packetsToSend = new CopyOnWriteArrayList<>();

    public static class SendPacket {

        private DataPacket packet;
        private Player player;

        public SendPacket (DataPacket p, Player player) {
            packet = p;
            this.player = player;
        }
    }

    private static Thread delayPacketThread;

    // TODO: Two problems.
    // 1) The client does not like being send the creative content packet how 1.16.200 does it
    // 2) 1.16.20 packets can't even be converted because it fails to parse the packet.
    // Potential solution to 2) Override all packets (oh geez...) and call registerPackets with your own. Failing to parse is OKAY. (Can lead to problems down the line, but this really shouldn't be a problem except for hacked clients... (or just the vanilla client being stupid) ugh)
    static {

        delayPacketThread = new Thread(() -> {

            while (true) {
                if (packetsToSend.size() > 0) {
                    SendPacket data = packetsToSend.get(0);
                    if (data.packet.pid() != ProtocolInfo.CREATIVE_CONTENT_PACKET) {
                        ((NVSAPIBase) getAPI()).getLogger().info("Now sending: " + data.packet.toString());
                        data.player.dataPacket(data.packet);
                    }
                    packetsToSend.remove(0);
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
    }

    private static NVSAPI instance;

    private static final int CURRENT_PROTOCOL_SUPPORT = 422;

    static {

        supportedProtocolVersions.add(408); // 1.16.20 - 1.16.40
        protocolVersionSupport.put(408, new ProtocolHandlerV408());

        supportedProtocolVersions.add(419); // 1.16.100
        protocolVersionSupport.put(419, new ProtocolHandlerV419());

        protocolVersionSupport.put(422, new ProtocolHandlerV422()); // 1.16.200

        LATEST_OLD_PROTOCOL_HANDLER = protocolVersionSupport.get(408);
    }

    @Override
    public void onEnable () {
        if (CURRENT_PROTOCOL_SUPPORT < ProtocolInfo.CURRENT_PROTOCOL) {
            getLogger().critical(String.format("This version does not yet support protocol version v%s. Please update, contact the developer, or submit a issue at our github repository.", ProtocolInfo.CURRENT_PROTOCOL));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        instance = this;
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("NukkitVersionSupport has been loaded.");

        delayPacketThread.start();

    }

    @Override
    public void onDisable () {
        oldProtocolOnlinePlayers.clear();
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onSendPacket (final DataPacketSendEvent event) {
//        if (event.getPacket().pid() == ProtocolInfo.SET_ENTITY_DATA_PACKET) {
//            getLogger().info("BLOCKED");
//            return;
//        }
        if (event.getPacket().pid() == ProtocolInfo.START_GAME_PACKET) {
            getLogger().info("START GAME PACKET =  " + event.getPacket().toString());
            GameRules rules = ((StartGamePacket)event.getPacket()).gameRules;
        }
        if (oldProtocolOnlinePlayers.containsKey(event.getPlayer().getUniqueId()) && !(event.getPacket() instanceof ConvertedProtocolPacket) && ProtocolHandlerLatest.isPacketSupported(event.getPacket())) {
            event.setCancelled(true);
            try {
                DataPacket packet = convertPacketToPlayerVersion(event.getPlayer(), event.getPacket());
                packet.encode();
                //getLogger().info(packet + " was sent.");
                packetsToSend.add(new SendPacket(packet, event.getPlayer()));
                //event.getPlayer().dataPacket(packet);
            } catch (Exception e) {
                getLogger().error(String.format("Error while handling a packet from the server with the id of %s.", event.getPacket().pid()));
                getLogger().error(e.toString());
                getLogger().error(String.format("Packet: %s", event.getPacket()));
            }
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onReceivePacket (final DataPacketReceiveEvent event) {
        if (ProtocolHandlerLatest.isPacketSupported(event.getPacket())) {

            if (event.getPacket() instanceof ConvertedProtocolPacket) {
                getLogger().info(event.getPacket() + " was received.");
            }

            if (event.getPacket() instanceof LoginPacket && !(event.getPacket() instanceof ConvertedProtocolPacket)) {
                LoginPacket loginPacket = (LoginPacket)event.getPacket();
                if (ProtocolInfo.CURRENT_PROTOCOL > loginPacket.getProtocol() && !ProtocolInfo.SUPPORTED_PROTOCOLS.contains(loginPacket.getProtocol()) && supportedProtocolVersions.contains(loginPacket.getProtocol())) {
                    LoginPacket convertedLoginPacket = (LoginPacket)convertPlayerPacketToServerVersion(event.getPacket(), loginPacket.getProtocol());
                    oldProtocolOnlinePlayers.put(convertedLoginPacket.clientUUID, loginPacket.getProtocol()); // we need to handle packets from this player now.
                    getLogger().info(String.format("%s is on protocol version: %s. Server will now listen and send packets for their version.",convertedLoginPacket.username, loginPacket.getProtocol()));
                }
            }

            if ((oldProtocolOnlinePlayers.containsKey(event.getPlayer().getUniqueId()) || (event.getPacket() instanceof LoginPacket && supportedProtocolVersions.contains(((LoginPacket)event.getPacket()).getProtocol()))) && !(event.getPacket() instanceof ConvertedProtocolPacket)) {

                if (event.getPacket() instanceof LoginPacket) {
                    LoginPacket loginPacket = (LoginPacket)event.getPacket();
                    LoginPacket convertedLoginPacket = (LoginPacket)convertPlayerPacketToServerVersion(event.getPacket(), loginPacket.getProtocol());
                    if (!oldProtocolOnlinePlayers.containsKey(convertedLoginPacket.clientUUID)) {
                        return;
                    }
                    event.setCancelled(true);
                    event.getPlayer().handleDataPacket(convertedLoginPacket);
                    return;
                }

                event.setCancelled(true);
                try {
                    DataPacket packet = convertPlayerPacketToServerVersion(event.getPlayer(), event.getPacket());
                    event.getPlayer().handleDataPacket(packet);
                } catch (Exception e) {
                    getLogger().error(String.format("Error while handling a packet from the client with the id of %s.", event.getPacket().pid()));
                    getLogger().error(e.toString());
                    getLogger().error(String.format("Packet: %s", event.getPacket()));
                }
            }

        }

    }

    @EventHandler
    public void onPlayerQuit (PlayerQuitEvent event) {
        if (oldProtocolOnlinePlayers.containsKey(event.getPlayer().getUniqueId())) {
            oldProtocolOnlinePlayers.remove(event.getPlayer().getUniqueId());
        }
    }

    public DataPacket convertPacketToPlayerVersion (DataPacket packet, int targetProtocolVersion) {

        if (!ProtocolHandlerLatest.isPacketSupported(packet)) {
            return packet;
        }

        ProtocolHandler handler = LATEST_OLD_PROTOCOL_HANDLER;
        DataPacket newPacket = handler.convertClientBoundPacketToThisVersion(packet);
        while (targetProtocolVersion != handler.getProtocolVersion()) {
            handler = protocolVersionSupport.get(handler.getPreviousProtocolVersion());
            newPacket = handler.convertClientBoundPacketToThisVersion(newPacket);
        }

        if (!(newPacket instanceof ConvertedProtocolPacket)) {
            // We do not have to change the packet. Just recreate it
            return LATEST_PROTOCOL_HANDLER.convertClientBoundPacketToThisVersion(packet);  // Latest version.
        }

        return newPacket;

    }

    @Override
    public DataPacket convertPacketToPlayerVersion (Player player, DataPacket packet) {
        if (!oldProtocolOnlinePlayers.containsKey(player.getUniqueId())) {
            // We do not have to change the packet. Just recreate it
            return LATEST_PROTOCOL_HANDLER.convertClientBoundPacketToThisVersion(packet);  // Latest version.
        }
        int targetProtocolVersion = oldProtocolOnlinePlayers.get(player.getUniqueId());
        return convertPacketToPlayerVersion(packet, targetProtocolVersion);
    }

    public DataPacket convertPlayerPacketToServerVersion (DataPacket packet, int playerProtocolVersion) {

        if (!ProtocolHandlerLatest.isPacketSupported(packet)) {
            return packet;
        }

        ProtocolHandler handler = protocolVersionSupport.get(protocolVersionSupport.get(playerProtocolVersion).getNextProtocolVersion());
        DataPacket newPacket = handler.convertServerBoundPacketToThisVersion(packet);

        while (handler.getProtocolVersion() != LATEST_PROTOCOL_HANDLER.getProtocolVersion()) {
            handler = protocolVersionSupport.get(handler.getNextProtocolVersion());
            newPacket = handler.convertServerBoundPacketToThisVersion(newPacket);
        }

        if (!(newPacket instanceof ConvertedProtocolPacket)) {
            // We do not have to change the packet. Just recreate it
            return LATEST_PROTOCOL_HANDLER.convertServerBoundPacketToThisVersion(newPacket);  // Latest version.
        }

        return newPacket;

    }

    @Override
    public DataPacket convertPlayerPacketToServerVersion (Player player, DataPacket packet) {
        if (!oldProtocolOnlinePlayers.containsKey(player.getUniqueId())) {
            return LATEST_PROTOCOL_HANDLER.convertServerBoundPacketToThisVersion(packet);  // Latest version.
        }

        return convertPlayerPacketToServerVersion(packet, oldProtocolOnlinePlayers.get(player.getUniqueId()));

    }

    public static NVSAPI getAPI () {
        return instance;
    }

}
