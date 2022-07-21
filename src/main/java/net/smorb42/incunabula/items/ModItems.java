package net.smorb42.incunabula.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.smorb42.incunabula.Incunabula;

public class ModItems {
    public static final Item TP_CRYSTAL = registerAnimated("tp_crystal",
            new BowItem(new FabricItemSettings().group(ModItemGroup.INCUNABULA).rarity(Rarity.UNCOMMON).fireproof().maxCount(1)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Incunabula.MOD_ID, name), item);
    }

    private static Item registerAnimated(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Incunabula.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Incunabula.LOGGER.info("Registering Mod Items for " + Incunabula.MOD_ID);
    }
}
