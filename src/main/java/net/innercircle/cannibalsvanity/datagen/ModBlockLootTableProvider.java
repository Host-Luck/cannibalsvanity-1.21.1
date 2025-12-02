package net.innercircle.cannibalsvanity.datagen;

import net.innercircle.cannibalsvanity.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.CORPSE_BLOCK.get());
        dropSelf(ModBlocks.TOUGHFLESH_BLOCK.get());
        dropSelf(ModBlocks.CORPSE_STAIRS.get());
        dropSelf(ModBlocks.CORPSE_BUTTON.get());
        dropSelf(ModBlocks.CORPSE_DOOR.get());
        dropSelf(ModBlocks.CORPSE_FENCE.get());
        dropSelf(ModBlocks.CORPSE_GATE.get());
        dropSelf(ModBlocks.CORPSE_PRESSUREPLATE.get());
        dropSelf(ModBlocks.CORPSE_SLAB.get());
        dropSelf(ModBlocks.CORPSE_TRAPDOOR.get());
        dropSelf(ModBlocks.CORPSE_WALL.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
