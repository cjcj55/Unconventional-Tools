package com.cjcj55.unconventionaltools.datagen.loot;

import com.cjcj55.unconventionaltools.core.init.ModBlocks;
import com.cjcj55.unconventionaltools.core.init.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.UNCONVENTIONAL_BLOCK.get());

        this.add(ModBlocks.UNCONVENTIONAL_ORE.get(), block -> createOreDrop(ModBlocks.UNCONVENTIONAL_ORE.get(), ModItems.RAW_UNCONVENTIONAL.get()));
        this.add(ModBlocks.DEEPSLATE_UNCONVENTIONAL_ORE.get(), block -> createOreDrop(ModBlocks.DEEPSLATE_UNCONVENTIONAL_ORE.get(), ModItems.RAW_UNCONVENTIONAL.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
