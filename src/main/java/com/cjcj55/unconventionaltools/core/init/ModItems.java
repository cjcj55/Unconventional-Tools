package com.cjcj55.unconventionaltools.core.init;

import com.cjcj55.unconventionaltools.UnconventionalTools;
import com.cjcj55.unconventionaltools.common.item.ExplosivePickaxeItem;
import com.cjcj55.unconventionaltools.common.item.ExplosiveSwordItem;
import com.cjcj55.unconventionaltools.common.item.InvisibleSwordItem;
import com.cjcj55.unconventionaltools.common.item.ThermalPickaxeItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, UnconventionalTools.MOD_ID);

    public static final RegistryObject<Item> RAW_UNCONVENTIONAL = ITEMS.register("raw_unconventional", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> UNCONVENTIONAL_INGOT = ITEMS.register("unconventional_ingot", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> EXPLOSIVE_SWORD = ITEMS.register("explosive_sword", () -> new ExplosiveSwordItem(new Item.Properties().durability(128)));
    public static final RegistryObject<Item> EXPLOSIVE_PICKAXE = ITEMS.register("explosive_pickaxe", () -> new ExplosivePickaxeItem(new Item.Properties().durability(128)));
    public static final RegistryObject<Item> INVISIBLE_SWORD = ITEMS.register("invisible_sword", () -> new InvisibleSwordItem(new Item.Properties().durability(512)));
    public static final RegistryObject<Item> THERMAL_PICKAXE = ITEMS.register("thermal_pickaxe", () -> new ThermalPickaxeItem(new Item.Properties().durability(384)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
