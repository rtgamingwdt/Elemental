package me.rtgamingwdt.elemental.item;

import me.rtgamingwdt.elemental.Elemental;
import me.rtgamingwdt.elemental.item.custom.FireSwordItem;
import net.minecraft.world.item.*;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
    
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Elemental.MOD_ID);

    //TODO Obtain Demonite from killing gods or demons.
    public static final RegistryObject<Item> DEMONITE = ITEMS.register("demonite", 
    () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ELEMENTAL_TAB)));
    public static final RegistryObject<Item> EARTHSTONE = ITEMS.register("earthstone", 
    () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ELEMENTAL_TAB)));

    public static final RegistryObject<Item> ICESTONE = ITEMS.register("icestone", 
    () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ELEMENTAL_TAB)));
    public static final RegistryObject<Item> LIGHTNINGSTONE = ITEMS.register("lightningstone", 
    () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ELEMENTAL_TAB)));

    // Firestone Items
    public static final RegistryObject<Item> FIRESTONE = ITEMS.register("firestone",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ELEMENTAL_TAB).fireResistant()));

    public static final RegistryObject<Item> FIRESTONE_SWORD = ITEMS.register("firestone_sword",
            () -> new FireSwordItem(ModTiers.FIRESTONE, 2, 3f,
                    new Item.Properties().tab(ModCreativeModeTab.ELEMENTAL_TAB).fireResistant()));
    public static final RegistryObject<Item> FIRESTONE_AXE = ITEMS.register("firestone_axe",
            () -> new AxeItem(ModTiers.FIRESTONE, 3, 4f,
                    new Item.Properties().tab(ModCreativeModeTab.ELEMENTAL_TAB).fireResistant()));
    public static final RegistryObject<Item> FIRESTONE_HOE = ITEMS.register("firestone_hoe",
            () -> new HoeItem(ModTiers.FIRESTONE, 0, 1f,
                    new Item.Properties().tab(ModCreativeModeTab.ELEMENTAL_TAB).fireResistant()));
    public static final RegistryObject<Item> FIRESTONE_PICKAXE = ITEMS.register("firestone_pickaxe",
            () -> new PickaxeItem(ModTiers.FIRESTONE, 0, -1f,
                    new Item.Properties().tab(ModCreativeModeTab.ELEMENTAL_TAB).fireResistant()));
    public static final RegistryObject<Item> FIRESTONE_SHOVEL = ITEMS.register("firestone_shovel",
            () -> new ShovelItem(ModTiers.FIRESTONE, 0, -1f,
                    new Item.Properties().tab(ModCreativeModeTab.ELEMENTAL_TAB).fireResistant()));




    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
