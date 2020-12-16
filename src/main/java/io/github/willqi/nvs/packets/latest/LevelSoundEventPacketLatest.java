package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.LevelSoundEventPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class LevelSoundEventPacketLatest extends LevelSoundEventPacket implements ConvertedProtocolPacket {

    public LevelSoundEventPacketLatest (LevelSoundEventPacket packet) {
        sound = packet.sound;
        x = packet.x;
        y = packet.y;
        z = packet.z;
        extraData = packet.extraData;
        entityIdentifier = packet.entityIdentifier;
        isBabyMob = packet.isBabyMob;
        isGlobal = packet.isGlobal;
    }

}
