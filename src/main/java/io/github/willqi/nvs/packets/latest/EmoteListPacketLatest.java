package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.EmoteListPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

import java.util.UUID;

public class EmoteListPacketLatest extends EmoteListPacket implements ConvertedProtocolPacket {

    public EmoteListPacketLatest (EmoteListPacket packet) {
        runtimeId = packet.runtimeId;
        for (UUID uuid : packet.pieceIds) {
            packet.pieceIds.add(uuid);
        }
    }

}
