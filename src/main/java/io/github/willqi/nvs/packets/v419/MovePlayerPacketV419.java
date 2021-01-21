package io.github.willqi.nvs.packets.v419;

import cn.nukkit.math.Vector3f;
import cn.nukkit.network.protocol.MovePlayerPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class MovePlayerPacketV419 extends MovePlayerPacket implements ConvertedProtocolPacket {

    @Override
    public void decode () {
        this.eid = this.getEntityRuntimeId();
        Vector3f v = this.getVector3f();
        this.x = v.x;
        this.y = v.y;
        this.z = v.z;
        this.pitch = this.getLFloat();
        this.yaw = this.getLFloat();
        this.headYaw = this.getLFloat();
        this.mode = this.getByte();
        this.onGround = this.getBoolean();
        this.ridingEid = this.getEntityRuntimeId();
        if (this.mode == MODE_TELEPORT) {
            this.int1 = this.getLInt();
            this.int2 = this.getLInt();
        }
        this.frame = 0;
    }

}
