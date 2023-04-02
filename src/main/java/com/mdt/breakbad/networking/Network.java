package com.mdt.breakbad.networking;

import com.mdt.breakbad.BreakBad;
import com.mdt.breakbad.networking.packets.IgniteTNTC2SPacket;
import com.mdt.breakbad.networking.packets.RingBellC2SPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class Network {
    private static SimpleChannel INSTANCE;

    private static int packetId = 0;
    private static int id() {
        return packetId++;
    }

    public static void register() {
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(BreakBad.MODID, "messages"))
                .networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        INSTANCE = net;

        net.messageBuilder(RingBellC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(RingBellC2SPacket::new)
                .encoder(RingBellC2SPacket::toBytes)
                .consumerMainThread(RingBellC2SPacket::handle)
                .add();
        net.messageBuilder(IgniteTNTC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(IgniteTNTC2SPacket::new)
                .encoder(IgniteTNTC2SPacket::toBytes)
                .consumerMainThread(IgniteTNTC2SPacket::handle)
                .add();
    }

    public static <MSG> void sendToServer(MSG message) {
        INSTANCE.sendToServer(message);
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }
}