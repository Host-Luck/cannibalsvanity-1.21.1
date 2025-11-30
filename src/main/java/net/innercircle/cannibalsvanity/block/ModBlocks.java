package net.innercircle.cannibalsvanity.block;

import net.innercircle.cannibalsvanity.CannibalsVanity;
import net.innercircle.cannibalsvanity.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(CannibalsVanity.MOD_ID);

    public static final DeferredBlock<Block> TOUGHFLESH_BLOCK = registerBlock("toughflesh_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.WET_SPONGE)
                    .strength(1.5f)));
    public static final DeferredBlock<Block> CORPSE_BLOCK = registerBlock("corpse_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.FUNGUS)
                    .strength(2f)));

    public static final DeferredBlock<StairBlock> CORPSE_STAIRS = registerBlock("corpse_stairs",
            () -> new StairBlock(ModBlocks.CORPSE_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2f)));
    public static final DeferredBlock<SlabBlock> CORPSE_SLAB = registerBlock("corpse_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2f)));

    public static final DeferredBlock<PressurePlateBlock> CORPSE_PRESSUREPLATE = registerBlock("corpse_pressureplate",
            () -> new PressurePlateBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(2f)));
    public static final DeferredBlock<ButtonBlock> CORPSE_BUTTON = registerBlock("corpse_button",
            () -> new ButtonBlock(BlockSetType.IRON, 100, BlockBehaviour.Properties.of().strength(2f).noCollission()));

    public static final DeferredBlock<FenceBlock> CORPSE_FENCE = registerBlock("corpse_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(2f)));
    public static final DeferredBlock<FenceGateBlock> CORPSE_GATE = registerBlock("corpse_gate",
            () -> new FenceGateBlock(WoodType.WARPED,BlockBehaviour.Properties.of().strength(2f)));
    public static final DeferredBlock<WallBlock> CORPSE_WALL = registerBlock("corpse_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(2f)));

    public static final DeferredBlock<DoorBlock> CORPSE_DOOR = registerBlock("corpse_door",
            () -> new DoorBlock(BlockSetType.WARPED, BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final DeferredBlock<TrapDoorBlock> CORPSE_TRAPDOOR = registerBlock("corpse_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.WARPED, BlockBehaviour.Properties.of().strength(2f).noOcclusion()));



    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
