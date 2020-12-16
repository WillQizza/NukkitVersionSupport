package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.VideoStreamConnectPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class VideoStreamConnectPacketLatest extends VideoStreamConnectPacket implements ConvertedProtocolPacket {

    public VideoStreamConnectPacketLatest (VideoStreamConnectPacket packet) {
        address = packet.address;
        screenshotFrequency = packet.screenshotFrequency;
        action = packet.action;
    }

}
