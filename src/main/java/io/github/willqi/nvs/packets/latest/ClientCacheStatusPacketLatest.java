package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.ClientCacheStatusPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class ClientCacheStatusPacketLatest extends ClientCacheStatusPacket implements ConvertedProtocolPacket {

    public ClientCacheStatusPacketLatest (ClientCacheStatusPacket packet) {
        supported = packet.supported;
    }

}
