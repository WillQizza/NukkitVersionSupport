package io.github.willqi.nvs.versions;

import cn.nukkit.network.protocol.*;
import io.github.willqi.nvs.packets.latest.*;

import java.util.HashMap;
import java.util.Map;

public class ProtocolHandlerLatest implements ProtocolHandler {

    private static final Map<Byte, PacketWrapper> packetTypes = new HashMap<>();

    static {
        packetTypes.put(ProtocolInfo.ADD_ENTITY_PACKET, new PacketWrapper(AddEntityPacketLatest.class, AddEntityPacket.class));
        packetTypes.put(ProtocolInfo.ADD_ITEM_ENTITY_PACKET, new PacketWrapper(AddItemEntityPacketLatest.class, AddItemEntityPacket.class));
        packetTypes.put(ProtocolInfo.ADD_PAINTING_PACKET, new PacketWrapper(AddPaintingPacketLatest.class, AddPaintingPacket.class));
        packetTypes.put(ProtocolInfo.ADD_PLAYER_PACKET, new PacketWrapper(AddPlayerPacketLatest.class, AddPlayerPacket.class));
        packetTypes.put(ProtocolInfo.ADVENTURE_SETTINGS_PACKET, new PacketWrapper(AdventureSettingsPacketLatest.class, AdventureSettingsPacket.class));
        packetTypes.put(ProtocolInfo.ANIMATE_PACKET, new PacketWrapper(AnimatePacketLatest.class, AnimatePacket.class));
        packetTypes.put(ProtocolInfo.AVAILABLE_COMMANDS_PACKET, new PacketWrapper(AvailableCommandsPacketLatest.class, AvailableCommandsPacket.class));
        packetTypes.put(ProtocolInfo.BATCH_PACKET, new PacketWrapper(BatchPacketLatest.class, BatchPacket.class));
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
        if (!packetTypes.containsKey(packet.pid())) {
            return null;
        }
        PacketWrapper wrapper = packetTypes.get(packet.pid());
        try {
            newPacket = wrapper.getWrapperPacketClass().getDeclaredConstructor(wrapper.getOriginalPacketClass()).newInstance(packet);
        } catch (Exception exception) {}
        return newPacket;
    }

    private static class PacketWrapper {

        private final Class<? extends DataPacket> packetWrapperClass;
        private final Class<? extends DataPacket> originalPacketClass;

        public PacketWrapper (Class<? extends DataPacket> packetWrapperClass, Class<? extends DataPacket> originalPacketClass) {
            this.packetWrapperClass = packetWrapperClass;
            this.originalPacketClass = originalPacketClass;
        }

        public Class<? extends DataPacket> getOriginalPacketClass () {
            return originalPacketClass;
        }

        public Class<? extends DataPacket> getWrapperPacketClass () {
            return packetWrapperClass;
        }

    }
}
