package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.AddPaintingPacket;
import cn.nukkit.network.protocol.DataPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class AddPaintingPacketLatest extends AddPaintingPacket implements ConvertedProtocolPacket {

    public AddPaintingPacketLatest (DataPacket packet) {
        entityUniqueId = ((AddPaintingPacket)packet).entityUniqueId;
        entityRuntimeId = ((AddPaintingPacket)packet).entityRuntimeId;
        x = ((AddPaintingPacket)packet).x;
        y = ((AddPaintingPacket)packet).y;
        z = ((AddPaintingPacket)packet).z;
        direction = ((AddPaintingPacket)packet).direction;
        title = ((AddPaintingPacket)packet).title;
    }

}
