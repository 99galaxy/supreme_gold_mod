package com.example.testmod.fluid;

import com.example.testmod.TestMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Molten Supreme Gold - the smeltery fluid behind the Tinkers' Construct
 * integration. Source + flowing fluids, liquid block and bucket, plus the
 * {@code forge:molten_supreme_gold} tag referenced by the melting/casting
 * recipes in {@code data/supreme_gold/recipes/smeltery/}.
 *
 * <p>Registered manually in {@code TestMod}'s constructor like the other
 * deferred registers. Field order matters: the source/flowing fluids come
 * first so the block/bucket field initializers don't reference a field that
 * is not yet declared (illegal forward reference).
 */
public class ModFluids {
    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, TestMod.MODID);
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, TestMod.MODID);
    public static final DeferredRegister<Block> FLUID_BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TestMod.MODID);
    public static final DeferredRegister<Item> FLUID_ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MODID);

    public static final RegistryObject<FluidType> MOLTEN_SUPREME_GOLD_TYPE = FLUID_TYPES.register(
            "molten_supreme_gold",
            () -> new MoltenSupremeGoldFluidType(
                    FluidType.Properties.create()
                            .descriptionId("block.supreme_gold.molten_supreme_gold")
                            .density(2000)
                            .viscosity(10000)
                            .temperature(1250)
                            .lightLevel(12)
                            .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                            .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA),
                    new ResourceLocation(TestMod.MODID, "block/molten_supreme_gold_still"),
                    new ResourceLocation(TestMod.MODID, "block/molten_supreme_gold_flow")));

    public static final RegistryObject<ForgeFlowingFluid> MOLTEN_SUPREME_GOLD = FLUIDS.register(
            "molten_supreme_gold",
            () -> new ForgeFlowingFluid.Source(ModFluids.fluidProperties()));
    public static final RegistryObject<ForgeFlowingFluid> MOLTEN_SUPREME_GOLD_FLOWING = FLUIDS.register(
            "molten_supreme_gold_flowing",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.fluidProperties()));

    public static final RegistryObject<LiquidBlock> MOLTEN_SUPREME_GOLD_BLOCK = FLUID_BLOCKS.register(
            "molten_supreme_gold",
            () -> new LiquidBlock(MOLTEN_SUPREME_GOLD.get(),
                    BlockBehaviour.Properties.copy(Blocks.LAVA).lightLevel(s -> 12)));

    public static final RegistryObject<Item> MOLTEN_SUPREME_GOLD_BUCKET = FLUID_ITEMS.register(
            "molten_supreme_gold_bucket",
            () -> new BucketItem(MOLTEN_SUPREME_GOLD.get(),
                    new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));

    // Molten Ultimate Iron - same structure as the supreme gold fluid, tuned
    // for the diamond-tier metal: temperature 1100 (between iron's 800 and
    // netherite's 1250, so it still needs a blazeborn foundry).
    public static final RegistryObject<FluidType> MOLTEN_ULTIMATE_IRON_TYPE = FLUID_TYPES.register(
            "molten_ultimate_iron",
            () -> new MoltenSupremeGoldFluidType(
                    FluidType.Properties.create()
                            .descriptionId("block.supreme_gold.molten_ultimate_iron")
                            .density(2000)
                            .viscosity(10000)
                            .temperature(1100)
                            .lightLevel(12)
                            .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                            .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA),
                    new ResourceLocation(TestMod.MODID, "block/molten_ultimate_iron_still"),
                    new ResourceLocation(TestMod.MODID, "block/molten_ultimate_iron_flow")));

    public static final RegistryObject<ForgeFlowingFluid> MOLTEN_ULTIMATE_IRON = FLUIDS.register(
            "molten_ultimate_iron",
            () -> new ForgeFlowingFluid.Source(ModFluids.ultimateIronFluidProperties()));
    public static final RegistryObject<ForgeFlowingFluid> MOLTEN_ULTIMATE_IRON_FLOWING = FLUIDS.register(
            "molten_ultimate_iron_flowing",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.ultimateIronFluidProperties()));

    public static final RegistryObject<LiquidBlock> MOLTEN_ULTIMATE_IRON_BLOCK = FLUID_BLOCKS.register(
            "molten_ultimate_iron",
            () -> new LiquidBlock(MOLTEN_ULTIMATE_IRON.get(),
                    BlockBehaviour.Properties.copy(Blocks.LAVA).lightLevel(s -> 12)));

    public static final RegistryObject<Item> MOLTEN_ULTIMATE_IRON_BUCKET = FLUID_ITEMS.register(
            "molten_ultimate_iron_bucket",
            () -> new BucketItem(MOLTEN_ULTIMATE_IRON.get(),
                    new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));

    // Molten Eternal Diamond - gem fluid for the eternal-diamond material.
    // Temperature 1450 matches vanilla molten diamond (needs a blazing foundry
    // with the hottest burners). 100 mb per gem.
    public static final RegistryObject<FluidType> MOLTEN_ETERNAL_DIAMOND_TYPE = FLUID_TYPES.register(
            "molten_eternal_diamond",
            () -> new MoltenSupremeGoldFluidType(
                    FluidType.Properties.create()
                            .descriptionId("block.supreme_gold.molten_eternal_diamond")
                            .density(2000)
                            .viscosity(10000)
                            .temperature(1450)
                            .lightLevel(15)
                            .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                            .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA),
                    new ResourceLocation(TestMod.MODID, "block/molten_eternal_diamond_still"),
                    new ResourceLocation(TestMod.MODID, "block/molten_eternal_diamond_flow")));

    public static final RegistryObject<ForgeFlowingFluid> MOLTEN_ETERNAL_DIAMOND = FLUIDS.register(
            "molten_eternal_diamond",
            () -> new ForgeFlowingFluid.Source(ModFluids.eternalDiamondFluidProperties()));
    public static final RegistryObject<ForgeFlowingFluid> MOLTEN_ETERNAL_DIAMOND_FLOWING = FLUIDS.register(
            "molten_eternal_diamond_flowing",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.eternalDiamondFluidProperties()));

    public static final RegistryObject<LiquidBlock> MOLTEN_ETERNAL_DIAMOND_BLOCK = FLUID_BLOCKS.register(
            "molten_eternal_diamond",
            () -> new LiquidBlock(MOLTEN_ETERNAL_DIAMOND.get(),
                    BlockBehaviour.Properties.copy(Blocks.LAVA).lightLevel(s -> 15)));

    public static final RegistryObject<Item> MOLTEN_ETERNAL_DIAMOND_BUCKET = FLUID_ITEMS.register(
            "molten_eternal_diamond_bucket",
            () -> new BucketItem(MOLTEN_ETERNAL_DIAMOND.get(),
                    new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));

    private static ForgeFlowingFluid.Properties fluidProperties() {
        return new ForgeFlowingFluid.Properties(
                        MOLTEN_SUPREME_GOLD_TYPE, MOLTEN_SUPREME_GOLD, MOLTEN_SUPREME_GOLD_FLOWING)
                .block(MOLTEN_SUPREME_GOLD_BLOCK)
                .bucket(MOLTEN_SUPREME_GOLD_BUCKET)
                .levelDecreasePerBlock(1)
                .slopeFindDistance(3)
                .explosionResistance(100F);
    }

    private static ForgeFlowingFluid.Properties ultimateIronFluidProperties() {
        return new ForgeFlowingFluid.Properties(
                        MOLTEN_ULTIMATE_IRON_TYPE, MOLTEN_ULTIMATE_IRON, MOLTEN_ULTIMATE_IRON_FLOWING)
                .block(MOLTEN_ULTIMATE_IRON_BLOCK)
                .bucket(MOLTEN_ULTIMATE_IRON_BUCKET)
                .levelDecreasePerBlock(1)
                .slopeFindDistance(3)
                .explosionResistance(100F);
    }

    private static ForgeFlowingFluid.Properties eternalDiamondFluidProperties() {
        return new ForgeFlowingFluid.Properties(
                        MOLTEN_ETERNAL_DIAMOND_TYPE, MOLTEN_ETERNAL_DIAMOND, MOLTEN_ETERNAL_DIAMOND_FLOWING)
                .block(MOLTEN_ETERNAL_DIAMOND_BLOCK)
                .bucket(MOLTEN_ETERNAL_DIAMOND_BUCKET)
                .levelDecreasePerBlock(1)
                .slopeFindDistance(3)
                .explosionResistance(100F);
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
        FLUIDS.register(eventBus);
        FLUID_BLOCKS.register(eventBus);
        FLUID_ITEMS.register(eventBus);
    }
}
