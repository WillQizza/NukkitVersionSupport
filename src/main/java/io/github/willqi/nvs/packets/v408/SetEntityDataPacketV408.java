package io.github.willqi.nvs.packets.v408;

import cn.nukkit.network.protocol.SetEntityDataPacket;
import cn.nukkit.utils.Binary;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class SetEntityDataPacketV408 extends SetEntityDataPacket implements ConvertedProtocolPacket {

    @Override
    public void encode() {
        this.reset();
        this.putEntityRuntimeId(this.eid);
        this.put(Binary.writeMetadata(this.metadata));  // TODO: IT'S PROBABLY THIS PACKET??? Compare and contrast the content and see what's up in 1.16.20 and 1.16.100
    }
}
