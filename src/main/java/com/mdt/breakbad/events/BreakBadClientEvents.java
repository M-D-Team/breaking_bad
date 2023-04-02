package com.mdt.breakbad.events;

import com.mdt.breakbad.BreakBad;
import com.mdt.breakbad.client.models.entities.HumanoidEntityModel;
import com.mdt.breakbad.client.models.entities.rideables.WheelchairModel;
import com.mdt.breakbad.client.models.renderers.HumanoidEntityRenderer;
import com.mdt.breakbad.client.models.renderers.rideables.WheelchairRenderer;
import com.mdt.breakbad.client.models.renderers.tileentities.BunsenBurnerRenderer;
import com.mdt.breakbad.client.models.tileentities.BunsenBurner;
import com.mdt.breakbad.common.entities.rideables.WheelchairEntity;
import com.mdt.breakbad.core.init.BreakBadEntities;
import com.mdt.breakbad.core.init.BreakBadTiles;
import com.mdt.breakbad.networking.Network;
import com.mdt.breakbad.networking.packets.IgniteTNTC2SPacket;
import com.mdt.breakbad.networking.packets.RingBellC2SPacket;
import com.mdt.breakbad.util.KeyBinding;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = BreakBad.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BreakBadClientEvents {

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers renderers) {
        // Items
        renderers.registerEntityRenderer(BreakBadEntities.FULMINATE.get(), ThrownItemRenderer::new);

        // Humanoids
        renderers.registerEntityRenderer(BreakBadEntities.HUMANOID_ENTITY.get(), HumanoidEntityRenderer::new);
        renderers.registerEntityRenderer(BreakBadEntities.GUS_ENTITY.get(), HumanoidEntityRenderer::new);
        renderers.registerEntityRenderer(BreakBadEntities.JESSE_ENTITY.get(), HumanoidEntityRenderer::new);
        renderers.registerEntityRenderer(BreakBadEntities.JESSE_SUIT_ENTITY.get(), HumanoidEntityRenderer::new);
        renderers.registerEntityRenderer(BreakBadEntities.WALTER_ENTITY.get(), HumanoidEntityRenderer::new);
        renderers.registerEntityRenderer(BreakBadEntities.WALTER_SUIT_ENTITY.get(), HumanoidEntityRenderer::new);
        renderers.registerEntityRenderer(BreakBadEntities.LPH_WORKER_ENTITY.get(), HumanoidEntityRenderer::new);
        renderers.registerEntityRenderer(BreakBadEntities.SAUL_ENTITY.get(), HumanoidEntityRenderer::new);
        renderers.registerEntityRenderer(BreakBadEntities.HECTOR_ENTITY.get(), HumanoidEntityRenderer::new);

        // Entities
        renderers.registerEntityRenderer(BreakBadEntities.WHEELCHAIR_ENTITY.get(), WheelchairRenderer::new);

        //Block entities
        renderers.registerBlockEntityRenderer(BreakBadTiles.BUNSEN_BURNER_TILE.get(), BunsenBurnerRenderer::new);
    }

    @Mod.EventBusSubscriber(modid = BreakBad.MODID, value = Dist.CLIENT)
    public static class ClientForgeEvents {

        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            if (KeyBinding.RING_BELL.consumeClick()) {
                Network.sendToServer(new RingBellC2SPacket());
            }
            if (KeyBinding.IGNITE_TNT.consumeClick()) {
                Network.sendToServer(new IgniteTNTC2SPacket());
            }
        }

    }

    @Mod.EventBusSubscriber(modid = BreakBad.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {

        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBinding.RING_BELL);
            event.register(KeyBinding.IGNITE_TNT);
        }

    }


    @SubscribeEvent
    public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(WheelchairModel.LAYER_LOCATION, WheelchairModel::createBodyLayer);
        event.registerLayerDefinition(BunsenBurner.LAYER_LOCATION, BunsenBurner::createBodyLayer);
        event.registerLayerDefinition(HumanoidEntityModel.LAYER_LOCATION,() -> LayerDefinition.create(PlayerModel.createMesh(CubeDeformation.NONE,true),64,64));
    }
}
