package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.LevelSoundEventPacketV1;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class LevelSoundEventPacketV1Latest extends LevelSoundEventPacketV1 implements ConvertedProtocolPacket {

    public LevelSoundEventPacketV1Latest (LevelSoundEventPacketV1 packet) {
        sound = packet.sound;
        x = packet.x;
        y = packet.y;
        z = packet.z;
        extraData = packet.extraData;
        pitch = packet.pitch;
        isBabyMob = packet.isBabyMob;
        isGlobal = packet.isGlobal;
    }

}
