package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.GameRulesChangedPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class GameRulesChangedPacketLatest extends GameRulesChangedPacket implements ConvertedProtocolPacket {

    public GameRulesChangedPacketLatest (GameRulesChangedPacket packet) {
        gameRules = packet.gameRules;
    }

}
