package com.example.testmod.item;

import com.example.testmod.TestMod;
import com.example.testmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MODID);

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TestMod.MODID);

    public static final RegistryObject<Item> SUPREME_GOLD_INGOT =
            ITEMS.register("supreme_gold_ingot", () -> new Item(new Item.Properties()));

    // Ultimate Iron Ingot - standalone item using the desktop-sourced texture.
    public static final RegistryObject<Item> ULTIMATE_IRON_INGOT =
            ITEMS.register("ultimate_iron_ingot", () -> new Item(new Item.Properties()));

    // Eternal Diamond - gem item from the desktop-sourced texture.
    public static final RegistryObject<Item> ETERNAL_DIAMOND =
            ITEMS.register("eternal_diamond", () -> new Item(new Item.Properties()));

    // Eternal Diamond armor - netherite stats, zero durability (unbreakable).
    public static final RegistryObject<Item> ETERNAL_DIAMOND_HELMET =
            ITEMS.register("eternal_diamond_helmet",
                    () -> new ArmorItem(EternalDiamondArmorMaterial.ETERNAL_DIAMOND, ArmorItem.Type.HELMET,
                            new Item.Properties()));
    public static final RegistryObject<Item> ETERNAL_DIAMOND_CHESTPLATE =
            ITEMS.register("eternal_diamond_chestplate",
                    () -> new ArmorItem(EternalDiamondArmorMaterial.ETERNAL_DIAMOND, ArmorItem.Type.CHESTPLATE,
                            new Item.Properties()));
    public static final RegistryObject<Item> ETERNAL_DIAMOND_LEGGINGS =
            ITEMS.register("eternal_diamond_leggings",
                    () -> new ArmorItem(EternalDiamondArmorMaterial.ETERNAL_DIAMOND, ArmorItem.Type.LEGGINGS,
                            new Item.Properties()));
    public static final RegistryObject<Item> ETERNAL_DIAMOND_BOOTS =
            ITEMS.register("eternal_diamond_boots",
                    () -> new ArmorItem(EternalDiamondArmorMaterial.ETERNAL_DIAMOND, ArmorItem.Type.BOOTS,
                            new Item.Properties()));

    // Eternal Diamond tools - netherite attack damage/speed, zero durability
    // (unbreakable) via EternalDiamondToolTier.
    public static final RegistryObject<Item> ETERNAL_DIAMOND_SWORD =
            ITEMS.register("eternal_diamond_sword",
                    () -> new SwordItem(EternalDiamondToolTier.ETERNAL_DIAMOND, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> ETERNAL_DIAMOND_PICKAXE =
            ITEMS.register("eternal_diamond_pickaxe",
                    () -> new PickaxeItem(EternalDiamondToolTier.ETERNAL_DIAMOND, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> ETERNAL_DIAMOND_AXE =
            ITEMS.register("eternal_diamond_axe",
                    () -> new AxeItem(EternalDiamondToolTier.ETERNAL_DIAMOND, 5.0F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> ETERNAL_DIAMOND_SHOVEL =
            ITEMS.register("eternal_diamond_shovel",
                    () -> new ShovelItem(EternalDiamondToolTier.ETERNAL_DIAMOND, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> ETERNAL_DIAMOND_HOE =
            ITEMS.register("eternal_diamond_hoe",
                    () -> new HoeItem(EternalDiamondToolTier.ETERNAL_DIAMOND, -4, 0.0F, new Item.Properties()));

    // Ultimate Iron armor - vanilla iron stats, repaired with ultimate iron ingot.
    public static final RegistryObject<Item> ULTIMATE_IRON_HELMET =
            ITEMS.register("ultimate_iron_helmet",
                    () -> new ArmorItem(SupremeIronArmorMaterial.SUPREME_IRON, ArmorItem.Type.HELMET,
                            new Item.Properties()));
    public static final RegistryObject<Item> ULTIMATE_IRON_CHESTPLATE =
            ITEMS.register("ultimate_iron_chestplate",
                    () -> new ArmorItem(SupremeIronArmorMaterial.SUPREME_IRON, ArmorItem.Type.CHESTPLATE,
                            new Item.Properties()));
    public static final RegistryObject<Item> ULTIMATE_IRON_LEGGINGS =
            ITEMS.register("ultimate_iron_leggings",
                    () -> new ArmorItem(SupremeIronArmorMaterial.SUPREME_IRON, ArmorItem.Type.LEGGINGS,
                            new Item.Properties()));
    public static final RegistryObject<Item> ULTIMATE_IRON_BOOTS =
            ITEMS.register("ultimate_iron_boots",
                    () -> new ArmorItem(SupremeIronArmorMaterial.SUPREME_IRON, ArmorItem.Type.BOOTS,
                            new Item.Properties()));

    // Ultimate Iron tools - vanilla diamond tier, vanilla diamond attack
    // damage/speed values (diamond-tier performance by design).
    public static final RegistryObject<Item> ULTIMATE_IRON_SWORD =
            ITEMS.register("ultimate_iron_sword",
                    () -> new SwordItem(Tiers.DIAMOND, 2, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> ULTIMATE_IRON_PICKAXE =
            ITEMS.register("ultimate_iron_pickaxe",
                    () -> new PickaxeItem(Tiers.DIAMOND, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> ULTIMATE_IRON_AXE =
            ITEMS.register("ultimate_iron_axe",
                    () -> new AxeItem(Tiers.DIAMOND, 5.0F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> ULTIMATE_IRON_SHOVEL =
            ITEMS.register("ultimate_iron_shovel",
                    () -> new ShovelItem(Tiers.DIAMOND, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> ULTIMATE_IRON_HOE =
            ITEMS.register("ultimate_iron_hoe",
                    () -> new HoeItem(Tiers.DIAMOND, -2, 0.0F, new Item.Properties()));

    // Supreme Gold armor - netherite-equivalent stats, repaired with supreme gold ingot.
    public static final RegistryObject<Item> SUPREME_GOLD_HELMET =
            ITEMS.register("supreme_gold_helmet",
                    () -> new ArmorItem(SupremeGoldArmorMaterial.SUPREME_GOLD, ArmorItem.Type.HELMET,
                            new Item.Properties()));
    public static final RegistryObject<Item> SUPREME_GOLD_CHESTPLATE =
            ITEMS.register("supreme_gold_chestplate",
                    () -> new ArmorItem(SupremeGoldArmorMaterial.SUPREME_GOLD, ArmorItem.Type.CHESTPLATE,
                            new Item.Properties()));
    public static final RegistryObject<Item> SUPREME_GOLD_LEGGINGS =
            ITEMS.register("supreme_gold_leggings",
                    () -> new ArmorItem(SupremeGoldArmorMaterial.SUPREME_GOLD, ArmorItem.Type.LEGGINGS,
                            new Item.Properties()));
    public static final RegistryObject<Item> SUPREME_GOLD_BOOTS =
            ITEMS.register("supreme_gold_boots",
                    () -> new ArmorItem(SupremeGoldArmorMaterial.SUPREME_GOLD, ArmorItem.Type.BOOTS,
                            new Item.Properties()));

    // Supreme Gold tools - netherite attack damage/speed, but durability is
    // one third of netherite (677) via SupremeGoldToolTier: the 3x3 excavation
    // costs real durability, so the tools wear down fast.
    public static final RegistryObject<Item> SUPREME_GOLD_SWORD =
            ITEMS.register("supreme_gold_sword",
                    () -> new SwordItem(SupremeGoldToolTier.SUPREME_GOLD, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> SUPREME_GOLD_PICKAXE =
            ITEMS.register("supreme_gold_pickaxe",
                    () -> new PickaxeItem(SupremeGoldToolTier.SUPREME_GOLD, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> SUPREME_GOLD_AXE =
            ITEMS.register("supreme_gold_axe",
                    () -> new AxeItem(SupremeGoldToolTier.SUPREME_GOLD, 5.0F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> SUPREME_GOLD_SHOVEL =
            ITEMS.register("supreme_gold_shovel",
                    () -> new ShovelItem(SupremeGoldToolTier.SUPREME_GOLD, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> SUPREME_GOLD_HOE =
            ITEMS.register("supreme_gold_hoe",
                    () -> new HoeItem(SupremeGoldToolTier.SUPREME_GOLD, -4, 0.0F, new Item.Properties()));

    public static final RegistryObject<CreativeModeTab> TEST_TAB =
            CREATIVE_TABS.register("test_tab", () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
                    .title(Component.translatable("itemGroup.supreme_gold"))
                    .icon(() -> new ItemStack(SUPREME_GOLD_INGOT.get()))
                    .displayItems((params, output) -> {
                        output.accept(SUPREME_GOLD_INGOT.get());
                        output.accept(ULTIMATE_IRON_INGOT.get());
                        output.accept(ETERNAL_DIAMOND.get());
                        output.accept(ModBlocks.ETERNAL_DIAMOND_ORE_ITEM.get());
                        output.accept(ETERNAL_DIAMOND_HELMET.get());
                        output.accept(ETERNAL_DIAMOND_CHESTPLATE.get());
                        output.accept(ETERNAL_DIAMOND_LEGGINGS.get());
                        output.accept(ETERNAL_DIAMOND_BOOTS.get());
                        output.accept(ETERNAL_DIAMOND_SWORD.get());
                        output.accept(ETERNAL_DIAMOND_PICKAXE.get());
                        output.accept(ETERNAL_DIAMOND_AXE.get());
                        output.accept(ETERNAL_DIAMOND_SHOVEL.get());
                        output.accept(ETERNAL_DIAMOND_HOE.get());
                        output.accept(ModBlocks.ULTIMATE_IRON_ORE_ITEM.get());
                        output.accept(ModBlocks.DEEPSLATE_ULTIMATE_IRON_ORE_ITEM.get());
                        output.accept(ModBlocks.ULTIMATE_IRON_BLOCK_ITEM.get());
                        output.accept(ModBlocks.SUPREME_GOLD_ORE_ITEM.get());
                        output.accept(ModBlocks.DEEPSLATE_SUPREME_GOLD_ORE_ITEM.get());
                        output.accept(ModBlocks.SUPREME_GOLD_BLOCK_ITEM.get());
                        output.accept(ULTIMATE_IRON_HELMET.get());
                        output.accept(ULTIMATE_IRON_CHESTPLATE.get());
                        output.accept(ULTIMATE_IRON_LEGGINGS.get());
                        output.accept(ULTIMATE_IRON_BOOTS.get());
                        output.accept(ULTIMATE_IRON_SWORD.get());
                        output.accept(ULTIMATE_IRON_PICKAXE.get());
                        output.accept(ULTIMATE_IRON_AXE.get());
                        output.accept(ULTIMATE_IRON_SHOVEL.get());
                        output.accept(ULTIMATE_IRON_HOE.get());
                        output.accept(SUPREME_GOLD_HELMET.get());
                        output.accept(SUPREME_GOLD_CHESTPLATE.get());
                        output.accept(SUPREME_GOLD_LEGGINGS.get());
                        output.accept(SUPREME_GOLD_BOOTS.get());
                        output.accept(SUPREME_GOLD_SWORD.get());
                        output.accept(SUPREME_GOLD_PICKAXE.get());
                        output.accept(SUPREME_GOLD_AXE.get());
                        output.accept(SUPREME_GOLD_SHOVEL.get());
                        output.accept(SUPREME_GOLD_HOE.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        CREATIVE_TABS.register(eventBus);
    }
}
