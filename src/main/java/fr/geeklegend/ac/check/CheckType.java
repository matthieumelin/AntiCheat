package fr.geeklegend.ac.check;

import java.util.Arrays;
import java.util.Objects;

public enum CheckType {
    COMBAT("Combat"),
    MOVEMENT("Movement"),
    PLAYER("Player");

    private final String name;

    CheckType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static CheckType fromPackageName(String packageName) {
       return Objects.requireNonNull(Arrays.stream(CheckType.values()).filter(checkType -> packageName.contains(checkType.getName().toLowerCase())).findFirst().orElse(null));
    }
}
