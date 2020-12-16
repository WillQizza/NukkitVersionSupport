package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.MoveEntityDeltaPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class MoveEntityDeltaPacketLatest extends MoveEntityDeltaPacket implements ConvertedProtocolPacket {

    public MoveEntityDeltaPacketLatest (MoveEntityDeltaPacket packet) {
        flags = packet.flags;
        xDelta = packet.xDelta;
        yDelta = packet.yDelta;
        zDelta = packet.zDelta;
        yawDelta = packet.yawDelta;
        headYawDelta = packet.headYawDelta;
        pitchDelta = packet.pitchDelta;
    }

}
