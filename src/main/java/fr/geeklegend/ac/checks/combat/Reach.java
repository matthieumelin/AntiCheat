package fr.geeklegend.ac.checks.combat;

import fr.geeklegend.ac.checks.Check;
import fr.geeklegend.ac.checks.CheckLevel;
import fr.geeklegend.ac.checks.CheckResult;
import fr.geeklegend.ac.checks.CheckType;
import fr.geeklegend.ac.data.User;
import fr.geeklegend.ac.settings.Settings;
import fr.geeklegend.ac.utilities.Distance;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;

public class Reach extends Check {
    private final CheckResult PASSED_RESULT = new CheckResult(CheckLevel.PASSED, CheckType.COMBAT, null);

    public Reach(String name, int max) {
        super(name, max);
    }

    @Override
    public CheckResult check(Distance distance, User user) {
        return null;
    }

    @Override
    public CheckResult check(User user, Entity entity) {
        Distance distance = new Distance(user.getPlayer().getLocation(), entity.getLocation());
        double x = distance.getxDiff();
        double z = distance.getzDiff();
        double max = user.getPlayer().getGameMode().equals(GameMode.CREATIVE) ? Settings.COMBAT_MAX_REACH_CREATIVE : Settings.COMBAT_MAX_REACH_SURVIVAL;
        double reach = (Math.max(distance.getxDiff(), distance.getzDiff()));
        if (x > max || z > max) return new CheckResult(CheckLevel.DEFINITELY, CheckType.COMBAT, Settings.PREFIX + ChatColor.RED + user.getPlayer().getName() + ChatColor.GRAY + " failed " + ChatColor.RED + name + ChatColor.GRAY + " [" + CheckLevel.DEFINITELY.getNameColor() + CheckLevel.DEFINITELY.getName() + ChatColor.GRAY + "] (reach=" + (Math.round(reach * 100) / 100.0) + ") (max=" + max + ")");
        return PASSED_RESULT;
    }
}
