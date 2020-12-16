package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.HurtArmorPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class HurtArmorPacketLatest extends HurtArmorPacket implements ConvertedProtocolPacket {

    public HurtArmorPacketLatest (HurtArmorPacket packet) {
        cause = packet.cause;
        damage = packet.damage;
    }

}
