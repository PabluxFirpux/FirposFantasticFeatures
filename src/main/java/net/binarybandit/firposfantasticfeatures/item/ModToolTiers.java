package net.binarybandit.firposfantasticfeatures.item;

import net.binarybandit.firposfantasticfeatures.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier BLUESTONE = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_BLUESTONE_TOOL,
            850, 10f, 2.5f, 30, () -> Ingredient.of(ModItems.BLUESTONE));
}
