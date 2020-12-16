package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.UpdateTradePacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class UpdateTradePacketLatest extends UpdateTradePacket implements ConvertedProtocolPacket {

    public UpdateTradePacketLatest (UpdateTradePacket packet) {
        windowId = packet.windowId;
        windowType = packet.windowType;
        unknownVarInt1 = packet.unknownVarInt1;
        tradeTier = packet.tradeTier;
        trader = packet.trader;
        player = packet.player;
        displayName = packet.displayName;
        screen2 = packet.screen2;
        isWilling = packet.isWilling;
        offers = packet.offers;
    }

}
