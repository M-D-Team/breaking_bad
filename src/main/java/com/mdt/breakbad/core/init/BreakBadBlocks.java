package com.mdt.breakbad.core.init;

import com.mdt.breakbad.BREAKBAD;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class BreakBadBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BREAKBAD.MOD_ID);
    public static final RegistryObject<Block> BARREL = registerBlock("barrel", () -> new Block(Block.Properties.of(Material.METAL).harvestLevel(2).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops()),BreakBadItemGroup.BREAKING_BAD_TAB);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block,ItemGroup tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name,toReturn,tab);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, ItemGroup tab) {
        BreakBadItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
