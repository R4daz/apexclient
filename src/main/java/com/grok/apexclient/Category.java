package com.grok.apexclient;

public enum Category {
    MOVEMENT("Movement"),
    COMBAT("Combat"),
    RENDER("Render"),
    WORLD("World"),
    MISC("Misc");

    private final String name;

    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
