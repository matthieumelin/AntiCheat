package fr.geeklegend.ac.managers;

import fr.geeklegend.ac.AntiCheat;
import fr.geeklegend.ac.listeners.bukkit.PlayerJoinListener;
import fr.geeklegend.ac.listeners.bukkit.PlayerQuitListener;
import org.bukkit.Bukkit;

import java.util.Arrays;

public class ListenerManager {
    public ListenerManager() {
        Arrays.asList(
                new PlayerJoinListener(),
                new PlayerQuitListener()
        ).forEach(listener -> Bukkit.getPluginManager().registerEvents(listener, AntiCheat.getInstance()));
    }
}
