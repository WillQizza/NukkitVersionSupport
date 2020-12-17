package io.github.willqi.nvs.packets.v422;

import cn.nukkit.network.protocol.ResourcePacksInfoPacket;
import cn.nukkit.resourcepacks.ResourcePack;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class ResourcePacksInfoPacketV422 extends ResourcePacksInfoPacket implements ConvertedProtocolPacket {

    @Override
    public void encode() {
        this.reset();
        this.putBoolean(mustAccept);
        this.putBoolean(scripting);

        encodePacks(resourcePackEntries);
        encodePacks(behaviourPackEntries);
    }

    private void encodePacks(ResourcePack[] packs) {
        this.putLShort(packs.length);
        for (ResourcePack entry : packs) {
            this.putString(entry.getPackId().toString());
            this.putString(entry.getPackVersion());
            this.putLLong(entry.getPackSize());
            this.putString(""); // encryption key
            this.putString(""); // sub-pack name
            this.putString(""); // content identity
            this.putBoolean(false); // scripting
            this.putBoolean(false); // ray casting
        }
    }

}
