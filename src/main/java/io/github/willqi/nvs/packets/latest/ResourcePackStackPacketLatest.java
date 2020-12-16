package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.ResourcePackStackPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class ResourcePackStackPacketLatest extends ResourcePackStackPacket implements ConvertedProtocolPacket {

    public ResourcePackStackPacketLatest (ResourcePackStackPacket packet) {
        mustAccept = packet.mustAccept;
        behaviourPackStack = packet.behaviourPackStack;
        resourcePackStack = packet.resourcePackStack;
        isExperimental = packet.isExperimental;
        gameVersion = packet.gameVersion;
    }

}
