package net.binarybandit.firposfantasticfeatures.datagen;

import net.binarybandit.firposfantasticfeatures.block.ModBlocks;
import net.binarybandit.firposfantasticfeatures.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {

    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.BLUESTONE_BLOCK.get());
        dropSelf(ModBlocks.BLUE_GEM_BLOCK.get());
        dropSelf(ModBlocks.BLUEWOOD.get());
        dropSelf(ModBlocks.BLUEWOOD_STAIR.get());
        dropSelf(ModBlocks.BLUEWOOD_BUTTON.get());
        dropSelf(ModBlocks.BLUEWOOD_FENCE.get());
        dropSelf(ModBlocks.BLUEWOOD_FENCE_GATE.get());
        dropSelf(ModBlocks.BLUEWOOD_PRESSUREPLATE.get());
        dropSelf(ModBlocks.BLUEWOOD_TRAPDOOR.get());
        dropSelf(ModBlocks.BLUEWOOD_WALL.get());

        add(ModBlocks.BLUEWOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BLUEWOOD_SLAB.get()));

        add(ModBlocks.BLUEWOOD_DOOR.get(),
                block -> createDoorTable(ModBlocks.BLUEWOOD_DOOR.get()));

        add(ModBlocks.BLUESTONE_ORE.get(), block -> createMultipleOreDrops(ModBlocks.BLUESTONE_ORE.get(), ModItems.BLUESTONE.get(), 5f,10f));
    }

    protected LootTable.Builder createMultipleOreDrops(Block pblock, Item item, float minDrops, float maxDrop) {
        HolderLookup.RegistryLookup<Enchantment> registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pblock,
                this.applyExplosionDecay(pblock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrop)))
                        .apply(ApplyBonusCount.addOreBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
