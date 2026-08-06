package com.example.testmod.event;

import com.example.testmod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

/**
 * Supreme Gold tools excavate a 3x3x3 cube: when a block is effectively broken
 * in survival mode while holding a Supreme Gold tool, the 26 surrounding blocks
 * in the cube are broken too. Extra blocks drop their normal loot (the held
 * tool's fortune/silk touch apply) and consume 1 durability each.
 *
 * <p>Registered manually in {@code TestMod}'s constructor (not via
 * {@code @Mod.EventBusSubscriber}) because this project's build doesn't run the
 * eventbus annotation processor.
 */
public class ModEvents {

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        // Only for real mining; creative instant-break would wipe a 3x3 for free.
        if (player == null || player.isCreative()) {
            return;
        }
        ItemStack held = player.getMainHandItem();
        if (held.isEmpty() || !isSupremeGoldTool(held)) {
            return;
        }
        if (!(event.getLevel() instanceof Level level) || level.isClientSide) {
            return;
        }
        // Only trigger when the tool is actually the right one for the broken block.
        if (!player.hasCorrectToolForDrops(event.getState())) {
            return;
        }

        BlockPos center = event.getPos();
        // Break the 3x3x3 cube around the broken block (center is handled by vanilla).
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                for (int dz = -1; dz <= 1; dz++) {
                    if (dx == 0 && dy == 0 && dz == 0) {
                        continue;
                    }
                    if (held.isEmpty()) {
                        return; // tool broke mid-excavation
                    }
                    excavate(level, center.offset(dx, dy, dz), player, held);
                }
            }
        }
    }

    /** Break one neighbor block, dropping its loot with the tool's enchantments. */
    private static void excavate(Level level, BlockPos pos, Player player, ItemStack held) {
        BlockState state = level.getBlockState(pos);
        // Skip air and unbreakable blocks (bedrock, barrier, ... destroy speed < 0).
        if (state.isAir() || state.getDestroySpeed(level, pos) < 0) {
            return;
        }
        // Only harvest blocks the tool is correct for (avoids silently losing ores etc.).
        if (!player.hasCorrectToolForDrops(state)) {
            return;
        }
        BlockEntity blockEntity = state.hasBlockEntity() ? level.getBlockEntity(pos) : null;
        Block.dropResources(state, level, pos, blockEntity, player, held);
        if (level.destroyBlock(pos, false, player)) {
            held.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(p.getUsedItemHand()));
        }
    }

    private static boolean isSupremeGoldTool(ItemStack stack) {
        Item item = stack.getItem();
        return item == ModItems.SUPREME_GOLD_SWORD.get()
                || item == ModItems.SUPREME_GOLD_PICKAXE.get()
                || item == ModItems.SUPREME_GOLD_AXE.get()
                || item == ModItems.SUPREME_GOLD_SHOVEL.get()
                || item == ModItems.SUPREME_GOLD_HOE.get();
    }
}
