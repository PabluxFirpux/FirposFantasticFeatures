package net.binarybandit.firposfantasticfeatures.item;

import net.binarybandit.firposfantasticfeatures.FirposFF;
import net.binarybandit.firposfantasticfeatures.item.custom.BlueCoalItem;
import net.binarybandit.firposfantasticfeatures.item.custom.ChiselItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
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

    public static final DeferredItem<Item> BLUE_IRON_INGOT = ITEMS.register("blue_iron_ingot",
            () -> new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.firposfantasticfeatures.blue_iron_ingot"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static final DeferredItem<SwordItem> BLUE_IRON_SWORD = ITEMS.register("blue_iron_sword",
            () -> new SwordItem(ModToolTiers.BLUESTONE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.BLUESTONE, 3, -2.5f))));

    public static final DeferredItem<PickaxeItem> BLUE_IRON_PICKAXE = ITEMS.register("blue_iron_pickaxe",
            () -> new PickaxeItem(ModToolTiers.BLUESTONE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.BLUESTONE, 1.5f, -2.5f))));

    public static final DeferredItem<ShovelItem> BLUE_IRON_SHOVEL = ITEMS.register("blue_iron_shovel",
            () -> new ShovelItem(ModToolTiers.BLUESTONE, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.BLUESTONE, 1.5f, -2.5f))));

    public static final DeferredItem<AxeItem> BLUE_IRON_AXE = ITEMS.register("blue_iron_axe",
            () -> new AxeItem(ModToolTiers.BLUESTONE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.BLUESTONE, 6, -2.5f))));

    public static void register(IEventBus evenbus) {
        ITEMS.register(evenbus);
    }
}
