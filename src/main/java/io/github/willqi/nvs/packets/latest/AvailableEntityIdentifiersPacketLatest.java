package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.AvailableEntityIdentifiersPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class AvailableEntityIdentifiersPacketLatest extends AvailableEntityIdentifiersPacket implements ConvertedProtocolPacket {

    public AvailableEntityIdentifiersPacketLatest (AvailableEntityIdentifiersPacket packet) {
        tag = packet.tag;
    }

}
