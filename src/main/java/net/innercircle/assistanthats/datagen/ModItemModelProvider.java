package net.innercircle.assistanthats.datagen;

import net.innercircle.assistanthats.AssistantHats;
import net.innercircle.assistanthats.AssistantHats;
import net.innercircle.assistanthats.block.ModBlocks;
import net.innercircle.assistanthats.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1f);
        trimMaterials.put(TrimMaterials.IRON, 0.2f);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3f);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4f);
        trimMaterials.put(TrimMaterials.COPPER, 0.5f);
        trimMaterials.put(TrimMaterials.GOLD, 0.6f);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7f);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8f);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9f);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0f);
    }

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AssistantHats.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.TOUGHFLESH.get());
        basicItem(ModItems.COOKEDFLESH.get());
        basicItem(ModItems.TOUGHBONE.get());
        basicItem(ModItems.SALT.get());

        buttonItem(ModBlocks.CORPSE_BUTTON, ModBlocks.CORPSE_BLOCK);
        fenceItem(ModBlocks.CORPSE_FENCE, ModBlocks.CORPSE_BLOCK);
        wallItem(ModBlocks.CORPSE_WALL, ModBlocks.CORPSE_BLOCK);

        basicItem(ModBlocks.CORPSE_DOOR.asItem());

        handheldItem(ModItems.CORPSE_AXE);
        handheldItem(ModItems.CORPSE_SHOVEL);
        handheldItem(ModItems.CORPSE_SWORD);
        handheldItem(ModItems.CORPSE_PICKAXE);
        handheldItem(ModItems.CORPSE_PLOW);
    }

    private void trimmedArmorItem(DeferredItem<Item> itemDeferredItem) {
        final String MOD_ID = AssistantHats.MOD_ID;

        if(itemDeferredItem.get() instanceof ArmorItem armorItem) {
            trimMaterials.forEach((trimMaterial, value) -> {
                float trimValue = value;

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = armorItem.toString();
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();

            });
        }
    }

    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(AssistantHats.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(AssistantHats.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(AssistantHats.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(AssistantHats.MOD_ID, "item/" + item.getId().getPath()));
    }
}
