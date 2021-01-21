package io.github.willqi.nvs.packets.v408;

import cn.nukkit.entity.Attribute;
import cn.nukkit.network.protocol.UpdateAttributesPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class UpdateAttributesPacketV408 extends UpdateAttributesPacket implements ConvertedProtocolPacket {

    @Override
    public void encode() {
        this.reset();

        this.putEntityRuntimeId(this.entityId);

        if (this.entries == null) {
            this.putUnsignedVarInt(0);
        } else {
            this.putUnsignedVarInt(this.entries.length);
            for (Attribute entry : this.entries) {
                this.putLFloat(entry.getMinValue());
                this.putLFloat(entry.getMaxValue());
                this.putLFloat(entry.getValue());
                this.putLFloat(entry.getDefaultValue());
                this.putString(entry.getName());
            }
        }
    }
}
