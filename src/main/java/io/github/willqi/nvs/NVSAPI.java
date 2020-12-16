package io.github.willqi.nvs;

import cn.nukkit.Player;
import cn.nukkit.network.protocol.DataPacket;

public interface NVSAPI {

    DataPacket convertPacketToPlayerVersion (Player player, DataPacket packet);

    DataPacket convertPlayerPacketToServerVersion (Player player, DataPacket packet);

}
