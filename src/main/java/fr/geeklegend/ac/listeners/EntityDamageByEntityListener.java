package fr.geeklegend.ac.listeners;

import fr.geeklegend.ac.AC;
import fr.geeklegend.ac.checks.Check;
import fr.geeklegend.ac.checks.CheckManager;
import fr.geeklegend.ac.checks.CheckResult;
import fr.geeklegend.ac.data.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamageByEntityListener implements Listener {
    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();
            User user = AC.get().getUserManager().getUser(player.getUniqueId());

            if (user != null) {
                CheckManager checkManager = AC.get().getCheckManager();
                Check reach = checkManager.getByName("Reach");
                CheckResult reachResult = reach.check(user, event.getEntity());

                if (reachResult.isFailed()) {
                    Bukkit.broadcastMessage(reachResult.getMessage());
                    user.addWarning(reach);
                }

                checkManager.getChecks().stream().filter(check -> user.getWarnings(check) >= check.getMax()).forEach(check -> player.kickPlayer(check.getName() + " detected"));
            }
        }
    }
}
