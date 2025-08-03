package com.elementuhc;

public enum RoleType {
    Hydrogene("Hydrogène"), // - implementer les rôles comme ça
    Helium("Hélium"),
    Azote("Azote"),
    Oxygene("Oxygène"),
    Fluor("Fluor"),
    Neon("Néon"),
    Chlore("Chlore"),
    Argon("Argon"),
    Krypton("Krypton"),
    Xenon("Xénon"),
    Radon("Radon"),
    Carbone("Carbone"),
    Phosphore("Phosphore"),
    Soufre("Soufre"),
    Selenium("Sélénium"),
    Iode("Idoe"),
    Brome("Brome"),
    Astate("Astate"),
    Bore("Bore"),
    Silicium("Silicium"),
    Germanium("Germanium"),
    Arsenic("Arsenic"),
    Antimoine("Anitmoine"),
    Tellure("Tellure"),
    Polonium("Polonium"),
    Oganesson("Oganesson");


    private final String name;

    RoleType(String name) {
        this.name = name;
    }

    public String getName() {return name;}

}
