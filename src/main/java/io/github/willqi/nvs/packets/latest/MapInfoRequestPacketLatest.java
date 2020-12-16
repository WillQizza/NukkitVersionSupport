package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.MapInfoRequestPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class MapInfoRequestPacketLatest extends MapInfoRequestPacket implements ConvertedProtocolPacket {

    public MapInfoRequestPacketLatest (MapInfoRequestPacket packet) {
        mapId = packet.mapId;
    }

}
