package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.DebugInfoPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class DebugInfoPacketLatest extends DebugInfoPacket implements ConvertedProtocolPacket {

    public DebugInfoPacketLatest (DebugInfoPacket packet) {
        entityId = packet.entityId;
        data = packet.data;
    }

}
