package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.BlockEntityDataPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class BlockEntityDataPacketLatest extends BlockEntityDataPacket implements ConvertedProtocolPacket {

    public BlockEntityDataPacketLatest (BlockEntityDataPacket packet) {
        x = packet.x;
        y = packet.y;
        z = packet.z;
        namedTag = packet.namedTag;
    }

}
