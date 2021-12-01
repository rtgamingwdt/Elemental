package me.rtgamingwdt.elemental.event;

import me.rtgamingwdt.elemental.Elemental;
import me.rtgamingwdt.elemental.world.gen.OreGeneration;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = Elemental.MOD_ID, bus = Bus.MOD)
public class CommonModEvents {
    
    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(OreGeneration::generateOres);
    }
}
