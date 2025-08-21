package net.binarybandit.firposfantasticfeatures.datagen;

import net.binarybandit.firposfantasticfeatures.FirposFF;
import net.binarybandit.firposfantasticfeatures.block.ModBlocks;
import net.binarybandit.firposfantasticfeatures.block.custom.BluestoneLampBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
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

        blockWithItem(ModBlocks.BLUEWOOD);
        stairsBlock(ModBlocks.BLUEWOOD_STAIR.get(), blockTexture(ModBlocks.BLUEWOOD.get()));
        slabBlock(ModBlocks.BLUEWOOD_SLAB.get(), blockTexture(ModBlocks.BLUEWOOD.get()), blockTexture(ModBlocks.BLUEWOOD.get()));
        buttonBlock(ModBlocks.BLUEWOOD_BUTTON.get(), blockTexture(ModBlocks.BLUEWOOD.get()));
        pressurePlateBlock(ModBlocks.BLUEWOOD_PRESSUREPLATE.get(), blockTexture(ModBlocks.BLUEWOOD.get()));
        fenceBlock(ModBlocks.BLUEWOOD_FENCE.get(), blockTexture(ModBlocks.BLUEWOOD.get()));
        fenceGateBlock(ModBlocks.BLUEWOOD_FENCE_GATE.get(), blockTexture(ModBlocks.BLUEWOOD.get()));
        wallBlock(ModBlocks.BLUEWOOD_WALL.get(), blockTexture(ModBlocks.BLUEWOOD.get()));
        doorBlockWithRenderType(ModBlocks.BLUEWOOD_DOOR.get(), modLoc("block/bluewood_door_bottom"), modLoc("block/bluewood_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.BLUEWOOD_TRAPDOOR.get(), modLoc("block/bluewood_trapdoor"),true, "cutout");

        blockItem(ModBlocks.BLUEWOOD_STAIR);
        blockItem(ModBlocks.BLUEWOOD_SLAB);
        blockItem(ModBlocks.BLUEWOOD_PRESSUREPLATE);
        blockItem(ModBlocks.BLUEWOOD_STAIR);
        blockItem(ModBlocks.BLUEWOOD_FENCE_GATE);
        blockItem(ModBlocks.BLUEWOOD_TRAPDOOR, "_bottom");

        customLamp((BluestoneLampBlock) ModBlocks.BLUESTONE_LAMP.get(), "bluestone_lamp");
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    //TODO: Generalize and abstract this class
    private void customLamp(BluestoneLampBlock block, String id) {
        getVariantBuilder(block).forAllStates(state -> {
           if (state.getValue(BluestoneLampBlock.CLICKED)) {
               return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll(id + "_on",
                       ResourceLocation.fromNamespaceAndPath(FirposFF.MODID, "block/" + id + "_on")))};
           } else {
               return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll(id + "_off",
                       ResourceLocation.fromNamespaceAndPath(FirposFF.MODID, "block/" + id + "_off")))};
           }
        });
        simpleBlockItem(ModBlocks.BLUESTONE_LAMP.get(), models().cubeAll(id + "_off",
                ResourceLocation.fromNamespaceAndPath(FirposFF.MODID, "block/" + id + "_off")));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("firposfantasticfeatures:block/" + deferredBlock.getId().getPath() + appendix));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        blockItem(deferredBlock, "");
    }
}
