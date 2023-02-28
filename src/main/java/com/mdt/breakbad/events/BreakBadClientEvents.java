package com.mdt.breakbad.events;

import com.mdt.breakbad.BreakBad;
import com.mdt.breakbad.client.models.entities.HumanoidEntityModel;
import com.mdt.breakbad.client.models.renderers.HumanoidEntityRenderer;
import com.mdt.breakbad.core.init.BreakBadEntities;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = BreakBad.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BreakBadClientEvents {

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers renderers) {
        renderers.registerEntityRenderer(BreakBadEntities.FULMINATE.get(), ThrownItemRenderer::new);
        renderers.registerEntityRenderer(BreakBadEntities.HUMANOID_ENTITY.get(), HumanoidEntityRenderer::new);
        renderers.registerEntityRenderer(BreakBadEntities.GUS_ENTITY.get(), HumanoidEntityRenderer::new);
        renderers.registerEntityRenderer(BreakBadEntities.JESSE_ENTITY.get(), HumanoidEntityRenderer::new);
        renderers.registerEntityRenderer(BreakBadEntities.JESSE_SUIT_ENTITY.get(), HumanoidEntityRenderer::new);
        renderers.registerEntityRenderer(BreakBadEntities.WALTER_ENTITY.get(), HumanoidEntityRenderer::new);
        renderers.registerEntityRenderer(BreakBadEntities.WALTER_SUIT_ENTITY.get(), HumanoidEntityRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(HumanoidEntityModel.LAYER_LOCATION,() -> LayerDefinition.create(PlayerModel.createMesh(CubeDeformation.NONE,true),64,64));
    }
}
