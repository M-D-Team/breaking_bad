package com.mdt.breakbad.client.models.renderers;

import com.ibm.icu.text.Normalizer;
import com.mdt.breakbad.BreakBad;
import com.mdt.breakbad.client.models.entities.HumanoidEntityModel;
import com.mdt.breakbad.common.entities.HumanoidEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class HumanoidEntityRenderer extends MobRenderer<HumanoidEntity, HumanoidEntityModel> {
    public HumanoidEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new HumanoidEntityModel(Minecraft.getInstance().getEntityModels().bakeLayer(HumanoidEntityModel.LAYER_LOCATION), false), 1f);
    }

    @Override
    public void render(HumanoidEntity entity, float p_115456_, float p_115457_, PoseStack matrixStack, MultiBufferSource p_115459_, int p_115460_) {
        matrixStack.pushPose();
        matrixStack.scale(0.9375F,0.9375F,0.9375F);
        super.render(entity, p_115456_, p_115457_, matrixStack, p_115459_, p_115460_);
        matrixStack.popPose();
    }

    @Override
    public ResourceLocation getTextureLocation(HumanoidEntity entity) {
        return entity.skin;
    }
}
