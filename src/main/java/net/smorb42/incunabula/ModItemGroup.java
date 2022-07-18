package net.smorb42.incunabula;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup INCUNABULA = FabricItemGroupBuilder.build(new Identifier(Incunabula.MOD_ID, "incunabula"),
            () -> new ItemStack(ModItems.MYTHRIL_INGOT));
}
