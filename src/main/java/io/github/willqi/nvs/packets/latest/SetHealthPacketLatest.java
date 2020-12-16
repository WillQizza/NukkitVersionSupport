package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.SetHealthPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class SetHealthPacketLatest extends SetHealthPacket implements ConvertedProtocolPacket {

    public SetHealthPacketLatest (SetHealthPacket packet) {
        health = packet.health;
    }

}
