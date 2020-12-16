package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.NetworkStackLatencyPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class NetworkStackLatencyPacketLatest extends NetworkStackLatencyPacket implements ConvertedProtocolPacket {

    public NetworkStackLatencyPacketLatest (NetworkStackLatencyPacket packet) {
        timestamp = packet.timestamp;
        unknownBool = packet.unknownBool;
    }

}
