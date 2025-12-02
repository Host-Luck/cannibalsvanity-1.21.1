package net.innercircle.cannibalsvanity.datagen;

import net.innercircle.cannibalsvanity.CannibalsVanity;
import net.innercircle.cannibalsvanity.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CannibalsVanity.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.CORPSE_BLOCK);
        blockWithItem(ModBlocks.CORPSE_BUTTON);
        blockWithItem(ModBlocks.CORPSE_DOOR);
        blockWithItem(ModBlocks.CORPSE_FENCE);
        blockWithItem(ModBlocks.CORPSE_GATE);
        blockWithItem(ModBlocks.CORPSE_PRESSUREPLATE);
        blockWithItem(ModBlocks.CORPSE_SLAB);
        blockWithItem(ModBlocks.CORPSE_STAIRS);
        blockWithItem(ModBlocks.CORPSE_TRAPDOOR);
        blockWithItem(ModBlocks.CORPSE_WALL);
        blockWithItem(ModBlocks.TOUGHFLESH_BLOCK);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
