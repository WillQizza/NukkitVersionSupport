package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.BiomeDefinitionListPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class BiomeDefinitionListPacketLatest extends BiomeDefinitionListPacket implements ConvertedProtocolPacket {

    public BiomeDefinitionListPacketLatest (BiomeDefinitionListPacket packet) {
        tag = packet.tag;
    }

}
