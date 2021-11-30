package me.rtgamingwdt.elemental.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;

public class ModTiers {

    public static  final ForgeTier  FIRESTONE = new ForgeTier(5, 1000, 3f, 5f, 10, Tags.Blocks.NEEDS_GOLD_TOOL,
            () -> Ingredient.of(ItemInit.FIRESTONE.get()));
}
