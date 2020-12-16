package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.MobArmorEquipmentPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class MobArmorEquipmentPacketLatest extends MobArmorEquipmentPacket implements ConvertedProtocolPacket {

    public MobArmorEquipmentPacketLatest (MobArmorEquipmentPacket packet) {
        eid = packet.eid;
        slots = packet.slots;
    }

}
