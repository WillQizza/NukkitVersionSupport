package io.github.willqi.nvs.versions;

import cn.nukkit.network.protocol.DataPacket;
import cn.nukkit.network.protocol.ProtocolInfo;
import io.github.willqi.nvs.packets.latest.*;

import java.util.HashMap;
import java.util.Map;

public class ProtocolHandlerLatest implements ProtocolHandler {

    private static final Map<Byte, Class<? extends DataPacket>> packetTypes = new HashMap<>();

    static {
        packetTypes.put(ProtocolInfo.ADD_ENTITY_PACKET, AddEntityPacketLatest.class);
        packetTypes.put(ProtocolInfo.ADD_ITEM_ENTITY_PACKET, AddItemEntityPacketLatest.class);
        packetTypes.put(ProtocolInfo.ADD_PAINTING_PACKET, AddPaintingPacketLatest.class);
        packetTypes.put(ProtocolInfo.ADD_PLAYER_PACKET, AddPlayerPacketLatest.class);
        packetTypes.put(ProtocolInfo.ADVENTURE_SETTINGS_PACKET, AdventureSettingsPacketLatest.class);
        packetTypes.put(ProtocolInfo.ANIMATE_PACKET, AnimatePacketLatest.class);
        packetTypes.put(ProtocolInfo.AVAILABLE_COMMANDS_PACKET, AvailableCommandsPacketLatest.class);
    }

    @Override
    public DataPacket convertClientBoundPacketToThisVersion(DataPacket packet) {
        return convertPacket(packet);
    }

    @Override
    public DataPacket convertServerBoundPacketToThisVersion(DataPacket packet) {
        return convertPacket(packet);
    }

    @Override
    public int getPreviousProtocolVersion() {
        return -1;
    }

    @Override
    public int getProtocolVersion() {
        return -1;
    }

    @Override
    public int getNextProtocolVersion() {
        return -1;
    }

    private static DataPacket convertPacket (DataPacket packet) {
        DataPacket newPacket = null;
        try {
            newPacket = packetTypes.get(packet.pid()).getDeclaredConstructor(DataPacket.class).newInstance(packet);
        } catch (Exception exception) {}
        return newPacket;
    }
}
