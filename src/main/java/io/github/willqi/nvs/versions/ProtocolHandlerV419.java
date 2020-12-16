package io.github.willqi.nvs.versions;

import cn.nukkit.network.protocol.DataPacket;
import cn.nukkit.network.protocol.ProtocolInfo;
import io.github.willqi.nvs.packets.v419.ResourcePacksInfoPacketV419;
import io.github.willqi.nvs.packets.v422.ResourcePacksInfoPacketV422;

public class ProtocolHandlerV419 implements ProtocolHandler {

    @Override
    public DataPacket convertClientBoundPacketToThisVersion(DataPacket packet) {
        DataPacket newPacket = packet;
        switch (packet.pid()) {

            case ProtocolInfo.RESOURCE_PACKS_INFO_PACKET:
                newPacket = new ResourcePacksInfoPacketV419();
                ((ResourcePacksInfoPacketV419)newPacket).resourcePackEntries = ((ResourcePacksInfoPacketV422)packet).resourcePackEntries;
                ((ResourcePacksInfoPacketV419)newPacket).behaviourPackEntries = ((ResourcePacksInfoPacketV422)packet).behaviourPackEntries;
                ((ResourcePacksInfoPacketV419)newPacket).mustAccept = ((ResourcePacksInfoPacketV422)packet).mustAccept;
                ((ResourcePacksInfoPacketV419)newPacket).scripting = ((ResourcePacksInfoPacketV422)packet).scripting;
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
