package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.TakeItemEntityPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class TakeItemEntityPacketLatest extends TakeItemEntityPacket implements ConvertedProtocolPacket {

    public TakeItemEntityPacketLatest (TakeItemEntityPacket packet) {
        entityId = packet.entityId;
        target = packet.target;
    }

}
