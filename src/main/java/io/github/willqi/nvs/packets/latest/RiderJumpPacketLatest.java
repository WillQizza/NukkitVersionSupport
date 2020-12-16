package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.RiderJumpPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class RiderJumpPacketLatest extends RiderJumpPacket implements ConvertedProtocolPacket {

    public RiderJumpPacketLatest (RiderJumpPacket packet) {
        unknown = packet.unknown;
    }

}
