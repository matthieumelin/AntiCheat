package fr.geeklegend.ac.data;

import fr.geeklegend.ac.managers.CheckManager;
import fr.geeklegend.ac.processors.ActionProcessor;
import fr.geeklegend.ac.processors.CombatProcessor;
import fr.geeklegend.ac.processors.MovementProcessor;
import fr.geeklegend.ac.processors.RotationProcessor;
import org.bukkit.entity.Player;

public class PlayerData {
    private final Player player;

    private final CheckManager checkManager;

    private final ActionProcessor actionProcessor;
    private final CombatProcessor combatProcessor;
    private final MovementProcessor movementProcessor;
    private final RotationProcessor rotationProcessor;

    public PlayerData(Player player) {
        this.player = player;
        this.checkManager = new CheckManager(this);
        this.actionProcessor = new ActionProcessor(this);
        this.combatProcessor = new CombatProcessor(this);
        this.movementProcessor = new MovementProcessor(this);
        this.rotationProcessor = new RotationProcessor(this);
    }

    public Player getPlayer() {
        return player;
    }

    public CheckManager getCheckManager() {
        return checkManager;
    }

    public ActionProcessor getActionProcessor() {
        return actionProcessor;
    }

    public CombatProcessor getCombatProcessor() {
        return combatProcessor;
    }

    public MovementProcessor getMovementProcessor() {
        return movementProcessor;
    }

    public RotationProcessor getRotationProcessor() {
        return rotationProcessor;
    }
}
