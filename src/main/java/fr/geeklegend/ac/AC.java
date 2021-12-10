package fr.geeklegend.ac;

import fr.geeklegend.ac.checks.CheckManager;
import fr.geeklegend.ac.data.UserManager;
import fr.geeklegend.ac.listeners.ListenerManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class AC extends JavaPlugin {
    private static AC instance;

    private UserManager userManager;
    private CheckManager checkManager;

    @Override
    public void onEnable() {
        instance = this;
        userManager = new UserManager();
        checkManager = new CheckManager();

        new ListenerManager();
    }

    @Override
    public void onDisable() {
        instance = null;
        Bukkit.getScheduler().cancelTasks(this);
    }

    public static AC get() {
        return instance;
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public CheckManager getCheckManager() {
        return checkManager;
    }
}
