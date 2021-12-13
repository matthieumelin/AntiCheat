package fr.geeklegend.ac.processors;

import fr.geeklegend.ac.data.PlayerData;
import io.github.retrooper.packetevents.packetwrappers.play.in.useentity.WrappedPacketInUseEntity;
import org.bukkit.entity.LivingEntity;

public class CombatProcessor {
    private final PlayerData data;
    private LivingEntity attacked, lastAttacked;
    private long lastAttack;

    public CombatProcessor(PlayerData data) {
        this.data = data;
    }

    public void handle(WrappedPacketInUseEntity wrappedPacketInUseEntity) {
        if (wrappedPacketInUseEntity.getAction().equals(WrappedPacketInUseEntity.EntityUseAction.ATTACK)) {
            lastAttacked = attacked;
            attacked = (LivingEntity) wrappedPacketInUseEntity.getEntity();
            lastAttack = System.currentTimeMillis();
        }
    }

    public LivingEntity getAttacked() {
        return attacked;
    }

    public LivingEntity getLastAttacked() {
        return lastAttacked;
    }

    public long getLastAttack() {
        return lastAttack;
    }
}
