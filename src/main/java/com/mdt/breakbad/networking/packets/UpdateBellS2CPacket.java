//package com.mdt.breakbad.networking.packets;
//
//import com.mdt.breakbad.common.entities.rideables.WheelchairEntity;
//import net.minecraft.network.FriendlyByteBuf;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.fml.DistExecutor;
//import net.minecraftforge.network.NetworkEvent;
//
//import java.util.UUID;
//import java.util.function.Supplier;
//
//public class UpdateBellS2CPacket {
//    private UUID entityID;
//    private boolean newVal;
//    public boolean messageIsValid;
//
//    public UpdateBellS2CPacket(UUID ID, boolean newValue) {
//        this.entityID = ID;
//        this.newVal = newValue;
//        System.out.println("Update Packet: " + ID + " " + newValue);
//    }
//
//    public UpdateBellS2CPacket() {
//        this.messageIsValid = false;
//    }
//
//
//    public static UpdateBellS2CPacket decode(FriendlyByteBuf buf) {
//        UpdateBellS2CPacket bellPacket = new UpdateBellS2CPacket();
//        try {
//            UUID uuid = buf.readUUID();
//            boolean val = buf.readBoolean();
//
//            bellPacket.entityID = uuid;
//            bellPacket.newVal = val;
//            System.out.println("Decoded: " + uuid + " " + val);
//        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
//            System.out.println("Exception while reading Packet: " + e);
//            return bellPacket;
//        }
//        bellPacket.messageIsValid = true;
//        return bellPacket;
//    }
//
//    public void encode(FriendlyByteBuf buf) {
//        if (!this.messageIsValid) return;
//        buf.writeUUID(this.entityID);
//        buf.writeBoolean(this.newVal);
//    }
//
//    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
//        NetworkEvent.Context context = supplier.get();
//        context.enqueueWork(() -> {
//            // Make sure it's only executed on the physical client
//            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
//                WheelchairEntity entity = (WheelchairEntity) context.
//                entity.setBell(this.newVal);
//            });
//        });
//        return true;
//    }
//}
