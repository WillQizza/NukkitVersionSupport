package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.ContainerSetDataPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class ContainerSetDataPacketLatest extends ContainerSetDataPacket implements ConvertedProtocolPacket {

    public ContainerSetDataPacketLatest (ContainerSetDataPacket packet) {
        windowId = packet.windowId;
        property = packet.property;
        value = packet.value;
    }

}
