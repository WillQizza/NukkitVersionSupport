package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.EmotePacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class EmotePacketLatest extends EmotePacket implements ConvertedProtocolPacket {

    public EmotePacketLatest (EmotePacket packet) {
        runtimeId = packet.runtimeId;
        emoteID = packet.emoteID;
        flags = packet.flags;
    }

}
