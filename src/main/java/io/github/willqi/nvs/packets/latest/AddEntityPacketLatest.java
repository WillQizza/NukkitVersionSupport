package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.AddEntityPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class AddEntityPacketLatest extends AddEntityPacket implements ConvertedProtocolPacket {

    public AddEntityPacketLatest (AddEntityPacket packet) {
        entityUniqueId = packet.entityUniqueId;
        entityRuntimeId = packet.entityRuntimeId;
        type = packet.type;
        id = packet.id;
        x = packet.x;
        y = packet.y;
        z = packet.z;
        speedX = packet.speedX;
        speedY = packet.speedY;
        speedZ = packet.speedZ;
        yaw = packet.yaw;
        pitch = packet.pitch;
        headYaw = packet.headYaw;
        metadata = packet.metadata;
        attributes = packet.attributes;
        links = packet.links;
    }

}
