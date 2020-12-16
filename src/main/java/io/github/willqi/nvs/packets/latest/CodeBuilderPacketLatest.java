package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.CodeBuilderPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class CodeBuilderPacketLatest extends CodeBuilderPacket implements ConvertedProtocolPacket {

    public CodeBuilderPacketLatest (CodeBuilderPacket packet) {
        isOpening = packet.isOpening;
        url = packet.url;
    }

}
