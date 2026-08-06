package com.example.testmod.block;

import com.example.testmod.TestMod;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TestMod.MODID);

    public static final DeferredRegister<Item> BLOCK_ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MODID);

    // Ores: properties copied from vanilla diamond ore / deepslate diamond ore,
    // so mining behavior (hardness, iron pickaxe requirement) matches diamond.
    public static final RegistryObject<Block> SUPREME_GOLD_ORE =
            BLOCKS.register("supreme_gold_ore",
                    () -> new DropExperienceBlock(
                            BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE), UniformInt.of(3, 7)));

    public static final RegistryObject<Block> DEEPSLATE_SUPREME_GOLD_ORE =
            BLOCKS.register("deepslate_supreme_gold_ore",
                    () -> new DropExperienceBlock(
                            BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE), UniformInt.of(3, 7)));

    public static final RegistryObject<Item> SUPREME_GOLD_ORE_ITEM =
            BLOCK_ITEMS.register("supreme_gold_ore",
                    () -> new BlockItem(SUPREME_GOLD_ORE.get(), new Item.Properties()));

    public static final RegistryObject<Item> DEEPSLATE_SUPREME_GOLD_ORE_ITEM =
            BLOCK_ITEMS.register("deepslate_supreme_gold_ore",
                    () -> new BlockItem(DEEPSLATE_SUPREME_GOLD_ORE.get(), new Item.Properties()));

    // Supreme gold block: properties copied from vanilla gold block.
    public static final RegistryObject<Block> SUPREME_GOLD_BLOCK =
            BLOCKS.register("supreme_gold_block",
                    () -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK)));

    public static final RegistryObject<Item> SUPREME_GOLD_BLOCK_ITEM =
            BLOCK_ITEMS.register("supreme_gold_block",
                    () -> new BlockItem(SUPREME_GOLD_BLOCK.get(), new Item.Properties()));

    // Ultimate iron ore: properties copied from vanilla iron ore / deepslate
    // iron ore (stone-pickaxe minable, drops the ultimate iron ingot via loot
    // table, silk-touch yields the block itself). Unlike vanilla iron ore (which
    // drops raw iron and gives no xp), this drops the finished ingot, so it
    // gives xp like diamond/emerald ore (3-7).
    public static final RegistryObject<Block> ULTIMATE_IRON_ORE =
            BLOCKS.register("ultimate_iron_ore",
                    () -> new DropExperienceBlock(
                            BlockBehaviour.Properties.copy(Blocks.IRON_ORE), UniformInt.of(3, 7)));

    public static final RegistryObject<Block> DEEPSLATE_ULTIMATE_IRON_ORE =
            BLOCKS.register("deepslate_ultimate_iron_ore",
                    () -> new DropExperienceBlock(
                            BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE), UniformInt.of(3, 7)));

    public static final RegistryObject<Item> ULTIMATE_IRON_ORE_ITEM =
            BLOCK_ITEMS.register("ultimate_iron_ore",
                    () -> new BlockItem(ULTIMATE_IRON_ORE.get(), new Item.Properties()));

    public static final RegistryObject<Item> DEEPSLATE_ULTIMATE_IRON_ORE_ITEM =
            BLOCK_ITEMS.register("deepslate_ultimate_iron_ore",
                    () -> new BlockItem(DEEPSLATE_ULTIMATE_IRON_ORE.get(), new Item.Properties()));

    // Ultimate iron block: properties copied from vanilla iron block
    // (hardness 5, blast resistance 6, metal sound), stone-pickaxe minable.
    public static final RegistryObject<Block> ULTIMATE_IRON_BLOCK =
            BLOCKS.register("ultimate_iron_block",
                    () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Item> ULTIMATE_IRON_BLOCK_ITEM =
            BLOCK_ITEMS.register("ultimate_iron_block",
                    () -> new BlockItem(ULTIMATE_IRON_BLOCK.get(), new Item.Properties()));

    // Eternal diamond ore: properties copied from vanilla ancient debris
    // (hardness 30, blast resistance 1200 - not blast-breakable, diamond
    // pickaxe required). Drops the eternal diamond via loot table.
    public static final RegistryObject<Block> ETERNAL_DIAMOND_ORE =
            BLOCKS.register("eternal_diamond_ore",
                    () -> new Block(BlockBehaviour.Properties.copy(Blocks.ANCIENT_DEBRIS)));

    public static final RegistryObject<Item> ETERNAL_DIAMOND_ORE_ITEM =
            BLOCK_ITEMS.register("eternal_diamond_ore",
                    () -> new BlockItem(ETERNAL_DIAMOND_ORE.get(), new Item.Properties()));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        BLOCK_ITEMS.register(eventBus);
    }
}
