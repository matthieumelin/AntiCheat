package fr.geeklegend.ac.data;

import com.google.common.collect.Lists;
import fr.geeklegend.ac.AC;
import fr.geeklegend.ac.utilities.PastLocation;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class DataPlayer {
    private Player player;

    private Object boundingBox;

    private boolean onGround, inLiquid, onStairSlab, onIce, onClimable, underBlock, onSlime, nearGround;

    private int airTicks, groundTicks, iceTicks, liquidTicks, blockTicks, slimeTicks, velXTicks, velYTicks, velZTicks;

    private long lastVelocityTaken, lastAttack, lastServerKP, ping;

    private LivingEntity lastHitEntity;

    public PastLocation entityPastLocations;

    // Killaura
    private int killAuraAVerbose;
    private long lastFlying;

    // Pattern
    private List<Float> patterns;
    private float lastRange;

    // Fly
    private float lastDeltaY, lastAcceleration;

    // NoFall
    private boolean serverGround;

    // Thresholds
    private int speedTreshold;
    private int reachTreshold;
    private float flyTreshold;

    public DataPlayer(Player player) {
        this.player = player;
        this.entityPastLocations = new PastLocation();
        this.patterns = Lists.newArrayList();
        this.serverGround = true;

        new BukkitRunnable() {
            @Override
            public void run() {
                if (lastHitEntity != null) {
                    entityPastLocations.addLocation(lastHitEntity.getLocation());
                }
            }
        }.runTaskTimer(AC.getInstance(), 0, 1);
    }

    public boolean isVelocityTaken() {
        return velXTicks > 0 || velYTicks > 0 || velZTicks > 0;
    }

    public void reduceVelocity(){
        velXTicks = Math.max(0, velXTicks - 1);
        velYTicks = Math.max(0, velYTicks - 1);
        velZTicks = Math.max(0, velZTicks - 1);
    }

    public Player getPlayer() {
        return player;
    }

    public long getLastAttack() {
        return lastAttack;
    }

    public void setLastAttack(long lastAttack) {
        this.lastAttack = lastAttack;
    }

    public LivingEntity getLastHitEntity() {
        return lastHitEntity;
    }

    public void setLastHitEntity(LivingEntity lastHitEntity) {
        this.lastHitEntity = lastHitEntity;
    }

    public List<Float> getPatterns() {
        return patterns;
    }

    public float getLastRange() {
        return lastRange;
    }

    public void setLastRange(float lastRange) {
        this.lastRange = lastRange;
    }
}
