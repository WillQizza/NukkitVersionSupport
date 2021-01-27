package io.github.willqi.nvs.versions;

import cn.nukkit.network.protocol.DataPacket;
import cn.nukkit.network.protocol.ProtocolInfo;
import cn.nukkit.network.protocol.ResourcePacksInfoPacket;
import io.github.willqi.nvs.packets.v419.ResourcePacksInfoPacketV419;

public class ProtocolHandlerV419 implements ProtocolHandler {

    @Override
    public DataPacket convertClientBoundPacketToThisVersion(DataPacket packet) {
        DataPacket newPacket = packet;
        switch (packet.pid()) {

            case ProtocolInfo.RESOURCE_PACKS_INFO_PACKET:
                newPacket = new ResourcePacksInfoPacketV419();
                ((ResourcePacksInfoPacketV419)newPacket).resourcePackEntries = ((ResourcePacksInfoPacket)packet).resourcePackEntries;
                ((ResourcePacksInfoPacketV419)newPacket).behaviourPackEntries = ((ResourcePacksInfoPacket)packet).behaviourPackEntries;
                ((ResourcePacksInfoPacketV419)newPacket).mustAccept = ((ResourcePacksInfoPacket)packet).mustAccept;
                ((ResourcePacksInfoPacketV419)newPacket).scripting = ((ResourcePacksInfoPacket)packet).scripting;
                break;

        }
        return newPacket;
    }

    @Override
    public DataPacket convertServerBoundPacketToThisVersion(DataPacket packet) {
        return packet;
    }

    @Override
    public int getPreviousProtocolVersion() {
        return 408; // We do not support this version at the moment. But, for consistency, we will provide the version.
    }

    @Override
    public int getProtocolVersion() {
        return 419;
    }

    @Override
    public int getNextProtocolVersion() {
        return 422;
    }

}
