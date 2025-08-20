package net.binarybandit.firposfantasticfeatures.datagen;

import net.binarybandit.firposfantasticfeatures.FirposFF;
import net.binarybandit.firposfantasticfeatures.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, FirposFF.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.BLUESTONE_BLOCK);
        blockWithItem(ModBlocks.BLUESTONE_ORE);
        blockWithItem(ModBlocks.BLUE_GEM_BLOCK);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
