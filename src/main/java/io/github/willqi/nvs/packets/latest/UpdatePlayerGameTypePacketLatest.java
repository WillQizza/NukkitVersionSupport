package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.UpdatePlayerGameTypePacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class UpdatePlayerGameTypePacketLatest extends UpdatePlayerGameTypePacket implements ConvertedProtocolPacket {

    public UpdatePlayerGameTypePacketLatest (UpdatePlayerGameTypePacket packet) {
        gameType = packet.gameType;
        entityId = packet.entityId;
    }

}
