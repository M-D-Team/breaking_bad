package com.mdt.breakbad.common.blockentities;

import com.mdt.breakbad.core.init.BreakBadTiles;
import com.mdt.breakbad.networking.Network;
import com.mdt.breakbad.networking.packets.UpdateBunsenBurnerS2CPacket;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BunsenBurnerTile extends BlockEntity {
    public int liquidLevel;
    public boolean hasCandle;
    public BunsenBurnerTile(BlockPos p_155229_, BlockState p_155230_) {
        super(BreakBadTiles.BUNSEN_BURNER_TILE.get(), p_155229_, p_155230_);
    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
        super.saveAdditional(nbt);
        nbt.putInt("liquidLevel", this.getLiquidLevel());
        nbt.putBoolean("hasCandle", this.hasCandle());
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        this.liquidLevel = nbt.getInt("liquidLevel");
        this.hasCandle = nbt.getBoolean("hasCandle");
    }

    public int getLiquidLevel() {
        return this.liquidLevel;
    }

    public void updateLiquidLevel() {
        this.liquidLevel++;
        if (this.liquidLevel > 7) {this.liquidLevel = 0;}
        System.out.println("Updated liquid level: " + this.liquidLevel + " | for client: " + this.level.isClientSide());
        this.updateClient();
    }

    /**
     * Sets the candle and updates the client.
     */
    public void setCandle(boolean value) {
        this.hasCandle = value;
        this.updateClient();
    }

    public void updateClient() {
        Network.sendToAll(new UpdateBunsenBurnerS2CPacket(this.getBlockPos(),this.getLiquidLevel(),this.hasCandle(),false));
    }

    public boolean hasCandle() {
        return this.hasCandle;
    }

    public void tick() {
//        System.out.println(this);
//        System.out.println("Liquid Level: " + this.getLiquidLevel() + " | for client: " + this.level.isClientSide);
    }
}
