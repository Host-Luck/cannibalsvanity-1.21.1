package net.innercircle.assistanthats.item;

import net.innercircle.assistanthats.AssistantHats;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;

import java.util.EnumMap;
import java.util.List;

public class ModArmorMaterials {

    public static final Holder<ArmorMaterial> ASSISTANT_ARMOR_MATERIAL = register("assistant",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.HELMET, 9);
            }), 16, 4f, 0.8f);

    private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.type, Integer> typeProtection,
                                                  int enchantibility, float toughness, float knockbackResistance) {
        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(AssistantHats.MOD_ID, name);
        Holder<SoundEvent> equipSound = SoundEvents.ARMOR_EQUIP_LEATHER;
        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(location));

        EnumMap<ArmorItem.Type, Integer> typeMap = new EnumMap<>(ArmorItem.Type.class);
        for (ArmorItem.Type type : ArmorItem.Type.values()) {
            typeMap.put(type, typeProtection.get(type));
        }

        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, location,
                new ArmorMaterial(typeProtection, enchantibility, equipSound, layers, toughness, knockbackResistance));
    }
}
