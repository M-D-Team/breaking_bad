package com.mdt.breakbad.client.models.renderers.layers;

import com.mdt.breakbad.BREAKBAD;
import com.mdt.breakbad.client.models.cosmetics.GasMask;
import com.mdt.breakbad.common.items.GasMaskArmourItem;
import com.mdt.breakbad.core.init.BreakBadItems;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class GasMaskLayer<T extends LivingEntity, M extends EntityModel<T>> extends LayerRenderer<T, M> {

    public static final ResourceLocation GAS_MASK_LOCATION = new ResourceLocation(BREAKBAD.MOD_ID, "textures/cosmetics/gas_mask.png");

    private static final GasMask gasMask = new GasMask();


    public GasMaskLayer(IEntityRenderer<T, M> renderer) {
        super(renderer);
    }


    @Override
    public void render(MatrixStack pMatrixStack, IRenderTypeBuffer pBuffer, int pPackedLight, T pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTicks, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        pMatrixStack.pushPose();
        ItemStack gasItem = pLivingEntity.getItemBySlot(EquipmentSlotType.HEAD);
        if (gasItem.getItem() instanceof GasMaskArmourItem) {
            if (getParentModel() instanceof PlayerModel) {
                PlayerModel model = (PlayerModel) getParentModel();
                model.hat.visible = true;
                model.head.visible = true;
                model.head.translateAndRotate(pMatrixStack);
                model.hat.visible = false;
                model.head.visible = false;
            }
            IVertexBuilder vertexBuffer = pBuffer.getBuffer(RenderType.entityTranslucent(GAS_MASK_LOCATION));
            this.gasMask.renderToBuffer(pMatrixStack, vertexBuffer, pPackedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1.0F);
        }
        pMatrixStack.popPose();
    }
    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return GAS_MASK_LOCATION;
    }
}