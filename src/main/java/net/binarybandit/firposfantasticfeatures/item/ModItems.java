package net.binarybandit.firposfantasticfeatures.item;

import net.binarybandit.firposfantasticfeatures.FirposFF;
import net.binarybandit.firposfantasticfeatures.item.custom.BlueCoalItem;
import net.binarybandit.firposfantasticfeatures.item.custom.ChiselItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FirposFF.MODID);

    public static final DeferredItem<Item> BLUESTONE = ITEMS.register("bluestone",
            () -> new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.firposfantasticfeatures.bluestone"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static final DeferredItem<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(1024)));

    public static final DeferredItem<Item> BLUE_APPLE = ITEMS.register("blue_apple",
            () -> new Item(new Item.Properties().food(ModFoodProperties.BLUE_APPLE)));

    public static final DeferredItem<Item> BLUE_COAL = ITEMS.register("blue_coal",
            () -> new BlueCoalItem(new Item.Properties(), 2048));

    public static void register(IEventBus evenbus) {
        ITEMS.register(evenbus);
    }
}
