package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.EntityEventPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class EntityEventPacketLatest extends EntityEventPacket implements ConvertedProtocolPacket {

    public EntityEventPacketLatest (EntityEventPacket packet) {
        eid = packet.eid;
        event = packet.event;
        data = packet.data;
    }

}
