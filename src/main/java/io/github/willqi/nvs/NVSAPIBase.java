package io.github.willqi.nvs;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.server.DataPacketReceiveEvent;
import cn.nukkit.event.server.DataPacketSendEvent;
import cn.nukkit.network.protocol.DataPacket;
import cn.nukkit.network.protocol.LoginPacket;
import cn.nukkit.network.protocol.ProtocolInfo;
import cn.nukkit.plugin.PluginBase;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;
import io.github.willqi.nvs.versions.ProtocolHandler;
import io.github.willqi.nvs.versions.ProtocolHandlerLatest;
import io.github.willqi.nvs.versions.ProtocolHandlerV419;
import io.github.willqi.nvs.versions.ProtocolHandlerV422;

import java.util.*;

public class NVSAPIBase extends PluginBase implements Listener, NVSAPI {

    private final Map<UUID, Integer> oldProtocolOnlinePlayers = new HashMap<>();

    private static final Map<Integer, ProtocolHandler> protocolVersionSupport = new HashMap<>();
    private static final Set<Integer> supportedProtocolVersions = new HashSet<>();

    private static final ProtocolHandler LATEST_OLD_PROTOCOL_HANDLER;
    private static final ProtocolHandler LATEST_PROTOCOL_HANDLER = new ProtocolHandlerLatest();

    private static final int CURRENT_PROTOCOL_SUPPORT = 422;

    static {
        supportedProtocolVersions.add(419); // 1.16.100
        protocolVersionSupport.put(419, new ProtocolHandlerV419());

        protocolVersionSupport.put(422, new ProtocolHandlerV422()); // 1.16.200

        LATEST_OLD_PROTOCOL_HANDLER = protocolVersionSupport.get(419);
    }

    @Override
    public void onEnable () {
        if (CURRENT_PROTOCOL_SUPPORT < ProtocolInfo.CURRENT_PROTOCOL) {
            getLogger().critical(String.format("This version does not yet support protocol version v%s. Please update, contact the developer, or submit a issue at our github repository.", ProtocolInfo.CURRENT_PROTOCOL));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable () {
        oldProtocolOnlinePlayers.clear();
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onSendPacket (final DataPacketSendEvent event) {
        if (oldProtocolOnlinePlayers.containsKey(event.getPlayer().getUniqueId()) && !(event.getPacket() instanceof ConvertedProtocolPacket)) {
            event.setCancelled(true);
            DataPacket packet = convertPacketToPlayerVersion(event.getPlayer(), event.getPacket());
            packet.encode();
            event.getPlayer().dataPacket(packet);
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onReceivePacket (final DataPacketReceiveEvent event) {
        if (event.getPacket() instanceof LoginPacket) {
            LoginPacket loginPacket = (LoginPacket)event.getPacket();
            if (ProtocolInfo.CURRENT_PROTOCOL > loginPacket.getProtocol() && !ProtocolInfo.SUPPORTED_PROTOCOLS.contains(loginPacket.getProtocol()) && supportedProtocolVersions.contains(loginPacket.getProtocol())) {
                oldProtocolOnlinePlayers.put(loginPacket.getUUID(), loginPacket.getProtocol()); // we need to handle packets from this player now.
                getLogger().debug(String.format("%s is on protocol version: %s. Server will now listen and send packets for their version.", loginPacket.username, loginPacket.getProtocol()));
            }
        }

        if (oldProtocolOnlinePlayers.containsKey(event.getPlayer().getUniqueId()) && !(event.getPacket() instanceof ConvertedProtocolPacket)) {
            event.setCancelled(true);
            DataPacket packet = convertPlayerPacketToServerVersion(event.getPlayer(), event.getPacket());
            packet.decode();
            event.getPlayer().handleDataPacket(packet);
        }

    }

    @Override
    public DataPacket convertPacketToPlayerVersion(Player player, DataPacket packet) {
        if (!oldProtocolOnlinePlayers.containsKey(player.getUniqueId())) {
            // We do not have to change the packet. Just recreate it
            return packet;  // Latest version.
        }
        ProtocolHandler handler = LATEST_OLD_PROTOCOL_HANDLER;
        int targetProtocolVersion = oldProtocolOnlinePlayers.get(player.getUniqueId());
        DataPacket newPacket;

        do {
            newPacket = handler.convertClientBoundPacketToThisVersion(packet);
            handler = protocolVersionSupport.get(handler.getPreviousProtocolVersion());
        } while (handler.getProtocolVersion() != targetProtocolVersion);

        if (!(newPacket instanceof ConvertedProtocolPacket)) {
            // We do not have to change the packet. Just recreate it
        }

        return newPacket;
    }

    @Override
    public DataPacket convertPlayerPacketToServerVersion(Player player, DataPacket packet) {
        ProtocolHandler handler;
        if (oldProtocolOnlinePlayers.containsKey(player.getUniqueId())) {
            handler = protocolVersionSupport.get(oldProtocolOnlinePlayers.get(player.getUniqueId()));
        } else {
            return packet;  // Latest version.
        }
        DataPacket newPacket;

        do {
            newPacket = handler.convertServerBoundPacketToThisVersion(packet);
            handler = protocolVersionSupport.get(handler.getNextProtocolVersion());
        } while (handler.getProtocolVersion() != LATEST_PROTOCOL_HANDLER.getProtocolVersion());


        return newPacket;
    }
}
