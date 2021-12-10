package fr.geeklegend.ac.checks.movement;

import fr.geeklegend.ac.checks.Check;
import fr.geeklegend.ac.checks.CheckLevel;
import fr.geeklegend.ac.checks.CheckResult;
import fr.geeklegend.ac.checks.CheckType;
import fr.geeklegend.ac.data.User;
import fr.geeklegend.ac.settings.Settings;
import fr.geeklegend.ac.utilities.Distance;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;

public class Speed extends Check {
    private final CheckResult PASSED_RESULT = new CheckResult(CheckLevel.PASSED, CheckType.MOVEMENT, null);

    public Speed(String name, int max) {
        super(name, max);
    }

    @Override
    public CheckResult check(Distance distance, User user) {
        if (user.getPlayer().isFlying()) return PASSED_RESULT;
        double xzSpeed = (Math.max(distance.getxDiff(), distance.getzDiff()));
        if (xzSpeed > Settings.MAX_XZ_SPEED) return new CheckResult(CheckLevel.DEFINITELY, CheckType.MOVEMENT, Settings.PREFIX + ChatColor.RED + user.getPlayer().getName() + ChatColor.GRAY + " failed " + ChatColor.RED + name + ChatColor.GRAY + " [" + CheckLevel.DEFINITELY.getNameColor() + CheckLevel.DEFINITELY.getName() + ChatColor.GRAY + "] (delta=" + (Math.round(xzSpeed * 100) / 100.0) + ", (max=" + Settings.MAX_XZ_SPEED + ")");
        return PASSED_RESULT;
    }

    @Override
    public CheckResult check(User user, Entity entity) {
        return null;
    }
}
