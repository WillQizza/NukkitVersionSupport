package io.github.willqi.nvs.versions;

import cn.nukkit.network.protocol.*;
import io.github.willqi.nvs.packets.latest.*;
import org.apache.logging.log4j.core.net.Protocol;

import java.util.HashMap;
import java.util.Map;

public class ProtocolHandlerLatest implements ProtocolHandler {

    private static final Map<Byte, PacketWrapper> packetTypes = new HashMap<>();

    static {
        packetTypes.put(ProtocolInfo.ADD_ENTITY_PACKET, new PacketWrapper(AddEntityPacketLatest.class, AddEntityPacket.class));
        packetTypes.put(ProtocolInfo.ADD_ITEM_ENTITY_PACKET, new PacketWrapper(AddItemEntityPacketLatest.class, AddItemEntityPacket.class));
        packetTypes.put(ProtocolInfo.ADD_PAINTING_PACKET, new PacketWrapper(AddPaintingPacketLatest.class, AddPaintingPacket.class));
        packetTypes.put(ProtocolInfo.ADD_PLAYER_PACKET, new PacketWrapper(AddPlayerPacketLatest.class, AddPlayerPacket.class));
        packetTypes.put(ProtocolInfo.ADVENTURE_SETTINGS_PACKET, new PacketWrapper(AdventureSettingsPacketLatest.class, AdventureSettingsPacket.class));
        packetTypes.put(ProtocolInfo.ANIMATE_PACKET, new PacketWrapper(AnimatePacketLatest.class, AnimatePacket.class));
        packetTypes.put(ProtocolInfo.AVAILABLE_COMMANDS_PACKET, new PacketWrapper(AvailableCommandsPacketLatest.class, AvailableCommandsPacket.class));
        packetTypes.put(ProtocolInfo.BATCH_PACKET, new PacketWrapper(BatchPacketLatest.class, BatchPacket.class));
        packetTypes.put(ProtocolInfo.BLOCK_ENTITY_DATA_PACKET, new PacketWrapper(BlockEntityDataPacketLatest.class, BlockEntityDataPacket.class));
        packetTypes.put(ProtocolInfo.BLOCK_EVENT_PACKET, new PacketWrapper(BlockEventPacketLatest.class, BlockEventPacket.class));
        packetTypes.put(ProtocolInfo.BLOCK_PICK_REQUEST_PACKET, new PacketWrapper(BlockPickRequestPacketLatest.class, BlockPickRequestPacket.class));
        packetTypes.put(ProtocolInfo.BOOK_EDIT_PACKET, new PacketWrapper(BookEditPacketLatest.class, BookEditPacket.class));
        packetTypes.put(ProtocolInfo.BOSS_EVENT_PACKET, new PacketWrapper(BossEventPacketLatest.class, BossEventPacket.class));
        packetTypes.put(ProtocolInfo.CHANGE_DIMENSION_PACKET, new PacketWrapper(ChangeDimensionPacketLatest.class, ChangeDimensionPacket.class));
        packetTypes.put(ProtocolInfo.CHUNK_RADIUS_UPDATED_PACKET, new PacketWrapper(ChunkRadiusUpdatedPacketLatest.class, ChunkRadiusUpdatedPacket.class));
        packetTypes.put(ProtocolInfo.CLIENTBOUND_MAP_ITEM_DATA_PACKET, new PacketWrapper(ClientboundMapItemDataPacketLatest.class, ClientboundMapItemDataPacket.class));
        packetTypes.put(ProtocolInfo.COMMAND_REQUEST_PACKET, new PacketWrapper(CommandRequestPacketLatest.class, CommandRequestPacket.class));
        packetTypes.put(ProtocolInfo.CONTAINER_CLOSE_PACKET, new PacketWrapper(ContainerClosePacketLatest.class, ContainerClosePacket.class));
        packetTypes.put(ProtocolInfo.CONTAINER_OPEN_PACKET, new PacketWrapper(ContainerOpenPacketLatest.class, ContainerOpenPacket.class));
        packetTypes.put(ProtocolInfo.CONTAINER_SET_DATA_PACKET, new PacketWrapper(ContainerSetDataPacketLatest.class, ContainerSetDataPacket.class));
        packetTypes.put(ProtocolInfo.CRAFTING_DATA_PACKET, new PacketWrapper(CraftingDataPacketLatest.class, CraftingDataPacket.class));
        packetTypes.put(ProtocolInfo.CRAFTING_EVENT_PACKET, new PacketWrapper(CraftingEventPacketLatest.class, CraftingEventPacket.class));
        packetTypes.put(ProtocolInfo.DISCONNECT_PACKET, new PacketWrapper(DisconnectPacketLatest.class, DisconnectPacket.class));
        packetTypes.put(ProtocolInfo.ENTITY_EVENT_PACKET, new PacketWrapper(EntityEventPacketLatest.class, EntityEventPacket.class));
        packetTypes.put(ProtocolInfo.ENTITY_FALL_PACKET, new PacketWrapper(EntityFallPacketLatest.class, EntityFallPacket.class));
        packetTypes.put(ProtocolInfo.FULL_CHUNK_DATA_PACKET, new PacketWrapper(LevelChunkPacketLatest.class, LevelChunkPacket.class));
        packetTypes.put(ProtocolInfo.GAME_RULES_CHANGED_PACKET, new PacketWrapper(GameRulesChangedPacketLatest.class, GameRulesChangedPacket.class));
        packetTypes.put(ProtocolInfo.HURT_ARMOR_PACKET, new PacketWrapper(HurtArmorPacketLatest.class, HurtArmorPacket.class));
        packetTypes.put(ProtocolInfo.INTERACT_PACKET, new PacketWrapper(InteractPacketLatest.class, InteractPacket.class));
        packetTypes.put(ProtocolInfo.INVENTORY_CONTENT_PACKET, new PacketWrapper(InventoryContentPacketLatest.class, InventoryContentPacket.class));
        packetTypes.put(ProtocolInfo.INVENTORY_SLOT_PACKET, new PacketWrapper(InventorySlotPacketLatest.class, InventorySlotPacket.class));
        packetTypes.put(ProtocolInfo.INVENTORY_TRANSACTION_PACKET, new PacketWrapper(InventoryTransactionPacketLatest.class, InventoryTransactionPacket.class));
        packetTypes.put(ProtocolInfo.ITEM_FRAME_DROP_ITEM_PACKET, new PacketWrapper(ItemFrameDropPacketLatest.class, ItemFrameDropItemPacket.class));
        packetTypes.put(ProtocolInfo.LEVEL_EVENT_PACKET, new PacketWrapper(LevelEventPacketLatest.class, LevelEventPacket.class));
        packetTypes.put(ProtocolInfo.LEVEL_SOUND_EVENT_PACKET_V1, new PacketWrapper(LevelSoundEventPacketV1Latest.class, LevelSoundEventPacketV1.class));
        packetTypes.put(ProtocolInfo.LOGIN_PACKET, new PacketWrapper(LoginPacketLatest.class, LoginPacket.class));
        packetTypes.put(ProtocolInfo.MAP_INFO_REQUEST_PACKET, new PacketWrapper(MapInfoRequestPacketLatest.class, MapInfoRequestPacket.class));
        packetTypes.put(ProtocolInfo.MOB_ARMOR_EQUIPMENT_PACKET, new PacketWrapper(MobArmorEquipmentPacketLatest.class, MobArmorEquipmentPacket.class));
        packetTypes.put(ProtocolInfo.MOB_EQUIPMENT_PACKET, new PacketWrapper(MobEquipmentPacketLatest.class, MobEquipmentPacket.class));
        packetTypes.put(ProtocolInfo.MODAL_FORM_REQUEST_PACKET, new PacketWrapper(ModalFormRequestPacketLatest.class, ModalFormRequestPacket.class));
        packetTypes.put(ProtocolInfo.MODAL_FORM_RESPONSE_PACKET, new PacketWrapper(ModalFormResponsePacketLatest.class, ModalFormResponsePacket.class));
        packetTypes.put(ProtocolInfo.MOVE_ENTITY_ABSOLUTE_PACKET, new PacketWrapper(MoveEntityAbsolutePacketLatest.class, MoveEntityAbsolutePacket.class));
        packetTypes.put(ProtocolInfo.MOVE_PLAYER_PACKET, new PacketWrapper(MovePlayerPacketLatest.class, MovePlayerPacket.class));
        packetTypes.put(ProtocolInfo.PLAYER_ACTION_PACKET, new PacketWrapper(PlayerActionPacketLatest.class, PlayerActionPacket.class));
        packetTypes.put(ProtocolInfo.PLAYER_INPUT_PACKET, new PacketWrapper(PlayerInputPacketLatest.class, PlayerInputPacket.class));
        packetTypes.put(ProtocolInfo.PLAYER_LIST_PACKET, new PacketWrapper(PlayerListPacketLatest.class, PlayerListPacket.class));
        packetTypes.put(ProtocolInfo.PLAYER_HOTBAR_PACKET, new PacketWrapper(PlayerHotbarPacketLatest.class, PlayerHotbarPacket.class));
        packetTypes.put(ProtocolInfo.PLAY_SOUND_PACKET, new PacketWrapper(PlaySoundPacketLatest.class, PlaySoundPacket.class));
        packetTypes.put(ProtocolInfo.PLAY_STATUS_PACKET, new PacketWrapper(PlayStatusPacketLatest.class, PlayStatusPacket.class));
        packetTypes.put(ProtocolInfo.REMOVE_ENTITY_PACKET, new PacketWrapper(RemoveEntityPacketLatest.class, RemoveEntityPacket.class));
        packetTypes.put(ProtocolInfo.REQUEST_CHUNK_RADIUS_PACKET, new PacketWrapper(RequestChunkRadiusPacketLatest.class, RequestChunkRadiusPacket.class));
        packetTypes.put(ProtocolInfo.RESOURCE_PACKS_INFO_PACKET, new PacketWrapper(ResourcePacksInfoPacketLatest.class, ResourcePacksInfoPacket.class));
        packetTypes.put(ProtocolInfo.RESOURCE_PACK_STACK_PACKET, new PacketWrapper(ResourcePackStackPacketLatest.class, ResourcePackStackPacket.class));
        packetTypes.put(ProtocolInfo.RESOURCE_PACK_CLIENT_RESPONSE_PACKET, new PacketWrapper(ResourcePackClientResponsePacketLatest.class, ResourcePackClientResponsePacket.class));
        packetTypes.put(ProtocolInfo.RESOURCE_PACK_DATA_INFO_PACKET, new PacketWrapper(ResourcePackDataInfoPacketLatest.class, ResourcePackDataInfoPacket.class));
        packetTypes.put(ProtocolInfo.RESOURCE_PACK_CHUNK_DATA_PACKET, new PacketWrapper(ResourcePackChunkDataPacketLatest.class, ResourcePackChunkDataPacket.class));
        packetTypes.put(ProtocolInfo.RESOURCE_PACK_CHUNK_REQUEST_PACKET, new PacketWrapper(ResourcePackChunkRequestPacketLatest.class, ResourcePackChunkRequestPacket.class));
        packetTypes.put(ProtocolInfo.PLAYER_SKIN_PACKET, new PacketWrapper(PlayerSkinPacketLatest.class, PlayerSkinPacket.class));
        packetTypes.put(ProtocolInfo.RESPAWN_PACKET, new PacketWrapper(RespawnPacketLatest.class, RespawnPacket.class));
        packetTypes.put(ProtocolInfo.RIDER_JUMP_PACKET, new PacketWrapper(RiderJumpPacketLatest.class, RiderJumpPacket.class));
        packetTypes.put(ProtocolInfo.SET_COMMANDS_ENABLED_PACKET, new PacketWrapper(SetCommandsEnabledPacketLatest.class, SetCommandsEnabledPacket.class));
        packetTypes.put(ProtocolInfo.SET_DIFFICULTY_PACKET, new PacketWrapper(SetDifficultyPacketLatest.class, SetDifficultyPacket.class));
        packetTypes.put(ProtocolInfo.SET_ENTITY_DATA_PACKET, new PacketWrapper(SetEntityDataPacketLatest.class, SetEntityDataPacket.class));
        packetTypes.put(ProtocolInfo.SET_ENTITY_LINK_PACKET, new PacketWrapper(SetEntityLinkPacketLatest.class, SetEntityLinkPacket.class));
        packetTypes.put(ProtocolInfo.SET_ENTITY_MOTION_PACKET, new PacketWrapper(SetEntityMotionPacketLatest.class, SetEntityMotionPacket.class));
        packetTypes.put(ProtocolInfo.SET_HEALTH_PACKET, new PacketWrapper(SetHealthPacketLatest.class, SetHealthPacket.class));
        packetTypes.put(ProtocolInfo.SET_PLAYER_GAME_TYPE_PACKET, new PacketWrapper(SetPlayerGameTypePacketLatest.class, SetPlayerGameTypePacket.class));
        packetTypes.put(ProtocolInfo.SET_SPAWN_POSITION_PACKET, new PacketWrapper(SetSpawnPositionPacketLatest.class, SetSpawnPositionPacket.class));
        packetTypes.put(ProtocolInfo.SET_TITLE_PACKET, new PacketWrapper(SetTitlePacketLatest.class, SetTitlePacket.class));
        packetTypes.put(ProtocolInfo.SET_TIME_PACKET, new PacketWrapper(SetTimePacketLatest.class, SetTimePacket.class));
        packetTypes.put(ProtocolInfo.SERVER_SETTINGS_REQUEST_PACKET, new PacketWrapper(ServerSettingsRequestPacketLatest.class, ServerSettingsRequestPacket.class));
        packetTypes.put(ProtocolInfo.SERVER_SETTINGS_RESPONSE_PACKET, new PacketWrapper(ServerSettingsResponsePacketLatest.class, ServerSettingsResponsePacket.class));
        packetTypes.put(ProtocolInfo.SHOW_CREDITS_PACKET, new PacketWrapper(ShowCreditsPacketLatest.class, ShowCreditsPacket.class));
        packetTypes.put(ProtocolInfo.SPAWN_EXPERIENCE_ORB_PACKET, new PacketWrapper(SpawnExperienceOrbPacketLatest.class, SpawnExperienceOrbPacket.class));
        packetTypes.put(ProtocolInfo.START_GAME_PACKET, new PacketWrapper(StartGamePacketLatest.class, StartGamePacket.class));
        packetTypes.put(ProtocolInfo.TAKE_ITEM_ENTITY_PACKET, new PacketWrapper(TakeItemEntityPacketLatest.class, TakeItemEntityPacket.class));
        packetTypes.put(ProtocolInfo.TEXT_PACKET, new PacketWrapper(TextPacketLatest.class, TextPacket.class));
        packetTypes.put(ProtocolInfo.UPDATE_ATTRIBUTES_PACKET, new PacketWrapper(UpdateAttributesPacketLatest.class, UpdateAttributesPacket.class));
        packetTypes.put(ProtocolInfo.UPDATE_BLOCK_PACKET, new PacketWrapper(UpdateBlockPacketLatest.class, UpdateBlockPacket.class));
        packetTypes.put(ProtocolInfo.UPDATE_TRADE_PACKET, new PacketWrapper(UpdateTradePacketLatest.class, UpdateTradePacket.class));
        packetTypes.put(ProtocolInfo.MOVE_ENTITY_DELTA_PACKET, new PacketWrapper(MoveEntityDeltaPacketLatest.class, MoveEntityDeltaPacket.class));
        packetTypes.put(ProtocolInfo.SET_LOCAL_PLAYER_AS_INITIALIZED_PACKET, new PacketWrapper(SetLocalPlayerAsInitializedPacketLatest.class, SetLocalPlayerAsInitializedPacket.class));
        packetTypes.put(ProtocolInfo.NETWORK_STACK_LATENCY_PACKET, new PacketWrapper(NetworkStackLatencyPacketLatest.class, NetworkStackLatencyPacket.class));
        packetTypes.put(ProtocolInfo.UPDATE_SOFT_ENUM_PACKET, new PacketWrapper(UpdateSoftEnumPacketLatest.class, UpdateSoftEnumPacket.class));
        packetTypes.put(ProtocolInfo.NETWORK_CHUNK_PUBLISHER_UPDATE_PACKET, new PacketWrapper(NetworkChunkPublisherUpdatePacketLatest.class, NetworkChunkPublisherUpdatePacket.class));
        packetTypes.put(ProtocolInfo.AVAILABLE_ENTITY_IDENTIFIERS_PACKET, new PacketWrapper(AvailableEntityIdentifiersPacketLatest.class, AvailableEntityIdentifiersPacket.class));
        packetTypes.put(ProtocolInfo.LEVEL_SOUND_EVENT_PACKET_V2, new PacketWrapper(LevelSoundEventPacketLatest.class, LevelSoundEventPacket.class));
        packetTypes.put(ProtocolInfo.SCRIPT_CUSTOM_EVENT_PACKET, new PacketWrapper(ScriptCustomEventPacketLatest.class, ScriptCustomEventPacket.class));
        packetTypes.put(ProtocolInfo.SPAWN_PARTICLE_EFFECT_PACKET, new PacketWrapper(SpawnParticleEffectPacketLatest.class, SpawnParticleEffectPacket.class));
        packetTypes.put(ProtocolInfo.BIOME_DEFINITION_LIST_PACKET, new PacketWrapper(BiomeDefinitionListPacketLatest.class, BiomeDefinitionListPacket.class));
        packetTypes.put(ProtocolInfo.LEVEL_SOUND_EVENT_PACKET, new PacketWrapper(LevelSoundEventPacketLatest.class, LevelSoundEventPacket.class));
        packetTypes.put(ProtocolInfo.LEVEL_EVENT_GENERIC_PACKET, new PacketWrapper(LevelEventGenericPacketLatest.class, LevelEventGenericPacket.class));
        packetTypes.put(ProtocolInfo.LECTERN_UPDATE_PACKET, new PacketWrapper(LecternUpdatePacketLatest.class, LecternUpdatePacket.class));
        packetTypes.put(ProtocolInfo.VIDEO_STREAM_CONNECT_PACKET, new PacketWrapper(VideoStreamConnectPacketLatest.class, VideoStreamConnectPacket.class));
        packetTypes.put(ProtocolInfo.CLIENT_CACHE_STATUS_PACKET, new PacketWrapper(ClientCacheStatusPacketLatest.class, ClientCacheStatusPacket.class));
        packetTypes.put(ProtocolInfo.MAP_CREATE_LOCKED_COPY_PACKET, new PacketWrapper(MapCreateLockedCopyPacketLatest.class, MapCreateLockedCopyPacket.class));
        packetTypes.put(ProtocolInfo.EMOTE_PACKET, new PacketWrapper(EmotePacketLatest.class, EmotePacket.class));
        packetTypes.put(ProtocolInfo.ON_SCREEN_TEXTURE_ANIMATION_PACKET, new PacketWrapper(OnScreenTextureAnimationPacketLatest.class, OnScreenTextureAnimationPacket.class));
        packetTypes.put(ProtocolInfo.COMPLETED_USING_ITEM_PACKET, new PacketWrapper(CompletedUsingItemPacketLatest.class, CompletedUsingItemPacket.class));
        packetTypes.put(ProtocolInfo.CODE_BUILDER_PACKET, new PacketWrapper(CodeBuilderPacketLatest.class, CodeBuilderPacket.class));
        packetTypes.put(ProtocolInfo.CREATIVE_CONTENT_PACKET, new PacketWrapper(CreativeContentPacketLatest.class, CreativeContentPacket.class));
        packetTypes.put(ProtocolInfo.DEBUG_INFO_PACKET, new PacketWrapper(DebugInfoPacketLatest.class, DebugInfoPacket.class));
        packetTypes.put(ProtocolInfo.EMOTE_LIST_PACKET, new PacketWrapper(EmoteListPacketLatest.class, EmoteListPacket.class));
        packetTypes.put(ProtocolInfo.PACKET_VIOLATION_WARNING_PACKET, new PacketWrapper(PacketViolationWarningPacketLatest.class, PacketViolationWarningPacket.class));
        packetTypes.put(ProtocolInfo.PLAYER_ARMOR_DAMAGE_PACKET, new PacketWrapper(PlayerArmorDamagePacketLatest.class, PlayerArmorDamagePacket.class));
        packetTypes.put(ProtocolInfo.PLAYER_ENCHANT_OPTIONS_PACKET, new PacketWrapper(PlayerEnchantOptionsPacketLatest.class, PlayerEnchantOptionsPacket.class));
        packetTypes.put(ProtocolInfo.UPDATE_PLAYER_GAME_TYPE_PACKET, new PacketWrapper(UpdatePlayerGameTypePacketLatest.class, UpdatePlayerGameTypePacket.class));
    }

    @Override
    public DataPacket convertClientBoundPacketToThisVersion(DataPacket packet) {
        return convertPacket(packet);
    }

    @Override
    public DataPacket convertServerBoundPacketToThisVersion(DataPacket packet) {
        return convertPacket(packet);
    }

    @Override
    public int getPreviousProtocolVersion() {
        return -1;
    }

    @Override
    public int getProtocolVersion() {
        return -1;
    }

    @Override
    public int getNextProtocolVersion() {
        return -1;
    }

    private static DataPacket convertPacket (DataPacket packet) {
        DataPacket newPacket = null;
        if (!packetTypes.containsKey(packet.pid())) {
            return null;
        }
        PacketWrapper wrapper = packetTypes.get(packet.pid());
        try {
            newPacket = wrapper.getWrapperPacketClass().getDeclaredConstructor(wrapper.getOriginalPacketClass()).newInstance(packet);
        } catch (Exception exception) {}
        return newPacket;
    }

    private static class PacketWrapper {

        private final Class<? extends DataPacket> packetWrapperClass;
        private final Class<? extends DataPacket> originalPacketClass;

        public PacketWrapper (Class<? extends DataPacket> packetWrapperClass, Class<? extends DataPacket> originalPacketClass) {
            this.packetWrapperClass = packetWrapperClass;
            this.originalPacketClass = originalPacketClass;
        }

        public Class<? extends DataPacket> getOriginalPacketClass () {
            return originalPacketClass;
        }

        public Class<? extends DataPacket> getWrapperPacketClass () {
            return packetWrapperClass;
        }

    }
}
