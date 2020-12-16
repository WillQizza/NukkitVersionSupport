package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.RespawnPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class RespawnPacketLatest extends RespawnPacket implements ConvertedProtocolPacket {

    public RespawnPacketLatest (RespawnPacket packet) {
        x = packet.x;
        y = packet.y;
        z = packet.z;
        respawnState = packet.respawnState;
        runtimeEntityId = packet.runtimeEntityId;
    }

}
