package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.PlayerSkinPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class PlayerSkinPacketLatest extends PlayerSkinPacket implements ConvertedProtocolPacket {

    public PlayerSkinPacketLatest (PlayerSkinPacket packet) {
        uuid = packet.uuid;
        skin = packet.skin;
        newSkinName = packet.newSkinName;
        oldSkinName = packet.oldSkinName;
    }

}
