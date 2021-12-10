package fr.geeklegend.ac.checks;

import fr.geeklegend.ac.data.User;
import fr.geeklegend.ac.utilities.Distance;
import org.bukkit.entity.Entity;

public abstract class Check {
    protected String name;

    protected int max;

    public Check(String name, int max) {
        this.name = name;
        this.max = max;
    }

    public abstract CheckResult check(Distance distance, User user);
    public abstract CheckResult check(User user, Entity entity);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
