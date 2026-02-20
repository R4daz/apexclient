package com.grok.apexclient;

import net.minecraft.client.MinecraftClient;

public abstract class Module {

    protected final String name;
    protected boolean enabled = false;

    public Module(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void toggle() {
        enabled = !enabled;
        if (enabled) onEnable();
        else onDisable();
    }

    public void onEnable() {}
    public void onDisable() {}
    public void onUpdate(MinecraftClient mc) {}
}
