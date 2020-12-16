package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.AddItemEntityPacket;
import cn.nukkit.network.protocol.DataPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class AddItemEntityPacketLatest extends AddItemEntityPacket implements ConvertedProtocolPacket {

    public AddItemEntityPacketLatest (DataPacket packet) {
        entityUniqueId = ((AddItemEntityPacket)packet).entityUniqueId;
        entityRuntimeId = ((AddItemEntityPacket)packet).entityRuntimeId;
        item = ((AddItemEntityPacket)packet).item;
        x = ((AddItemEntityPacket)packet).x;
        y = ((AddItemEntityPacket)packet).y;
        z = ((AddItemEntityPacket)packet).z;
        speedX = ((AddItemEntityPacket)packet).speedX;
        speedY = ((AddItemEntityPacket)packet).speedY;
        speedZ = ((AddItemEntityPacket)packet).speedZ;
        metadata = ((AddItemEntityPacket)packet).metadata;
        isFromFishing = ((AddItemEntityPacket)packet).isFromFishing;
    }

}
