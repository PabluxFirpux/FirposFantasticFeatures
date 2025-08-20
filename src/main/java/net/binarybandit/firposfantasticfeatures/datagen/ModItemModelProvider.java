package net.binarybandit.firposfantasticfeatures.datagen;

import net.binarybandit.firposfantasticfeatures.FirposFF;
import net.binarybandit.firposfantasticfeatures.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output,ExistingFileHelper existingFileHelper) {
        super(output, FirposFF.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.BLUESTONE.get());
        basicItem(ModItems.CHISEL.get());
    }
}
