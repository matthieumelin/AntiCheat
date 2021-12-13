package fr.geeklegend.ac.managers;

import fr.geeklegend.ac.data.PlayerData;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayerDataManager {
    private final Map<Player, PlayerData> datas;

    public PlayerDataManager() {
        this.datas = new HashMap<>();
    }

    public void add(Player player) {
        datas.put(player, new PlayerData(player));
    }

    public void remove(Player player) {
        datas.remove(player);
    }

    public PlayerData get(Player player) {
        return datas.getOrDefault(player, new PlayerData(player));
    }
}
