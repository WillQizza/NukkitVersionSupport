package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.AddPlayerPacket;
import cn.nukkit.network.protocol.DataPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class AddPlayerPacketLatest extends AddPlayerPacket implements ConvertedProtocolPacket {

    public AddPlayerPacketLatest (DataPacket packet) {
        uuid = ((AddPlayerPacket)packet).uuid;
        username = ((AddPlayerPacket)packet).username;
        entityUniqueId = ((AddPlayerPacket)packet).entityUniqueId;
        entityRuntimeId = ((AddPlayerPacket)packet).entityRuntimeId;
        platformChatId = ((AddPlayerPacket)packet).platformChatId;
        x = ((AddPlayerPacket)packet).x;
        y = ((AddPlayerPacket)packet).y;
        z = ((AddPlayerPacket)packet).z;
        speedX = ((AddPlayerPacket)packet).speedX;
        speedY = ((AddPlayerPacket)packet).speedY;
        speedZ = ((AddPlayerPacket)packet).speedZ;
        pitch = ((AddPlayerPacket)packet).pitch;
        yaw = ((AddPlayerPacket)packet).yaw;
        item = ((AddPlayerPacket)packet).item;
        metadata = ((AddPlayerPacket)packet).metadata;
        deviceId = ((AddPlayerPacket)packet).deviceId;
        buildPlatform = ((AddPlayerPacket)packet).buildPlatform;
    }

}
