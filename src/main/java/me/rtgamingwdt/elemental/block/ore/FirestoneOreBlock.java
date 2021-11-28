package me.rtgamingwdt.elemental.block.ore;

import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockState;

public class FirestoneOreBlock extends OreBlock {

    private final UniformInt xpRange;

    public FirestoneOreBlock(Properties properties, UniformInt uniformInt) {
        super(properties);
        this.xpRange = uniformInt;
    }
    
    @Override
    public int getExpDrop(BlockState state, LevelReader reader, BlockPos pos, int fortune, int silktouch) {
        return silktouch == 0 ? this.xpRange.sample(RANDOM) : 0;
    }
}
