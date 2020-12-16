package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.InventoryTransactionPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class InventoryTransactionPacketLatest extends InventoryTransactionPacket implements ConvertedProtocolPacket {

    public InventoryTransactionPacketLatest (InventoryTransactionPacket packet) {
        transactionType = packet.transactionType;
        actions = packet.actions;
        transactionData = packet.transactionData;
        hasNetworkIds = packet.hasNetworkIds;
        legacyRequestId = packet.legacyRequestId;
        isCraftingPart = packet.isCraftingPart;
        isEnchantingPart = packet.isEnchantingPart;
    }

}
