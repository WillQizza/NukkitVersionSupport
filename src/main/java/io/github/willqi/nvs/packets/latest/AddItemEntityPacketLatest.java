package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.AddItemEntityPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class AddItemEntityPacketLatest extends AddItemEntityPacket implements ConvertedProtocolPacket {

    public AddItemEntityPacketLatest (AddItemEntityPacket packet) {
        entityUniqueId = packet.entityUniqueId;
        entityRuntimeId = packet.entityRuntimeId;
        item = packet.item;
        x = packet.x;
        y = packet.y;
        z = packet.z;
        speedX = packet.speedX;
        speedY = packet.speedY;
        speedZ = packet.speedZ;
        metadata = packet.metadata;
        isFromFishing = packet.isFromFishing;
    }

}
