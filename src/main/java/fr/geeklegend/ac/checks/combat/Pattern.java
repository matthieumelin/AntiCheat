package fr.geeklegend.ac.checks.combat;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.EnumWrappers;
import fr.geeklegend.ac.AC;
import fr.geeklegend.ac.checks.Check;
import fr.geeklegend.ac.checks.CheckType;
import fr.geeklegend.ac.data.DataPlayer;
import fr.geeklegend.ac.utilities.MathUtils;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Collections;
import java.util.Optional;

public class Pattern extends Check {
    public Pattern(String name, CheckType checkType, boolean enabled, boolean punishable, int max) {
        super(name, checkType, enabled, punishable, max);

        ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapter(AC.getInstance(), PacketType.Play.Client.USE_ENTITY) {
            @Override
            public void onPacketReceiving(PacketEvent event) {
                Optional<Entity> entityOp = event.getPlayer().getWorld().getEntities().stream().filter(entity -> entity.getEntityId() == event.getPacket().getIntegers().read(0)).findFirst();

                if (entityOp.isPresent()) {
                    Entity entity = entityOp.get();

                    EnumWrappers.EntityUseAction action = event.getPacket().getEntityUseActions().read(0);

                    if (action.equals(EnumWrappers.EntityUseAction.ATTACK) && entity instanceof LivingEntity) {
                        DataPlayer dataPlayer = AC.getInstance().getDataManager().getDataPlayer(event.getPlayer());

                        if (dataPlayer != null) {
                            dataPlayer.setLastAttack(System.currentTimeMillis());
                            dataPlayer.setLastHitEntity((LivingEntity) entity);
                        }
                    }
                }
            }
        });
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        DataPlayer dataPlayer = AC.getInstance().getDataManager().getDataPlayer(event.getPlayer());

        if (dataPlayer == null || dataPlayer.getLastHitEntity() == null || (System.currentTimeMillis() - dataPlayer.getLastAttack() > 350L))
            return;

        float offset = MathUtils.yawTo180F((float) MathUtils.getOffsetFromEntity(event.getPlayer(), dataPlayer.getLastHitEntity())[0]);

        if (dataPlayer.getPatterns().size() >= 10) {
            Collections.sort(dataPlayer.getPatterns());

            float range = Math.abs(dataPlayer.getPatterns().get(dataPlayer.getPatterns().size() - 1) - dataPlayer.getPatterns().get(0));

            if (Math.abs(range - dataPlayer.getLastRange()) < 4) {
                flag(event.getPlayer(), Math.abs(range - dataPlayer.getLastRange()) + "<-2");
            }
            dataPlayer.setLastRange(range);
            dataPlayer.getPatterns().clear();
        } else {
            dataPlayer.getPatterns().add(offset);
        }
    }
}
