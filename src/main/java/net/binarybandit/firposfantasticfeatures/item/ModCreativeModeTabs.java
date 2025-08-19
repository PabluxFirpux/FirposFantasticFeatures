package net.binarybandit.firposfantasticfeatures.item;

import net.binarybandit.firposfantasticfeatures.FirposFF;
import net.binarybandit.firposfantasticfeatures.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FirposFF.MODID);

    public static final Supplier<CreativeModeTab> FIRPOSFF_TAB = CREATIVE_MODE_TAB.register("fff_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BLUESTONE.get())).title(Component.translatable("creativetab.firposfantasticfeatures.fff"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.BLUESTONE);
                        output.accept(ModBlocks.BLUESTONE_BLOCK);
                        output.accept(ModBlocks.BLUESTONE_ORE);
                        output.accept(ModItems.CHISEL);
                        output.accept(ModBlocks.BLUE_GEM_BLOCK);
                    }).build());

    public static void register(IEventBus bus) {
        CREATIVE_MODE_TAB.register(bus);
    }
}
