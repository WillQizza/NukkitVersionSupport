package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.CommandRequestPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class CommandRequestPacketLatest extends CommandRequestPacket implements ConvertedProtocolPacket {

    public CommandRequestPacketLatest (CommandRequestPacket packet) {
        command = packet.command;
        data = packet.data;
    }

}
