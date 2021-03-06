package me.rtgamingwdt.elemental.block;

import java.util.function.Supplier;
import me.rtgamingwdt.elemental.Elemental;
import me.rtgamingwdt.elemental.block.ore.*;
import me.rtgamingwdt.elemental.item.ItemInit;
import me.rtgamingwdt.elemental.item.ModCreativeModeTab;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
// import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            Elemental.MOD_ID);

    public static final RegistryObject<Block> FIRESTONE_ORE = registerBlock("firestone_ore",
            () -> new FirestoneOreBlock(BlockBehaviour.Properties.of(Material.STONE).strength(7f),
                    UniformInt.of(3, 7)));
    public static final RegistryObject<Block> LIGHTNINGSTONE_ORE = registerBlock("lightningstone_ore",
            () -> new LightningStoneOre(BlockBehaviour.Properties.of(Material.STONE).strength(8f),
                    UniformInt.of(3, 7)));
    public static final RegistryObject<Block> EARTHSTONE_ORE = registerBlock("earthstone_ore",
            () -> new EarthstoneOreBlock(BlockBehaviour.Properties.of(Material.STONE).strength(5f),
                    UniformInt.of(3, 7)));
    public static final RegistryObject<Block> ICESTONE_ORE = registerBlock("icestone_ore",
            () -> new IcestoneOreBlock(BlockBehaviour.Properties.of(Material.STONE).strength(5f), UniformInt.of(3, 7)));

    // private static <T extends Block>RegistryObject<T> registerBlock(String name,
    // Supplier<T> block, CreativeModeTab tab) {
    // RegistryObject<T> toReturn = BLOCKS.register(name, block);
    // registerBlockItem(name, toReturn, tab);
    // return toReturn;
    // }

    // private static <T extends Block> void registerBlockItem(String name,
    // RegistryObject<T> block, CreativeModeTab tab) {
    // ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), new
    // Item.Properties().tab(ModCreativeModeTab.ELEMENTAL_TAB)));
    // }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ItemInit.ITEMS.register(name,
                () -> new BlockItem(block.get(), new Item.Properties().tab(ModCreativeModeTab.ELEMENTAL_TAB)));
    }

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
