package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.PlayerListPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class PlayerListPacketLatest extends PlayerListPacket implements ConvertedProtocolPacket {

    public PlayerListPacketLatest (PlayerListPacket packet) {
        type = packet.type;
        entries = packet.entries;
    }

}
