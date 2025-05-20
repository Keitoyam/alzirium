package net.kentoyam.alzirium.world.tree;

import net.kentoyam.alzirium.Alzirium;
import net.kentoyam.alzirium.world.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator MAPLE = new SaplingGenerator(Alzirium.MOD_ID + ":maple",
            Optional.empty(), Optional.of(ModConfiguredFeatures.MAPLE_KEY), Optional.empty());
}
