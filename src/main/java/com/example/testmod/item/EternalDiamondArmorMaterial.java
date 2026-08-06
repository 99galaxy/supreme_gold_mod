package com.example.testmod.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

/**
 * Eternal Diamond armor material - identical stats to netherite (defense
 * 3/8/6/3, toughness 3.0, knockback resistance 0.1, enchantment value 15) but
 * with effectively infinite durability: {@code getDurabilityForType} returns
 * {@link Integer#MAX_VALUE}, so armor never wears out in practice while
 * remaining enchantable (vanilla requires a positive maxDamage to enchant).
 * Repaired with the eternal diamond. Layer textures live at
 * assets/minecraft/textures/models/armor/eternal_diamond_layer_{1,2}.png (the
 * {@code minecraft} namespace is required for 1.20.1 armor layers).
 */
public enum EternalDiamondArmorMaterial implements ArmorMaterial {
    ETERNAL_DIAMOND("eternal_diamond", 0, new int[]{3, 8, 6, 3}, 15,
            SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F,
            () -> Ingredient.of(ModItems.ETERNAL_DIAMOND.get()));

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

    EternalDiamondArmorMaterial(String name, int durabilityMultiplier, int[] protection,
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
        return Integer.MAX_VALUE;
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
