package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.UpdateBlockPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class UpdateBlockPacketLatest extends UpdateBlockPacket implements ConvertedProtocolPacket {

    public UpdateBlockPacketLatest (UpdateBlockPacket packet) {
        x = packet.x;
        y = packet.y;
        z = packet.z;
        blockRuntimeId = packet.blockRuntimeId;
        flags = packet.flags;
        dataLayer = packet.dataLayer;
    }

}
