package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.ResourcePackChunkRequestPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class ResourcePackChunkRequestPacketLatest extends ResourcePackChunkRequestPacket implements ConvertedProtocolPacket {

    public ResourcePackChunkRequestPacketLatest (ResourcePackChunkRequestPacket packet) {
        packId = packet.packId;
        chunkIndex = packet.chunkIndex;
    }

}
