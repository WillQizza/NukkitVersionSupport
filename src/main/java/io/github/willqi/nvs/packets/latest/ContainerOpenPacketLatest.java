package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.ContainerOpenPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class ContainerOpenPacketLatest extends ContainerOpenPacket implements ConvertedProtocolPacket {

    public ContainerOpenPacketLatest (ContainerOpenPacket packet) {
        windowId = packet.windowId;
        type = packet.type;
        x = packet.x;
        y = packet.y;
        z = packet.z;
        entityId = packet.entityId;
    }

}
