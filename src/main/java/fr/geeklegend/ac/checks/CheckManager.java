package fr.geeklegend.ac.checks;

import fr.geeklegend.ac.checks.combat.Reach;
import fr.geeklegend.ac.checks.movement.Speed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckManager {
    private final List<Check> checks;

    public CheckManager() {
        this.checks = new ArrayList<>();
        this.checks.addAll(Arrays.asList(
                new Speed("Speed", 20),
                new Reach("Reach", 50)
        ));
    }

    public List<Check> getChecks() {
        return checks;
    }

    public Check getByName(String name) {
        return checks.stream().filter(check -> check.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

}
