package com.mdt.breakbad.client.models.renderers;

import com.mdt.breakbad.BreakBad;
import com.mdt.breakbad.client.models.entities.HumanoidEntityModel;
import com.mdt.breakbad.common.entities.HumanoidEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class HumanoidEntityRenderer extends MobRenderer<HumanoidEntity, HumanoidEntityModel> {

    private static final ResourceLocation TEST_TEXTURE = new ResourceLocation(BreakBad.MODID,"textures/entities/humanoid/test.png");
    public ResourceLocation texture;

    public HumanoidEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new HumanoidEntityModel(context.bakeLayer(HumanoidEntityModel.LAYER_LOCATION)), 1f);
        this.texture = TEST_TEXTURE;
    }

    @Override
    public ResourceLocation getTextureLocation(HumanoidEntity entity) {
        return this.texture;
    }
}
