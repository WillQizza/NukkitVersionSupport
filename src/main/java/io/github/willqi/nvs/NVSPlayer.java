package io.github.willqi.nvs;

import cn.nukkit.AdventureSettings;
import cn.nukkit.Player;
import cn.nukkit.PlayerFood;
import cn.nukkit.Server;
import cn.nukkit.block.Block;
import cn.nukkit.block.BlockEnderChest;
import cn.nukkit.entity.Attribute;
import cn.nukkit.entity.Entity;
import cn.nukkit.entity.EntityHuman;
import cn.nukkit.entity.EntityInteractable;
import cn.nukkit.entity.data.EntityData;
import cn.nukkit.entity.data.EntityMetadata;
import cn.nukkit.entity.data.Skin;
import cn.nukkit.entity.item.EntityItem;
import cn.nukkit.event.entity.EntityDamageEvent;
import cn.nukkit.event.entity.EntityRegainHealthEvent;
import cn.nukkit.event.player.PlayerKickEvent;
import cn.nukkit.event.player.PlayerTeleportEvent;
import cn.nukkit.form.window.FormWindow;
import cn.nukkit.inventory.*;
import cn.nukkit.item.Item;
import cn.nukkit.lang.TextContainer;
import cn.nukkit.lang.TranslationContainer;
import cn.nukkit.level.Level;
import cn.nukkit.level.Location;
import cn.nukkit.level.Position;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.math.*;
import cn.nukkit.metadata.MetadataValue;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.network.SourceInterface;
import cn.nukkit.network.protocol.DataPacket;
import cn.nukkit.network.protocol.LoginPacket;
import cn.nukkit.permission.Permission;
import cn.nukkit.permission.PermissionAttachment;
import cn.nukkit.permission.PermissionAttachmentInfo;
import cn.nukkit.plugin.Plugin;
import cn.nukkit.potion.Effect;
import cn.nukkit.utils.DummyBossBar;
import cn.nukkit.utils.LoginChainData;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.util.*;

public class NVSPlayer extends Player {

    protected Player protocolPlayer;

    public NVSPlayer(SourceInterface interfaz, Long clientID, InetSocketAddress socketAddress) {
        super(interfaz, clientID, socketAddress);
    }

    @Override
    public void handleDataPacket(DataPacket packet) {

        if (packet instanceof LoginPacket) {
            LoginPacket loginPacket = (LoginPacket)packet;
            Optional<Class<? extends Player>> protocolPlayerClass = NVSAPI.getProtocolPlayer(loginPacket.getProtocol());
            if (protocolPlayerClass.isPresent()) {
                this.protocolPlayer = makePlayerInstance(protocolPlayerClass.get());
            } else {
                NVSAPI.get().getLogger().debug("Could not find protocol player for v" + loginPacket.getProtocol());
                this.protocolPlayer = makePlayerInstance(Player.class);
            }
        }

        if (this.protocolPlayer != null) {
            this.protocolPlayer.handleDataPacket(packet);
        }

    }

    @Override
    public boolean dataPacket(DataPacket packet) {
        if (this.protocolPlayer != null) {
            return this.protocolPlayer.dataPacket(packet);
        }
        return this.dataPacketWithoutVersionSupport(packet);
    }

    /**
     * Used internally to prevent conversion errors.
     * Should not be used by version classes.
     * @param packet
     * @return
     */
    protected boolean dataPacketWithoutVersionSupport(DataPacket packet) {
        return super.dataPacket(packet);
    }

    protected Player makePlayerInstance(Class<? extends Player> clazz) {
        Player player = null;
        try {
            Constructor<? extends Player> constructor = clazz.getConstructor(SourceInterface.class, Long.class, InetSocketAddress.class);
            player = constructor.newInstance(this.interfaz, this.clientID, this.socketAddress);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            NVSAPI.get().getLogger().error("Error while creating class instance for " + this.getClass().getName());
            NVSAPI.get().getLogger().error(e.getMessage());
        }
        return player;
    }

    private Object invokeMethod(String name, Object... args) {
        Object result = null;
        try {
            Method method = this.protocolPlayer.getClass().getMethod(name);
            result = method.invoke(this.protocolPlayer, args);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            NVSAPI.get().getLogger().error("Could not access " + name + "  of class " + this.protocolPlayer.getClass() + ": " + e);
        }
        return result;
    }

    @Override
    protected void doFirstSpawn() {
        invokeMethod("doFirstSpawn");
    }

    @Override
    public int getStartActionTick() {
        return this.protocolPlayer.getStartActionTick();
    }

    @Override
    public void startAction() {
        this.protocolPlayer.startAction();
    }

    @Override
    public void stopAction() {
        this.protocolPlayer.stopAction();
    }

    @Override
    public int getLastEnderPearlThrowingTick() {
        return this.protocolPlayer.getLastEnderPearlThrowingTick();
    }

    @Override
    public void onThrowEnderPearl() {
        this.protocolPlayer.onThrowEnderPearl();
    }

    @Override
    public int getLastChorusFruitTeleport() {
        return this.protocolPlayer.getLastChorusFruitTeleport();
    }

    @Override
    public void onChorusFruitTeleport() {
        this.protocolPlayer.onChorusFruitTeleport();
    }

    @Override
    public BlockEnderChest getViewingEnderChest() {
        return this.protocolPlayer.getViewingEnderChest();
    }

    @Override
    public void setViewingEnderChest(BlockEnderChest chest) {
        this.protocolPlayer.setViewingEnderChest(chest);
    }

    @Override
    public TranslationContainer getLeaveMessage() {
        return this.protocolPlayer.getLeaveMessage();
    }

    @Override
    public String getClientSecret() {
        return this.protocolPlayer.getClientSecret();
    }

    @Override
    public Long getClientId() {
        return this.protocolPlayer.getClientId();
    }

    @Override
    public boolean isBanned() {
        return this.protocolPlayer.isBanned();
    }

    @Override
    public void setBanned(boolean value) {
        this.protocolPlayer.setBanned(value);
    }

    @Override
    public boolean isWhitelisted() {
        return this.protocolPlayer.isWhitelisted();
    }

    @Override
    public void setWhitelisted(boolean value) {
        this.protocolPlayer.setWhitelisted(value);
    }

    @Override
    public Player getPlayer() {
        return this.protocolPlayer.getPlayer();
    }

    @Override
    public Long getFirstPlayed() {
        return this.protocolPlayer.getFirstPlayed();
    }

    @Override
    public Long getLastPlayed() {
        return this.protocolPlayer.getLastPlayed();
    }

    @Override
    public boolean hasPlayedBefore() {
        return this.protocolPlayer.hasPlayedBefore();
    }

    @Override
    public AdventureSettings getAdventureSettings() {
        return this.protocolPlayer.getAdventureSettings();
    }

    @Override
    public void setAdventureSettings(AdventureSettings adventureSettings) {
        this.protocolPlayer.setAdventureSettings(adventureSettings);
    }

    @Override
    public void resetInAirTicks() {
        this.protocolPlayer.resetInAirTicks();
    }

    @Override
    public void setAllowFlight(boolean value) {
        this.protocolPlayer.setAllowFlight(value);
    }

    @Override
    public boolean getAllowFlight() {
        return this.protocolPlayer.getAllowFlight();
    }

    @Override
    public void setAllowModifyWorld(boolean value) {
        this.protocolPlayer.setAllowModifyWorld(value);
    }

    @Override
    public void setAllowInteract(boolean value) {
        this.protocolPlayer.setAllowInteract(value);
    }

    @Override
    public void setAllowInteract(boolean value, boolean containers) {
        this.protocolPlayer.setAllowInteract(value, containers);
    }

    @Override
    public void setAutoJump(boolean value) {
        this.protocolPlayer.setAutoJump(value);
    }

    @Override
    public boolean hasAutoJump() {
        return this.protocolPlayer.hasAutoJump();
    }

    @Override
    public void spawnTo(Player player) {
        this.protocolPlayer.spawnTo(player);
    }

    @Override
    public Server getServer() {
        return this.protocolPlayer.getServer();
    }

    @Override
    public boolean getRemoveFormat() {
        return this.protocolPlayer.getRemoveFormat();
    }

    @Override
    public void setRemoveFormat() {
        this.protocolPlayer.setRemoveFormat();
    }

    @Override
    public void setRemoveFormat(boolean remove) {
        this.protocolPlayer.setRemoveFormat(remove);
    }

    @Override
    public boolean canSee(Player player) {
        return this.protocolPlayer.canSee(player);
    }

    @Override
    public void hidePlayer(Player player) {
        this.protocolPlayer.hidePlayer(player);
    }

    @Override
    public void showPlayer(Player player) {
        this.protocolPlayer.showPlayer(player);
    }

    @Override
    public boolean canCollideWith(Entity entity) {
        return this.protocolPlayer.canCollideWith(entity);
    }

    @Override
    public void resetFallDistance() {
        this.protocolPlayer.resetFallDistance();
    }

    @Override
    public boolean isOnline() {
        return this.protocolPlayer.isOnline();
    }

    @Override
    public boolean isOp() {
        return this.protocolPlayer.isOp();
    }

    @Override
    public void setOp(boolean value) {
        this.protocolPlayer.setOp(value);
    }

    @Override
    public boolean isPermissionSet(String name) {
        return this.protocolPlayer.isPermissionSet(name);
    }

    @Override
    public boolean isPermissionSet(Permission permission) {
        return this.protocolPlayer.isPermissionSet(permission);
    }

    @Override
    public boolean hasPermission(String name) {
        return this.protocolPlayer.hasPermission(name);
    }

    @Override
    public boolean hasPermission(Permission permission) {
        return this.protocolPlayer.hasPermission(permission);
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin) {
        return this.protocolPlayer.addAttachment(plugin);
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String name) {
        return this.protocolPlayer.addAttachment(plugin, name);
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String name, Boolean value) {
        return this.protocolPlayer.addAttachment(plugin, name, value);
    }

    @Override
    public void removeAttachment(PermissionAttachment attachment) {
        this.protocolPlayer.removeAttachment(attachment);
    }

    @Override
    public void recalculatePermissions() {
        this.protocolPlayer.recalculatePermissions();
    }

    @Override
    public boolean isEnableClientCommand() {
        return this.protocolPlayer.isEnableClientCommand();
    }

    @Override
    public void setEnableClientCommand(boolean enable) {
        this.protocolPlayer.setEnableClientCommand(enable);
    }

    @Override
    public void sendCommandData() {
        this.protocolPlayer.sendCommandData();
    }

    @Override
    public Map<String, PermissionAttachmentInfo> getEffectivePermissions() {
        return this.protocolPlayer.getEffectivePermissions();
    }

    @Override
    protected void initEntity() {
        invokeMethod("initEntity");
    }

    @Override
    public boolean isPlayer() {
        return this.protocolPlayer.isPlayer();
    }

    @Override
    public void removeAchievement(String achievementId) {
        this.protocolPlayer.removeAchievement(achievementId);
    }

    @Override
    public boolean hasAchievement(String achievementId) {
        return this.protocolPlayer.hasAchievement(achievementId);
    }

    @Override
    public boolean isConnected() {
        return this.protocolPlayer.isConnected();
    }

    @Override
    public String getDisplayName() {
        return this.protocolPlayer.getDisplayName();
    }

    @Override
    public void setDisplayName(String displayName) {
        this.protocolPlayer.setDisplayName(displayName);
    }

    @Override
    public void setSkin(Skin skin) {
        this.protocolPlayer.setSkin(skin);
    }

    @Override
    public String getAddress() {
        return this.protocolPlayer.getAddress();
    }

    @Override
    public int getPort() {
        return this.protocolPlayer.getPort();
    }

    @Override
    public InetSocketAddress getSocketAddress() {
        return this.protocolPlayer.getSocketAddress();
    }

    @Override
    public Position getNextPosition() {
        return this.protocolPlayer.getNextPosition();
    }

    @Override
    public boolean isSleeping() {
        return this.protocolPlayer.isSleeping();
    }

    @Override
    public int getInAirTicks() {
        return this.protocolPlayer.getInAirTicks();
    }

    @Override
    public boolean isUsingItem() {
        return this.protocolPlayer.isUsingItem();
    }

    @Override
    public void setUsingItem(boolean value) {
        this.protocolPlayer.setUsingItem(value);
    }

    @Override
    public String getButtonText() {
        return this.protocolPlayer.getButtonText();
    }

    @Override
    public void setButtonText(String text) {
        this.protocolPlayer.setButtonText(text);
    }

    @Override
    public void unloadChunk(int x, int z) {
        this.protocolPlayer.unloadChunk(x, z);
    }

    @Override
    public void unloadChunk(int x, int z, Level level) {
        this.protocolPlayer.unloadChunk(x, z, level);
    }

    @Override
    public Position getSpawn() {
        return this.protocolPlayer.getSpawn();
    }

    @Override
    public void sendChunk(int x, int z, DataPacket packet) {
        this.protocolPlayer.sendChunk(x, z, packet);
    }

    @Override
    public void sendChunk(int x, int z, int subChunkCount, byte[] payload) {
        this.protocolPlayer.sendChunk(x, z, subChunkCount, payload);
    }

    @Override
    protected void sendNextChunk() {
        invokeMethod("sendNextChunk");
    }

    @Override
    protected boolean orderChunks() {
        return (boolean)invokeMethod("orderChunks");
    }

    @Override
    public boolean batchDataPacket(DataPacket packet) {
        return this.protocolPlayer.batchDataPacket(packet);
    }

    @Override
    public int dataPacket(DataPacket packet, boolean needACK) {
        return this.protocolPlayer.dataPacket(packet, needACK);
    }

    @Override
    public boolean directDataPacket(DataPacket packet) {
        return this.protocolPlayer.directDataPacket(packet);
    }

    @Override
    public int directDataPacket(DataPacket packet, boolean needACK) {
        return this.protocolPlayer.directDataPacket(packet, needACK);
    }

    @Override
    public int getPing() {
        return this.protocolPlayer.getPing();
    }

    @Override
    public boolean sleepOn(Vector3 pos) {
        return this.protocolPlayer.sleepOn(pos);
    }

    @Override
    public void setSpawn(Vector3 pos) {
        this.protocolPlayer.setSpawn(pos);
    }

    @Override
    public void stopSleep() {
        this.protocolPlayer.stopSleep();
    }

    @Override
    public boolean awardAchievement(String achievementId) {
        return this.protocolPlayer.awardAchievement(achievementId);
    }

    @Override
    public int getGamemode() {
        return this.protocolPlayer.getGamemode();
    }

    @Override
    public boolean setGamemode(int gamemode) {
        return this.protocolPlayer.setGamemode(gamemode);
    }

    @Override
    public boolean setGamemode(int gamemode, boolean clientSide) {
        return this.protocolPlayer.setGamemode(gamemode, clientSide);
    }

    @Override
    public boolean setGamemode(int gamemode, boolean clientSide, AdventureSettings newSettings) {
        return this.protocolPlayer.setGamemode(gamemode, clientSide, newSettings);
    }

    @Override
    public void sendSettings() {
        this.protocolPlayer.sendSettings();
    }

    @Override
    public boolean isSurvival() {
        return this.protocolPlayer.isSurvival();
    }

    @Override
    public boolean isCreative() {
        return this.protocolPlayer.isCreative();
    }

    @Override
    public boolean isSpectator() {
        return this.protocolPlayer.isSpectator();
    }

    @Override
    public boolean isAdventure() {
        return this.protocolPlayer.isAdventure();
    }

    @Override
    public Item[] getDrops() {
        return this.protocolPlayer.getDrops();
    }

    @Override
    public boolean setDataProperty(EntityData data) {
        return this.protocolPlayer.setDataProperty(data);
    }

    @Override
    public boolean setDataProperty(EntityData data, boolean send) {
        return this.protocolPlayer.setDataProperty(data, send);
    }

    @Override
    protected void checkGroundState(double movX, double movY, double movZ, double dx, double dy, double dz) {
        invokeMethod("checkGroundState", movX, movY, movZ, dx, dy, dz);
    }

    @Override
    protected void checkBlockCollision() {
        invokeMethod("checkBlockCollision");
    }

    @Override
    protected void checkNearEntities() {
        invokeMethod("checkNearEntities");
    }

    @Override
    protected void processMovement(int tickDiff) {
        invokeMethod("processMovement", tickDiff);
    }

    @Override
    public void addMovement(double x, double y, double z, double yaw, double pitch, double headYaw) {
        this.protocolPlayer.addMovement(x, y, z, yaw, pitch, headYaw);
    }

    @Override
    public boolean setMotion(Vector3 motion) {
        return this.protocolPlayer.setMotion(motion);
    }

    @Override
    public void sendAttributes() {
        this.protocolPlayer.sendAttributes();
    }

    @Override
    public boolean onUpdate(int currentTick) {
        return this.protocolPlayer.onUpdate(currentTick);
    }

    @Override
    public void checkInteractNearby() {
        this.protocolPlayer.checkInteractNearby();
    }

    @Override
    public EntityInteractable getEntityPlayerLookingAt(int maxDistance) {
        return this.protocolPlayer.getEntityPlayerLookingAt(maxDistance);
    }

    @Override
    public void checkNetwork() {
        this.protocolPlayer.checkNetwork();
    }

    @Override
    public boolean canInteract(Vector3 pos, double maxDistance) {
        return this.protocolPlayer.canInteract(pos, maxDistance);
    }

    @Override
    public boolean canInteract(Vector3 pos, double maxDistance, double maxDiff) {
        return this.protocolPlayer.canInteract(pos, maxDistance, maxDiff);
    }

    @Override
    protected void processLogin() {
        invokeMethod("processLogin");
    }

    @Override
    protected void completeLoginSequence() {
        invokeMethod("completeLoginSequence");
    }

    @Override
    public boolean chat(String message) {
        return this.protocolPlayer.chat(message);
    }

    @Override
    public boolean kick() {
        return this.protocolPlayer.kick();
    }

    @Override
    public boolean kick(String reason, boolean isAdmin) {
        return this.protocolPlayer.kick(reason, isAdmin);
    }

    @Override
    public boolean kick(String reason) {
        return this.protocolPlayer.kick(reason);
    }

    @Override
    public boolean kick(PlayerKickEvent.Reason reason) {
        return this.protocolPlayer.kick(reason);
    }

    @Override
    public boolean kick(PlayerKickEvent.Reason reason, String reasonString) {
        return this.protocolPlayer.kick(reason, reasonString);
    }

    @Override
    public boolean kick(PlayerKickEvent.Reason reason, boolean isAdmin) {
        return this.protocolPlayer.kick(reason, isAdmin);
    }

    @Override
    public boolean kick(PlayerKickEvent.Reason reason, String reasonString, boolean isAdmin) {
        return this.protocolPlayer.kick(reason, reasonString, isAdmin);
    }

    @Override
    public void setViewDistance(int distance) {
        this.protocolPlayer.setViewDistance(distance);
    }

    @Override
    public int getViewDistance() {
        return this.protocolPlayer.getViewDistance();
    }

    @Override
    public void sendMessage(String message) {
        this.protocolPlayer.sendMessage(message);
    }

    @Override
    public void sendMessage(TextContainer message) {
        this.protocolPlayer.sendMessage(message);
    }

    @Override
    public void sendTranslation(String message) {
        this.protocolPlayer.sendTranslation(message);
    }

    @Override
    public void sendTranslation(String message, String[] parameters) {
        this.protocolPlayer.sendTranslation(message, parameters);
    }

    @Override
    public void sendChat(String message) {
        this.protocolPlayer.sendChat(message);
    }

    @Override
    public void sendChat(String source, String message) {
        this.protocolPlayer.sendChat(source, message);
    }

    @Override
    public void sendPopup(String message) {
        this.protocolPlayer.sendPopup(message);
    }

    @Override
    public void sendPopup(String message, String subtitle) {
        this.protocolPlayer.sendPopup(message, subtitle);
    }

    @Override
    public void sendTip(String message) {
        this.protocolPlayer.sendTip(message);
    }

    @Override
    public void clearTitle() {
        this.protocolPlayer.clearTitle();
    }

    @Override
    public void resetTitleSettings() {
        this.protocolPlayer.resetTitleSettings();
    }

    @Override
    public void setSubtitle(String subtitle) {
        this.protocolPlayer.setSubtitle(subtitle);
    }

    @Override
    public void setTitleAnimationTimes(int fadein, int duration, int fadeout) {
        this.protocolPlayer.setTitleAnimationTimes(fadein, duration, fadeout);
    }

    @Override
    public void sendTitle(String title) {
        this.protocolPlayer.sendTitle(title);
    }

    @Override
    public void sendTitle(String title, String subtitle) {
        this.protocolPlayer.sendTitle(title, subtitle);
    }

    @Override
    public void sendTitle(String title, String subtitle, int fadeIn, int stay, int fadeOut) {
        this.protocolPlayer.sendTitle(title, subtitle, fadeIn, stay, fadeOut);
    }

    @Override
    public void sendActionBar(String title) {
        this.protocolPlayer.sendActionBar(title);
    }

    @Override
    public void sendActionBar(String title, int fadein, int duration, int fadeout) {
        this.protocolPlayer.sendActionBar(title, fadein, duration, fadeout);
    }

    @Override
    public void close() {
        this.protocolPlayer.close();
    }

    @Override
    public void close(String message) {
        this.protocolPlayer.close(message);
    }

    @Override
    public void close(String message, String reason) {
        this.protocolPlayer.close(message, reason);
    }

    @Override
    public void close(String message, String reason, boolean notify) {
        this.protocolPlayer.close(message, reason, notify);
    }

    @Override
    public void close(TextContainer message) {
        this.protocolPlayer.close(message);
    }

    @Override
    public void close(TextContainer message, String reason) {
        this.protocolPlayer.close(message, reason);
    }

    @Override
    public void close(TextContainer message, String reason, boolean notify) {
        this.protocolPlayer.close(message, reason, notify);
    }

    @Override
    public void save() {
        this.protocolPlayer.save();
    }

    @Override
    public void save(boolean async) {
        this.protocolPlayer.save(async);
    }

    @Override
    public String getName() {
        return this.protocolPlayer.getName();
    }

    @Override
    public void kill() {
        this.protocolPlayer.kill();
    }

    @Override
    protected void respawn() {
        invokeMethod("respawn");
    }

    @Override
    public void setHealth(float health) {
        this.protocolPlayer.setHealth(health);
    }

    @Override
    public void setMaxHealth(int maxHealth) {
        this.protocolPlayer.setMaxHealth(maxHealth);
    }

    @Override
    public int getExperience() {
        return this.protocolPlayer.getExperience();
    }

    @Override
    public int getExperienceLevel() {
        return this.protocolPlayer.getExperienceLevel();
    }

    @Override
    public void addExperience(int add) {
        this.protocolPlayer.addExperience(add);
    }

    @Override
    public void setExperience(int exp) {
        this.protocolPlayer.setExperience(exp);
    }

    @Override
    public void setExperience(int exp, int level) {
        this.protocolPlayer.setExperience(exp, level);
    }

    @Override
    public void sendExperience() {
        this.protocolPlayer.sendExperience();
    }

    @Override
    public void sendExperience(int exp) {
        this.protocolPlayer.sendExperience(exp);
    }

    @Override
    public void sendExperienceLevel() {
        this.protocolPlayer.sendExperienceLevel();
    }

    @Override
    public void sendExperienceLevel(int level) {
        this.protocolPlayer.sendExperienceLevel(level);
    }

    @Override
    public void setAttribute(Attribute attribute) {
        this.protocolPlayer.setAttribute(attribute);
    }

    @Override
    public void setMovementSpeed(float speed) {
        this.protocolPlayer.setMovementSpeed(speed);
    }

    @Override
    public void setMovementSpeed(float speed, boolean send) {
        this.protocolPlayer.setMovementSpeed(speed, send);
    }

    @Override
    public Entity getKiller() {
        return this.protocolPlayer.getKiller();
    }

    @Override
    public boolean attack(EntityDamageEvent source) {
        return this.protocolPlayer.attack(source);
    }

    @Override
    public boolean dropItem(Item item) {
        return this.protocolPlayer.dropItem(item);
    }

    @Override
    public EntityItem dropAndGetItem(Item item) {
        return this.protocolPlayer.dropAndGetItem(item);
    }

    @Override
    public void sendPosition(Vector3 pos) {
        this.protocolPlayer.sendPosition(pos);
    }

    @Override
    public void sendPosition(Vector3 pos, double yaw) {
        this.protocolPlayer.sendPosition(pos, yaw);
    }

    @Override
    public void sendPosition(Vector3 pos, double yaw, double pitch) {
        this.protocolPlayer.sendPosition(pos, yaw, pitch);
    }

    @Override
    public void sendPosition(Vector3 pos, double yaw, double pitch, int mode) {
        this.protocolPlayer.sendPosition(pos, yaw, pitch, mode);
    }

    @Override
    public void sendPosition(Vector3 pos, double yaw, double pitch, int mode, Player[] targets) {
        this.protocolPlayer.sendPosition(pos, yaw, pitch, mode, targets);
    }

    @Override
    protected void checkChunks() {
        invokeMethod("checkChunks");
    }

    @Override
    protected boolean checkTeleportPosition() {
        return (boolean)invokeMethod("checkTeleportPosition");
    }

    @Override
    protected void sendPlayStatus(int status) {
        invokeMethod("sendPlayStatus", status);
    }

    @Override
    protected void sendPlayStatus(int status, boolean immediate) {
        invokeMethod("sendPlayStatus", status, immediate);
    }

    @Override
    public boolean teleport(Location location, PlayerTeleportEvent.TeleportCause cause) {
        return this.protocolPlayer.teleport(location, cause);
    }

    @Override
    protected void forceSendEmptyChunks() {
        invokeMethod("forceSendEmptyChunks");
    }

    @Override
    public void teleportImmediate(Location location) {
        this.protocolPlayer.teleportImmediate(location);
    }

    @Override
    public void teleportImmediate(Location location, PlayerTeleportEvent.TeleportCause cause) {
        this.protocolPlayer.teleportImmediate(location, cause);
    }

    @Override
    public int showFormWindow(FormWindow window) {
        return this.protocolPlayer.showFormWindow(window);
    }

    @Override
    public int showFormWindow(FormWindow window, int id) {
        return this.protocolPlayer.showFormWindow(window, id);
    }

    @Override
    public int addServerSettings(FormWindow window) {
        return this.protocolPlayer.addServerSettings(window);
    }

    @Override
    public long createBossBar(String text, int length) {
        return this.protocolPlayer.createBossBar(text, length);
    }

    @Override
    public long createBossBar(DummyBossBar dummyBossBar) {
        return this.protocolPlayer.createBossBar(dummyBossBar);
    }

    @Override
    public DummyBossBar getDummyBossBar(long bossBarId) {
        return this.protocolPlayer.getDummyBossBar(bossBarId);
    }

    @Override
    public Map<Long, DummyBossBar> getDummyBossBars() {
        return this.protocolPlayer.getDummyBossBars();
    }

    @Override
    public void updateBossBar(String text, int length, long bossBarId) {
        this.protocolPlayer.updateBossBar(text, length, bossBarId);
    }

    @Override
    public void removeBossBar(long bossBarId) {
        this.protocolPlayer.removeBossBar(bossBarId);
    }

    @Override
    public int getWindowId(Inventory inventory) {
        return this.protocolPlayer.getWindowId(inventory);
    }

    @Override
    public Inventory getWindowById(int id) {
        return this.protocolPlayer.getWindowById(id);
    }

    @Override
    public int addWindow(Inventory inventory) {
        return this.protocolPlayer.addWindow(inventory);
    }

    @Override
    public int addWindow(Inventory inventory, Integer forceId) {
        return this.protocolPlayer.addWindow(inventory, forceId);
    }

    @Override
    public int addWindow(Inventory inventory, Integer forceId, boolean isPermanent) {
        return this.protocolPlayer.addWindow(inventory, forceId, isPermanent);
    }

    @Override
    public int addWindow(Inventory inventory, Integer forceId, boolean isPermanent, boolean alwaysOpen) {
        return this.protocolPlayer.addWindow(inventory, forceId, isPermanent, alwaysOpen);
    }

    @Override
    public Optional<Inventory> getTopWindow() {
        return this.protocolPlayer.getTopWindow();
    }

    @Override
    public void removeWindow(Inventory inventory) {
        this.protocolPlayer.removeWindow(inventory);
    }

    @Override
    protected void removeWindow(Inventory inventory, boolean isResponse) {
        invokeMethod("removeWindow", inventory, isResponse);
    }

    @Override
    public void sendAllInventories() {
        this.protocolPlayer.sendAllInventories();
    }

    @Override
    protected void addDefaultWindows() {
        invokeMethod("addDefaultWindows");
    }

    @Override
    public PlayerUIInventory getUIInventory() {
        return this.protocolPlayer.getUIInventory();
    }

    @Override
    public PlayerCursorInventory getCursorInventory() {
        return this.protocolPlayer.getCursorInventory();
    }

    @Override
    public CraftingGrid getCraftingGrid() {
        return this.protocolPlayer.getCraftingGrid();
    }

    @Override
    public void setCraftingGrid(CraftingGrid grid) {
        this.protocolPlayer.setCraftingGrid(grid);
    }

    @Override
    public void resetCraftingGridType() {
        this.protocolPlayer.resetCraftingGridType();
    }

    @Override
    public void removeAllWindows() {
        this.protocolPlayer.removeAllWindows();
    }

    @Override
    public void removeAllWindows(boolean permanent) {
        this.protocolPlayer.removeAllWindows(permanent);
    }

    @Override
    public int getClosingWindowId() {
        return this.protocolPlayer.getClosingWindowId();
    }

    @Override
    public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {
        this.protocolPlayer.setMetadata(metadataKey, newMetadataValue);
    }

    @Override
    public List<MetadataValue> getMetadata(String metadataKey) {
        return this.protocolPlayer.getMetadata(metadataKey);
    }

    @Override
    public boolean hasMetadata(String metadataKey) {
        return this.protocolPlayer.hasMetadata(metadataKey);
    }

    @Override
    public void removeMetadata(String metadataKey, Plugin owningPlugin) {
        this.protocolPlayer.removeMetadata(metadataKey, owningPlugin);
    }

    @Override
    public void onChunkChanged(FullChunk chunk) {
        this.protocolPlayer.onChunkChanged(chunk);
    }

    @Override
    public void onChunkLoaded(FullChunk chunk) {
        this.protocolPlayer.onChunkLoaded(chunk);
    }

    @Override
    public void onChunkPopulated(FullChunk chunk) {
        this.protocolPlayer.onChunkPopulated(chunk);
    }

    @Override
    public void onChunkUnloaded(FullChunk chunk) {
        this.protocolPlayer.onChunkUnloaded(chunk);
    }

    @Override
    public void onBlockChanged(Vector3 block) {
        this.protocolPlayer.onBlockChanged(block);
    }

    @Override
    public int getLoaderId() {
        return this.protocolPlayer.getLoaderId();
    }

    @Override
    public boolean isLoaderActive() {
        return this.protocolPlayer.isLoaderActive();
    }

    @Override
    public boolean isFoodEnabled() {
        return this.protocolPlayer.isFoodEnabled();
    }

    @Override
    public void setFoodEnabled(boolean foodEnabled) {
        this.protocolPlayer.setFoodEnabled(foodEnabled);
    }

    @Override
    public PlayerFood getFoodData() {
        return this.protocolPlayer.getFoodData();
    }

    @Override
    public boolean switchLevel(Level level) {
        return this.protocolPlayer.switchLevel(level);
    }

    @Override
    public void setCheckMovement(boolean checkMovement) {
        this.protocolPlayer.setCheckMovement(checkMovement);
    }

    @Override
    public boolean isCheckingMovement() {
        return this.protocolPlayer.isCheckingMovement();
    }

    @Override
    public synchronized void setLocale(Locale locale) {
        this.protocolPlayer.setLocale(locale);
    }

    @Override
    public synchronized Locale getLocale() {
        return this.protocolPlayer.getLocale();
    }

    @Override
    public void setSprinting(boolean value) {
        this.protocolPlayer.setSprinting(value);
    }

    @Override
    public void transfer(InetSocketAddress address) {
        this.protocolPlayer.transfer(address);
    }

    @Override
    public LoginChainData getLoginChainData() {
        return this.protocolPlayer.getLoginChainData();
    }

    @Override
    public boolean pickupEntity(Entity entity, boolean near) {
        return this.protocolPlayer.pickupEntity(entity, near);
    }

    @Override
    public int hashCode() {
        return this.protocolPlayer.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.protocolPlayer.equals(obj);
    }

    @Override
    public boolean isBreakingBlock() {
        return this.protocolPlayer.isBreakingBlock();
    }

    @Override
    public void showXboxProfile(String xuid) {
        this.protocolPlayer.showXboxProfile(xuid);
    }

    @Override
    public void startFishing(Item fishingRod) {
        this.protocolPlayer.startFishing(fishingRod);
    }

    @Override
    public void stopFishing(boolean click) {
        this.protocolPlayer.stopFishing(click);
    }

    @Override
    public boolean doesTriggerPressurePlate() {
        return this.protocolPlayer.doesTriggerPressurePlate();
    }

    @Override
    public String toString() {
        return this.protocolPlayer.toString();
    }

    @Override
    public int getTimeSinceRest() {
        return this.protocolPlayer.getTimeSinceRest();
    }

    @Override
    public void setTimeSinceRest(int timeSinceRest) {
        this.protocolPlayer.setTimeSinceRest(timeSinceRest);
    }

    @Override
    public float getWidth() {
        return this.protocolPlayer.getWidth();
    }

    @Override
    public float getLength() {
        return this.protocolPlayer.getLength();
    }

    @Override
    public float getHeight() {
        return this.protocolPlayer.getHeight();
    }

    @Override
    public float getEyeHeight() {
        return this.protocolPlayer.getEyeHeight();
    }

    @Override
    protected float getBaseOffset() {
        return (float)invokeMethod("getBaseOffset");
    }

    @Override
    public int getNetworkId() {
        return this.protocolPlayer.getNetworkId();
    }

    @Override
    public Skin getSkin() {
        return this.protocolPlayer.getSkin();
    }

    @Override
    public UUID getUniqueId() {
        return this.protocolPlayer.getUniqueId();
    }

    @Override
    public byte[] getRawUniqueId() {
        return this.protocolPlayer.getRawUniqueId();
    }

    @Override
    public void saveNBT() {
        this.protocolPlayer.saveNBT();
    }

    @Override
    public void despawnFrom(Player player) {
        this.protocolPlayer.despawnFrom(player);
    }

    @Override
    public PlayerInventory getInventory() {
        return this.protocolPlayer.getInventory();
    }

    @Override
    public PlayerEnderChestInventory getEnderChestInventory() {
        return this.protocolPlayer.getEnderChestInventory();
    }

    @Override
    public PlayerOffhandInventory getOffhandInventory() {
        return this.protocolPlayer.getOffhandInventory();
    }

    @Override
    protected double calculateEnchantmentProtectionFactor(Item item, EntityDamageEvent source) {
        return (double)invokeMethod("calculateEnchantmentProtectionFactor", item, source);
    }

    @Override
    public void setOnFire(int seconds) {
        this.protocolPlayer.setOnFire(seconds);
    }

    @Override
    protected float getGravity() {
        return (float)invokeMethod("getGravity");
    }

    @Override
    protected float getDrag() {
        return (float)invokeMethod("getDrag");
    }

    @Override
    public boolean hasLineOfSight(Entity entity) {
        return this.protocolPlayer.hasLineOfSight(entity);
    }

    @Override
    public void collidingWith(Entity ent) {
        this.protocolPlayer.collidingWith(ent);
    }

    @Override
    public void knockBack(Entity attacker, double damage, double x, double z) {
        this.protocolPlayer.knockBack(attacker, damage, x, z);
    }

    @Override
    public void knockBack(Entity attacker, double damage, double x, double z, double base) {
        this.protocolPlayer.knockBack(attacker, damage, x, z, base);
    }

    @Override
    public boolean entityBaseTick() {
        return this.protocolPlayer.entityBaseTick();
    }

    @Override
    public boolean entityBaseTick(int tickDiff) {
        return this.protocolPlayer.entityBaseTick(tickDiff);
    }

    @Override
    public Block[] getLineOfSight(int maxDistance) {
        return this.protocolPlayer.getLineOfSight(maxDistance);
    }

    @Override
    public Block[] getLineOfSight(int maxDistance, int maxLength) {
        return this.protocolPlayer.getLineOfSight(maxDistance, maxLength);
    }

    @Override
    public Block[] getLineOfSight(int maxDistance, int maxLength, Map<Integer, Object> transparent) {
        return this.protocolPlayer.getLineOfSight(maxDistance, maxLength, transparent);
    }

    @Override
    public Block[] getLineOfSight(int maxDistance, int maxLength, Integer[] transparent) {
        return this.protocolPlayer.getLineOfSight(maxDistance, maxLength, transparent);
    }

    @Override
    public Block getTargetBlock(int maxDistance) {
        return this.protocolPlayer.getTargetBlock(maxDistance);
    }

    @Override
    public Block getTargetBlock(int maxDistance, Map<Integer, Object> transparent) {
        return this.protocolPlayer.getTargetBlock(maxDistance, transparent);
    }

    @Override
    public Block getTargetBlock(int maxDistance, Integer[] transparent) {
        return this.protocolPlayer.getTargetBlock(maxDistance, transparent);
    }

    @Override
    public float getMovementSpeed() {
        return this.protocolPlayer.getMovementSpeed();
    }

    @Override
    public int getAirTicks() {
        return this.protocolPlayer.getAirTicks();
    }

    @Override
    public void setAirTicks(int ticks) {
        this.protocolPlayer.setAirTicks(ticks);
    }

    @Override
    protected double getStepHeight() {
        return (double)invokeMethod("getStepHeight");
    }

    @Override
    public boolean canCollide() {
        return this.protocolPlayer.canCollide();
    }

    @Override
    public boolean hasCustomName() {
        return this.protocolPlayer.hasCustomName();
    }

    @Override
    public String getNameTag() {
        return this.protocolPlayer.getNameTag();
    }

    @Override
    public boolean isNameTagVisible() {
        return this.protocolPlayer.isNameTagVisible();
    }

    @Override
    public boolean isNameTagAlwaysVisible() {
        return this.protocolPlayer.isNameTagAlwaysVisible();
    }

    @Override
    public void setNameTag(String name) {
        this.protocolPlayer.setNameTag(name);
    }

    @Override
    public void setNameTagVisible() {
        this.protocolPlayer.setNameTagVisible();
    }

    @Override
    public void setNameTagVisible(boolean value) {
        this.protocolPlayer.setNameTagVisible(value);
    }

    @Override
    public void setNameTagAlwaysVisible() {
        this.protocolPlayer.setNameTagAlwaysVisible();
    }

    @Override
    public void setNameTagAlwaysVisible(boolean value) {
        this.protocolPlayer.setNameTagAlwaysVisible(value);
    }

    @Override
    public void setScoreTag(String score) {
        this.protocolPlayer.setScoreTag(score);
    }

    @Override
    public String getScoreTag() {
        return this.protocolPlayer.getScoreTag();
    }

    @Override
    public boolean isSneaking() {
        return this.protocolPlayer.isSneaking();
    }

    @Override
    public void setSneaking() {
        this.protocolPlayer.setSneaking();
    }

    @Override
    public void setSneaking(boolean value) {
        this.protocolPlayer.setSneaking(value);
    }

    @Override
    public boolean isSwimming() {
        return this.protocolPlayer.isSwimming();
    }

    @Override
    public void setSwimming() {
        this.protocolPlayer.setSwimming();
    }

    @Override
    public void setSwimming(boolean value) {
        this.protocolPlayer.setSwimming(value);
    }

    @Override
    public boolean isSprinting() {
        return this.protocolPlayer.isSprinting();
    }

    @Override
    public void setSprinting() {
        this.protocolPlayer.setSprinting();
    }

    @Override
    public boolean isGliding() {
        return this.protocolPlayer.isGliding();
    }

    @Override
    public void setGliding() {
        this.protocolPlayer.setGliding();
    }

    @Override
    public void setGliding(boolean value) {
        this.protocolPlayer.setGliding(value);
    }

    @Override
    public boolean isImmobile() {
        return this.protocolPlayer.isImmobile();
    }

    @Override
    public void setImmobile() {
        this.protocolPlayer.setImmobile();
    }

    @Override
    public void setImmobile(boolean value) {
        this.protocolPlayer.setImmobile(value);
    }

    @Override
    public boolean canClimb() {
        return this.protocolPlayer.canClimb();
    }

    @Override
    public void setCanClimb() {
        this.protocolPlayer.setCanClimb();
    }

    @Override
    public void setCanClimb(boolean value) {
        this.protocolPlayer.setCanClimb(value);
    }

    @Override
    public boolean canClimbWalls() {
        return this.protocolPlayer.canClimbWalls();
    }

    @Override
    public void setCanClimbWalls() {
        this.protocolPlayer.setCanClimbWalls();
    }

    @Override
    public void setCanClimbWalls(boolean value) {
        this.protocolPlayer.setCanClimbWalls(value);
    }

    @Override
    public void setScale(float scale) {
        this.protocolPlayer.setScale(scale);
    }

    @Override
    public float getScale() {
        return this.protocolPlayer.getScale();
    }

    @Override
    public List<Entity> getPassengers() {
        return this.protocolPlayer.getPassengers();
    }

    @Override
    public Entity getPassenger() {
        return this.protocolPlayer.getPassenger();
    }

    @Override
    public boolean isPassenger(Entity entity) {
        return this.protocolPlayer.isPassenger(entity);
    }

    @Override
    public boolean isControlling(Entity entity) {
        return this.protocolPlayer.isControlling(entity);
    }

    @Override
    public boolean hasControllingPassenger() {
        return this.protocolPlayer.hasControllingPassenger();
    }

    @Override
    public Entity getRiding() {
        return this.protocolPlayer.getRiding();
    }

    @Override
    public Map<Integer, Effect> getEffects() {
        return this.protocolPlayer.getEffects();
    }

    @Override
    public void removeAllEffects() {
        this.protocolPlayer.removeAllEffects();
    }

    @Override
    public void removeEffect(int effectId) {
        this.protocolPlayer.removeEffect(effectId);
    }

    @Override
    public Effect getEffect(int effectId) {
        return this.protocolPlayer.getEffect(effectId);
    }

    @Override
    public boolean hasEffect(int effectId) {
        return this.protocolPlayer.hasEffect(effectId);
    }

    @Override
    public void addEffect(Effect effect) {
        this.protocolPlayer.addEffect(effect);
    }

    @Override
    public void recalculateBoundingBox() {
        this.protocolPlayer.recalculateBoundingBox();
    }

    @Override
    public void recalculateBoundingBox(boolean send) {
        this.protocolPlayer.recalculateBoundingBox(send);
    }

    @Override
    protected void recalculateEffectColor() {
        invokeMethod("recalculateEffectColor");
    }

    @Override
    protected DataPacket createAddEntityPacket() {
        return (DataPacket)invokeMethod("createAddEntityPacket");
    }

    @Override
    public Map<Integer, Player> getViewers() {
        return this.protocolPlayer.getViewers();
    }

    @Override
    public void sendPotionEffects(Player player) {
        this.protocolPlayer.sendPotionEffects(player);
    }

    @Override
    public void sendData(Player player) {
        this.protocolPlayer.sendData(player);
    }

    @Override
    public void sendData(Player player, EntityMetadata data) {
        this.protocolPlayer.sendData(player, data);
    }

    @Override
    public void sendData(Player[] players) {
        this.protocolPlayer.sendData(players);
    }

    @Override
    public void sendData(Player[] players, EntityMetadata data) {
        this.protocolPlayer.sendData(players, data);
    }

    @Override
    public boolean attack(float damage) {
        return this.protocolPlayer.attack(damage);
    }

    @Override
    public void heal(EntityRegainHealthEvent source) {
        this.protocolPlayer.heal(source);
    }

    @Override
    public void heal(float amount) {
        this.protocolPlayer.heal(amount);
    }

    @Override
    public float getHealth() {
        return this.protocolPlayer.getHealth();
    }

    @Override
    public boolean isAlive() {
        return this.protocolPlayer.isAlive();
    }

    @Override
    public boolean isClosed() {
        return this.protocolPlayer.isClosed();
    }

    @Override
    public void setLastDamageCause(EntityDamageEvent type) {
        this.protocolPlayer.setLastDamageCause(type);
    }

    @Override
    public EntityDamageEvent getLastDamageCause() {
        return this.protocolPlayer.getLastDamageCause();
    }

    @Override
    public int getMaxHealth() {
        return this.protocolPlayer.getMaxHealth();
    }

    @Override
    protected boolean checkObstruction(double x, double y, double z) {
        return (boolean)invokeMethod("checkObstruction", x, y, z);
    }

    @Override
    public void updateMovement() {
        this.protocolPlayer.updateMovement();
    }

    @Override
    public void addMotion(double motionX, double motionY, double motionZ) {
        this.protocolPlayer.addMotion(motionX, motionY, motionZ);
    }

    @Override
    public Vector3 getDirectionVector() {
        return this.protocolPlayer.getDirectionVector();
    }

    @Override
    public Vector2 getDirectionPlane() {
        return this.protocolPlayer.getDirectionPlane();
    }

    @Override
    public BlockFace getHorizontalFacing() {
        return this.protocolPlayer.getHorizontalFacing();
    }

    @Override
    public boolean mountEntity(Entity entity) {
        return this.protocolPlayer.mountEntity(entity);
    }

    @Override
    public boolean mountEntity(Entity entity, byte mode) {
        return this.protocolPlayer.mountEntity(entity, mode);
    }

    @Override
    public boolean dismountEntity(Entity entity) {
        return this.protocolPlayer.dismountEntity(entity);
    }

    @Override
    protected void broadcastLinkPacket(Entity rider, byte type) {
        invokeMethod("broadcastLinkPacket", rider, type);
    }

    @Override
    public void updatePassengers() {
        this.protocolPlayer.updatePassengers();
    }

    @Override
    protected void updatePassengerPosition(Entity passenger) {
        invokeMethod("updatePassengerPosition", passenger);
    }

    @Override
    public void setSeatPosition(Vector3f pos) {
        this.protocolPlayer.setSeatPosition(pos);
    }

    @Override
    public Vector3f getSeatPosition() {
        return this.protocolPlayer.getSeatPosition();
    }

    @Override
    public Vector3f getMountedOffset(Entity entity) {
        return this.protocolPlayer.getMountedOffset(entity);
    }

    @Override
    public boolean isOnFire() {
        return this.protocolPlayer.isOnFire();
    }

    @Override
    public float getAbsorption() {
        return this.protocolPlayer.getAbsorption();
    }

    @Override
    public void setAbsorption(float absorption) {
        this.protocolPlayer.setAbsorption(absorption);
    }

    @Override
    public BlockFace getDirection() {
        return this.protocolPlayer.getDirection();
    }

    @Override
    public void extinguish() {
        this.protocolPlayer.extinguish();
    }

    @Override
    public boolean canTriggerWalking() {
        return this.protocolPlayer.canTriggerWalking();
    }

    @Override
    protected void updateFallState(boolean onGround) {
        invokeMethod("updateFallState", onGround);
    }

    @Override
    public AxisAlignedBB getBoundingBox() {
        return this.protocolPlayer.getBoundingBox();
    }

    @Override
    public void fall(float fallDistance) {
        this.protocolPlayer.fall(fallDistance);
    }

    @Override
    public void handleLavaMovement() {
        this.protocolPlayer.handleLavaMovement();
    }

    @Override
    public void moveFlying(float strafe, float forward, float friction) {
        this.protocolPlayer.moveFlying(strafe, forward, friction);
    }

    @Override
    public void onCollideWithPlayer(EntityHuman entityPlayer) {
        this.protocolPlayer.onCollideWithPlayer(entityPlayer);
    }

    @Override
    public void applyEntityCollision(Entity entity) {
        this.protocolPlayer.applyEntityCollision(entity);
    }

    @Override
    public void onStruckByLightning(Entity entity) {
        this.protocolPlayer.onStruckByLightning(entity);
    }

    @Override
    public boolean onInteract(Player player, Item item, Vector3 clickedPos) {
        return this.protocolPlayer.onInteract(player, item, clickedPos);
    }

    @Override
    public boolean onInteract(Player player, Item item) {
        return this.protocolPlayer.onInteract(player, item);
    }

    @Override
    public Position getPosition() {
        return this.protocolPlayer.getPosition();
    }

    @Override
    public Location getLocation() {
        return this.protocolPlayer.getLocation();
    }

    @Override
    public boolean isInsideOfWater() {
        return this.protocolPlayer.isInsideOfWater();
    }

    @Override
    public boolean isInsideOfSolid() {
        return this.protocolPlayer.isInsideOfSolid();
    }

    @Override
    public boolean isInsideOfFire() {
        return this.protocolPlayer.isInsideOfFire();
    }

    @Override
    public boolean isOnLadder() {
        return this.protocolPlayer.isOnLadder();
    }

    @Override
    public boolean fastMove(double dx, double dy, double dz) {
        return this.protocolPlayer.fastMove(dx, dy, dz);
    }

    @Override
    public boolean move(double dx, double dy, double dz) {
        return this.protocolPlayer.move(dx, dy, dz);
    }

    @Override
    public List<Block> getBlocksAround() {
        return this.protocolPlayer.getBlocksAround();
    }

    @Override
    public List<Block> getCollisionBlocks() {
        return this.protocolPlayer.getCollisionBlocks();
    }

    @Override
    public boolean canBeMovedByCurrents() {
        return this.protocolPlayer.canBeMovedByCurrents();
    }

    @Override
    public boolean setPositionAndRotation(Vector3 pos, double yaw, double pitch) {
        return this.protocolPlayer.setPositionAndRotation(pos, yaw, pitch);
    }

    @Override
    public void setRotation(double yaw, double pitch) {
        this.protocolPlayer.setRotation(yaw, pitch);
    }

    @Override
    public boolean canPassThrough() {
        return this.protocolPlayer.canPassThrough();
    }

    @Override
    public boolean setPosition(Vector3 pos) {
        return this.protocolPlayer.setPosition(pos);
    }

    @Override
    public Vector3 getMotion() {
        return this.protocolPlayer.getMotion();
    }

    @Override
    public boolean isOnGround() {
        return this.protocolPlayer.isOnGround();
    }

    @Override
    public boolean teleport(Vector3 pos) {
        return this.protocolPlayer.teleport(pos);
    }

    @Override
    public boolean teleport(Vector3 pos, PlayerTeleportEvent.TeleportCause cause) {
        return this.protocolPlayer.teleport(pos, cause);
    }

    @Override
    public boolean teleport(Position pos) {
        return this.protocolPlayer.teleport(pos);
    }

    @Override
    public boolean teleport(Position pos, PlayerTeleportEvent.TeleportCause cause) {
        return this.protocolPlayer.teleport(pos, cause);
    }

    @Override
    public boolean teleport(Location location) {
        return this.protocolPlayer.teleport(location);
    }

    @Override
    public long getId() {
        return this.protocolPlayer.getId();
    }

    @Override
    public void respawnToAll() {
        this.protocolPlayer.respawnToAll();
    }

    @Override
    public void spawnToAll() {
        this.protocolPlayer.spawnToAll();
    }

    @Override
    public void despawnFromAll() {
        this.protocolPlayer.despawnFromAll();
    }

    @Override
    public EntityMetadata getDataProperties() {
        return this.protocolPlayer.getDataProperties();
    }

    @Override
    public EntityData getDataProperty(int id) {
        return this.protocolPlayer.getDataProperty(id);
    }

    @Override
    public int getDataPropertyInt(int id) {
        return this.protocolPlayer.getDataPropertyInt(id);
    }

    @Override
    public int getDataPropertyShort(int id) {
        return this.protocolPlayer.getDataPropertyShort(id);
    }

    @Override
    public int getDataPropertyByte(int id) {
        return this.protocolPlayer.getDataPropertyByte(id);
    }

    @Override
    public boolean getDataPropertyBoolean(int id) {
        return this.protocolPlayer.getDataPropertyBoolean(id);
    }

    @Override
    public long getDataPropertyLong(int id) {
        return this.protocolPlayer.getDataPropertyLong(id);
    }

    @Override
    public String getDataPropertyString(int id) {
        return this.protocolPlayer.getDataPropertyString(id);
    }

    @Override
    public float getDataPropertyFloat(int id) {
        return this.protocolPlayer.getDataPropertyFloat(id);
    }

    @Override
    public CompoundTag getDataPropertyNBT(int id) {
        return this.protocolPlayer.getDataPropertyNBT(id);
    }

    @Override
    public Vector3 getDataPropertyPos(int id) {
        return this.protocolPlayer.getDataPropertyPos(id);
    }

    @Override
    public Vector3f getDataPropertyVector3f(int id) {
        return this.protocolPlayer.getDataPropertyVector3f(id);
    }

    @Override
    public int getDataPropertyType(int id) {
        return this.protocolPlayer.getDataPropertyType(id);
    }

    @Override
    public void setDataFlag(int propertyId, int id) {
        this.protocolPlayer.setDataFlag(propertyId, id);
    }

    @Override
    public void setDataFlag(int propertyId, int id, boolean value) {
        this.protocolPlayer.setDataFlag(propertyId, id, value);
    }

    @Override
    public boolean getDataFlag(int propertyId, int id) {
        return this.protocolPlayer.getDataFlag(propertyId, id);
    }

    @Override
    public double getYaw() {
        return this.protocolPlayer.getYaw();
    }

    @Override
    public double getPitch() {
        return this.protocolPlayer.getPitch();
    }

    @Override
    public Location add(double x) {
        return this.protocolPlayer.add(x);
    }

    @Override
    public Location add(double x, double y) {
        return this.protocolPlayer.add(x, y);
    }

    @Override
    public Location add(double x, double y, double z) {
        return this.protocolPlayer.add(x, y, z);
    }

    @Override
    public Location add(Vector3 x) {
        return this.protocolPlayer.add(x);
    }

    @Override
    public Location subtract() {
        return this.protocolPlayer.subtract();
    }

    @Override
    public Location subtract(double x) {
        return this.protocolPlayer.subtract(x);
    }

    @Override
    public Location subtract(double x, double y) {
        return this.protocolPlayer.subtract(x, y);
    }

    @Override
    public Location subtract(double x, double y, double z) {
        return this.protocolPlayer.subtract(x, y, z);
    }

    @Override
    public Location subtract(Vector3 x) {
        return this.protocolPlayer.subtract(x);
    }

    @Override
    public Location multiply(double number) {
        return this.protocolPlayer.multiply(number);
    }

    @Override
    public Location divide(double number) {
        return this.protocolPlayer.divide(number);
    }

    @Override
    public Location ceil() {
        return this.protocolPlayer.ceil();
    }

    @Override
    public Location floor() {
        return this.protocolPlayer.floor();
    }

    @Override
    public Location round() {
        return this.protocolPlayer.round();
    }

    @Override
    public Location abs() {
        return this.protocolPlayer.abs();
    }

    @Override
    public Location clone() {
        return this.protocolPlayer.clone();
    }

    @Override
    public Level getLevel() {
        return this.protocolPlayer.getLevel();
    }

    @Override
    public Position setLevel(Level level) {
        return this.protocolPlayer.setLevel(level);
    }

    @Override
    public boolean isValid() {
        return this.protocolPlayer.isValid();
    }

    @Override
    public boolean setStrong() {
        return this.protocolPlayer.setStrong();
    }

    @Override
    public boolean setWeak() {
        return this.protocolPlayer.setWeak();
    }

    @Override
    public Position getSide(BlockFace face) {
        return this.protocolPlayer.getSide(face);
    }

    @Override
    public Position getSide(BlockFace face, int step) {
        return this.protocolPlayer.getSide(face, step);
    }

    @Override
    public Position setComponents(double x, double y, double z) {
        return this.protocolPlayer.setComponents(x, y, z);
    }

    @Override
    public Block getLevelBlock() {
        return this.protocolPlayer.getLevelBlock();
    }

    @Override
    public FullChunk getChunk() {
        return this.protocolPlayer.getChunk();
    }

    @Override
    public double getX() {
        return this.protocolPlayer.getX();
    }

    @Override
    public double getY() {
        return this.protocolPlayer.getY();
    }

    @Override
    public double getZ() {
        return this.protocolPlayer.getZ();
    }

    @Override
    public int getFloorX() {
        return this.protocolPlayer.getFloorX();
    }

    @Override
    public int getFloorY() {
        return this.protocolPlayer.getFloorY();
    }

    @Override
    public int getFloorZ() {
        return this.protocolPlayer.getFloorZ();
    }

    @Override
    public int getChunkX() {
        return this.protocolPlayer.getChunkX();
    }

    @Override
    public int getChunkZ() {
        return this.protocolPlayer.getChunkZ();
    }

    @Override
    public double getRight() {
        return this.protocolPlayer.getRight();
    }

    @Override
    public double getUp() {
        return this.protocolPlayer.getUp();
    }

    @Override
    public double getForward() {
        return this.protocolPlayer.getForward();
    }

    @Override
    public double getSouth() {
        return this.protocolPlayer.getSouth();
    }

    @Override
    public double getWest() {
        return this.protocolPlayer.getWest();
    }

    @Override
    public Vector3 up() {
        return this.protocolPlayer.up();
    }

    @Override
    public Vector3 up(int step) {
        return this.protocolPlayer.up(step);
    }

    @Override
    public Vector3 down() {
        return this.protocolPlayer.down();
    }

    @Override
    public Vector3 down(int step) {
        return this.protocolPlayer.down(step);
    }

    @Override
    public Vector3 north() {
        return this.protocolPlayer.north();
    }

    @Override
    public Vector3 north(int step) {
        return this.protocolPlayer.north(step);
    }

    @Override
    public Vector3 south() {
        return this.protocolPlayer.south();
    }

    @Override
    public Vector3 south(int step) {
        return this.protocolPlayer.south(step);
    }

    @Override
    public Vector3 east() {
        return this.protocolPlayer.east();
    }

    @Override
    public Vector3 east(int step) {
        return this.protocolPlayer.east(step);
    }

    @Override
    public Vector3 west() {
        return this.protocolPlayer.west();
    }

    @Override
    public Vector3 west(int step) {
        return this.protocolPlayer.west(step);
    }

    @Override
    public double distance(Vector3 pos) {
        return this.protocolPlayer.distance(pos);
    }

    @Override
    public double distanceSquared(Vector3 pos) {
        return this.protocolPlayer.distanceSquared(pos);
    }

    @Override
    public double maxPlainDistance() {
        return this.protocolPlayer.maxPlainDistance();
    }

    @Override
    public double maxPlainDistance(double x) {
        return this.protocolPlayer.maxPlainDistance(x);
    }

    @Override
    public double maxPlainDistance(double x, double z) {
        return this.protocolPlayer.maxPlainDistance(x, z);
    }

    @Override
    public double maxPlainDistance(Vector2 vector) {
        return this.protocolPlayer.maxPlainDistance(vector);
    }

    @Override
    public double maxPlainDistance(Vector3 x) {
        return this.protocolPlayer.maxPlainDistance(x);
    }

    @Override
    public double length() {
        return this.protocolPlayer.length();
    }

    @Override
    public double lengthSquared() {
        return this.protocolPlayer.lengthSquared();
    }

    @Override
    public Vector3 normalize() {
        return this.protocolPlayer.normalize();
    }

    @Override
    public double dot(Vector3 v) {
        return this.protocolPlayer.dot(v);
    }

    @Override
    public Vector3 cross(Vector3 v) {
        return this.protocolPlayer.cross(v);
    }

    @Override
    public Vector3 getIntermediateWithXValue(Vector3 v, double x) {
        return this.protocolPlayer.getIntermediateWithXValue(v, x);
    }

    @Override
    public Vector3 getIntermediateWithYValue(Vector3 v, double y) {
        return this.protocolPlayer.getIntermediateWithYValue(v, y);
    }

    @Override
    public Vector3 getIntermediateWithZValue(Vector3 v, double z) {
        return this.protocolPlayer.getIntermediateWithZValue(v, z);
    }

    @Override
    public int rawHashCode() {
        return this.protocolPlayer.rawHashCode();
    }

    @Override
    public Vector3f asVector3f() {
        return this.protocolPlayer.asVector3f();
    }

    @Override
    public BlockVector3 asBlockVector3() {
        return this.protocolPlayer.asBlockVector3();
    }
}
