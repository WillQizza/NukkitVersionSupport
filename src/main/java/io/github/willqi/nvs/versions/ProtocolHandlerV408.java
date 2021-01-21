package io.github.willqi.nvs.versions;

import cn.nukkit.network.protocol.*;
import io.github.willqi.nvs.packets.v408.*;

public class ProtocolHandlerV408 implements ProtocolHandler {

    @Override
    public DataPacket convertClientBoundPacketToThisVersion(DataPacket packet) {
        DataPacket newPacket = packet;
        switch (packet.pid()) {
            case ProtocolInfo.CONTAINER_CLOSE_PACKET:
                newPacket = new ContainerClosePacketV408();
                ((ContainerClosePacketV408)newPacket).windowId = ((ContainerClosePacket)packet).windowId;
                break;
            case ProtocolInfo.SET_ENTITY_DATA_PACKET:
                newPacket = new SetEntityDataPacketV408();
                ((SetEntityDataPacketV408)newPacket).eid = ((SetEntityDataPacket)packet).eid;
                ((SetEntityDataPacketV408)newPacket).metadata = ((SetEntityDataPacket)packet).metadata;
                break;
            case ProtocolInfo.RESOURCE_PACK_STACK_PACKET:
                newPacket = new ResourcePackStackPacketV408();
                ((ResourcePackStackPacketV408)newPacket).mustAccept = ((ResourcePackStackPacket)packet).mustAccept;
                ((ResourcePackStackPacketV408)newPacket).behaviourPackStack = ((ResourcePackStackPacket)packet).behaviourPackStack;
                ((ResourcePackStackPacketV408)newPacket).resourcePackStack = ((ResourcePackStackPacket)packet).resourcePackStack;
                ((ResourcePackStackPacketV408)newPacket).isExperimental = ((ResourcePackStackPacket)packet).isExperimental;
                ((ResourcePackStackPacketV408)newPacket).gameVersion = ((ResourcePackStackPacket)packet).gameVersion;
                break;
            case ProtocolInfo.UPDATE_ATTRIBUTES_PACKET:
                newPacket = new UpdateAttributesPacketV408();
                ((UpdateAttributesPacketV408)newPacket).entries = ((UpdateAttributesPacket)packet).entries;
                ((UpdateAttributesPacketV408)newPacket).entityId = ((UpdateAttributesPacket)packet).entityId;
                break;
            case ProtocolInfo.START_GAME_PACKET:
                newPacket = new StartGamePacketV408();
                ((StartGamePacketV408)newPacket).entityUniqueId = ((StartGamePacket)packet).entityUniqueId;
                ((StartGamePacketV408)newPacket).entityRuntimeId = ((StartGamePacket)packet).entityRuntimeId;
                ((StartGamePacketV408)newPacket).playerGamemode = ((StartGamePacket)packet).playerGamemode;
                ((StartGamePacketV408)newPacket).x = ((StartGamePacket)packet).x;
                ((StartGamePacketV408)newPacket).y = ((StartGamePacket)packet).y;
                ((StartGamePacketV408)newPacket).z = ((StartGamePacket)packet).z;
                ((StartGamePacketV408)newPacket).yaw = ((StartGamePacket)packet).yaw;
                ((StartGamePacketV408)newPacket).pitch = ((StartGamePacket)packet).pitch;
                ((StartGamePacketV408)newPacket).seed = ((StartGamePacket)packet).seed;
                ((StartGamePacketV408)newPacket).dimension = ((StartGamePacket)packet).dimension;
                ((StartGamePacketV408)newPacket).generator = ((StartGamePacket)packet).generator;
                ((StartGamePacketV408)newPacket).worldGamemode = ((StartGamePacket)packet).worldGamemode;
                ((StartGamePacketV408)newPacket).difficulty = ((StartGamePacket)packet).difficulty;
                ((StartGamePacketV408)newPacket).spawnX = ((StartGamePacket)packet).spawnX;
                ((StartGamePacketV408)newPacket).spawnY = ((StartGamePacket)packet).spawnY;
                ((StartGamePacketV408)newPacket).spawnZ = ((StartGamePacket)packet).spawnZ;
                ((StartGamePacketV408)newPacket).hasAchievementsDisabled = ((StartGamePacket)packet).hasAchievementsDisabled;
                ((StartGamePacketV408)newPacket).dayCycleStopTime = ((StartGamePacket)packet).dayCycleStopTime;
                ((StartGamePacketV408)newPacket).eduEditionOffer = ((StartGamePacket)packet).eduEditionOffer;
                ((StartGamePacketV408)newPacket).hasEduFeaturesEnabled = ((StartGamePacket)packet).hasEduFeaturesEnabled;
                ((StartGamePacketV408)newPacket).rainLevel = ((StartGamePacket)packet).rainLevel;
                ((StartGamePacketV408)newPacket).lightningLevel = ((StartGamePacket)packet).lightningLevel;
                ((StartGamePacketV408)newPacket).hasConfirmedPlatformLockedContent = ((StartGamePacket)packet).hasConfirmedPlatformLockedContent;
                ((StartGamePacketV408)newPacket).multiplayerGame = ((StartGamePacket)packet).multiplayerGame;
                ((StartGamePacketV408)newPacket).broadcastToLAN = ((StartGamePacket)packet).broadcastToLAN;
                ((StartGamePacketV408)newPacket).xblBroadcastIntent = ((StartGamePacket)packet).xblBroadcastIntent;
                ((StartGamePacketV408)newPacket).platformBroadcastIntent = ((StartGamePacket)packet).platformBroadcastIntent;
                ((StartGamePacketV408)newPacket).commandsEnabled = ((StartGamePacket)packet).commandsEnabled;
                ((StartGamePacketV408)newPacket).isTexturePacksRequired = ((StartGamePacket)packet).isTexturePacksRequired;
                ((StartGamePacketV408)newPacket).gameRules = ((StartGamePacket)packet).gameRules;
                ((StartGamePacketV408)newPacket).bonusChest = ((StartGamePacket)packet).bonusChest;
                ((StartGamePacketV408)newPacket).hasStartWithMapEnabled = ((StartGamePacket)packet).hasStartWithMapEnabled;
                ((StartGamePacketV408)newPacket).trustingPlayers = ((StartGamePacket)packet).trustingPlayers;
                ((StartGamePacketV408)newPacket).permissionLevel = ((StartGamePacket)packet).permissionLevel;
                ((StartGamePacketV408)newPacket).serverChunkTickRange = ((StartGamePacket)packet).serverChunkTickRange;
                ((StartGamePacketV408)newPacket).hasLockedBehaviorPack = ((StartGamePacket)packet).hasLockedBehaviorPack;
                ((StartGamePacketV408)newPacket).hasLockedResourcePack = ((StartGamePacket)packet).hasLockedResourcePack;
                ((StartGamePacketV408)newPacket).isFromLockedWorldTemplate = ((StartGamePacket)packet).isFromLockedWorldTemplate;
                ((StartGamePacketV408)newPacket).isUsingMsaGamertagsOnly = ((StartGamePacket)packet).isUsingMsaGamertagsOnly;
                ((StartGamePacketV408)newPacket).isFromWorldTemplate = ((StartGamePacket)packet).isFromWorldTemplate;
                ((StartGamePacketV408)newPacket).isWorldTemplateOptionLocked = ((StartGamePacket)packet).isWorldTemplateOptionLocked;
                ((StartGamePacketV408)newPacket).isOnlySpawningV1Villagers = ((StartGamePacket)packet).isOnlySpawningV1Villagers;
                ((StartGamePacketV408)newPacket).vanillaVersion = "1.16.20";
                ((StartGamePacketV408)newPacket).levelId = ((StartGamePacket)packet).levelId;
                ((StartGamePacketV408)newPacket).worldName = ((StartGamePacket)packet).worldName;
                ((StartGamePacketV408)newPacket).premiumWorldTemplateId = ((StartGamePacket)packet).premiumWorldTemplateId;
                ((StartGamePacketV408)newPacket).isTrial = ((StartGamePacket)packet).isTrial;
                ((StartGamePacketV408)newPacket).isMovementServerAuthoritative = ((StartGamePacket)packet).isMovementServerAuthoritative;
                ((StartGamePacketV408)newPacket).isInventoryServerAuthoritative = ((StartGamePacket)packet).isInventoryServerAuthoritative;
                ((StartGamePacketV408)newPacket).currentTick = ((StartGamePacket)packet).currentTick;
                ((StartGamePacketV408)newPacket).enchantmentSeed = ((StartGamePacket)packet).enchantmentSeed;
                ((StartGamePacketV408)newPacket).multiplayerCorrelationId = ((StartGamePacket)packet).multiplayerCorrelationId;
                break;
            case ProtocolInfo.MOVE_PLAYER_PACKET:
                newPacket = new MovePlayerPacketV408();
                ((MovePlayerPacketV408)newPacket).eid = ((MovePlayerPacket)packet).eid;
                ((MovePlayerPacketV408)newPacket).x = ((MovePlayerPacket)packet).x;
                ((MovePlayerPacketV408)newPacket).y = ((MovePlayerPacket)packet).y;
                ((MovePlayerPacketV408)newPacket).z = ((MovePlayerPacket)packet).z;
                ((MovePlayerPacketV408)newPacket).pitch = ((MovePlayerPacket)packet).pitch;
                ((MovePlayerPacketV408)newPacket).yaw = ((MovePlayerPacket)packet).yaw;
                ((MovePlayerPacketV408)newPacket).headYaw = ((MovePlayerPacket)packet).headYaw;
                ((MovePlayerPacketV408)newPacket).mode = ((MovePlayerPacket)packet).mode;
                ((MovePlayerPacketV408)newPacket).onGround = ((MovePlayerPacket)packet).onGround;
                ((MovePlayerPacketV408)newPacket).ridingEid = ((MovePlayerPacket)packet).ridingEid;
                ((MovePlayerPacketV408)newPacket).int1 = ((MovePlayerPacket)packet).int1;
                ((MovePlayerPacketV408)newPacket).int2 = ((MovePlayerPacket)packet).int2;
                break;
            case ProtocolInfo.MOVE_ENTITY_DELTA_PACKET:
                newPacket = new MoveEntityDeltaPacketV408();
                ((MoveEntityDeltaPacketV408)newPacket).flags = ((MoveEntityDeltaPacket)newPacket).flags;
                ((MoveEntityDeltaPacketV408)newPacket).x = ((MoveEntityDeltaPacket)newPacket).x;
                ((MoveEntityDeltaPacketV408)newPacket).y = ((MoveEntityDeltaPacket)newPacket).y;
                ((MoveEntityDeltaPacketV408)newPacket).z = ((MoveEntityDeltaPacket)newPacket).z;
                ((MoveEntityDeltaPacketV408)newPacket).yawDelta = ((MoveEntityDeltaPacket)newPacket).yawDelta;
                ((MoveEntityDeltaPacketV408)newPacket).headYawDelta = ((MoveEntityDeltaPacket)newPacket).headYawDelta;
                ((MoveEntityDeltaPacketV408)newPacket).pitchDelta = ((MoveEntityDeltaPacket)newPacket).pitchDelta;
                break;
        }
        return newPacket;
    }

    @Override
    public DataPacket convertServerBoundPacketToThisVersion(DataPacket packet) {
        DataPacket newPacket = packet;
        switch (packet.pid()) {

            case ProtocolInfo.MOVE_ENTITY_DELTA_PACKET:
                newPacket = new MoveEntityDeltaPacketV408();
                packet.setOffset(0);
                newPacket.setBuffer(packet.getBuffer());
                newPacket.decode();
                break;

        }
        return newPacket;
    }

    @Override
    public int getPreviousProtocolVersion() {
        return 407;
    }

    @Override
    public int getProtocolVersion() {
        return 408;
    }

    @Override
    public int getNextProtocolVersion() {
        return 419;
    }
}
