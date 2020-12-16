package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.SetTitlePacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class SetTitlePacketLatest extends SetTitlePacket implements ConvertedProtocolPacket {

    public SetTitlePacketLatest (SetTitlePacket packet) {
        type = packet.type;
        text = packet.text;
        fadeInTime = packet.fadeInTime;
        stayTime = packet.stayTime;
        fadeOutTime = packet.fadeOutTime;
    }

}
