package com.mdt.breakbad.common.blockentities;

import com.mdt.breakbad.core.init.BreakBadTiles;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BunsenBurnerTile extends BlockEntity {
//    public int liquidLevel = 0;
    public BunsenBurnerTile(BlockPos p_155229_, BlockState p_155230_) {
        super(BreakBadTiles.BUNSEN_BURNER_TILE.get(), p_155229_, p_155230_);
    }

//    public int getLiquidLevel() {
//        return this.liquidLevel;
//    }
//
//    public void updateLiquidLevel() {
//        this.liquidLevel++;
//        if (this.liquidLevel > 7) {this.liquidLevel = 0;}
//    }

    public void tick() {

    }
}
