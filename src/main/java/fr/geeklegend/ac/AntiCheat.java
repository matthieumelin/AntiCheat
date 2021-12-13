package fr.geeklegend.ac;

import fr.geeklegend.ac.listeners.packet.PacketListener;
import fr.geeklegend.ac.managers.ListenerManager;
import fr.geeklegend.ac.managers.PlayerDataManager;
import io.github.retrooper.packetevents.PacketEvents;
import io.github.retrooper.packetevents.utils.server.ServerVersion;
import org.bukkit.plugin.java.JavaPlugin;

public class AntiCheat extends JavaPlugin {
    private static AntiCheat instance;

    private PlayerDataManager playerDataManager;
    private ListenerManager listenerManager;

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();

        PacketEvents.create(this)
                .getSettings()
                .checkForUpdates(true)
                .fallbackServerVersion(ServerVersion.v_1_8_8);

        playerDataManager = new PlayerDataManager();
        listenerManager = new ListenerManager();

        PacketEvents.get().registerListener(new PacketListener());
        PacketEvents.get().init();

        System.out.println("Anti-Cheat enabled");
    }

    @Override
    public void onDisable() {
        instance = null;

        PacketEvents.get().terminate();

        System.out.println("Anti-Cheat disabled");
    }

    public static AntiCheat getInstance() {
        return instance;
    }

    public PlayerDataManager getPlayerDataManager() {
        return playerDataManager;
    }

    public ListenerManager getListenerManager() {
        return listenerManager;
    }
}
