package io.github.willqi.nvs.versions;

import cn.nukkit.network.protocol.DataPacket;
import cn.nukkit.network.protocol.LoginPacket;
import cn.nukkit.network.protocol.ProtocolInfo;
import io.github.willqi.nvs.packets.v419.ResourcePacksInfoPacketV419;
import io.github.willqi.nvs.packets.v422.LoginPacketV422;
import io.github.willqi.nvs.packets.v422.ResourcePacksInfoPacketV422;

public class ProtocolHandlerV422 implements ProtocolHandler {

    @Override
    public DataPacket convertClientBoundPacketToThisVersion(DataPacket packet) {
        DataPacket newPacket = packet;
        switch (packet.pid()) {

            case ProtocolInfo.RESOURCE_PACKS_INFO_PACKET:
                newPacket = new ResourcePacksInfoPacketV422();
                ((ResourcePacksInfoPacketV422)newPacket).resourcePackEntries = ((ResourcePacksInfoPacketV419)packet).resourcePackEntries;
                ((ResourcePacksInfoPacketV422)newPacket).behaviourPackEntries = ((ResourcePacksInfoPacketV419)packet).behaviourPackEntries;
                ((ResourcePacksInfoPacketV422)newPacket).mustAccept = ((ResourcePacksInfoPacketV419)packet).mustAccept;
                ((ResourcePacksInfoPacketV422)newPacket).scripting = ((ResourcePacksInfoPacketV419)packet).scripting;
                break;

        }
        return newPacket;
    }

    @Override
    public DataPacket convertServerBoundPacketToThisVersion(DataPacket packet) {
        DataPacket newPacket = packet;
        switch (packet.pid()) {

            case ProtocolInfo.LOGIN_PACKET:
                newPacket = new LoginPacketV422();
                packet.setOffset(0);
                newPacket.setBuffer(packet.getBuffer());
                newPacket.decode();
                break;

        }
        return newPacket;
    }

    @Override
    public int getPreviousProtocolVersion() {
        return 419;
    }

    @Override
    public int getProtocolVersion() {
        return 422;
    }

    @Override
    public int getNextProtocolVersion() {
        return 0;   // TODO: Find next protocol version
    }
}
