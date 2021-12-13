package fr.geeklegend.ac.managers;

import fr.geeklegend.ac.check.Check;
import fr.geeklegend.ac.check.CheckType;
import fr.geeklegend.ac.check.impl.movement.fly.FlyA;
import fr.geeklegend.ac.check.impl.movement.nofall.NoFallA;
import fr.geeklegend.ac.data.PlayerData;

import java.util.Arrays;
import java.util.List;

public class CheckManager {
    private final PlayerData data;

    private List<Check> checks;

    public CheckManager(PlayerData data) {
        this.data = data;
        this.checks = Arrays.asList(
                new FlyA(data, "Fly A", CheckType.MOVEMENT, 20, false),
                new NoFallA(data, "NoFall A", CheckType.MOVEMENT, 20, false)
        );
    }

    public List<Check> getChecks() {
        return checks;
    }
}
