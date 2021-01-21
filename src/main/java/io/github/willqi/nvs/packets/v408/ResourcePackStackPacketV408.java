package io.github.willqi.nvs.packets.v408;

import cn.nukkit.network.protocol.ResourcePackStackPacket;
import cn.nukkit.resourcepacks.ResourcePack;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class ResourcePackStackPacketV408 extends ResourcePackStackPacket implements ConvertedProtocolPacket {

    @Override
    public void encode() {

        this.reset();
        this.putBoolean(this.mustAccept);

        this.putUnsignedVarInt(this.behaviourPackStack.length);
        for (ResourcePack entry : this.behaviourPackStack) {
            this.putString(entry.getPackId().toString());
            this.putString(entry.getPackVersion());
            this.putString("");
        }

        this.putUnsignedVarInt(this.resourcePackStack.length);
        for (ResourcePack entry : this.resourcePackStack) {
            this.putString(entry.getPackId().toString());
            this.putString(entry.getPackVersion());
            this.putString("");
        }

        this.putBoolean(this.isExperimental);
        this.putString(this.gameVersion);

    }
}
