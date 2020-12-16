package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.SetCommandsEnabledPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class SetCommandsEnabledPacketLatest extends SetCommandsEnabledPacket implements ConvertedProtocolPacket {

    public SetCommandsEnabledPacketLatest (SetCommandsEnabledPacket packet) {
        enabled = packet.enabled;
    }

}
