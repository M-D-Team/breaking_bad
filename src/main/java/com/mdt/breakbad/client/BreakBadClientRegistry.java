package com.mdt.breakbad.client;


import com.mdt.breakbad.BREAKBAD;
import com.mdt.breakbad.client.models.renderers.layers.GasMaskLayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.Map;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = BREAKBAD.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BreakBadClientRegistry {

    @SubscribeEvent
    public static void register(FMLClientSetupEvent event) {
        Map<String, PlayerRenderer> skinMap = Minecraft.getInstance().getEntityRenderDispatcher().getSkinMap();
        for (PlayerRenderer renderPlayer : skinMap.values()) {
            renderPlayer.addLayer(new GasMaskLayer<>(renderPlayer));
        }
    }

}
