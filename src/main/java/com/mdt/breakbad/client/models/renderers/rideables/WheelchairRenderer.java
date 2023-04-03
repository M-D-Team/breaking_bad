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
        this.model = new WheelchairModel(context.bakeLayer(WheelchairModel.LAYER_LOCATION));
    }

    @Override
    public void render(WheelchairEntity p_115455_, float p_115456_, float p_115457_, PoseStack p_115458_, MultiBufferSource p_115459_, int p_115460_) {
        super.render(p_115455_, p_115456_, p_115457_, p_115458_, p_115459_, p_115460_);
    }

    @Override
    public ResourceLocation getTextureLocation(WheelchairEntity p_114482_) {
        return TEXTURE;
    }
}
