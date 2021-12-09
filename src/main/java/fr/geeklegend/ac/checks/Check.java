package fr.geeklegend.ac.checks;

import fr.geeklegend.ac.AC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.Map;
import java.util.WeakHashMap;

public abstract class Check implements Listener {
    protected String name;

    protected CheckType checkType;

    protected boolean enabled;

    protected boolean punishable;

    protected int max;

    protected Map<Player, Integer> violations;

    public Check(String name, CheckType checkType, boolean enabled, boolean punishable, int max) {
        this.name = name;
        this.checkType = checkType;
        this.enabled = enabled;
        this.punishable = punishable;
        this.max = max;
        this.violations = new WeakHashMap<>();

        Bukkit.getPluginManager().registerEvents(this, AC.getInstance());
    }

    protected void flag(Player player, String... information) {
        int violations = this.violations.getOrDefault(player, 0) + 1;
        if (information != null) {
            StringBuilder formattedInfo = new StringBuilder();
            for (String string : information) {
                formattedInfo.append(string).append(", ");
            }
            Bukkit.getOnlinePlayers().forEach(staff -> {
                if (staff.hasPermission("anticheat.staff")) {
                    staff.sendMessage(ChatColor.GOLD + "[AntiCheat] " + ChatColor.YELLOW + player.getName() + ChatColor.GRAY + " has been detected for " + ChatColor.YELLOW + name + ChatColor.GOLD + " [" + formattedInfo + "] " + ChatColor.RED + "(" + violations + ")");
                }
            });
        } else {
            Bukkit.getOnlinePlayers().forEach(staff -> {
                if (staff.hasPermission("anticheat.staff")) {
                    staff.sendMessage(ChatColor.GOLD + "[AntiCheat] " + ChatColor.YELLOW + player.getName() + ChatColor.GRAY + " has been detected for " + ChatColor.YELLOW + name + ChatColor.RED + "(" + violations + ")");
                }
            });
        }
        if (violations >= max) {
            player.kickPlayer("You have been detected for " + name);
        }
        this.violations.put(player, violations);
    }

}
