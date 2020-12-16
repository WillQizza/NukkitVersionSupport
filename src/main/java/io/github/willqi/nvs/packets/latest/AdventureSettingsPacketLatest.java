package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.AdventureSettingsPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class AdventureSettingsPacketLatest extends AdventureSettingsPacket implements ConvertedProtocolPacket {

    public AdventureSettingsPacketLatest (AdventureSettingsPacket packet) {
        flags = packet.flags;
        commandPermission = packet.commandPermission;
        flags2 = packet.flags2;
        playerPermission = packet.playerPermission;
        customFlags = packet.customFlags;
        entityUniqueId = packet.entityUniqueId;
    }

}
