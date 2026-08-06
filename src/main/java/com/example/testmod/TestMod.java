package com.example.testmod;

import com.example.testmod.block.ModBlocks;
import com.example.testmod.event.ModEvents;
import com.example.testmod.fluid.ModFluids;
import com.example.testmod.item.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

@Mod(TestMod.MODID)
public class TestMod {
    public static final String MODID = "supreme_gold";
    private static final Logger LOGGER = LogUtils.getLogger();

    public TestMod(IEventBus modEventBus) {
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModFluids.register(modEventBus);
        // Register the 3x3 excavation handler on the Forge event bus. This is done
        // manually rather than via @Mod.EventBusSubscriber because this project's
        // build doesn't configure the eventbus annotation processor, so the
        // generated META-INF/eventbus-subscribers.js would never be created and
        // the handler would silently never fire.
        MinecraftForge.EVENT_BUS.register(ModEvents.class);
        LOGGER.info("Test Mod loading! MODID={}", MODID);
    }
}
