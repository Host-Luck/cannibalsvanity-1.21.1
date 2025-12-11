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

    public static final DeferredItem<ArmorItem> CORPSE_HELMET = ITEMS.register("corpse_helmet",
            () -> new ArmorItem(ModArmorMaterials.CORPSE_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(40))));
    public static final DeferredItem<ArmorItem> CORPSE_CHESTPLATE = ITEMS.register("corpse_chestplate",
            () -> new ArmorItem(ModArmorMaterials.CORPSE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(40))));
    public static final DeferredItem<ArmorItem> CORPSE_LEGGINGS = ITEMS.register("corpse_leggings",
            () -> new ArmorItem(ModArmorMaterials.CORPSE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(40))));
    public static final DeferredItem<ArmorItem> CORPSE_BOOTS = ITEMS.register("corpse_boots",
            () -> new ArmorItem(ModArmorMaterials.CORPSE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(40))));

    public static final DeferredItem<ArmorItem> BONE_HELMET = ITEMS.register("bone_helmet",
            () -> new ArmorItem(ModArmorMaterials.BONE_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(25))));
    public static final DeferredItem<ArmorItem> BONE_CHESTPLATE = ITEMS.register("bone_chestplate",
            () -> new ArmorItem(ModArmorMaterials.BONE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(25))));
    public static final DeferredItem<ArmorItem> BONE_LEGGINGS = ITEMS.register("bone_leggings",
            () -> new ArmorItem(ModArmorMaterials.BONE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(25))));
    public static final DeferredItem<ArmorItem> BONE_BOOTS = ITEMS.register("bone_boots",
            () -> new ArmorItem(ModArmorMaterials.BONE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(25))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
