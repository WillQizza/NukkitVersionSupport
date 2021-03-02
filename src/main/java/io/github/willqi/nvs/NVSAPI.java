package io.github.willqi.nvs;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerCreationEvent;
import cn.nukkit.network.protocol.ProtocolInfo;
import cn.nukkit.plugin.PluginBase;
import io.github.willqi.nvs.versions.PlayerV419;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class NVSAPI extends PluginBase implements Listener {

    private static final int CURRENT_PROTOCOL_SUPPORT = 422;

    private static final Map<Integer, Class<? extends Player>> playerClasses;

    private static NVSAPI instance;

    static {
        Map<Integer, Class<? extends Player>> classes = new HashMap<>();
        classes.put(CURRENT_PROTOCOL_SUPPORT, Player.class);
        classes.put(419, PlayerV419.class);                     // 1.16.100

        playerClasses = Collections.unmodifiableMap(classes);
    }

    /**
     * Get the player object for a specific protocol
     * @param protocolVersion
     * @return
     */
    public static Optional<Class<? extends Player>> getProtocolPlayer(int protocolVersion) {
        if (playerClasses.containsKey(protocolVersion)) {
            return Optional.of(playerClasses.get(protocolVersion));
        } else {
            return Optional.empty();
        }
    }

    public static NVSAPI get() {
        return instance;
    }

    @Override
    public void onEnable () {
        if (CURRENT_PROTOCOL_SUPPORT < ProtocolInfo.CURRENT_PROTOCOL) {
            getLogger().critical(String.format("This version does not yet support protocol version v%s. Please update, contact the developer, or submit a issue/pull request at our github repository.", ProtocolInfo.CURRENT_PROTOCOL));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        instance = this;
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("NukkitVersionSupport has been launched.");

    }

    @EventHandler
    public void onPlayerCreation(PlayerCreationEvent event) {
        event.setBaseClass(NVSPlayer.class);
        event.setPlayerClass(NVSPlayer.class);
    }



}
