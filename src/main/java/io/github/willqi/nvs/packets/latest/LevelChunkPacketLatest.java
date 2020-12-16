package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.LevelChunkPacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class LevelChunkPacketLatest extends LevelChunkPacket implements ConvertedProtocolPacket {
    
    public LevelChunkPacketLatest (LevelChunkPacket packet) {
        chunkX = packet.chunkX;
        chunkZ = packet.chunkZ;
        subChunkCount = packet.subChunkCount;
        cacheEnabled = packet.cacheEnabled;
        blobIds = packet.blobIds;
        data = packet.data;
    }
    
}
