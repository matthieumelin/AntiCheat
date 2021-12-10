package fr.geeklegend.ac.listeners;

import fr.geeklegend.ac.AC;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        AC.get().getUserManager().add(event.getPlayer().getUniqueId());
    }
}
