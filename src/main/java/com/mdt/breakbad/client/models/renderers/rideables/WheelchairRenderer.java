package com.mdt.breakbad.client.models.renderers.rideables;

import com.mdt.breakbad.BreakBad;
import com.mdt.breakbad.client.models.entities.rideables.WheelchairModel;
import com.mdt.breakbad.common.entities.rideables.WheelchairEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class WheelchairRenderer extends MobRenderer<WheelchairEntity, WheelchairModel<WheelchairEntity>> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(BreakBad.MODID, "textures/entities/rideables/wheelchair.png");
    public WheelchairRenderer(EntityRendererProvider.Context context) {
        super(context, new WheelchairModel<>(context.bakeLayer(WheelchairModel.LAYER_LOCATION)), 0.5f);
    }


    @Override
    public void render(WheelchairEntity p_115308_, float p_115309_, float p_115310_, PoseStack p_115311_, MultiBufferSource p_115312_, int p_115313_) {
        super.render(p_115308_, p_115309_, p_115310_, p_115311_, p_115312_, p_115313_);
    }

    @Override
    public ResourceLocation getTextureLocation(WheelchairEntity p_114482_) {
        return TEXTURE;
    }
}
