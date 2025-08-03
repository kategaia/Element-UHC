package com.elementuhc;

public class Role {

    private RoleType type;

    public Role(RoleType type) {
        this.type = type;
    }

    public String getName() {
        return type.getName();
    }

    public RoleType getType() {
        return type;
    }



}
