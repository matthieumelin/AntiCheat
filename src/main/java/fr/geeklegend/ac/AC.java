package fr.geeklegend.ac;

import fr.geeklegend.ac.data.DataManager;
import org.bukkit.plugin.java.JavaPlugin;

public class AC extends JavaPlugin {

    private static AC instance;

    private DataManager dataManager;

    @Override
    public void onEnable() {
        instance = this;

        dataManager = new DataManager();
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static AC getInstance() {
        return instance;
    }

    public DataManager getDataManager() {
        return dataManager;
    }
}
