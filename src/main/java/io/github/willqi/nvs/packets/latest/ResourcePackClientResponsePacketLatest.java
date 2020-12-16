package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.ResourcePackClientResponsePacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class ResourcePackClientResponsePacketLatest extends ResourcePackClientResponsePacket implements ConvertedProtocolPacket {

    public ResourcePackClientResponsePacketLatest (ResourcePackClientResponsePacket packet) {
        responseStatus = packet.responseStatus;
        packEntries = packet.packEntries;
    }

}
