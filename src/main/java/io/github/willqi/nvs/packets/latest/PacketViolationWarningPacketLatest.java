package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.PacketViolationWarningPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class PacketViolationWarningPacketLatest extends PacketViolationWarningPacket implements ConvertedProtocolPacket {

    public PacketViolationWarningPacketLatest (PacketViolationWarningPacket packet) {
        type = packet.type;
        severity = packet.severity;
        packetId = packet.packetId;
        context = packet.context;
    }

}
