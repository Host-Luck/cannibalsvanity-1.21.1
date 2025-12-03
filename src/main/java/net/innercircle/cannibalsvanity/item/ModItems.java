package net.innercircle.cannibalsvanity.item;

import net.innercircle.cannibalsvanity.CannibalsVanity;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CannibalsVanity.MOD_ID);

    public static final DeferredItem<Item> TOUGHFLESH = ITEMS.register("toughflesh",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TOUGHBONE = ITEMS.register("toughbone",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SALT = ITEMS.register("salt",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> COOKEDFLESH = ITEMS.register("cookedflesh",
            () -> new Item(new Item.Properties().food(ModFoodProperties.COOKEDFLESH)));

    public static final DeferredItem<SwordItem> CORPSE_SWORD = ITEMS.register("corpse_sword",
            () -> new SwordItem(ModToolTiers.CORPSE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.CORPSE, 5, -3f))));

    public static final DeferredItem<PickaxeItem> CORPSE_PICKAXE = ITEMS.register("corpse_pickaxe",
            () -> new PickaxeItem(ModToolTiers.CORPSE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.CORPSE, 1, -2f))));

    public static final DeferredItem<ShovelItem> CORPSE_SHOVEL = ITEMS.register("corpse_shovel",
            () -> new ShovelItem(ModToolTiers.CORPSE, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.CORPSE, 1, -2f))));

    public static final DeferredItem<AxeItem> CORPSE_AXE = ITEMS.register("corpse_axe",
            () -> new AxeItem(ModToolTiers.CORPSE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.CORPSE, 10, -1f))));

    public static final DeferredItem<HoeItem> CORPSE_PLOW = ITEMS.register("corpse_plow",
            () -> new HoeItem(ModToolTiers.CORPSE, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.CORPSE, 1, -2f))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
