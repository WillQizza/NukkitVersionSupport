package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.CraftingEventPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class CraftingEventPacketLatest extends CraftingEventPacket implements ConvertedProtocolPacket {

    public CraftingEventPacketLatest (CraftingEventPacket packet) {
        windowId = packet.windowId;
        type = packet.type;
        id = packet.id;
        input = packet.input;
        output = packet.output;
    }

}
