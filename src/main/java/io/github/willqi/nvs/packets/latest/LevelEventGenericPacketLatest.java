package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.LevelEventGenericPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class LevelEventGenericPacketLatest extends LevelEventGenericPacket implements ConvertedProtocolPacket {

    public LevelEventGenericPacketLatest (LevelEventGenericPacket packet) {
        eventId = packet.eventId;
        tag = packet.tag;
    }

}
