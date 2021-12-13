package fr.geeklegend.ac.listeners.packet;

import fr.geeklegend.ac.AntiCheat;
import fr.geeklegend.ac.data.PlayerData;
import fr.geeklegend.ac.packet.Packet;
import io.github.retrooper.packetevents.event.PacketListenerAbstract;
import io.github.retrooper.packetevents.event.impl.PacketPlayReceiveEvent;
import io.github.retrooper.packetevents.packettype.PacketType;
import io.github.retrooper.packetevents.packetwrappers.play.in.entityaction.WrappedPacketInEntityAction;
import io.github.retrooper.packetevents.packetwrappers.play.in.flying.WrappedPacketInFlying;
import io.github.retrooper.packetevents.packetwrappers.play.in.useentity.WrappedPacketInUseEntity;

public class PacketListener extends PacketListenerAbstract {
    @Override
    public void onPacketPlayReceive(PacketPlayReceiveEvent event) {
        final PlayerData data = AntiCheat.getInstance().getPlayerDataManager().get(event.getPlayer());

        if (data == null) return;

        if (PacketType.Play.Client.Util.isInstanceOfFlying(event.getPacketId())) {
            final WrappedPacketInFlying wrapped = new WrappedPacketInFlying(event.getNMSPacket());
            data.getRotationProcessor().handle(wrapped);
            data.getMovementProcessor().handle(wrapped);
        } else if (event.getPacketId() == PacketType.Play.Client.USE_ENTITY) {
            final WrappedPacketInUseEntity wrappedPacketInUseEntity = new WrappedPacketInUseEntity(event.getNMSPacket());
            data.getCombatProcessor().handle(wrappedPacketInUseEntity);
        } else if (event.getPacketId() == PacketType.Play.Client.ENTITY_ACTION) {
            final WrappedPacketInEntityAction wrapper = new WrappedPacketInEntityAction(event.getNMSPacket());
            data.getActionProcessor().handle(wrapper);
        }

        data.getCheckManager().getChecks().forEach(check -> check.handle(new Packet(Packet.Direction.RECEIVE, event.getNMSPacket(), event.getPacketId())));
    }
}
