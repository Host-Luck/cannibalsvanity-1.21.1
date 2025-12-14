package net.innercircle.assistanthats.datagen;

import net.innercircle.assistanthats.CannibalsVanity;
import net.innercircle.assistanthats.block.ModBlocks;
import net.innercircle.assistanthats.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CannibalsVanity.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.CORPSE_BLOCK.get())
                .add(ModBlocks.CORPSE_WALL.get())
                .add(ModBlocks.CORPSE_TRAPDOOR.get())
                .add(ModBlocks.CORPSE_PRESSUREPLATE.get())
                .add(ModBlocks.CORPSE_DOOR.get())
                .add(ModBlocks.CORPSE_FENCE.get())
                .add(ModBlocks.CORPSE_GATE.get())
                .add(ModBlocks.CORPSE_SLAB.get())
                .add(ModBlocks.CORPSE_STAIRS.get())
                .add(ModBlocks.CORPSE_BUTTON.get());

        tag(BlockTags.FENCES)
                .add(ModBlocks.CORPSE_FENCE.get());
        tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.CORPSE_GATE.get());
        tag(BlockTags.WALLS)
                .add(ModBlocks.CORPSE_WALL.get());

        tag(ModTags.Blocks.NEEDS_CORPSE_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);
        tag(ModTags.Blocks.INCORRECT_FOR_CORPSE_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .remove(ModTags.Blocks.NEEDS_CORPSE_TOOL);
    }
}
