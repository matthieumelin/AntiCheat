package fr.geeklegend.ac.listeners.bukkit;

import fr.geeklegend.ac.AntiCheat;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        AntiCheat.getInstance().getPlayerDataManager().add(event.getPlayer());
    }
}
