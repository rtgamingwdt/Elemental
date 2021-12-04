package me.rtgamingwdt.elemental.world.gen;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import me.rtgamingwdt.elemental.Elemental;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

public class OreGeneration {

    private static final List<ConfiguredFeature<?, ?>> OVERWORLD_ORES = new ArrayList<>();
    // private static final List<ConfiguredFeature<?, ?>> END_ORES = new
    // ArrayList<>();
    // private static final List<ConfiguredFeature<?, ?>> NETHER_ORES = new
    // ArrayList<>();

    public static void generateOres() {
        for (OverworldOreType ore : OverworldOreType.values()) {
            BlockState state = ore.getBlock().get().defaultBlockState();
            int veinSize = ore.getVeinSize();
            int height = ore.getHeight();
            // TODO: Add deepslate texture
            ConfiguredFeature<?, ?> ORE = Feature.ORE
                    .configured(new OreConfiguration(List.of(
                            OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES,
                                    state),
                            OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES,
                                    state)),
                            veinSize))
                    .rangeUniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(height)).squared()
                    .count(veinSize);
            OVERWORLD_ORES.add(register(ore.getName(), ORE));
        }
    }

    private static <Config extends FeatureConfiguration> ConfiguredFeature<Config, ?> register(String name,
            ConfiguredFeature<Config, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(Elemental.MOD_ID, name),
                configuredFeature);
    }

    @Mod.EventBusSubscriber(modid = Elemental.MOD_ID, bus = Bus.FORGE)
    public static class ForgeBusSubscriber {
        @SubscribeEvent
        public static void biomeLoading(BiomeLoadingEvent event) {
            List<Supplier<ConfiguredFeature<?, ?>>> features = event.getGeneration()
                    .getFeatures(Decoration.UNDERGROUND_ORES);

            switch (event.getCategory()) {
                // case NETHER -> OreGeneration.NETHER_ORES.forEach(ore -> features.add(() ->
                // ore));
                // case THEEND -> OreGeneration.END_ORES.forEach(ore -> features.add(() ->
                // ore));
                default -> OreGeneration.OVERWORLD_ORES.forEach(ore -> features.add(() -> ore));
            }
        }
    }
}