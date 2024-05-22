package com.cjcj55.unconventionaltools.common.creativetabs;

import com.cjcj55.unconventionaltools.UnconventionalTools;
import com.cjcj55.unconventionaltools.core.init.ModBlocks;
import com.cjcj55.unconventionaltools.core.init.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.stream.Stream;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, UnconventionalTools.MOD_ID);

    public static final RegistryObject<CreativeModeTab> UNCONVENTIONAL_TAB = CREATIVE_MODE_TABS.register("unconventional_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.UNCONVENTIONAL_INGOT.get())).title(Component.translatable("creativetab.unconventional_tab"))
                    .displayItems((displayParameters, output) -> {
                        Stream<RegistryObject<Item>> itemStream = ModItems.ITEMS.getEntries().stream();
                        Stream<RegistryObject<Block>> blockStream = ModBlocks.BLOCKS.getEntries().stream();

                        itemStream.forEach(i -> output.accept(i.get()));
                        blockStream.forEach(b -> output.accept(b.get()));
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
