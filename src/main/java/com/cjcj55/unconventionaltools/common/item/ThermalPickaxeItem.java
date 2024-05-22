package com.cjcj55.unconventionaltools.common.item;

import com.google.common.collect.Maps;
import net.minecraft.core.BlockPos;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Map;
import java.util.Optional;

public class ThermalPickaxeItem extends PickaxeItem {

    public ThermalPickaxeItem(Properties pProperties) {
        super(Tiers.DIAMOND, 2, -2.5f, pProperties);
    }
}
