package com.grok.apexclient.modules;

import com.grok.apexclient.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.Vec3d;

public class Speed extends Module {

    private float multiplier = 2.0f;

    public Speed() {
        super("Speed");
    }

    @Override
    public void onUpdate(MinecraftClient mc) {
        if (mc.player == null || !mc.player.isSprinting()) return;

        Vec3d velocity = mc.player.getVelocity();
        double forward = mc.player.forwardSpeed;
        double strafe = mc.player.sidewaysSpeed;

        float yaw = mc.player.getYaw();

        if (forward == 0 && strafe == 0) {
            mc.player.setVelocity(0, velocity.y, 0);
        } else {
            if (forward != 0) {
                if (strafe > 0) {
                    yaw += (forward > 0 ? -45 : 45);
                } else if (strafe < 0) {
                    yaw += (forward > 0 ? 45 : -45);
                }
                strafe = 0;
                if (forward > 0) {
                    forward = 1;
                } else if (forward < 0) {
                    forward = -1;
                }
            }

            double x = forward * Math.cos(Math.toRadians(yaw + 90)) + strafe * Math.sin(Math.toRadians(yaw + 90));
            double z = forward * Math.sin(Math.toRadians(yaw + 90)) - strafe * Math.cos(Math.toRadians(yaw + 90));

            mc.player.setVelocity(x * multiplier * 0.3, velocity.y, z * multiplier * 0.3);
        }
    }

    public float getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(float multiplier) {
        this.multiplier = multiplier;
    }
}
