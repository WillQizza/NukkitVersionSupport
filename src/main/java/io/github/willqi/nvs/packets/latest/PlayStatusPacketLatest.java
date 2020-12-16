package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.PlayStatusPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class PlayStatusPacketLatest extends PlayStatusPacket implements ConvertedProtocolPacket {

    public PlayStatusPacketLatest (PlayStatusPacket packet) {
        status = packet.status;
    }

}
