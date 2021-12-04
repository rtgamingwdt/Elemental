package me.rtgamingwdt.elemental.world.gen;

import java.util.Random;

import me.rtgamingwdt.elemental.block.BlockInit;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.util.Lazy;

public enum OverworldOreType {

    EARTHSTONE(Lazy.of(BlockInit.EARTHSTONE_ORE), "earthstone_ore", 4, 8, 25, 50),
    FIRESTONE(Lazy.of(BlockInit.FIRESTONE_ORE), "firestone_ore", 4, 8, 25, 50),
    ICESTONE(Lazy.of(BlockInit.ICESTONE_ORE), "icestone_ore", 4, 8, 25, 50),
    LIGHTNINGSTONE(Lazy.of(BlockInit.LIGHTNINGSTONE_ORE), "lightningstone_ore", 4, 8, 25, 50);

    private final Lazy<Block> block;
    private final String name;
    private final int minVeinSize;
    private final int maxVeinSize;
    private final int minHeight;
    private final int maxHeight;

    OverworldOreType(Lazy<Block> block, String name, int minVeinSize, int maxVeinSize, int minHeight, int maxHeight) {
        this.name = name;
        this.block = block;
        this.minVeinSize = minVeinSize;
        this.maxVeinSize = maxVeinSize;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }

    public Lazy<Block> getBlock() {
        return block;
    }

    public String getName() {
        return name;
    }

    public int getMinVeinSize() {
        return minVeinSize;
    }

    public int getMaxVeinSize() {
        return maxVeinSize;
    }

    public int getVeinSize() {
        try {
            return new Random().nextInt(maxVeinSize - minVeinSize) + minVeinSize;
        } catch (IllegalArgumentException exception) {
            return maxVeinSize;
        }
    }

    public int getMinHeight() {
        return minHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public int getHeight() {
        try {
            return new Random().nextInt(maxHeight - minHeight) + minHeight;
        } catch (IllegalArgumentException exception) {
            return minHeight;
        }
    }

    public static OverworldOreType get(Block block) {
        for (OverworldOreType ore : values()) {
            if (block == ore.block) {
                return ore;
            }
        }
        return null;
    }
}