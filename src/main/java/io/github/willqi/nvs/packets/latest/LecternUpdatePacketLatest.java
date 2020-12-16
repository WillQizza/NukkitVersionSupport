package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.LecternUpdatePacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class LecternUpdatePacketLatest extends LecternUpdatePacket implements ConvertedProtocolPacket {

    public LecternUpdatePacketLatest (LecternUpdatePacket packet) {
        page = packet.page;
        totalPages = packet.totalPages;
        blockPosition = packet.blockPosition;
        dropBook = packet.dropBook;
    }

}
