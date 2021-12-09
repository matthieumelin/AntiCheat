package fr.geeklegend.ac.data;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public class DataManager {
    private final Set<DataPlayer> dataSet;

    public DataManager() {
        this.dataSet = new HashSet<>();

        Bukkit.getOnlinePlayers().forEach(this::add);
    }

    public void add(Player player) {
        dataSet.add(new DataPlayer(player));
    }

    public void remove(Player player) {
        dataSet.removeIf(dataPlayer -> dataPlayer.getPlayer().equals(player));
    }

    public DataPlayer getDataPlayer(Player player) {
        return dataSet.stream().filter(dataPlayer -> dataPlayer.getPlayer().equals(dataPlayer)).findFirst().orElse(null);
    }
}
