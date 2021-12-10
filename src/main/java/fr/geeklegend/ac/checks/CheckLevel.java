package fr.geeklegend.ac.checks;

import org.bukkit.ChatColor;

public enum CheckLevel {
    DEFINITELY("Definite", ChatColor.DARK_RED),
    PROBABLY("Probably", ChatColor.GOLD),
    PASSED("Passed", ChatColor.GREEN);

    private String name;
    private ChatColor nameColor;

    CheckLevel(String name, ChatColor nameColor) {
        this.name = name;
        this.nameColor = nameColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ChatColor getNameColor() {
        return nameColor;
    }

    public void setNameColor(ChatColor nameColor) {
        this.nameColor = nameColor;
    }
}
