package fr.geeklegend.ac.listeners;

import fr.geeklegend.ac.AC;
import fr.geeklegend.ac.checks.Check;
import fr.geeklegend.ac.checks.CheckManager;
import fr.geeklegend.ac.checks.CheckResult;
import fr.geeklegend.ac.data.User;
import fr.geeklegend.ac.utilities.Distance;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        User user = AC.get().getUserManager().getUser(player.getUniqueId());

        if (user != null) {
            Distance distance = new Distance(event);
            CheckManager checkManager = AC.get().getCheckManager();
            Check speed = checkManager.getByName("Speed");
            CheckResult speedResult = speed.check(distance, user);

            if (speedResult.isFailed()) {
                Bukkit.broadcastMessage(speedResult.getMessage());
                user.addWarning(speed);
            }

            checkManager.getChecks().stream().filter(check -> user.getWarnings(check) >= check.getMax()).forEach(check -> player.kickPlayer(check.getName() + " detected"));
        }
    }
}
