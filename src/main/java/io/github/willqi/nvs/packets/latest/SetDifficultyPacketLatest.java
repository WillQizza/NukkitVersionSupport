package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.SetDifficultyPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class SetDifficultyPacketLatest extends SetDifficultyPacket implements ConvertedProtocolPacket {

    public SetDifficultyPacketLatest (SetDifficultyPacket packet) {
        difficulty = packet.difficulty;
    }

}
