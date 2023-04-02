package com.mdt.breakbad.networking.packets;

import com.mdt.breakbad.common.entities.rideables.WheelchairEntity;
import net.minecraft.ChatFormatting;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class RingBellC2SPacket {

    public RingBellC2SPacket() {

    }

    public RingBellC2SPacket(FriendlyByteBuf buf) {

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
                if(wheelchair.hasBell()) {
                    level.playSound(null, player.getOnPos(), SoundEvents.ANVIL_PLACE, SoundSource.PLAYERS,
                            1, 2);
                    if(wheelchair.hasTNT()) {
                        wheelchair.explodeWheelchair(wheelchair);
                    }
                }
            }
        });
        return true;
    }
}