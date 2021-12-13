package fr.geeklegend.ac.check.impl.movement.fly;

import fr.geeklegend.ac.check.Check;
import fr.geeklegend.ac.check.CheckType;
import fr.geeklegend.ac.data.PlayerData;
import fr.geeklegend.ac.packet.Packet;
import fr.geeklegend.ac.processors.MovementProcessor;
import org.bukkit.util.Vector;

public class FlyA extends Check {
    public FlyA(PlayerData data, String name, CheckType type, int maxVl, boolean experimental) {
        super(data, name, type, maxVl, experimental);
    }

    @Override
    public void handle(Packet packet) {
        if (packet.isFlying()) {
            MovementProcessor movementProcessor = data.getMovementProcessor();

            double prediction = Math.abs((movementProcessor.getLastDeltaY() - 0.08D) * 0.98F) < 0.005 ? 0 : (movementProcessor.getLastDeltaY() - 0.08D) * 0.98F;

            Vector predictionMove = new Vector(0, prediction, 0);
            Vector actualMove = new Vector(0, movementProcessor.getDeltaY(), 0);

            double distance = predictionMove.distance(actualMove);

            boolean midAir = movementProcessor.getAirTicks() > 12 && !movementProcessor.isOnGround();
            boolean exempt = movementProcessor.isInWeb();

            if (midAir && !exempt) {
                if (distance > 0.003D) {
                    if (++buffer > 3) {
                        flag(data);
                    }
                } else if (buffer > 0) buffer -= 0.1;
            }

        }
    }
}
