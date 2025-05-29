package net.kentoyam.alzirium.block;

import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kentoyam.alzirium.Alzirium;
import net.kentoyam.alzirium.world.tree.ModSaplingGenerators;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class ModBlocks {
    public static final Block MAPLE_LOG = registerBlock("maple_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Alzirium.MOD_ID, "maple_log")))));
    public static final Block MAPLE_WOOD = registerBlock("maple_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Alzirium.MOD_ID, "maple_wood")))));
    public static final Block STRIPPED_MAPLE_LOG = registerBlock("stripped_maple_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Alzirium.MOD_ID, "stripped_maple_log")))));
    public static final Block STRIPPED_MAPLE_WOOD = registerBlock("stripped_maple_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Alzirium.MOD_ID, "stripped_maple_log")))));
    public static final Block MAPLE_PLANKS = registerBlock("maple_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_LOG).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Alzirium.MOD_ID, "maple_planks")))));
    public static final Block MAPLE_LEAVES = registerBlock("maple_leaves",
            new TintedParticleLeavesBlock(0.01f, AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Alzirium.MOD_ID, "maple_leaves")))))
    public static final Block MAPLE_SAPLING = registerBlock("maple_sapling",
            new SaplingBlock(ModSaplingGenerators.MAPLE, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Alzirium.MOD_ID, "maple_sapling")))));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Alzirium.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Alzirium.MOD_ID, name),
                new BlockItem(block, new Item.Settings()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Alzirium.MOD_ID, name))).useBlockPrefixedTranslationKey()));
    }

    public static void registerModBlocks() {
        Alzirium.LOGGER.info("blockregisterer300000");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.MAPLE_LOG);
        });
    }
}
