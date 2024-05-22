package com.cjcj55.unconventionaltools.common.item;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.Level;

public class ExplosivePickaxeItem extends PickaxeItem {
    public ExplosivePickaxeItem(Properties pProperties) {
        super(Tiers.IRON, 3, -2.0f, pProperties);
    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, Player player) {
        if (!player.level().isClientSide()) {
            player.level().explode(player, pos.getX(), pos.getY(), pos.getZ(), 2.0f, false, Level.ExplosionInteraction.BLOCK);
        }

        return super.onBlockStartBreak(itemstack, pos, player);
    }
}
