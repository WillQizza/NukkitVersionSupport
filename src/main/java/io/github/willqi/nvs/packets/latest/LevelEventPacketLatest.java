package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.LevelEventPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class LevelEventPacketLatest extends LevelEventPacket implements ConvertedProtocolPacket {

    public LevelEventPacketLatest (LevelEventPacket packet) {
        evid = packet.evid;
        x = packet.x;
        y = packet.y;
        z = packet.z;
        data = packet.data;
    }

}
