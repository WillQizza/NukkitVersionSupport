package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.BookEditPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class BookEditPacketLatest extends BookEditPacket implements ConvertedProtocolPacket {

    public BookEditPacketLatest (BookEditPacket packet) {
        action = packet.action;
        inventorySlot = packet.inventorySlot;
        pageNumber = packet.pageNumber;
        secondaryPageNumber = packet.secondaryPageNumber;
        text = packet.text;
        author = packet.author;
        xuid = packet.xuid;
    }

}
