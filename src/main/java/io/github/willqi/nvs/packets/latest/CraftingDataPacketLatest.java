package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.CraftingDataPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class CraftingDataPacketLatest extends CraftingDataPacket implements ConvertedProtocolPacket {

    public CraftingDataPacketLatest (CraftingDataPacket packet) {
        cleanRecipes = packet.cleanRecipes;
    }

}
