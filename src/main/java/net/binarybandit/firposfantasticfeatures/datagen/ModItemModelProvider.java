package net.binarybandit.firposfantasticfeatures.datagen;

import net.binarybandit.firposfantasticfeatures.FirposFF;
import net.binarybandit.firposfantasticfeatures.block.ModBlocks;
import net.binarybandit.firposfantasticfeatures.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output,ExistingFileHelper existingFileHelper) {
        super(output, FirposFF.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.BLUESTONE.get());
        basicItem(ModItems.CHISEL.get());
        basicItem(ModItems.BLUE_APPLE.get());
        basicItem(ModItems.BLUE_COAL.get());

        buttonItem(ModBlocks.BLUEWOOD_BUTTON, ModBlocks.BLUEWOOD);
        fenceItem(ModBlocks.BLUEWOOD_FENCE, ModBlocks.BLUEWOOD);
        wallItem(ModBlocks.BLUEWOOD_WALL, ModBlocks.BLUEWOOD);

        basicItem(ModBlocks.BLUEWOOD_DOOR.asItem());
        basicItem(ModItems.BLUE_IRON_INGOT.get());

        handHeldItem(ModItems.BLUE_IRON_PICKAXE);
        handHeldItem(ModItems.BLUE_IRON_SHOVEL);
        handHeldItem(ModItems.BLUE_IRON_SWORD);
        handHeldItem(ModItems.BLUE_IRON_AXE);
    }

    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(FirposFF.MODID,
                            "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(FirposFF.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/polished_blackstone_wall_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(FirposFF.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }

    private ItemModelBuilder handHeldItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(FirposFF.MODID, "item/" + item.getId().getPath()));
    }
}
