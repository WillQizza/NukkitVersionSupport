package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.ResourcePacksInfoPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class ResourcePacksInfoPacketLatest extends ResourcePacksInfoPacket implements ConvertedProtocolPacket {

    public ResourcePacksInfoPacketLatest (ResourcePacksInfoPacket packet) {
        mustAccept = packet.mustAccept;
        scripting = packet.scripting;
        behaviourPackEntries = packet.behaviourPackEntries;
        resourcePackEntries = packet.resourcePackEntries;
    }

}
