package com.mdt.breakbad.core.init;

import com.mdt.breakbad.BreakBad;
import com.mdt.breakbad.common.blockentities.BunsenBurnerTile;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BreakBadTiles {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, BreakBad.MODID);

    public static final RegistryObject<BlockEntityType<BunsenBurnerTile>> BUNSEN_BURNER_TILE =
            BLOCK_ENTITIES.register("bunsen_burner", () ->
                    BlockEntityType.Builder.of(BunsenBurnerTile::new, BreakBadBlocks.BUNSEN_BURNER.get()).build(null));
}