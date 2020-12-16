package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.ItemFrameDropItemPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class ItemFrameDropPacketLatest extends ItemFrameDropItemPacket implements ConvertedProtocolPacket {

    public ItemFrameDropPacketLatest (ItemFrameDropItemPacket packet) {
        x = packet.x;
        y = packet.y;
        z = packet.z;
    }

}
