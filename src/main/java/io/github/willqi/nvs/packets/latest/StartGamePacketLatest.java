package io.github.willqi.nvs.packets.latest;

import cn.nukkit.network.protocol.StartGamePacket;
import io.github.willqi.nvs.packets.ConvertedProtocolPacket;

public class StartGamePacketLatest extends StartGamePacket implements ConvertedProtocolPacket {

    public StartGamePacketLatest (StartGamePacket packet) {
        entityRuntimeId = packet.entityRuntimeId;
        entityUniqueId = packet.entityUniqueId;
        playerGamemode = packet.playerGamemode;
        x = packet.x;
        y = packet.y;
        z = packet.z;
        yaw = packet.yaw;
        pitch = packet.pitch;
        seed = packet.seed;
        dimension = packet.dimension;
        generator = packet.generator;
        worldGamemode = packet.worldGamemode;
        difficulty = packet.difficulty;
        spawnX = packet.spawnX;
        spawnY = packet.spawnY;
        spawnZ = packet.spawnZ;
        hasAchievementsDisabled = packet.hasAchievementsDisabled;
        dayCycleStopTime = packet.dayCycleStopTime;
        eduEditionOffer = packet.eduEditionOffer;
        hasEduFeaturesEnabled = packet.hasEduFeaturesEnabled;
        rainLevel = packet.rainLevel;
        lightningLevel = packet.lightningLevel;
        hasConfirmedPlatformLockedContent = packet.hasConfirmedPlatformLockedContent;
        multiplayerGame = packet.multiplayerGame;
        broadcastToLAN = packet.broadcastToLAN;
        xblBroadcastIntent = packet.xblBroadcastIntent;
        platformBroadcastIntent = packet.platformBroadcastIntent;
        commandsEnabled = packet.commandsEnabled;
        isTexturePacksRequired = packet.isTexturePacksRequired;
        gameRules = packet.gameRules;
        bonusChest = packet.bonusChest;
        hasStartWithMapEnabled = packet.hasStartWithMapEnabled;
        trustingPlayers = packet.trustingPlayers;
        permissionLevel = packet.permissionLevel;
        serverChunkTickRange = packet.serverChunkTickRange;
        hasLockedBehaviorPack = packet.hasLockedBehaviorPack;
        hasLockedResourcePack = packet.hasLockedResourcePack;
        isFromLockedWorldTemplate = packet.isFromLockedWorldTemplate;
        isUsingMsaGamertagsOnly = packet.isUsingMsaGamertagsOnly;
        isFromWorldTemplate = packet.isFromWorldTemplate;
        isWorldTemplateOptionLocked = packet.isWorldTemplateOptionLocked;
        isOnlySpawningV1Villagers = packet.isOnlySpawningV1Villagers;
        vanillaVersion = packet.vanillaVersion;
        levelId = packet.levelId;
        worldName = packet.worldName;
        premiumWorldTemplateId = packet.premiumWorldTemplateId;
        isTrial = packet.isTrial;
        isMovementServerAuthoritative = packet.isMovementServerAuthoritative;
        isInventoryServerAuthoritative = packet.isInventoryServerAuthoritative;
        currentTick = packet.currentTick;
        enchantmentSeed = packet.enchantmentSeed;
        multiplayerCorrelationId = packet.multiplayerCorrelationId;

    }

}
