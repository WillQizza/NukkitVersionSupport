package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.SetSpawnPositionPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class SetSpawnPositionPacketLatest extends SetSpawnPositionPacket implements ConvertedProtocolPacket {

    public SetSpawnPositionPacketLatest (SetSpawnPositionPacket packet) {
        spawnType = packet.spawnType;
        x = packet.x;
        y = packet.y;
        z = packet.z;
        dimension = packet.dimension;
    }

}
