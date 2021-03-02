package io.github.willqi.nvs.versions;

import cn.nukkit.network.SourceInterface;
import cn.nukkit.network.protocol.DataPacket;
import cn.nukkit.network.protocol.LoginPacket;

import java.net.InetSocketAddress;

public class PlayerV419 extends PlayerVBase {

    private static final int NEXT_PROTOCOL_VERSION = 422;

    public PlayerV419(SourceInterface interfaz, Long clientID, InetSocketAddress socketAddress) {
        super(interfaz, clientID, socketAddress, NEXT_PROTOCOL_VERSION);
    }

    @Override
    public DataPacket convertIncomingPacketToNextVersion(DataPacket packet) {
        DataPacket newPacket = packet;
        if (newPacket instanceof LoginPacket) {

        }
        return newPacket;
    }

    @Override
    public DataPacket convertOutgoingPacketToThisVersion(DataPacket packet) {
        return packet;
    }

}
