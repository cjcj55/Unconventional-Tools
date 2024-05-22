package com.cjcj55.unconventionaltools.datagen;

import com.cjcj55.unconventionaltools.UnconventionalTools;
import com.cjcj55.unconventionaltools.core.init.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, UnconventionalTools.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.DEEPSLATE_UNCONVENTIONAL_ORE.get(),
                        ModBlocks.UNCONVENTIONAL_ORE.get(),
                        ModBlocks.UNCONVENTIONAL_BLOCK.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.DEEPSLATE_UNCONVENTIONAL_ORE.get(),
                        ModBlocks.UNCONVENTIONAL_ORE.get(),
                        ModBlocks.UNCONVENTIONAL_BLOCK.get());
    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
