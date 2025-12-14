package net.innercircle.assistanthats.datagen;

import net.innercircle.assistanthats.CannibalsVanity;
import net.innercircle.assistanthats.item.ModItems;
import net.innercircle.assistanthats.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, CannibalsVanity.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.FLESH)
                .add(ModItems.COOKEDFLESH.get())
                .add(ModItems.TOUGHFLESH.get())
                .add(Items.ROTTEN_FLESH);

        tag(ItemTags.SWORDS)
                .add(ModItems.CORPSE_SWORD.get());
        tag(ItemTags.AXES)
                .add(ModItems.CORPSE_AXE.get());
        tag(ItemTags.SHOVELS)
                .add(ModItems.CORPSE_SHOVEL.get());
        tag(ItemTags.PICKAXES)
                .add(ModItems.CORPSE_PICKAXE.get());
        tag(ItemTags.HOES)
                .add(ModItems.CORPSE_PLOW.get());
    }
}
