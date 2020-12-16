package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.AvailableCommandsPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class AvailableCommandsPacketLatest extends AvailableCommandsPacket implements ConvertedProtocolPacket {

    public AvailableCommandsPacketLatest (AvailableCommandsPacket packet) {

        commands = packet.commands;
        for (String key : packet.softEnums.keySet()) {
            softEnums.put(key, packet.softEnums.get(key));
        }

    }

}
