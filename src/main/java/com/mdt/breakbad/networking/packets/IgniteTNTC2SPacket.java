package com.mdt.breakbad.networking.packets;

import com.mdt.breakbad.common.entities.rideables.WheelchairEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class IgniteTNTC2SPacket {

    public IgniteTNTC2SPacket() {

    }

    public IgniteTNTC2SPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // HERE WE ARE ON THE SERVER!
            ServerPlayer player = context.getSender();
            ServerLevel level = player.getLevel();

            if(player.getVehicle() instanceof WheelchairEntity) {
                WheelchairEntity wheelchair = (WheelchairEntity) player.getVehicle();

                if (wheelchair.hasTNT()) {
                    wheelchair.explode();
                }
            }
        });
        return true;
    }
}