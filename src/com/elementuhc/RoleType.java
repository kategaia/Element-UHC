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
    Oganesson("Oganesson"),
    Lithium("Lithium"),
    Beryllium("Béryllium"),
    Sodium("Sodium"),
    Magnesium("Magnésium"),
    Aluminium("Aluminium"),
    Potassium("Potassium"),
    Calcium("Calcium"),
    Scandium("Scandium"),
    Titane("Titane"),
    Vanadium("Vanadium"),
    Chrome("Chrome"),
    Manganese("Manganèse"),
    Zinc("Zinc"),
    Galium("Galium"),
    Strontium("Strontium"),
    Yttrium("YUttrium"),
    Zirconium("Zirconium"),
    Niobium("Niobium"),
    Molybdene("Molybdène"),
    Ruthenium("Ruthénium"),
    Rhodium("Rhodium"),
    Palladium("Palladium"),
    Cadium("Cadium"),
    Indium("Indium"),
    Etain("Étain"),
    Thallium("Thallium"),
    Baryum("Baryum");

    private final String name;

    RoleType(String name) {
        this.name = name;
    }

    public String getName() {return name;}

}
