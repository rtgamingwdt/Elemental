package me.rtgamingwdt.elemental.item.custom;

import java.util.Map;
import java.util.Objects;

import com.google.common.collect.ImmutableMap;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class FireShovelItem extends Item {

    private static final Map<Block, Item> canSmelt = new ImmutableMap.Builder<Block, Item>()
            .put(Blocks.CLAY, Items.BRICK)
            .put(Blocks.SAND, Items.GLASS)
            .put(Blocks.GRAVEL, Items.FLINT)
            .build();

    public FireShovelItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (!pContext.getLevel().isClientSide()) {
            Level level = pContext.getLevel();
            BlockPos positionClicked = pContext.getClickedPos();
            Block blockClicked = level.getBlockState(positionClicked).getBlock();

            if (isSmeltable(blockClicked)) {
                ItemEntity entityItem = new ItemEntity(level,
                        positionClicked.getX(), positionClicked.getY(), positionClicked.getZ(),
                        new ItemStack(canSmelt.get(blockClicked), 1));

                level.destroyBlock(positionClicked, false);
                level.addFreshEntity(entityItem);
                pContext.getItemInHand().hurtAndBreak(1, Objects.requireNonNull(pContext.getPlayer()), p -> {
                    p.broadcastBreakEvent(pContext.getHand());
                });
            } else {
                pContext.getPlayer().sendMessage(new TextComponent("Cannot blow torch this Block!"),
                        Util.NIL_UUID);
            }
        }

        return InteractionResult.SUCCESS;
    }

    private boolean isSmeltable(Block block) {
        return canSmelt.containsKey(block);
    }
}
