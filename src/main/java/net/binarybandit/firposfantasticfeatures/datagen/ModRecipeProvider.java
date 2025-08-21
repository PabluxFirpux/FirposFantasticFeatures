package net.binarybandit.firposfantasticfeatures.datagen;

import net.binarybandit.firposfantasticfeatures.block.ModBlocks;
import net.binarybandit.firposfantasticfeatures.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> BLUESTONE_SMELTABLES = List.of(ModBlocks.BLUESTONE_ORE);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BLUE_APPLE.get())
                .pattern("BBB")
                .pattern("BAB")
                .pattern("BBB")
                .define('B', ModItems.BLUESTONE.get())
                .define('A', Items.APPLE)
                .unlockedBy("has_bluestone", has(ModItems.BLUESTONE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BLUE_COAL.get())
                .pattern("BBB")
                .pattern("BCB")
                .pattern("BBB")
                .define('B', ModItems.BLUESTONE.get())
                .define('C', Items.COAL)
                .unlockedBy("has_bluestone", has(ModItems.BLUESTONE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLUESTONE_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.BLUESTONE.get())
                .unlockedBy("has_bluestone", has(ModItems.BLUESTONE)).save(recipeOutput);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CHISEL.get())
                .pattern("B")
                .pattern("I")
                .define('B', Items.IRON_INGOT)
                .define('I', Items.STICK)
                .unlockedBy("has_iron", has(Items.IRON_INGOT)).save(recipeOutput, "firposfantasticfeatures:fff_chisel");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BLUESTONE.get(), 9)
                .requires(ModBlocks.BLUESTONE_BLOCK)
                .unlockedBy("has_bluestone_block", has(ModBlocks.BLUESTONE_BLOCK)).save(recipeOutput);

        oreSmelting(recipeOutput, BLUESTONE_SMELTABLES, RecipeCategory.MISC, ModItems.BLUESTONE.get(), 1f, 100, "bluestone");
        oreBlasting(recipeOutput, BLUESTONE_SMELTABLES, RecipeCategory.MISC, ModItems.BLUESTONE.get(), 1f, 50, "bluestone");

        stairBuilder(ModBlocks.BLUEWOOD_STAIR.get(), Ingredient.of(ModBlocks.BLUEWOOD)).group("bluewood").unlockedBy("has_bluewood", has(ModBlocks.BLUEWOOD)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.MISC, ModBlocks.BLUEWOOD_SLAB.get(), ModBlocks.BLUEWOOD.get());
        wall(recipeOutput, RecipeCategory.MISC, ModBlocks.BLUEWOOD_WALL.get(), ModBlocks.BLUEWOOD.get());
        fenceBuilder(ModBlocks.BLUEWOOD_FENCE.get(), Ingredient.of(ModBlocks.BLUEWOOD)).group("bluewood").unlockedBy("has_bluewood", has(ModBlocks.BLUEWOOD)).save(recipeOutput);
        fenceGateBuilder(ModBlocks.BLUEWOOD_FENCE_GATE.get(), Ingredient.of(ModBlocks.BLUEWOOD)).group("bluewood").unlockedBy("has_bluewood", has(ModBlocks.BLUEWOOD)).save(recipeOutput);
        pressurePlateBuilder(RecipeCategory.MISC, ModBlocks.BLUEWOOD_WALL.get(), Ingredient.of(ModBlocks.BLUEWOOD));
        trapdoorBuilder(ModBlocks.BLUEWOOD_TRAPDOOR.get(), Ingredient.of(ModBlocks.BLUEWOOD)).group("bluewood").unlockedBy("has_bluewood", has(ModBlocks.BLUEWOOD)).save(recipeOutput);
        buttonBuilder(ModBlocks.BLUEWOOD_BUTTON.get(), Ingredient.of(ModBlocks.BLUEWOOD)).group("bluewood").unlockedBy("has_bluewood", has(ModBlocks.BLUEWOOD)).save(recipeOutput);
        doorBuilder(ModBlocks.BLUEWOOD_DOOR.get(), Ingredient.of(ModBlocks.BLUEWOOD)).group("bluewood").unlockedBy("has_bluewood", has(ModBlocks.BLUEWOOD)).save(recipeOutput);

    }
}
