package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.BlockPickRequestPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class BlockPickRequestPacketLatest extends BlockPickRequestPacket implements ConvertedProtocolPacket {

    public BlockPickRequestPacketLatest (BlockPickRequestPacket packet) {
        x = packet.x;
        y = packet.y;
        z = packet.z;
        addUserData = packet.addUserData;
        selectedSlot = packet.selectedSlot;
    }


}
