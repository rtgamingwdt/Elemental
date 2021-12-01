package me.rtgamingwdt.elemental.event;

import me.rtgamingwdt.elemental.Elemental;
import me.rtgamingwdt.elemental.item.ItemInit;
import me.rtgamingwdt.elemental.world.gen.OreGeneration;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
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

    @SubscribeEvent
    public static void onHurt(LivingAttackEvent event) {
        if(event.getSource().getEntity() instanceof Player) {
            Player player = (Player) event.getSource().getEntity();
            if(player.getItemInHand(InteractionHand.MAIN_HAND) == new ItemStack(ItemInit.FIRESTONE_SWORD.get())) {
                //TODO add fire immunity with armor
                if(!(event.getEntity().isOnFire())) {
                    event.getEntityLiving().setSecondsOnFire(25);
                }
            }
        }
    }
}
