package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.SetLocalPlayerAsInitializedPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class SetLocalPlayerAsInitializedPacketLatest extends SetLocalPlayerAsInitializedPacket implements ConvertedProtocolPacket {

    public SetLocalPlayerAsInitializedPacketLatest (SetLocalPlayerAsInitializedPacket packet) {
        eid = packet.eid;
    }

}
