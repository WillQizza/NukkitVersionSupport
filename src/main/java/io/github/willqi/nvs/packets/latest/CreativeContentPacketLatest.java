package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.CreativeContentPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class CreativeContentPacketLatest extends CreativeContentPacket implements ConvertedProtocolPacket {

    public CreativeContentPacketLatest (CreativeContentPacket packet) {
        entries = packet.entries;
    }

}
