package com.grok.apexclient.screens;

import com.grok.apexclient.Module;
import com.grok.apexclient.ModuleManager;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ClickGuiScreen extends Screen {

    public ClickGuiScreen() {
        super(Text.literal("Apex Client - ClickGUI"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        // Dark background
        context.fill(0, 0, width, height, 0xD0111111);

        int y = 30;
        context.drawCenteredTextWithShadow(textRenderer, "Apex Client - Modules", width / 2, 10, 0xFFFFFF);

        for (Module module : ModuleManager.modules) {
            String status = module.isEnabled() ? "§aON" : "§cOFF";
            String line = module.getName() + " §7[ " + status + " §7]";

            context.drawTextWithShadow(textRenderer, line, 20, y, 0xFFFFFF);
            y += 14;
        }

        super.render(context, mouseX, mouseY, delta);
    }

    // Very basic toggle on click (you can improve this)
    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button != 0) return super.mouseClicked(mouseX, mouseY, button);

        int y = 30;
        for (Module module : ModuleManager.modules) {
            if (mouseY >= y && mouseY <= y + 12 && mouseX >= 20 && mouseX <= width - 20) {
                module.toggle();
                return true;
            }
            y += 14;
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }
}
