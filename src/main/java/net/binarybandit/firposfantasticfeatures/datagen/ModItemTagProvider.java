package net.binarybandit.firposfantasticfeatures.datagen;

import net.binarybandit.firposfantasticfeatures.FirposFF;
import net.binarybandit.firposfantasticfeatures.item.ModItems;
import net.binarybandit.firposfantasticfeatures.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {

    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, FirposFF.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.TRANSMUTED_BY_BLUE_GEM)
            .add(ModItems.BLUESTONE.get());

        tag(ItemTags.SWORDS).add(ModItems.BLUE_IRON_SWORD.get());
        tag(ItemTags.PICKAXES).add(ModItems.BLUE_IRON_PICKAXE.get());
        tag(ItemTags.SHOVELS).add(ModItems.BLUE_IRON_SHOVEL.get());
        tag(ItemTags.AXES).add(ModItems.BLUE_IRON_AXE.get());
    }
}
