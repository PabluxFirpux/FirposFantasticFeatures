package net.binarybandit.firposfantasticfeatures.block;

import net.binarybandit.firposfantasticfeatures.FirposFF;
import net.binarybandit.firposfantasticfeatures.block.custom.BlueGemBlock;
import net.binarybandit.firposfantasticfeatures.block.custom.BluestoneLampBlock;
import net.binarybandit.firposfantasticfeatures.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(FirposFF.MODID);

    public static final DeferredBlock<Block> BLUESTONE_BLOCK = registerBlock("bluestone_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.BONE_BLOCK)));

    public static final DeferredBlock<Block> BLUE_GEM_BLOCK = registerBlock("blue_gem_block",
            () -> new BlueGemBlock(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST_CLUSTER)));

    public static final DeferredBlock<Block> BLUESTONE_ORE = registerBlock("bluestone_ore",
            () -> new DropExperienceBlock(UniformInt.of(3,6),BlockBehaviour.Properties.of()
                    .strength(5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> BLUEWOOD = registerBlock("bluewood",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1f).sound(SoundType.WOOD)));

    public static final DeferredBlock<StairBlock> BLUEWOOD_STAIR = registerBlock("bluewood_stair",
            () -> new StairBlock(ModBlocks.BLUEWOOD.get().defaultBlockState(), BlockBehaviour.Properties.of().strength(1f)));

    public static final DeferredBlock<SlabBlock> BLUEWOOD_SLAB = registerBlock("bluewood_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(1f)));

    public static final DeferredBlock<PressurePlateBlock> BLUEWOOD_PRESSUREPLATE = registerBlock("bluewood_pressureplate",
            () -> new PressurePlateBlock(BlockSetType.OAK ,BlockBehaviour.Properties.of().strength(1f)));

    public static final DeferredBlock<ButtonBlock> BLUEWOOD_BUTTON = registerBlock("bluewood_button",
            () -> new ButtonBlock(BlockSetType.OAK , 40 ,BlockBehaviour.Properties.of().strength(1f).noCollission()));

    public static final DeferredBlock<FenceBlock> BLUEWOOD_FENCE = registerBlock("bluewood_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(1f)));

    public static final DeferredBlock<FenceGateBlock> BLUEWOOD_FENCE_GATE = registerBlock("bluewood_fence_gate",
            () -> new FenceGateBlock(WoodType.OAK ,BlockBehaviour.Properties.of().strength(1f)));

    public static final DeferredBlock<WallBlock> BLUEWOOD_WALL = registerBlock("bluewood_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(1f)));

    public static final DeferredBlock<DoorBlock> BLUEWOOD_DOOR = registerBlock("bluewood_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().strength(1f).noOcclusion()));

    public static final DeferredBlock<TrapDoorBlock> BLUEWOOD_TRAPDOOR = registerBlock("bluewood_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().strength(1f).noOcclusion()));

    public static final DeferredBlock<Block> BLUESTONE_LAMP = registerBlock("bluestone_lamp",
            () -> new BluestoneLampBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().lightLevel(state -> state.getValue(BluestoneLampBlock.CLICKED) ? 15 : 0)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventbus) {
        BLOCKS.register(eventbus);
    }

}
