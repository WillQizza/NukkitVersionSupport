package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.InteractPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class InteractPacketLatest extends InteractPacket implements ConvertedProtocolPacket {

    public InteractPacketLatest (InteractPacket packet) {
        action = packet.action;
        target = packet.target;
    }

}
