package net.binarybandit.firposfantasticfeatures.util;

import net.binarybandit.firposfantasticfeatures.FirposFF;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_BLUESTONE_TOOL = createTag("needs_bluestone_tool");
        public static final TagKey<Block> INCORRECT_FOR_BLUESTONE_TOOL = createTag("incorrect_for_bluestone_tool");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(FirposFF.MODID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSMUTED_BY_BLUE_GEM = createTag("transmuted_by_blue_gem");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(FirposFF.MODID, name));
        }

    }
}
