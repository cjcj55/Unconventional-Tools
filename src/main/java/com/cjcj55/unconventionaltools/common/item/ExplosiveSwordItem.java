package com.cjcj55.unconventionaltools.common.item;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.Level;

public class ExplosiveSwordItem extends SwordItem {
    public ExplosiveSwordItem(Properties pProperties) {
        super(Tiers.IRON, 3, -3.0f, pProperties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if (entity instanceof LivingEntity livingEntity) {
            if (player.level().isClientSide) {
                livingEntity.level().explode(livingEntity, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), 2.0f, false, Level.ExplosionInteraction.BLOCK);
            }
        }
        return super.onLeftClickEntity(stack, player, entity);
    }
}
