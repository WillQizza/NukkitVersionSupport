package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.ChunkRadiusUpdatedPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class ChunkRadiusUpdatedPacketLatest extends ChunkRadiusUpdatedPacket implements ConvertedProtocolPacket {

    public ChunkRadiusUpdatedPacketLatest (ChunkRadiusUpdatedPacket packet) {
        radius = packet.radius;
    }

}
