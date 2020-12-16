package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.BatchPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class BatchPacketLatest extends BatchPacket implements ConvertedProtocolPacket {

    public BatchPacketLatest (BatchPacket packet) {
        payload = packet.payload;
    }

}
