package fr.geeklegend.ac.processors;

import fr.geeklegend.ac.data.PlayerData;
import io.github.retrooper.packetevents.packetwrappers.play.in.entityaction.WrappedPacketInEntityAction;

public class ActionProcessor {
    private final PlayerData data;

    private boolean isSprinting;

    public ActionProcessor(final PlayerData data) {
        this.data = data;
    }

    public void handle(WrappedPacketInEntityAction wrappedPacketInEntityAction) {
        switch (wrappedPacketInEntityAction.getAction()) {
            case START_SPRINTING:
                isSprinting = true;
                break;
            case STOP_SPRINTING:
                isSprinting = false;
                break;
        }
    }

    public boolean isSprinting() {
        return isSprinting;
    }
}
