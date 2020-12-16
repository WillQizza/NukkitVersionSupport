package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.SpawnParticleEffectPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class SpawnParticleEffectPacketLatest extends SpawnParticleEffectPacket implements ConvertedProtocolPacket {

    public SpawnParticleEffectPacketLatest (SpawnParticleEffectPacket packet) {
        dimensionId = packet.dimensionId;
        uniqueEntityId = packet.uniqueEntityId;
        position = packet.position;
        identifier = packet.identifier;
    }

}
