package com.grok.apexclient.modules;

import com.grok.apexclient.Module;
import net.minecraft.client.MinecraftClient;

public class Fullbright extends Module {

    private double oldGamma = -1;

    public Fullbright() {
        super("Fullbright");
    }

    @Override
    public void onEnable() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.options != null) {
            oldGamma = mc.options.getGamma().getValue();
            mc.options.getGamma().setValue(16.0);
        }
    }

    @Override
    public void onDisable() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.options != null && oldGamma != -1) {
            mc.options.getGamma().setValue(oldGamma);
            oldGamma = -1;
        }
    }
}
