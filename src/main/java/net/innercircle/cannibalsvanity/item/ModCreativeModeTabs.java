package net.innercircle.cannibalsvanity.item;

import net.innercircle.cannibalsvanity.CannibalsVanity;
import net.innercircle.cannibalsvanity.block.ModBlocks;
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
                    }).build());

    public static final Supplier<CreativeModeTab> CANNIBALS_BLOCKS_TAB = CREATIVE_MODE_TAB.register("cannibals_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.TOUGHFLESH_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(CannibalsVanity.MOD_ID, "cannibals_items_tab"))
                    .title(Component.translatable("creativetab.cannibalsvanity.cannibals_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.TOUGHFLESH_BLOCK);
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
