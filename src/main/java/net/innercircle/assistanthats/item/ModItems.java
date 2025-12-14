package net.innercircle.assistanthats.item;

import net.innercircle.assistanthats.AssistantHats;
import net.innercircle.assistanthats.AssistantHats;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(AssistantHats.MOD_ID);

    public static final DeferredItem<Item> GUESTT_HAT = ITEMS.register("guestt_hat",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<ArmorItem> CORPSE_HELMET = ITEMS.register("corpse_helmet",
            () -> new ArmorItem(ModArmorMaterials.ASSISTANT_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(40))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
