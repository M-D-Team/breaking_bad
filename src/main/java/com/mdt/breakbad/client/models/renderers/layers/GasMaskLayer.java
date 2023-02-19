package com.mdt.breakbad.client.models.renderers.layers;

import com.mdt.breakbad.BreakBad;
import com.mdt.breakbad.client.models.cosmetics.GasMaskModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexBuffer;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class GasMaskLayer<T extends LivingEntity, M extends EntityModel<T> & HeadedModel> extends RenderLayer<T, M> {
    public static final ResourceLocation GAS_MASK_LOCATION = new ResourceLocation(BreakBad.MODID, "textures/cosmetics/gas_mask.png");

    private static final GasMaskModel gasMask = new GasMaskModel();

    public GasMaskLayer(RenderLayerParent<T, M> p_117346_) {
        super(p_117346_);
    }


    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return GAS_MASK_LOCATION;
    }

    @Override
    public void render(PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight, T pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTicks, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        pMatrixStack.pushPose();
        ItemStack gasItem = pLivingEntity.getItemBySlot(EquipmentSlot.HEAD);
        if (gasItem.getItem() instanceof GasMaskArmourItem) {
            if (getParentModel() instanceof PlayerModel) {
                PlayerModel model = (PlayerModel) getParentModel();
                model.hat.visible = true;
                model.head.visible = true;
                model.head.translateAndRotate(pMatrixStack);
                model.hat.visible = false;
                model.head.visible = false;
            }
            VertexConsumer vertexBuffer = pBuffer.getBuffer(RenderType.entityTranslucent(GAS_MASK_LOCATION));
            this.gasMask.renderToBuffer(pMatrixStack, vertexBuffer, pPackedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1.0F);
        }
        pMatrixStack.popPose();
    }
}

