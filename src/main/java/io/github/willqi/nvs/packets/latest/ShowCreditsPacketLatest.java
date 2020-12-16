package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.ShowCreditsPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class ShowCreditsPacketLatest extends ShowCreditsPacket implements ConvertedProtocolPacket {

    public ShowCreditsPacketLatest (ShowCreditsPacket packet) {
        eid = packet.eid;
        status = packet.status;
    }

}
