package com.fpsbooster;

import com.fpsbooster.util.Culling;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.event.RenderLivingEvent;

public final class FpsBoosterEvents {
    private FpsBoosterEvents() {}

    public static void register() {
        RenderLivingEvent.Pre.BUS.addListener(FpsBoosterEvents::shouldCull);
    }

    private static boolean shouldCull(RenderLivingEvent.Pre<?, ?, ?> event) {
        if (!Config.on(Config.CULL_ENTITIES)) return false;
        EntityRenderState state = event.getState();
        if (state.entityType == EntityType.PLAYER) return false;
        Vec3 center = new Vec3(state.x, state.y + state.boundingBoxHeight * 0.5, state.z);
        return Culling.behindWalls(center);
    }
}
