package net.binarybandit.firposfantasticfeatures.datagen;

import net.binarybandit.firposfantasticfeatures.FirposFF;
import net.binarybandit.firposfantasticfeatures.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, FirposFF.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.BLUESTONE_BLOCK.get())
                .add(ModBlocks.BLUESTONE_ORE.get())
                .add(ModBlocks.BLUE_GEM_BLOCK.get());

        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.BLUEWOOD.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BLUESTONE_ORE.get());

        tag(BlockTags.FENCES).add(ModBlocks.BLUEWOOD_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.BLUEWOOD_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.BLUEWOOD_WALL.get());
    }
}
