package fr.geeklegend.ac.check.impl.movement.nofall;

import fr.geeklegend.ac.check.Check;
import fr.geeklegend.ac.check.CheckType;
import fr.geeklegend.ac.data.PlayerData;
import fr.geeklegend.ac.packet.Packet;

public class NoFallA extends Check {
    public NoFallA(PlayerData data, String name, CheckType type, int maxVl, boolean experimental) {
        super(data, name, type, maxVl, experimental);
    }

    @Override
    public void handle(Packet packet) {
    }
}
