package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.ResourcePackDataInfoPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class ResourcePackDataInfoPacketLatest extends ResourcePackDataInfoPacket implements ConvertedProtocolPacket {

    public ResourcePackDataInfoPacketLatest (ResourcePackDataInfoPacket packet) {
        packId = packet.packId;
        maxChunkSize = packet.maxChunkSize;
        chunkCount = packet.chunkCount;
        compressedPackSize = packet.compressedPackSize;
        sha256 = packet.sha256;
        premium = packet.premium;
        type = packet.type;
    }

}
