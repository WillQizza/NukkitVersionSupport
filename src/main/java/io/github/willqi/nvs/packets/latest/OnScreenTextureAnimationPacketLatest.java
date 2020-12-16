package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.OnScreenTextureAnimationPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class OnScreenTextureAnimationPacketLatest extends OnScreenTextureAnimationPacket implements ConvertedProtocolPacket {

    public OnScreenTextureAnimationPacketLatest (OnScreenTextureAnimationPacket packet) {
        effectId = packet.effectId;
    }

}
