package com.example.testmod.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

/**
 * Supreme Gold tool tier - identical stats to netherite (speed 9.0, attack
 * damage bonus 4.0, harvest level 4, enchantment value 15) but with durability
 * reduced to one third of netherite (2031 / 3 = 677) so the 3x3 excavation
 * comes at a real cost. Repaired with the supreme gold ingot.
 */
public enum SupremeGoldToolTier implements Tier {
    SUPREME_GOLD(677, 9.0F, 4.0F, 4, 15,
            () -> Ingredient.of(ModItems.SUPREME_GOLD_INGOT.get()));

    private final int uses;
    private final float speed;
    private final float attackDamageBonus;
    private final int level;
    private final int enchantmentValue;
    private final Supplier<Ingredient> repairIngredient;

    SupremeGoldToolTier(int uses, float speed, float attackDamageBonus, int level,
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
