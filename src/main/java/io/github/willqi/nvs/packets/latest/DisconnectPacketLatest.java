package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.DisconnectPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class DisconnectPacketLatest extends DisconnectPacket implements ConvertedProtocolPacket {

    public DisconnectPacketLatest (DisconnectPacket packet) {
        hideDisconnectionScreen = packet.hideDisconnectionScreen;
        message = packet.message;
    }

}
