package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.AddPaintingPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class AddPaintingPacketLatest extends AddPaintingPacket implements ConvertedProtocolPacket {

    public AddPaintingPacketLatest (AddPaintingPacket packet) {
        entityUniqueId = packet.entityUniqueId;
        entityRuntimeId = packet.entityRuntimeId;
        x = packet.x;
        y = packet.y;
        z = packet.z;
        direction = packet.direction;
        title = packet.title;
    }

}
