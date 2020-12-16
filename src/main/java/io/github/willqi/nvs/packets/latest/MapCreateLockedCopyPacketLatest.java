package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.MapCreateLockedCopyPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class MapCreateLockedCopyPacketLatest extends MapCreateLockedCopyPacket implements ConvertedProtocolPacket {

    public MapCreateLockedCopyPacketLatest (MapCreateLockedCopyPacket packet) {
        originalMapId = packet.originalMapId;
        newMapId = packet.newMapId;
    }

}
