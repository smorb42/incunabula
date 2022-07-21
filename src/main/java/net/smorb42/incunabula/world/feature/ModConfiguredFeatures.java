package net.smorb42.incunabula.world.feature;

import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.smorb42.incunabula.Incunabula;
import net.smorb42.incunabula.blocks.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> HAWTHORN_TREE =
            ConfiguredFeatures.register("hawthorn_tree", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(ModBlocks.HAWTHORN_LOG),
                    new StraightTrunkPlacer(5, 6, 3),
                    BlockStateProvider.of(ModBlocks.HAWTHORN_LEAVES),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 4),
                    new TwoLayersFeatureSize(1, 0, 2)).build());

    public static final RegistryEntry<PlacedFeature> HAWTHORN_CHECKED =
            PlacedFeatures.register("hawthorn_checked", HAWTHORN_TREE,
                    PlacedFeatures.wouldSurvive(ModBlocks.HAWTHORN_SAPLING));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> HAWTHORN_SPAWN =
            ConfiguredFeatures.register("hawthorn_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(new RandomFeatureEntry(HAWTHORN_CHECKED, 0.5f)),
                            HAWTHORN_CHECKED));


    public static void registerConfiguredFeatures() {
        System.out.println("Registering ModConfiguredFeatures for " + Incunabula.MOD_ID);
    }
}
