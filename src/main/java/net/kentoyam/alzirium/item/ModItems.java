package net.kentoyam.alzirium.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kentoyam.alzirium.Alzirium;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public final class ModItems {
    public static final Item PRISMARINE_ROD = registerItem("prismarine_rod", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Alzirium.MOD_ID, "prismarine_rod")))));
    public static final Item PRISMARINE_TINE = registerItem("prismarine_tine", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Alzirium.MOD_ID, "prismarine_tine")))));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Alzirium.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Alzirium.LOGGER.info("Mod Items registering, hopefully");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(ModItems.PRISMARINE_ROD);
            entries.add(ModItems.PRISMARINE_TINE);
        });
    }
}