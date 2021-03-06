package me.rtgamingwdt.elemental.item.custom;

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
import java.util.Map;
import java.util.Objects;

public class FirePickaxeItem extends Item {
    private static final Map<Block, Item> canSmelt = new ImmutableMap.Builder<Block, Item>()
            // .put(ModBlocks.TITANIUM_BLOCK.get(), ModItems.TITANIUM_NUGGET.get())
            .put(Blocks.GOLD_ORE, Items.GOLD_INGOT)
            .put(Blocks.DEEPSLATE_GOLD_ORE, Items.GOLD_INGOT)
            .put(Blocks.NETHER_GOLD_ORE, Items.GOLD_INGOT)
            .put(Blocks.IRON_ORE, Items.IRON_INGOT)
            .put(Blocks.DEEPSLATE_IRON_ORE, Items.IRON_INGOT)
            .put(Blocks.COPPER_ORE, Items.COPPER_INGOT)
            .put(Blocks.DEEPSLATE_COPPER_ORE, Items.COPPER_INGOT)
            .put(Blocks.ANCIENT_DEBRIS, Items.NETHERITE_SCRAP)
            .build();

    public FirePickaxeItem(Properties pProperties) {
        super(pProperties);
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