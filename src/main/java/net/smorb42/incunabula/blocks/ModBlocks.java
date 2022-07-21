package net.smorb42.incunabula.blocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.smorb42.incunabula.Incunabula;
import net.smorb42.incunabula.items.ModItemGroup;
import net.smorb42.incunabula.world.feature.tree.HawthornSaplingGenerator;

import javax.annotation.Nullable;
import java.util.List;

public class ModBlocks {
    public static final Block VAT_BLOCK = registerBlock("vat_block",
            new VatBlock( FabricBlockSettings.copy(Blocks.IRON_BLOCK).nonOpaque() ),
            ModItemGroup.INCUNABULA, "tooltip.incunabula.vat");

    public static final Block VAT_CORE = registerBlock("vat_core",
            new Block( FabricBlockSettings.copy(Blocks.IRON_BLOCK).nonOpaque()),
            ModItemGroup.INCUNABULA, "tooltip.incunabula.vat");
    public static final Block HAWTHORN_SAPLING = registerBlock("hawthorn_sapling",
            new ModSaplingBlock(new HawthornSaplingGenerator(), FabricBlockSettings.copy(Blocks.OAK_SAPLING)),
            ModItemGroup.INCUNABULA, "tooltip.incunabula.hawthorn_sapling");

    public static final Block HAWTHORN_PLANKS = registerBlock("hawthorn_planks",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()),
            ModItemGroup.INCUNABULA, "tooltip.incunabula.hawthorn_planks");

    public static final Block HAWTHORN_LOG = registerBlock("hawthorn_log",
            new PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(4f).requiresTool()),
            ModItemGroup.INCUNABULA, "tooltip.incunabula.hawthorn_log");

    public static final Block HAWTHORN_LEAVES = registerBlock("hawthorn_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES).nonOpaque()),
            ModItemGroup.INCUNABULA, "tooltip.incunabula.hawthorn_leaves");


    public static final Block SERPENTINITE = registerBlock("serpentinite",
            new Block(FabricBlockSettings.of(Material.STONE).strength(6f).requiresTool()),
            ModItemGroup.INCUNABULA, "tooltip.incunabula.serpentinite");

    public static final Block POLISHED_SERPENTINITE = registerBlock("polished_serpentinite",
            new Block(FabricBlockSettings.of(Material.STONE).strength(6f).requiresTool()),
            ModItemGroup.INCUNABULA, "tooltip.incunabula.polished_serpentinite");

    private static Block registerBlock(String name, Block block, ItemGroup group, String tooltipKey) {
        registerBlockItem(name, block, group, tooltipKey);
        return Registry.register(Registry.BLOCK, new Identifier(Incunabula.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group, String tooltipKey) {
        return Registry.register(Registry.ITEM, new Identifier(Incunabula.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)) {
                    @Override
                    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                        tooltip.add(Text.translatable(tooltipKey).formatted(Formatting.ITALIC,Formatting.GRAY));
                    }
                });
    }

    private static Block registerBlockWithoutBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.BLOCK, new Identifier(Incunabula.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(Incunabula.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(Incunabula.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks() {
        Incunabula.LOGGER.info("Registering ModBlocks for " + Incunabula.MOD_ID);
    }
}
