package fr.geeklegend.ac.processors;

import fr.geeklegend.ac.data.PlayerData;
import io.github.retrooper.packetevents.packetwrappers.play.in.flying.WrappedPacketInFlying;

public class RotationProcessor {
    private final PlayerData data;

    private float yaw, pitch,
            deltaYaw, deltaPitch,
            lastYaw, lastPitch,
            lastDeltaYaw, lastDeltaPitch;

    public RotationProcessor(PlayerData data) {
        this.data = data;
    }

    public void handle(WrappedPacketInFlying wrappedPacketInFlying) {
        lastYaw = yaw;
        lastPitch = pitch;

        yaw = wrappedPacketInFlying.getYaw();
        pitch = wrappedPacketInFlying.getPitch();

        lastDeltaYaw = deltaYaw;
        lastDeltaPitch = deltaPitch;

        deltaYaw = Math.abs(yaw - lastYaw) % 360.0f;
        deltaPitch = Math.abs(pitch - lastPitch);
    }
}
