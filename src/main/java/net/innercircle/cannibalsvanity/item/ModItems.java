package net.innercircle.cannibalsvanity.item;

import net.innercircle.cannibalsvanity.CannibalsVanity;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CannibalsVanity.MOD_ID);

    public static final DeferredItem<Item> TOUGHFLESH = ITEMS.register("toughflesh",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TOUGHBONE = ITEMS.register("toughbone",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
