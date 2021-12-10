package fr.geeklegend.ac.data;

import fr.geeklegend.ac.checks.Check;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class User {
    private final Player player;

    private final HashMap<Check, Integer> warnings;

    public User(UUID uuid) {
        this.player = Bukkit.getPlayer(uuid);
        this.warnings = new HashMap<>();
    }

    public void addWarning(Check check) {
        warnings.put(check, getWarnings(check) + 1);
    }

    public int getWarnings(Check check) {
        warnings.putIfAbsent(check, 0);
        return warnings.get(check);
    }

    public Player getPlayer() {
        return player;
    }

}
