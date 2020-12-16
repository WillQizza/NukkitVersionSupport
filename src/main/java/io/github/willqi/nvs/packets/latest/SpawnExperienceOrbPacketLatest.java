package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.SpawnExperienceOrbPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class SpawnExperienceOrbPacketLatest extends SpawnExperienceOrbPacket implements ConvertedProtocolPacket {

    public SpawnExperienceOrbPacketLatest (SpawnExperienceOrbPacket packet) {
        x = packet.x;
        y = packet.y;
        z = packet.z;
        amount = packet.amount;
    }

}
