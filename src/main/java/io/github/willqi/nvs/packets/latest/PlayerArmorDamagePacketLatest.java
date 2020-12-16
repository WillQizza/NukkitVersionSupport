package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.PlayerArmorDamagePacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class PlayerArmorDamagePacketLatest extends PlayerArmorDamagePacket implements ConvertedProtocolPacket {

    public PlayerArmorDamagePacketLatest (PlayerArmorDamagePacket packet) {
        for (PlayerArmorDamagePacket.PlayerArmorDamageFlag flag : packet.flags) {
            flags.add(flag);
        }
        damage[0] = packet.damage[0];
        damage[1] = packet.damage[1];
        damage[2] = packet.damage[2];
        damage[3] = packet.damage[3];
    }

}
