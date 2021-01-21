package io.github.willqi.nvs.packets.v408;

import cn.nukkit.network.protocol.MovePlayerPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class MovePlayerPacketV408 extends MovePlayerPacket implements ConvertedProtocolPacket {

    @Override
    public void encode () {
        this.reset();
        this.putEntityRuntimeId(this.eid);
        this.putVector3f(this.x, this.y, this.z);
        this.putLFloat(this.pitch);
        this.putLFloat(this.yaw);
        this.putLFloat(this.headYaw);
        this.putByte((byte) this.mode);
        this.putBoolean(this.onGround);
        this.putEntityRuntimeId(this.ridingEid);
        if (this.mode == MODE_TELEPORT) {
            this.putLInt(this.int1);
            this.putLInt(this.int2);
        }
    }


}
