package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.ServerSettingsResponsePacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class ServerSettingsResponsePacketLatest extends ServerSettingsResponsePacket implements ConvertedProtocolPacket {

    public ServerSettingsResponsePacketLatest (ServerSettingsResponsePacket packet) {
        formId = packet.formId;
        data = packet.data;
    }

}
