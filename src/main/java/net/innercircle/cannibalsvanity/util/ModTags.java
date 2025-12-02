package net.innercircle.cannibalsvanity.util;

import net.innercircle.cannibalsvanity.CannibalsVanity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> FLESH = createTag("flesh");
        public static final TagKey<Block> BONE = createTag("bone");
        public static final TagKey<Block> CORPSE = createTag("corpse");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(CannibalsVanity.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> FLESH = createTag("flesh");
        public static final TagKey<Item> BONE = createTag("bone");
        public static final TagKey<Item> CORPSE = createTag("corpse");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(CannibalsVanity.MOD_ID, name));
        }
    }
}
