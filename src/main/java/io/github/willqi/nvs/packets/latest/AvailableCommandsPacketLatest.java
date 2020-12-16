package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.AvailableCommandsPacket;
import cn.nukkit.network.protocol.DataPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class AvailableCommandsPacketLatest extends AvailableCommandsPacket implements ConvertedProtocolPacket {

    public AvailableCommandsPacketLatest (DataPacket packet) {

        commands = ((AvailableCommandsPacket)packet).commands;
        for (String key : ((AvailableCommandsPacket)packet).softEnums.keySet()) {
            softEnums.put(key, ((AvailableCommandsPacket)packet).softEnums.get(key));
        }

    }

}
