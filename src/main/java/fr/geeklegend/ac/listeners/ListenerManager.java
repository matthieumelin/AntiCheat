package fr.geeklegend.ac.listeners;

import fr.geeklegend.ac.AC;
import org.bukkit.Bukkit;

import java.util.Arrays;

public class ListenerManager {
    public ListenerManager() {
        Arrays.asList(
                new PlayerMoveListener(),
                new PlayerJoinListener(),
                new PlayerQuitListener(),
                new EntityDamageByEntityListener()
        ).forEach(listener -> Bukkit.getServer().getPluginManager().registerEvents(listener, AC.get()));
    }
}
