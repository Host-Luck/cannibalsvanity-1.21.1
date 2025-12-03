package net.innercircle.cannibalsvanity.item;

import net.innercircle.cannibalsvanity.block.ModBlocks;
import net.innercircle.cannibalsvanity.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier CORPSE = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_CORPSE_TOOL,
            1000, 8f, 5f, 30, () -> Ingredient.of(ModBlocks.CORPSE_BLOCK));
}
