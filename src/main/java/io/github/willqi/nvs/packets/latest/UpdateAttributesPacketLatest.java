package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.UpdateAttributesPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class UpdateAttributesPacketLatest extends UpdateAttributesPacket implements ConvertedProtocolPacket {

    public UpdateAttributesPacketLatest (UpdateAttributesPacket packet) {
        entries = packet.entries;
        entityId = packet.entityId;
    }

}
