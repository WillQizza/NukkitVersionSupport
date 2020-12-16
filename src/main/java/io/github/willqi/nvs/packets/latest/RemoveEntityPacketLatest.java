package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.RemoveEntityPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class RemoveEntityPacketLatest extends RemoveEntityPacket implements ConvertedProtocolPacket {

    public RemoveEntityPacketLatest (RemoveEntityPacket packet) {
        eid = packet.eid;
    }

}
