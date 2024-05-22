package com.cjcj55.unconventionaltools.common.loot;

import com.cjcj55.unconventionaltools.core.init.ModItems;
import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.items.ItemHandlerHelper;

import java.util.Optional;
import java.util.function.Supplier;

public class SmeltBlockItemModifier extends LootModifier {
    public static final Supplier<Codec<SmeltBlockItemModifier>> CODEC = Suppliers.memoize(() ->
            RecordCodecBuilder.create(inst -> codecStart(inst).apply(inst, SmeltBlockItemModifier::new)));

    public SmeltBlockItemModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> loot, LootContext context) {
        if(!context.getParam(LootContextParams.TOOL).is(ModItems.THERMAL_PICKAXE.get())) return loot;
        ServerLevel level = context.getLevel();
        RecipeManager recipeManager = level.getRecipeManager();
        SimpleContainer furnace = new SimpleContainer(3);
        ObjectArrayList<ItemStack> newLoot = new ObjectArrayList<>(loot.size());
        for (ItemStack stack : loot) {
            furnace.setItem(0, stack);
            Optional<SmeltingRecipe> recipe = recipeManager.getRecipeFor(RecipeType.SMELTING, furnace, level);
            if(recipe.isEmpty()) {
                newLoot.add(stack);
                continue;
            }
            ItemStack tmp = ItemStack.EMPTY;
            for(int i=0; i<stack.getCount(); i++) {
                ItemStack result = recipe.get().assemble(furnace, level.registryAccess());
                if(result.isEmpty()) result = ItemHandlerHelper.copyStackWithSize(stack, 1);
                if(ItemStack.isSameItemSameTags(result, tmp))
                    tmp.setCount(tmp.getCount() + result.getCount());
                else {
                    if(!tmp.isEmpty()) newLoot.add(tmp);
                    tmp = result;
                }
            }
            if(!tmp.isEmpty()) newLoot.add(tmp);
        }
        return newLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
