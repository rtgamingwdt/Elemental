package me.rtgamingwdt.elemental.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;


public class FireSwordItem extends Item {

    public FireSwordItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.setRemainingFireTicks(500);
        return super.hurtEnemy(stack, target, attacker);
    }
}
