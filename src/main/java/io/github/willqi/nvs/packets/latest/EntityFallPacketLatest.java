package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.EntityFallPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class EntityFallPacketLatest extends EntityFallPacket implements ConvertedProtocolPacket {

    public EntityFallPacketLatest (EntityFallPacket packet) {
        eid = packet.eid;
        fallDistance = packet.fallDistance;
        unknown = packet.unknown;
    }

}
