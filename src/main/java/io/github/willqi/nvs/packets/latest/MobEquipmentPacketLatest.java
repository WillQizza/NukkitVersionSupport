package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.MobEquipmentPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class MobEquipmentPacketLatest extends MobEquipmentPacket implements ConvertedProtocolPacket {

    public MobEquipmentPacketLatest (MobEquipmentPacket packet) {
        eid = packet.eid;
        item = packet.item;
        inventorySlot = packet.inventorySlot;
        hotbarSlot = packet.hotbarSlot;
        windowId = packet.windowId;
    }

}
