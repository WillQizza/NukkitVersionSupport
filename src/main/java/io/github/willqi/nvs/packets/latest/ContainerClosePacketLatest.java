package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.ContainerClosePacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class ContainerClosePacketLatest extends ContainerClosePacket implements ConvertedProtocolPacket {

    public ContainerClosePacketLatest (ContainerClosePacket packet) {
        windowId = packet.windowId;
    }

}
