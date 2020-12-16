package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.RequestChunkRadiusPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class RequestChunkRadiusPacketLatest extends RequestChunkRadiusPacket implements ConvertedProtocolPacket {

    public RequestChunkRadiusPacketLatest (RequestChunkRadiusPacket packet) {
        radius = packet.radius;
    }

}
