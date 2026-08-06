package com.example.testmod.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

/**
 * "Supreme Gold" armor material - identical stats to netherite except
 * durability is one third (durability multiplier 12 vs netherite's 37,
 * defense 3/8/6/3, toughness 3.0, knockback resistance 0.1, enchantment
 * value 15), repaired with the mod's own supreme gold ingot. Layer textures
 * live at assets/minecraft/textures/models/armor/supreme_gold_layer_{1,2}.png
 * - the {@code minecraft} namespace is required: 1.20.1 builds the armor layer
 * path from the material name with the default namespace, so mod-namespaced
 * textures would never be found.
 */
public enum SupremeGoldArmorMaterial implements ArmorMaterial {
    SUPREME_GOLD("supreme_gold", 12, new int[]{3, 8, 6, 3}, 15,
            SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F,
            () -> Ingredient.of(ModItems.SUPREME_GOLD_INGOT.get()));

    // Durability per slot (helmet, chestplate, leggings, boots) - vanilla base values.
    private static final int[] BASE_DURABILITY = {11, 16, 15, 13};

    private final String name;
    private final int durabilityMultiplier;
    private final int[] protection;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    SupremeGoldArmorMaterial(String name, int durabilityMultiplier, int[] protection,
                             int enchantmentValue, SoundEvent equipSound, float toughness,
                             float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protection = protection;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return BASE_DURABILITY[type.getSlot().getIndex()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return this.protection[type.getSlot().getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
