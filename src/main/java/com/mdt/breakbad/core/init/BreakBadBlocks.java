package com.mdt.breakbad.core.init;

import com.mdt.breakbad.BreakBad;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BreakBadBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BreakBad.MODID);

    public static final RegistryObject<Block> BARREL = register("barrel",() -> new Block(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops()), new Item.Properties());
    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> supplier, Item.Properties properties ){
        RegistryObject<T> block = BLOCKS.register(name, supplier);
        BreakBadItems.ITEMS.register(name, () -> new BlockItem(block.get(), properties));
        return block;
    }
}
