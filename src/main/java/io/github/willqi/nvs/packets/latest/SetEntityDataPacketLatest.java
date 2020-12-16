package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.SetEntityDataPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class SetEntityDataPacketLatest extends SetEntityDataPacket implements ConvertedProtocolPacket {

    public SetEntityDataPacketLatest (SetEntityDataPacket packet) {
        eid = packet.eid;
        metadata = packet.metadata;
    }

}
