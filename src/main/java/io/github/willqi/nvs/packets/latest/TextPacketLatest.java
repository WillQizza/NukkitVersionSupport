package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.TextPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class TextPacketLatest extends TextPacket implements ConvertedProtocolPacket {

    public TextPacketLatest (TextPacket packet) {
        type = packet.type;
        source = packet.source;
        message = packet.message;
        parameters = packet.parameters;
        isLocalized = packet.isLocalized;
        xboxUserId = packet.xboxUserId;
        platformChatId = packet.platformChatId;
    }

}
