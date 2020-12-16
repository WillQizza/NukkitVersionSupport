package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.AddEntityPacket;
import cn.nukkit.network.protocol.DataPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class AddEntityPacketLatest extends AddEntityPacket implements ConvertedProtocolPacket {

    public AddEntityPacketLatest (DataPacket packet) {
        entityUniqueId = ((AddEntityPacket)packet).entityUniqueId;
        entityRuntimeId = ((AddEntityPacket)packet).entityRuntimeId;
        type = ((AddEntityPacket)packet).type;
        id = ((AddEntityPacket)packet).id;
        x = ((AddEntityPacket)packet).x;
        y = ((AddEntityPacket)packet).y;
        z = ((AddEntityPacket)packet).z;
        speedX = ((AddEntityPacket)packet).speedX;
        speedY = ((AddEntityPacket)packet).speedY;
        speedZ = ((AddEntityPacket)packet).speedZ;
        yaw = ((AddEntityPacket)packet).yaw;
        pitch = ((AddEntityPacket)packet).pitch;
        headYaw = ((AddEntityPacket)packet).headYaw;
        metadata = ((AddEntityPacket)packet).metadata;
        attributes = ((AddEntityPacket)packet).attributes;
        links = ((AddEntityPacket)packet).links;
    }

}
