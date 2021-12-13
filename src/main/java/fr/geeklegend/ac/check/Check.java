package fr.geeklegend.ac.check;

import fr.geeklegend.ac.AntiCheat;
import fr.geeklegend.ac.data.PlayerData;
import fr.geeklegend.ac.packet.Packet;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;

public abstract class Check {
    public final PlayerData data;

    public double buffer;
    private final String name;
    private final CheckType type;
    private int vl;
    private final int maxVl;
    private final boolean experimental;

    public Check(PlayerData data, String name, CheckType type, int maxVl, boolean experimental) {
        this.data = data;
        this.name = name;
        this.type = type;
        this.maxVl = maxVl;
        this.experimental = experimental;
    }

    public abstract void handle(Packet packet);

    protected void flag(PlayerData data) {
        if (data.getPlayer().getAllowFlight()
                || data.getPlayer().getGameMode().equals(GameMode.SURVIVAL)
                || data.getPlayer().getGameMode().equals(GameMode.CREATIVE)) return;

        TextComponent toSendExp = new TextComponent(ChatColor.translateAlternateColorCodes('&', AntiCheat.getInstance().getConfig()
                .getString("anticheat.alert-message").replaceAll("%player%", data.getPlayer().getName()).
                replaceAll("%check%", this.name).replaceAll("%type%", type.getName()).
                replaceAll("%exp%", "&7(Experimental)").replaceAll("%vl%",
                        String.valueOf(vl)).replaceAll("%maxVl%", String.valueOf(maxVl))));

        TextComponent toSend = new TextComponent(ChatColor.translateAlternateColorCodes('&', AntiCheat.getInstance().getConfig()
                .getString("anticheat.alert-message").replaceAll("%player%", data.getPlayer().getName()).
                replaceAll("%check%", this.name).replaceAll("%type%", type.getName()).
                replaceAll("%exp%", "").replaceAll("%vl%",
                        String.valueOf(vl)).replaceAll("%maxVl%", String.valueOf(maxVl))));

        toSend.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatColor.
                translateAlternateColorCodes('&', "&8[&c&lAnti-Cheat&8]\n&cExperimental:&7 " + experimental + "\n&cmaxVl: &7" + maxVl +
                        "\n\n&cClick to teleport")).create()));
        toSendExp.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatColor.
                translateAlternateColorCodes('&', "&8[&c&lAnti-Cheat&8]\n&cExperimental:&7 " + experimental + "\n&cmaxVl: &7" + maxVl +
                        "\n\n&cClick to teleport")).create()));
        toSend.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "tp " + data.getPlayer().getName()));
        toSendExp.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tp " + data.getPlayer().getName()));

        Bukkit.getOnlinePlayers().stream().filter(online -> online.isOp() || online.hasPermission("anticheat.alerts"))
                .forEach(online -> {
                    if (experimental) online.spigot().sendMessage(toSendExp);
                    else online.spigot().sendMessage(toSend);
                });

        vl++;

        if (vl >= maxVl) punish(data);
    }

    private void punish(PlayerData data) {
        String toDispatch = ChatColor.translateAlternateColorCodes('&', AntiCheat.getInstance().
                getConfig().getString("anticheat.punish-command").replaceAll("%player%", data.getPlayer().getName()));
       // Bukkit.getScheduler().runTask(AntiCheat.getInstance(), () -> Bukkit.dispatchCommand(
       //         Bukkit.getConsoleSender(), toDispatch));
        data.getPlayer().getWorld().strikeLightningEffect(data.getPlayer().getLocation());
        vl = 0;
    }

    public PlayerData getData() {
        return data;
    }

    public double getBuffer() {
        return buffer;
    }

    public String getName() {
        return name;
    }

    public CheckType getType() {
        return type;
    }

    public int getVl() {
        return vl;
    }

    public int getMaxVl() {
        return maxVl;
    }

    public boolean isExperimental() {
        return experimental;
    }
}