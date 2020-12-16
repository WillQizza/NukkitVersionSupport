package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.ClientboundMapItemDataPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class ClientboundMapItemDataPacketLatest extends ClientboundMapItemDataPacket implements ConvertedProtocolPacket {

    public ClientboundMapItemDataPacketLatest (ClientboundMapItemDataPacket packet) {
        eids = packet.eids;
        update = packet.update;
        scale = packet.scale;
        isLocked = packet.isLocked;
        width = packet.width;
        height = packet.height;
        offsetX = packet.offsetX;
        offsetZ = packet.offsetZ;
        dimensionId = packet.dimensionId;
        decorators = packet.decorators;
        colors = packet.colors;
        mapId = packet.mapId;
        image = packet.image;
    }

}
