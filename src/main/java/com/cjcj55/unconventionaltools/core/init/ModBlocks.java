package com.cjcj55.unconventionaltools.core.init;

import com.cjcj55.unconventionaltools.UnconventionalTools;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, UnconventionalTools.MOD_ID);

    public static final RegistryObject<Block> UNCONVENTIONAL_BLOCK = registerBlock("unconventional_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(6.5f, 8.0f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> UNCONVENTIONAL_ORE = registerBlock("unconventional_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.STONE), UniformInt.of(0, 3)));
    public static final RegistryObject<Block> DEEPSLATE_UNCONVENTIONAL_ORE = registerBlock("deepslate_unconventional_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(UNCONVENTIONAL_ORE.get()), UniformInt.of(0, 3)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
