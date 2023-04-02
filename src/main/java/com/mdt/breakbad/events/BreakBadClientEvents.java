package com.mdt.breakbad.events;

import com.google.common.collect.ImmutableMap;
import com.mdt.breakbad.BreakBad;
import com.mdt.breakbad.client.models.entities.HumanoidEntityModel;
import com.mdt.breakbad.client.models.renderers.HumanoidEntityRenderer;
import com.mdt.breakbad.client.models.renderers.tileentities.BunsenBurnerRenderer;
import com.mdt.breakbad.client.models.tileentities.BunsenBurner;
import com.mdt.breakbad.core.init.BreakBadEntities;
import com.mdt.breakbad.core.init.BreakBadTiles;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = BreakBad.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BreakBadClientEvents {

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers renderers) {

        //Entities
        renderers.registerEntityRenderer(BreakBadEntities.FULMINATE.get(), ThrownItemRenderer::new);
        renderers.registerEntityRenderer(BreakBadEntities.HUMANOID_ENTITY.get(), HumanoidEntityRenderer::new);
        renderers.registerEntityRenderer(BreakBadEntities.GUS_ENTITY.get(), HumanoidEntityRenderer::new);
        renderers.registerEntityRenderer(BreakBadEntities.JESSE_ENTITY.get(), HumanoidEntityRenderer::new);
        renderers.registerEntityRenderer(BreakBadEntities.JESSE_SUIT_ENTITY.get(), HumanoidEntityRenderer::new);
        renderers.registerEntityRenderer(BreakBadEntities.WALTER_ENTITY.get(), HumanoidEntityRenderer::new);
        renderers.registerEntityRenderer(BreakBadEntities.WALTER_SUIT_ENTITY.get(), HumanoidEntityRenderer::new);
        renderers.registerEntityRenderer(BreakBadEntities.LPH_WORKER_ENTITY.get(), HumanoidEntityRenderer::new);
        renderers.registerEntityRenderer(BreakBadEntities.SAUL_ENTITY.get(), HumanoidEntityRenderer::new);

        //Block entities
        renderers.registerBlockEntityRenderer(BreakBadTiles.BUNSEN_BURNER_TILE.get(), BunsenBurnerRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(BunsenBurner.LAYER_LOCATION, BunsenBurner::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(HumanoidEntityModel.LAYER_LOCATION,() -> LayerDefinition.create(PlayerModel.createMesh(CubeDeformation.NONE,true),64,64));
    }
}
