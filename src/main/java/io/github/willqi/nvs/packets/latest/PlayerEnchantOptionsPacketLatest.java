package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.PlayerEnchantOptionsPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class PlayerEnchantOptionsPacketLatest extends PlayerEnchantOptionsPacket implements ConvertedProtocolPacket {

    public PlayerEnchantOptionsPacketLatest (PlayerEnchantOptionsPacket packet) {
        for (PlayerEnchantOptionsPacket.EnchantOptionData option : packet.options) {
            options.add(option);
        }
    }

}
