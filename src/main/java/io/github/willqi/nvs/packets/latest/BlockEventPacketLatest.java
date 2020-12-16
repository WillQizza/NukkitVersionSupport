package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.BlockEventPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class BlockEventPacketLatest extends BlockEventPacket implements ConvertedProtocolPacket {

    public BlockEventPacketLatest (BlockEventPacket packet) {
        x = packet.x;
        y = packet.y;
        z = packet.z;
        case1 = packet.case1;
        case2 = packet.case2;
    }

}
