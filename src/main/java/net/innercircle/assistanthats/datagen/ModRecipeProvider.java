package net.innercircle.assistanthats.datagen;

import net.innercircle.assistanthats.CannibalsVanity;
import net.innercircle.assistanthats.block.ModBlocks;
import net.innercircle.assistanthats.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> SALT_DRYING = List.of(Items.WATER_BUCKET);
        List<ItemLike> CANNIBALISM = List.of(ModItems.TOUGHFLESH);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TOUGHFLESH_BLOCK.get())
                .pattern("FFF")
                .pattern("FFF")
                .pattern("FFF")
                .define('F', ModItems.TOUGHFLESH.get())
                .unlockedBy("has_tanned", has(ModItems.TOUGHFLESH)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TOUGHFLESH.get())
                .pattern(" S ")
                .pattern("SFS")
                .pattern(" S ")
                .define('F', Items.ROTTEN_FLESH)
                .define('S', ModItems.SALT.get())
                .unlockedBy("has_salt", has(Items.ROTTEN_FLESH)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CORPSE_BLOCK.get())
                .pattern("FbF")
                .pattern("bBb")
                .pattern("FbF")
                .define('F', ModItems.TOUGHFLESH.get())
                .define('b', ModItems.TOUGHBONE.get())
                .define('B', Blocks.BONE_BLOCK)
                .unlockedBy("has_corpses", has(ModItems.TOUGHFLESH)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TOUGHFLESH.get(), 9)
                .requires(ModBlocks.TOUGHFLESH_BLOCK)
                .unlockedBy("has_toughflesh_block", has(ModBlocks.TOUGHFLESH_BLOCK))
                .save(recipeOutput, "cannibalsvanity:toughflesh_from_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TOUGHBONE.get(), 1)
                .requires(Items.BONE, 2)
                .requires(Items.STRING, 1)
                .unlockedBy("has_shin", has(Items.STRING)).save(recipeOutput);

        oreSmelting(recipeOutput, SALT_DRYING, RecipeCategory.MISC, ModItems.SALT.get(), 0.5f, 200, "bone");
        oreSmelting(recipeOutput, CANNIBALISM, RecipeCategory.MISC, ModItems.COOKEDFLESH.get(), 0.50f, 200, "flesh");
        oreCooking(recipeOutput, CANNIBALISM, RecipeCategory.MISC, ModItems.COOKEDFLESH.get(), 0.5f, 100, "flesh");

        stairBuilder(ModBlocks.CORPSE_STAIRS.get(), Ingredient.of(ModBlocks.CORPSE_BLOCK)).group("corpse")
                .unlockedBy("has_corpse", has(ModBlocks.CORPSE_BLOCK)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CORPSE_SLAB.get(), ModBlocks.CORPSE_BLOCK.get());

        buttonBuilder(ModBlocks.CORPSE_BUTTON.get(), Ingredient.of(ModBlocks.CORPSE_BLOCK)).group("corpse")
                .unlockedBy("has_corpse", has(ModBlocks.CORPSE_BLOCK)).save(recipeOutput);
        pressurePlate(recipeOutput, ModBlocks.CORPSE_PRESSUREPLATE.get(), ModBlocks.CORPSE_BLOCK.get());

        fenceBuilder(ModBlocks.CORPSE_FENCE.get(), Ingredient.of(ModBlocks.CORPSE_BLOCK)).group("corpse")
                .unlockedBy("has_corpse", has(ModBlocks.CORPSE_BLOCK)).save(recipeOutput);
        fenceGateBuilder(ModBlocks.CORPSE_GATE.get(), Ingredient.of(ModBlocks.CORPSE_BLOCK)).group("corpse")
                .unlockedBy("has_corpse", has(ModBlocks.CORPSE_BLOCK)).save(recipeOutput);
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CORPSE_WALL.get(), ModBlocks.CORPSE_BLOCK.get());

        doorBuilder(ModBlocks.CORPSE_DOOR.get(), Ingredient.of(ModBlocks.CORPSE_BLOCK)).group("corpse")
                .unlockedBy("has_corpse", has(ModBlocks.CORPSE_BLOCK)).save(recipeOutput);
        trapdoorBuilder(ModBlocks.CORPSE_TRAPDOOR.get(), Ingredient.of(ModBlocks.CORPSE_BLOCK)).group("corpse")
                .unlockedBy("has_corpse", has(ModBlocks.CORPSE_BLOCK)).save(recipeOutput);
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreCooking(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMOKING_RECIPE, SmokingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smoking");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemLike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemLike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemLike), has(itemLike))
                    .save(recipeOutput, CannibalsVanity.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemLike));
        }
    }
}
