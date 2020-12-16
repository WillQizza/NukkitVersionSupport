package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.SetEntityLinkPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class SetEntityLinkPacketLatest extends SetEntityLinkPacket implements ConvertedProtocolPacket {

    public SetEntityLinkPacketLatest (SetEntityLinkPacket packet) {
        vehicleUniqueId = packet.vehicleUniqueId;
        riderInitiated = packet.riderInitiated;
        type = packet.type;
        immediate = packet.immediate;
        riderInitiated = packet.riderInitiated;
    }

}
