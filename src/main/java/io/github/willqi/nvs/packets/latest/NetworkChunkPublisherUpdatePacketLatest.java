package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.NetworkChunkPublisherUpdatePacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class NetworkChunkPublisherUpdatePacketLatest extends NetworkChunkPublisherUpdatePacket implements ConvertedProtocolPacket {

    public NetworkChunkPublisherUpdatePacketLatest (NetworkChunkPublisherUpdatePacket packet) {
        position = packet.position;
        radius = packet.radius;
    }

}
