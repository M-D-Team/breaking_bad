package com.mdt.breakbad.common.blocks;

import com.mdt.breakbad.common.blockentities.BunsenBurnerTile;
import com.mdt.breakbad.core.init.BreakBadTiles;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class BunsenBurnerBlock extends BaseEntityBlock {

    public BunsenBurnerBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return level.isClientSide() ? null : ($0, $1, $2, blockEntity) -> {
            if(blockEntity instanceof BunsenBurnerTile) {
                BunsenBurnerTile burner = (BunsenBurnerTile) blockEntity;
                burner.tick();
            }
        };
    }


    @Override
    public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
        return BreakBadTiles.BUNSEN_BURNER_TILE.get().create(p_153215_, p_153216_);
    }
}
