package net.kentoyam.alzirium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.kentoyam.alzirium.item.ModItems;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.client.data.TextureMap.pattern;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                createShaped(RecipeCategory.MISC, ModItems.PRISMARINE_TINE, 1)
                        .pattern("KO")
                        .pattern("LN")
                        .input('K', Items.PRISMARINE_SHARD)
                        .input('O', Items.PRISMARINE_CRYSTALS)
                        .input('L', Items.VERDANT_FROGLIGHT)
                        .input('N', Items.QUARTZ)
                        .criterion(hasItem(Items.PRISMARINE_SHARD), conditionsFromItem(Items.PRISMARINE_SHARD))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, ModItems.PRISMARINE_ROD, 1)
                        .pattern("H")
                        .pattern("H")
                        .input('H', Items.PRISMARINE_SHARD)
                        .criterion(hasItem(Items.PRISMARINE_SHARD), conditionsFromItem(Items.PRISMARINE_SHARD))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, Items.TRIDENT, 1)
                        .pattern("AAA")
                        .pattern(" B ")
                        .pattern(" B ")
                        .input('A', ModItems.PRISMARINE_TINE)
                        .input('B', ModItems.PRISMARINE_ROD)
                        .criterion(hasItem(Items.PRISMARINE_SHARD), conditionsFromItem(Items.PRISMARINE_SHARD))
                        .offerTo(exporter);
            }
        };
    }


    @Override
    public String getName() {
        return "TutorialMod Recipes";
    }
}