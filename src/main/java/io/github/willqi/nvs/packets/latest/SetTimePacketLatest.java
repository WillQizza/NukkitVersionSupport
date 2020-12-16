package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.SetTimePacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class SetTimePacketLatest extends SetTimePacket implements ConvertedProtocolPacket {

    public SetTimePacketLatest (SetTimePacket packet) {
        time = packet.time;
    }

}
