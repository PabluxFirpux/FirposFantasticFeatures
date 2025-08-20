package net.binarybandit.firposfantasticfeatures.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties BLUE_APPLE = new FoodProperties.Builder().nutrition(10).saturationModifier(1.25f).alwaysEdible()
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 10000, 4),1f)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 10000, 9),1f).build();
}
