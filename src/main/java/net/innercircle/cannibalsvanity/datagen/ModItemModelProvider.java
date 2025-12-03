package net.innercircle.cannibalsvanity.datagen;

import net.innercircle.cannibalsvanity.CannibalsVanity;
import net.innercircle.cannibalsvanity.block.ModBlocks;
import net.innercircle.cannibalsvanity.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CannibalsVanity.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.TOUGHFLESH.get());
        basicItem(ModItems.COOKEDFLESH.get());
        basicItem(ModItems.TOUGHBONE.get());
        basicItem(ModItems.SALT.get());

        buttonItem(ModBlocks.CORPSE_BUTTON, ModBlocks.CORPSE_BLOCK);
        fenceItem(ModBlocks.CORPSE_FENCE, ModBlocks.CORPSE_BLOCK);
        wallItem(ModBlocks.CORPSE_WALL, ModBlocks.CORPSE_BLOCK);

        basicItem(ModBlocks.CORPSE_DOOR.asItem());

        handheldItem(ModItems.CORPSE_AXE);
        handheldItem(ModItems.CORPSE_SHOVEL);
        handheldItem(ModItems.CORPSE_SWORD);
        handheldItem(ModItems.CORPSE_PICKAXE);
        handheldItem(ModItems.CORPSE_PLOW);
    }

    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(CannibalsVanity.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(CannibalsVanity.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(CannibalsVanity.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(CannibalsVanity.MOD_ID, "item/" + item.getId().getPath()));
    }
}
