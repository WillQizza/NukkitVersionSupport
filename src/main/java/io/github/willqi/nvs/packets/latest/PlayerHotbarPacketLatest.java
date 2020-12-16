package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.PlayerHotbarPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class PlayerHotbarPacketLatest extends PlayerHotbarPacket implements ConvertedProtocolPacket {

    public PlayerHotbarPacketLatest (PlayerHotbarPacket packet) {
        selectedHotbarSlot = packet.selectedHotbarSlot;
        windowId = packet.windowId;
        selectHotbarSlot = packet.selectHotbarSlot;
    }

}
