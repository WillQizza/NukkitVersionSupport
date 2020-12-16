package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.CompletedUsingItemPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class CompletedUsingItemPacketLatest extends CompletedUsingItemPacket implements ConvertedProtocolPacket {

    public CompletedUsingItemPacketLatest (CompletedUsingItemPacket packet) {
        itemId = packet.itemId;
        action = packet.action;
    }

}
