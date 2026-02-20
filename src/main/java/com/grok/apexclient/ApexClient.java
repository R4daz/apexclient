package com.grok.apexclient;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class ApexClient implements ClientModInitializer {

    public static KeyBinding openMenuKey;

    @Override
    public void onInitializeClient() {
        // Register keybind (example: Right Shift)
        openMenuKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.apexclient.menu",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_RIGHT_SHIFT,
            "category.apexclient"
        ));

        // Tick event example
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (openMenuKey.wasPressed()) {
                // TODO: open click gui here later
                if (client.player != null) {
                    client.player.sendMessage(net.minecraft.text.Text.literal("Menu would open here"), false);
                }
            }
        });
    }
}
