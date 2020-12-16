package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.ModalFormRequestPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class ModalFormRequestPacketLatest extends ModalFormRequestPacket implements ConvertedProtocolPacket {

    public ModalFormRequestPacketLatest (ModalFormRequestPacket packet) {
        formId = packet.formId;
        data = packet.data;
    }

}
