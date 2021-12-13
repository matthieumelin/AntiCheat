package fr.geeklegend.ac.listeners.bukkit;

import fr.geeklegend.ac.AntiCheat;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        AntiCheat.getInstance().getPlayerDataManager().remove(event.getPlayer());
    }
}
