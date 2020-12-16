package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.ResourcePackChunkDataPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class ResourcePackChunkDataPacketLatest extends ResourcePackChunkDataPacket implements ConvertedProtocolPacket {

    public ResourcePackChunkDataPacketLatest (ResourcePackChunkDataPacket packet) {
        packId = packet.packId;
        chunkIndex = packet.chunkIndex;
        progress = packet.progress;
        data = packet.data;
    }

}
