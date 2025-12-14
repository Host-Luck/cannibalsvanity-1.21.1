package net.innercircle.assistanthats.item.custom;

import com.mojang.serialization.MapCodec;

import static net.minecraft.world.level.block.state.BlockBehaviour.simpleCodec;

public class GuesttHat {
    public static final MapCodec<GuesttHat> CODEC = simpleCodec(GuesttHat::new);

    public GuesttHat()
}
