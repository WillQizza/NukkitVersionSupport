package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.MoveEntityAbsolutePacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class MoveEntityAbsolutePacketLatest extends MoveEntityAbsolutePacket implements ConvertedProtocolPacket {

    public MoveEntityAbsolutePacketLatest (MoveEntityAbsolutePacket packet) {
        eid = packet.eid;
        x = packet.x;
        y = packet.y;
        z = packet.z;
        yaw = packet.yaw;
        headYaw = packet.headYaw;
        pitch = packet.pitch;
        onGround = packet.onGround;
        teleport = packet.teleport;
    }

}
