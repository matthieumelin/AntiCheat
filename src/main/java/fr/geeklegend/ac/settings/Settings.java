package fr.geeklegend.ac.settings;

import org.bukkit.ChatColor;

public class Settings {
    /**
     * General settings
     */
    public static final String PREFIX = ChatColor.RED + "" + ChatColor.BOLD + "AC" + ChatColor.RESET + ChatColor.DARK_GRAY + " » ";

    /**
     * Combat settings
     */
    public static final double COMBAT_MAX_REACH_SURVIVAL = 3.7D;
    public static final double COMBAT_MAX_REACH_CREATIVE = 5.25D;

    /**
     * Movement settings
     */
    public static final double MAX_XZ_SPEED = 0.65D;
}
