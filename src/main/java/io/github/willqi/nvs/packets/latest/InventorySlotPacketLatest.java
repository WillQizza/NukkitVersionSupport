package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.InventorySlotPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class InventorySlotPacketLatest extends InventorySlotPacket implements ConvertedProtocolPacket {

    public InventorySlotPacketLatest (InventorySlotPacket packet) {
        inventoryId = packet.inventoryId;
        slot = packet.slot;
        item = packet.item;
    }

}
