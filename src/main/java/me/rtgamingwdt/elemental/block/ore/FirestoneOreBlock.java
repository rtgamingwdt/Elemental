package me.rtgamingwdt.elemental.block.ore;

import java.util.List;

import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext.Builder;

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

    @Override
    public List<ItemStack> getDrops(BlockState pState, Builder pBuilder) {
        return super.getDrops(pState, pBuilder);
    }
}
