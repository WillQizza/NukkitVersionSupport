package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.MoveEntityDeltaPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class MoveEntityDeltaPacketLatest extends MoveEntityDeltaPacket implements ConvertedProtocolPacket {

    public MoveEntityDeltaPacketLatest (MoveEntityDeltaPacket packet) {
        flags = packet.flags;
        x = packet.x;
        y = packet.y;
        z = packet.z;
        yawDelta = packet.yawDelta;
        headYawDelta = packet.headYawDelta;
        pitchDelta = packet.pitchDelta;
    }

}
