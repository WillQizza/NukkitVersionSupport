package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.AdventureSettingsPacket;
import cn.nukkit.network.protocol.DataPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class AdventureSettingsPacketLatest extends AdventureSettingsPacket implements ConvertedProtocolPacket {

    public AdventureSettingsPacketLatest (DataPacket packet) {
        flags = ((AdventureSettingsPacket)packet).flags;
        commandPermission = ((AdventureSettingsPacket)packet).commandPermission;
        flags2 = ((AdventureSettingsPacket)packet).flags2;
        playerPermission = ((AdventureSettingsPacket)packet).playerPermission;
        customFlags = ((AdventureSettingsPacket)packet).customFlags;
        entityUniqueId = ((AdventureSettingsPacket)packet).entityUniqueId;
    }

}
