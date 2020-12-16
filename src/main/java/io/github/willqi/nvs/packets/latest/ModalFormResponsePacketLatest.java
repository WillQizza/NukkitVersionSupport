package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.ModalFormResponsePacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class ModalFormResponsePacketLatest extends ModalFormResponsePacket implements ConvertedProtocolPacket {

    public ModalFormResponsePacketLatest (ModalFormResponsePacket packet) {
        formId = packet.formId;
        data = packet.data;
    }

}
