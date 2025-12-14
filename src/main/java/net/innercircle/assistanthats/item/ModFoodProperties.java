package net.innercircle.assistanthats.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;

public class ModFoodProperties {
    public static final FoodProperties COOKEDFLESH = new FoodProperties.Builder()
            .nutrition(6)
            .saturationModifier(1f)
            .usingConvertsTo(Items.BONE)
            .build();
}
