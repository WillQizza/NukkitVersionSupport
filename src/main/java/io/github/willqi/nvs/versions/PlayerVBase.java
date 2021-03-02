package io.github.willqi.nvs.versions;

import cn.nukkit.Player;
import cn.nukkit.network.SourceInterface;
import cn.nukkit.network.protocol.DataPacket;
import io.github.willqi.nvs.NVSAPI;
import io.github.willqi.nvs.NVSPlayer;

import java.net.InetSocketAddress;
import java.util.Optional;

public abstract class PlayerVBase extends NVSPlayer {

    public PlayerVBase(SourceInterface interfaz, Long clientID, InetSocketAddress socketAddress, int nextProtocol) {
        super(interfaz, clientID, socketAddress);

        Optional<Class<? extends Player>> protocolPlayerClass = NVSAPI.getProtocolPlayer(nextProtocol);
        if (protocolPlayerClass.isPresent()) {
            this.protocolPlayer = makePlayerInstance(protocolPlayerClass.get());
        } else {
            NVSAPI.get().getLogger().debug("Could not find protocol player for v" + nextProtocol);
            this.protocolPlayer = makePlayerInstance(Player.class);
        }

    }

    /**
     * Handles converting packets from this version to the next version.
     * @param packet
     * @return
     */
    public abstract DataPacket convertIncomingPacketToNextVersion(DataPacket packet);

    /**
     * Handles converting packets from the next version to this version.
     * @param packet
     * @return
     */
    public abstract DataPacket convertOutgoingPacketToThisVersion(DataPacket packet);

    /**
     * Downgrades a outgoing packet to this version.
     * Used internally and should not be called by version classes.
     * @param packet
     * @return
     */
    public DataPacket downgradePacketToThisVersion(DataPacket packet) {
        DataPacket newPacket = packet;
        if (this.protocolPlayer instanceof PlayerVBase) {
            newPacket = ((PlayerVBase)this.protocolPlayer).downgradePacketToThisVersion(newPacket);
        }
        newPacket = convertOutgoingPacketToThisVersion(newPacket);
        return newPacket;
    }

    @Override
    public void handleDataPacket(DataPacket packet) {

        if (this.protocolPlayer != null) {
            DataPacket newPacket = this.convertIncomingPacketToNextVersion(packet);
            this.protocolPlayer.handleDataPacket(newPacket);
        }

    }

    @Override
    public boolean dataPacket(DataPacket packet) {
        if (this.protocolPlayer != null) {
            if (this.protocolPlayer instanceof PlayerVBase) {
                // Downgrade this packet to the previous version.
                DataPacket newPacket = this.downgradePacketToThisVersion(packet);
                return this.dataPacketWithoutVersionSupport(newPacket);
            } else {
                return this.protocolPlayer.dataPacket(packet);
            }
        }
        return false;
    }

}
