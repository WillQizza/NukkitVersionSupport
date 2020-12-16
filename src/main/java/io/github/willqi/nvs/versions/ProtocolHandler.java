package io.github.willqi.nvs.versions;

import cn.nukkit.network.protocol.DataPacket;

public interface ProtocolHandler {

    DataPacket convertClientBoundPacketToThisVersion (DataPacket packet);

    DataPacket convertServerBoundPacketToThisVersion (DataPacket packet);

    int getPreviousProtocolVersion ();

    int getProtocolVersion ();

    int getNextProtocolVersion ();

}
