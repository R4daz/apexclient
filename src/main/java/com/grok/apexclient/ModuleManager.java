package com.grok.apexclient;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {

    public static final List<Module> modules = new ArrayList<>();

    public static void init() {
        // Add your modules here later, example:
        // modules.add(new Fly());
    }

    public static void onUpdate() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player == null) return;

        for (Module module : modules) {
            if (module.isEnabled()) {
                module.onUpdate(mc);
            }
        }
    }

    public static Module getModuleByName(String name) {
        for (Module m : modules) {
            if (m.getName().equalsIgnoreCase(name)) {
                return m;
            }
        }
        return null;
    }
}
