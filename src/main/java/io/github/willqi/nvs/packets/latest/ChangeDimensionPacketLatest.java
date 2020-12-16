package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.ChangeDimensionPacket;
import cn.nukkit.network.protocol.DataPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class ChangeDimensionPacketLatest extends ChangeDimensionPacket implements ConvertedProtocolPacket {

    public ChangeDimensionPacketLatest (ChangeDimensionPacket packet) {
        dimension = packet.dimension;
        x = packet.x;
        y = packet.y;
        z = packet.z;
        respawn = packet.respawn;
    }

}
