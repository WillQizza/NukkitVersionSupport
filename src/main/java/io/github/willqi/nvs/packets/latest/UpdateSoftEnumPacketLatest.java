package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.UpdateSoftEnumPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class UpdateSoftEnumPacketLatest extends UpdateSoftEnumPacket implements ConvertedProtocolPacket {

    public UpdateSoftEnumPacketLatest (UpdateSoftEnumPacket packet) {
        name = packet.name;
        type = packet.type;
        for (int i = 0; i < packet.values.length; i++) {
            values[i] = packet.values[i];
        }
    }

}
