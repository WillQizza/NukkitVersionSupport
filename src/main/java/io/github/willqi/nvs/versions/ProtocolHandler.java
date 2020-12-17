package io.github.willqi.nvs.versions;

import cn.nukkit.network.protocol.DataPacket;

public interface ProtocolHandler {

    /**
     * Convert a packet from the server in a higher protocol to this protocol
     * @param packet
     * @return
     */
    DataPacket convertClientBoundPacketToThisVersion (DataPacket packet);

    /**
     * Convert a packet sent from a player in the previous protocol to this protocol
     * @param packet
     * @return
     */
    DataPacket convertServerBoundPacketToThisVersion (DataPacket packet);

    int getPreviousProtocolVersion ();

    int getProtocolVersion ();

    int getNextProtocolVersion ();

}
