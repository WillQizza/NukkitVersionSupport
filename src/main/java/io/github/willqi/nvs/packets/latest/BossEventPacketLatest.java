package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.BossEventPacket;
import cn.nukkit.network.protocol.DataPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class BossEventPacketLatest extends BossEventPacket implements ConvertedProtocolPacket {

    public BossEventPacketLatest (BossEventPacket packet) {

        bossEid = packet.bossEid;
        type = packet.type;
        playerEid = packet.playerEid;
        healthPercent = packet.healthPercent;
        title = packet.title;
        unknown = packet.unknown;
        color = packet.color;
        overlay = packet.overlay;

    }

}
