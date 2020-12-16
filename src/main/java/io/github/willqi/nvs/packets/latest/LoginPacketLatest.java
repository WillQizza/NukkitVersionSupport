package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.LoginPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class LoginPacketLatest extends LoginPacket implements ConvertedProtocolPacket {

    public LoginPacketLatest (LoginPacket packet) {
        username = packet.username;
        protocol = packet.protocol;
        clientUUID = packet.clientUUID;
        clientId = packet.clientId;
        skin = packet.skin;
    }

}
