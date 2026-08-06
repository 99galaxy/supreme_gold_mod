package com.example.testmod.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

/**
 * Eternal Diamond tool tier - identical stats to netherite (speed 9.0, attack
 * damage bonus 4.0, harvest level 4, enchantment value 15) but with
 * effectively infinite durability: {@code getUses()} returns
 * {@link Integer#MAX_VALUE}, so the tools never wear out in practice while
 * remaining enchantable (vanilla ties enchantability to
 * {@code isDamageableItem()}, which requires a positive maxDamage - zero
 * durability items cannot be enchanted). Repaired with the eternal diamond.
 */
public enum EternalDiamondToolTier implements Tier {
    ETERNAL_DIAMOND(Integer.MAX_VALUE, 9.0F, 4.0F, 4, 15,
            () -> Ingredient.of(ModItems.ETERNAL_DIAMOND.get()));

    private final int uses;
    private final float speed;
    private final float attackDamageBonus;
    private final int level;
    private final int enchantmentValue;
    private final Supplier<Ingredient> repairIngredient;

    EternalDiamondToolTier(int uses, float speed, float attackDamageBonus, int level,
                           int enchantmentValue, Supplier<Ingredient> repairIngredient) {
        this.uses = uses;
        this.speed = speed;
        this.attackDamageBonus = attackDamageBonus;
        this.level = level;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getUses() {
        return uses;
    }

    @Override
    public float getSpeed() {
        return speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return attackDamageBonus;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairIngredient.get();
    }
}
