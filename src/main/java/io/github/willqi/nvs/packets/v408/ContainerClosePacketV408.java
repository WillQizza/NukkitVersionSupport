package io.github.willqi.nvs.packets.v408;

import cn.nukkit.network.protocol.ContainerClosePacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class ContainerClosePacketV408 extends ContainerClosePacket implements ConvertedProtocolPacket {

    @Override
    public void encode() {
        this.reset();
        this.putByte((byte) this.windowId);
    }
}
