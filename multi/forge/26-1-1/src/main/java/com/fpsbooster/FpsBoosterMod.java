package com.fpsbooster;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(FpsBoosterMod.MODID)
public final class FpsBoosterMod {
    public static final String MODID = "fpsbooster";
    public static final Logger LOGGER = LogUtils.getLogger();

    public FpsBoosterMod(FMLJavaModLoadingContext context) {
        context.registerConfig(ModConfig.Type.CLIENT, Config.SPEC);
        FpsBoosterEvents.register();
        LOGGER.info("FPS Booster loaded (Forge, client-only) — event handlers registered");
    }
}
