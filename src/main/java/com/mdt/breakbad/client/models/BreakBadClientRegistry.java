package com.mdt.breakbad.client.models;

import com.mdt.breakbad.BreakBad;
import com.mdt.breakbad.core.init.BreakBadEntities;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = BreakBad.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BreakBadClientRegistry {
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers renderers) {
//        Map<String, EntityRenderer<? extends Player>> skinMap = Minecraft.getInstance().getEntityRenderDispatcher().getSkinMap();
//        for (EntityRenderer<? extends Player> playerRenderer : skinMap.values()) {
//            ((PlayerRenderer) playerRenderer).addLayer(new GasMaskLayer<>((PlayerRenderer) playerRenderer));
//        }
        renderers.registerEntityRenderer(BreakBadEntities.FULMINATE.get(), ThrownItemRenderer::new);
    }
}
