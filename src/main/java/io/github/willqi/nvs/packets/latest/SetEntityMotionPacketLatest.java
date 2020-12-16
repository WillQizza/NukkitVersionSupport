package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.SetEntityMotionPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class SetEntityMotionPacketLatest extends SetEntityMotionPacket implements ConvertedProtocolPacket {

    public SetEntityMotionPacketLatest (SetEntityMotionPacket packet) {
        eid = packet.eid;
        motionX = packet.motionX;
        motionY = packet.motionY;
        motionZ = packet.motionZ;
    }

}
