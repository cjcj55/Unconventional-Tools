package com.cjcj55.unconventionaltools.datagen;

import com.cjcj55.unconventionaltools.UnconventionalTools;
import com.cjcj55.unconventionaltools.core.init.ModBlocks;
import com.cjcj55.unconventionaltools.core.init.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;

public class ModLanguageProvider extends LanguageProvider {

    public ModLanguageProvider(PackOutput output, String locale) {
        super(output, UnconventionalTools.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        addItem(ModItems.RAW_UNCONVENTIONAL, "Raw Unconventional");
        addItem(ModItems.UNCONVENTIONAL_INGOT, "Unconventional Ingot");
        addBlock(ModBlocks.UNCONVENTIONAL_ORE, "Unconventional Ore");
        addBlock(ModBlocks.DEEPSLATE_UNCONVENTIONAL_ORE, "Deepslate Unconventional Ore");
        addBlock(ModBlocks.UNCONVENTIONAL_BLOCK, "Unconventional Block");

        addItem(ModItems.EXPLOSIVE_SWORD, "Explosive Sword");
        addItem(ModItems.EXPLOSIVE_PICKAXE, "Explosive Pickaxe");
        addItem(ModItems.INVISIBLE_SWORD, "Invisible Sword");
        addItem(ModItems.THERMAL_PICKAXE, "Thermal Pickaxe");

        add("creativetab.unconventional_tab", "Unconventional Tools");
    }

    private void addItem(RegistryObject<Item> item, String name) {
        add(item.get(), name);
    }

    private void addBlock(RegistryObject<Block> block, String name) {
        add(block.get(), name);
    }
}