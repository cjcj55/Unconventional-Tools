package com.cjcj55.unconventionaltools.datagen;

import com.cjcj55.unconventionaltools.UnconventionalTools;
import com.cjcj55.unconventionaltools.common.loot.AddItemModifier;
import com.cjcj55.unconventionaltools.common.loot.SmeltBlockItemModifier;
import com.cjcj55.unconventionaltools.core.init.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output) {
        super(output, UnconventionalTools.MOD_ID);
    }

    @Override
    protected void start() {
        add("unconventional_ingot_from_grass", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.35f).build() }, ModItems.UNCONVENTIONAL_INGOT.get()));

        add("unconventional_ingot_from_jungle_temple", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/jungle_temple")).build() }, ModItems.UNCONVENTIONAL_INGOT.get()));

        add("smelt_all_blocks_with_thermal_pickaxe", new SmeltBlockItemModifier(new LootItemCondition[]{

        }));
    }
}
