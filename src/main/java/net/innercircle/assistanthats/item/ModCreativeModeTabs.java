package net.innercircle.assistanthats.item;

import net.innercircle.assistanthats.CannibalsVanity;
import net.innercircle.assistanthats.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CannibalsVanity.MOD_ID);

    public static final Supplier<CreativeModeTab> CANNIBALS_ITEMS_TAB = CREATIVE_MODE_TAB.register("cannibals_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TOUGHFLESH.get()))
                    .title(Component.translatable("creativetab.cannibalsvanity.cannibals_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.TOUGHFLESH);
                        output.accept(ModItems.TOUGHBONE);
                        output.accept(ModItems.SALT);
                        output.accept(ModItems.COOKEDFLESH);

                        output.accept(ModItems.CORPSE_AXE);
                        output.accept(ModItems.CORPSE_SHOVEL);
                        output.accept(ModItems.CORPSE_PICKAXE);
                        output.accept(ModItems.CORPSE_PLOW);
                        output.accept(ModItems.CORPSE_SWORD);

                        output.accept(ModItems.BONE_HELMET);
                        output.accept(ModItems.BONE_CHESTPLATE);
                        output.accept(ModItems.BONE_LEGGINGS);
                        output.accept(ModItems.BONE_BOOTS);

                        output.accept(ModItems.CORPSE_HELMET);
                        output.accept(ModItems.CORPSE_CHESTPLATE);
                        output.accept(ModItems.CORPSE_LEGGINGS);
                        output.accept(ModItems.CORPSE_BOOTS);
                    }).build());

    public static final Supplier<CreativeModeTab> CANNIBALS_BLOCKS_TAB = CREATIVE_MODE_TAB.register("cannibals_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.TOUGHFLESH_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(CannibalsVanity.MOD_ID, "cannibals_items_tab"))
                    .title(Component.translatable("creativetab.cannibalsvanity.cannibals_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.TOUGHFLESH_BLOCK);

                        output.accept(ModBlocks.CORPSE_BLOCK);
                        output.accept(ModBlocks.CORPSE_STAIRS);
                        output.accept(ModBlocks.CORPSE_SLAB);
                        output.accept(ModBlocks.CORPSE_WALL);
                        output.accept(ModBlocks.CORPSE_FENCE);
                        output.accept(ModBlocks.CORPSE_GATE);
                        output.accept(ModBlocks.CORPSE_DOOR);
                        output.accept(ModBlocks.CORPSE_TRAPDOOR);
                        output.accept(ModBlocks.CORPSE_PRESSUREPLATE);
                        output.accept(ModBlocks.CORPSE_BUTTON);
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
