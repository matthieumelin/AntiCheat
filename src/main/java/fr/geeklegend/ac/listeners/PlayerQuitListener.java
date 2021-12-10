package fr.geeklegend.ac.listeners;

import fr.geeklegend.ac.AC;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        AC.get().getUserManager().remove(event.getPlayer().getUniqueId());
    }
}
