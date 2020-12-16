package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.AddPlayerPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class AddPlayerPacketLatest extends AddPlayerPacket implements ConvertedProtocolPacket {

    public AddPlayerPacketLatest (AddPlayerPacket packet) {
        uuid = packet.uuid;
        username = packet.username;
        entityUniqueId = packet.entityUniqueId;
        entityRuntimeId = packet.entityRuntimeId;
        platformChatId = packet.platformChatId;
        x = packet.x;
        y = packet.y;
        z = packet.z;
        speedX = packet.speedX;
        speedY = packet.speedY;
        speedZ = packet.speedZ;
        pitch = packet.pitch;
        yaw = packet.yaw;
        item = packet.item;
        metadata = packet.metadata;
        deviceId = packet.deviceId;
        buildPlatform = packet.buildPlatform;
    }

}
