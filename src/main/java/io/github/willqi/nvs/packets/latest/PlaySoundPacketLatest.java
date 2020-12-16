package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.PlaySoundPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class PlaySoundPacketLatest extends PlaySoundPacket implements ConvertedProtocolPacket {

    public PlaySoundPacketLatest (PlaySoundPacket packet) {
        name = packet.name;
        x = packet.x;
        y = packet.y;
        z = packet.z;
        volume = packet.volume;
        pitch = packet.pitch;
    }

}
