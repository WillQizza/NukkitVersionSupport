package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.AnimatePacket;
import cn.nukkit.network.protocol.DataPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class AnimatePacketLatest extends AnimatePacket implements ConvertedProtocolPacket {

    public AnimatePacketLatest (DataPacket packet) {
        eid = ((AnimatePacket)packet).eid;
        action = ((AnimatePacket)packet).action;
        rowingTime = ((AnimatePacket)packet).rowingTime;
    }

}
