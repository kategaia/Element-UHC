package com.elementuhc;

public enum RoleType {
    Hydrogene("Hydrogène", "premier élément du tableau périodique"); // - implementer les rôles comme ça

    private final String name;
    private final String description;

    RoleType(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {return name;}

    public String getDescription() {return description;}
}
