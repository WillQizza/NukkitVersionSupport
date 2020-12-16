package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.AnimatePacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class AnimatePacketLatest extends AnimatePacket implements ConvertedProtocolPacket {

    public AnimatePacketLatest (AnimatePacket packet) {
        eid = packet.eid;
        action = packet.action;
        rowingTime = packet.rowingTime;
    }

}
