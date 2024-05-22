package com.cjcj55.unconventionaltools.common.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.Level;

public class InvisibleSwordItem extends SwordItem {
    public InvisibleSwordItem(Properties pProperties) {
        super(Tiers.DIAMOND, 3, -2.0f, pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        MobEffectInstance invisibilityEffect = pPlayer.getActiveEffects().stream()
                .filter(effect -> effect.getEffect() == MobEffects.INVISIBILITY)
                .findFirst()
                .orElse(null);

        if (invisibilityEffect!= null) {
            invisibilityEffect = new MobEffectInstance(MobEffects.INVISIBILITY, invisibilityEffect.getDuration() + 200, invisibilityEffect.getAmplifier());
            pPlayer.addEffect(invisibilityEffect);
        } else {
            pPlayer.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 200, 0));
        }

        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);
        if (!pPlayer.isCreative() && !itemStack.isEmpty()) {
            itemStack.hurtAndBreak(10, pPlayer, (p_150845_) -> {
                p_150845_.broadcastBreakEvent(pUsedHand);
            });
        }

        return super.use(pLevel, pPlayer, pUsedHand);
    }
}
