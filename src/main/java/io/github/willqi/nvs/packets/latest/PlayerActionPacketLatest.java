package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.PlayerActionPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class PlayerActionPacketLatest extends PlayerActionPacket implements ConvertedProtocolPacket {

    public PlayerActionPacketLatest (PlayerActionPacket packet) {
        entityId = packet.entityId;
        action = packet.action;
        x = packet.x;
        y = packet.y;
        z = packet.z;
        face = packet.face;
    }

}
