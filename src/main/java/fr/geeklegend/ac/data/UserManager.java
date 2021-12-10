package fr.geeklegend.ac.data;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserManager {
    private final Map<UUID, User> users;

    public UserManager() {
        this.users = new HashMap<>();
    }

    public void add(UUID uuid) {
        if (getUser(uuid) != null) return;
        users.put(uuid, new User(uuid));
    }

    public void remove(UUID uuid) {
        if (getUser(uuid) != null) {
            users.remove(uuid);
        }
    }

    public User getUser(UUID uuid) {
        return users.get(uuid);
    }

    public Map<UUID, User> getUsers() {
        return users;
    }
}
