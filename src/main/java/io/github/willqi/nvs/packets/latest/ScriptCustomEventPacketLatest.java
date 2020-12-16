package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.ScriptCustomEventPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class ScriptCustomEventPacketLatest extends ScriptCustomEventPacket implements ConvertedProtocolPacket {

    public ScriptCustomEventPacketLatest (ScriptCustomEventPacket packet) {
        eventName = packet.eventName;
        eventData = packet.eventData;
    }

}
