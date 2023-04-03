package com.mdt.breakbad.networking.packets;

import com.mdt.breakbad.common.blockentities.BunsenBurnerTile;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class UpdateBunsenBurnerS2CPacket {

    private BlockPos pos;
    private int liquidLevel;
    private boolean hasCandle, isLit;
    public boolean messageIsValid;

    public UpdateBunsenBurnerS2CPacket(BlockPos pos, int liquidLevel, boolean hasCandle, boolean isLit) {
        this.pos = pos;
        this.hasCandle = hasCandle;
        this.isLit = isLit;
        this.liquidLevel = liquidLevel;
        this.messageIsValid = true;
        System.out.println("Update Packet: | POS: " + this.pos + " | hasCandle: " + this.hasCandle + " | isLit: " + this.isLit + " | liquidLevel: " + this.liquidLevel);
    }

    public UpdateBunsenBurnerS2CPacket() {
        this.messageIsValid = false;
    }


    public static UpdateBunsenBurnerS2CPacket decode(FriendlyByteBuf buf) {
        UpdateBunsenBurnerS2CPacket bunsenPacket = new UpdateBunsenBurnerS2CPacket();
        try {
            BlockPos pos = buf.readBlockPos();
            int liquidLevel = buf.readInt();
            boolean hasCandle = buf.readBoolean();
            boolean isLit = buf.readBoolean();

            bunsenPacket.pos = pos;
            bunsenPacket.liquidLevel = liquidLevel;
            bunsenPacket.hasCandle = hasCandle;
            bunsenPacket.isLit = isLit;

        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            System.out.println("Exception while reading Packet: " + e);
            return bunsenPacket;
        }
        bunsenPacket.messageIsValid = true;
        return bunsenPacket;
    }

    public void encode(FriendlyByteBuf buf) {
        if (!this.messageIsValid) return;
        buf.writeBlockPos(this.pos);
        buf.writeInt(this.liquidLevel);
        buf.writeBoolean(this.hasCandle);
        buf.writeBoolean(this.isLit);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // Make sure it's only executed on the physical client
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
                Level level = context.getSender().getLevel();
                if (level != null) {
                    BunsenBurnerTile tile = (BunsenBurnerTile) level.getBlockEntity(this.pos);
                    if (tile != null) {
                        tile.hasCandle = this.hasCandle;
                        tile.liquidLevel = this.liquidLevel;
                        System.out.println(tile);
                    }
                }
            });
        });
        return true;
    }
}
