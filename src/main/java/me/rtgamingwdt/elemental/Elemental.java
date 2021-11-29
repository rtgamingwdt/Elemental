package me.rtgamingwdt.elemental;

// import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
// import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import me.rtgamingwdt.elemental.block.BlockInit;
import me.rtgamingwdt.elemental.item.ItemInit;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(Elemental.MOD_ID)
public class Elemental {
    // Directly reference a log4j logger.
    // private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "elemental";

    public Elemental() {
        
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemInit.register(bus);
        BlockInit.register(bus);

        // bus.addListener(this::setup);
        // MinecraftForge.EVENT_BUS.register(this);  
    }

    // private void setup(final FMLCommonSetupEvent event) {
    //     LOGGER.info("HELLO FROM PREINIT");
    //     LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    // }
}
