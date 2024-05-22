package com.cjcj55.unconventionaltools.datagen;

import com.cjcj55.unconventionaltools.core.init.ModBlocks;
import com.cjcj55.unconventionaltools.core.init.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.StrictNBTIngredient;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> UNCONVENTIONAL_SMELTABLES = List.of(ModItems.RAW_UNCONVENTIONAL.get(), ModBlocks.UNCONVENTIONAL_ORE.get(), ModBlocks.DEEPSLATE_UNCONVENTIONAL_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreCooking(pWriter, UNCONVENTIONAL_SMELTABLES, ModItems.UNCONVENTIONAL_INGOT, 0.5f, "unconventional");
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.EXPLOSIVE_SWORD.get())
                .pattern("A")
                .pattern("A")
                .pattern("B")
                .define('A', Blocks.TNT)
                .define('B', Items.STICK)
                .unlockedBy("has_tnt", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Blocks.TNT).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EXPLOSIVE_PICKAXE.get())
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', Blocks.TNT)
                .define('B', Items.STICK)
                .unlockedBy("has_tnt", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Blocks.TNT).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.INVISIBLE_SWORD.get())
                .pattern(" A ")
                .pattern("CAC")
                .pattern(" B ")
                .define('A', Blocks.GLASS)
                .define('B', Items.STICK)
                .define('C', StrictNBTIngredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.INVISIBILITY)))
                .unlockedBy("has_tnt", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Blocks.GLASS).build()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.THERMAL_PICKAXE.get())
                .pattern("ACA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', Blocks.COAL_BLOCK)
                .define('B', Items.STICK)
                .define('C', Blocks.IRON_BLOCK)
                .unlockedBy("has_iron", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.IRON_INGOT, Items.COAL).build()))
                .save(pWriter);
    }

    private void oreCooking(Consumer<FinishedRecipe> pWriter, List<ItemLike> itemsToSmelt, RegistryObject<Item> returnItem, float experience, String group) {
        oreSmelting(pWriter, itemsToSmelt, RecipeCategory.MISC, returnItem.get(), experience, 200, group);
        oreBlasting(pWriter, itemsToSmelt, RecipeCategory.MISC, returnItem.get(), experience, 100, group);
    }
}
