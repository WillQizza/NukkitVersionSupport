package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.InventoryContentPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class InventoryContentPacketLatest extends InventoryContentPacket implements ConvertedProtocolPacket {

    public InventoryContentPacketLatest (InventoryContentPacket packet) {
        inventoryId = packet.inventoryId;
        slots = packet.slots;
    }

}
