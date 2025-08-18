package net.binarybandit.firposfantasticfeatures.item;

import net.binarybandit.firposfantasticfeatures.FirposFF;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FirposFF.MODID);

    public static final DeferredItem<Item> BLUESTONE = ITEMS.register("bluestone",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus evenbus) {
        ITEMS.register(evenbus);
    }
}
