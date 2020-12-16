package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.PlayerInputPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class PlayerInputPacketLatest extends PlayerInputPacket implements ConvertedProtocolPacket {

    public PlayerInputPacketLatest (PlayerInputPacket packet) {
        motionX = packet.motionX;
        motionY = packet.motionY;
        jumping = packet.jumping;
        sneaking = packet.sneaking;
    }

}
