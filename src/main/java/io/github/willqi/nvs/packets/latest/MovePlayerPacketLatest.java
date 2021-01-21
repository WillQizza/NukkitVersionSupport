package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.MovePlayerPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class MovePlayerPacketLatest extends MovePlayerPacket implements ConvertedProtocolPacket {

    public MovePlayerPacketLatest (MovePlayerPacket packet) {
        eid = packet.eid;
        x = packet.x;
        y = packet.y;
        z = packet.z;
        yaw = packet.yaw;
        headYaw = packet.headYaw;
        pitch = packet.pitch;
        mode = packet.mode;
        onGround = packet.onGround;
        ridingEid = packet.ridingEid;
        int1 = packet.int1;
        int2 = packet.int2;
        frame = packet.frame;
    }


}
