package net.innercircle.assistanthats.datagen;

import net.innercircle.assistanthats.CannibalsVanity;
import net.innercircle.assistanthats.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CannibalsVanity.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.CORPSE_BLOCK);
        blockWithItem(ModBlocks.TOUGHFLESH_BLOCK);

        stairsBlock(ModBlocks.CORPSE_STAIRS.get(), blockTexture(ModBlocks.CORPSE_BLOCK.get()));
        slabBlock(ModBlocks.CORPSE_SLAB.get(), blockTexture(ModBlocks.CORPSE_BLOCK.get()), blockTexture(ModBlocks.CORPSE_BLOCK.get()));

        buttonBlock(ModBlocks.CORPSE_BUTTON.get(), blockTexture(ModBlocks.CORPSE_BLOCK.get()));
        pressurePlateBlock(ModBlocks.CORPSE_PRESSUREPLATE.get(), blockTexture(ModBlocks.CORPSE_BLOCK.get()));

        fenceBlock(ModBlocks.CORPSE_FENCE.get(), blockTexture(ModBlocks.CORPSE_BLOCK.get()));
        fenceGateBlock(ModBlocks.CORPSE_GATE.get(), blockTexture(ModBlocks.CORPSE_BLOCK.get()));
        wallBlock(ModBlocks.CORPSE_WALL.get(), blockTexture(ModBlocks.CORPSE_BLOCK.get()));

        doorBlockWithRenderType(ModBlocks.CORPSE_DOOR.get(), modLoc("block/corpse_doorbottom"), modLoc("block/corpse_doortop"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.CORPSE_TRAPDOOR.get(), modLoc("block/corpse_trapdoor"), true, "cutout");

        blockItem(ModBlocks.CORPSE_STAIRS);
        blockItem(ModBlocks.CORPSE_SLAB);
        blockItem(ModBlocks.CORPSE_PRESSUREPLATE);
        blockItem(ModBlocks.CORPSE_TRAPDOOR, "_bottom");
        blockItem(ModBlocks.CORPSE_GATE);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("cannibalsvanity:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("cannibalsvanity:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
