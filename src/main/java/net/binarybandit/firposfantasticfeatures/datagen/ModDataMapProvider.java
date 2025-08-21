package net.binarybandit.firposfantasticfeatures.datagen;

import net.binarybandit.firposfantasticfeatures.block.ModBlocks;
import net.binarybandit.firposfantasticfeatures.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {
    protected ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather(HolderLookup.Provider provider) {
        super.gather(provider);

        this.builder(NeoForgeDataMaps.FURNACE_FUELS).add(ModItems.BLUE_COAL.getId(), new FurnaceFuel(2048), false);


        this.builder(NeoForgeDataMaps.FURNACE_FUELS).add(ModBlocks.BLUEWOOD.getId(), new FurnaceFuel(160), false);
    }
}
