package com.mdt.breakbad.client.models;

import com.mdt.breakbad.BreakBad;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.EntityRenderersEvent;

public class BreakBadModels {
    public static ModelLayerLocation GAS_MASK = new ModelLayerLocation(new ResourceLocation(BreakBad.MODID,"gas_mask"),"gas_mask");

    public static void addModels(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(GAS_MASK, GasMaskModel::createBodyLayer);
    }
}
