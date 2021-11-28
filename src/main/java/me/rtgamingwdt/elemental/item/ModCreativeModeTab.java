package me.rtgamingwdt.elemental.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {

    public static final CreativeModeTab ELEMENTAL_TAB = new CreativeModeTab("elemental_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.DEMONITE.get());
        }
    };
}
