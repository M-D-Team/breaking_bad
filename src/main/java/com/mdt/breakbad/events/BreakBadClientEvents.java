package com.mdt.breakbad.events;

import com.mdt.breakbad.BreakBad;
import com.mdt.breakbad.client.models.entities.HumanoidEntityModel;
import com.mdt.breakbad.client.models.renderers.HumanoidEntityRenderer;
import com.mdt.breakbad.core.init.BreakBadEntities;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
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
    }

    @SubscribeEvent
    public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(HumanoidEntityModel.LAYER_LOCATION,HumanoidEntityModel::createBodyLayer);
    }
}
