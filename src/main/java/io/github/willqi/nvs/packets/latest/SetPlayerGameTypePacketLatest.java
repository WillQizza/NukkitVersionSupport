package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.SetPlayerGameTypePacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class SetPlayerGameTypePacketLatest extends SetPlayerGameTypePacket implements ConvertedProtocolPacket {

    public SetPlayerGameTypePacketLatest (SetPlayerGameTypePacket packet) {
        gamemode = packet.gamemode;
    }

}
