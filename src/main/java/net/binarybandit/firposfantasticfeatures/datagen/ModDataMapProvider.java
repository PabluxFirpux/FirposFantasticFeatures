package net.binarybandit.firposfantasticfeatures.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {
    protected ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather(HolderLookup.Provider provider) {
        super.gather(provider);

        //this.builder(NeoForgeDataMaps.FURNACE_FUELS).add(ModItems.NIDEA.getId(), new FurnaceFuel(2000), false)
    }
}
