package io.github.willqi.nvs.packets.v408;

import cn.nukkit.network.protocol.MoveEntityDeltaPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class MoveEntityDeltaPacketV408 extends MoveEntityDeltaPacket implements ConvertedProtocolPacket {
    
    @Override
    public void encode () {
        this.putByte((byte) flags);
        putCoordinate(FLAG_HAS_X, (int)this.x);
        putCoordinate(FLAG_HAS_Y, (int)this.y);
        putCoordinate(FLAG_HAS_Z, (int)this.z);
        putRotation(FLAG_HAS_YAW, this.yawDelta);
        putRotation(FLAG_HAS_HEAD_YAW, this.headYawDelta);
        putRotation(FLAG_HAS_PITCH, this.pitchDelta);
    }

    @Override
    public void decode () {
        this.flags = this.getByte();
        this.x = getCoordinate(FLAG_HAS_X);
        this.y = getCoordinate(FLAG_HAS_Y);
        this.z = getCoordinate(FLAG_HAS_Z);
        this.yawDelta = getRotation(FLAG_HAS_YAW);
        this.headYawDelta = getRotation(FLAG_HAS_HEAD_YAW);
        this.pitchDelta = getRotation(FLAG_HAS_PITCH);
    }

    private int getCoordinate(int flag) {
        if ((flags & flag) != 0) {
            return this.getVarInt();
        }
        return 0;
    }

    private double getRotation(int flag) {
        if ((flags & flag) != 0) {
            return this.getByte() * (360d / 256d);
        }
        return 0d;
    }

    private void putCoordinate(int flag, int value) {
        if ((flags & flag) != 0) {
            this.putVarInt(value);
        }
    }

    private void putRotation(int flag, double value) {
        if ((flags & flag) != 0) {
            this.putByte((byte) (value / (360d / 256d)));
        }
    }

}
