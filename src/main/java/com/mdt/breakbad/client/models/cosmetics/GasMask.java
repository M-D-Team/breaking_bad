package com.mdt.breakbad.client.models.cosmetics;// Made with Blockbench 4.6.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;


public class GasMask extends EntityModel<Entity> {
	private final ModelRenderer mask;

	public GasMask() {
		int textureWidth = 64;
		int textureHeight = 64;

		mask = new ModelRenderer(this);
		mask.setPos(0.0F, 24.0F, 0.0F);
		mask.texOffs(22, 23).addBox(-4.0F, -28.0F, -6.0F, 8.0F, 4.0F, 2.0F, 0.0F, false);
		mask.texOffs(0, 24).addBox(-3.0F, -32.0F, -6.0F, 6.0F, 1.0F, 2.0F, 0.0F, false);
		mask.texOffs(0, 12).addBox(-4.0F, -32.0F, -6.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);
		mask.texOffs(6, 12).addBox(-4.0F, -33.0F, 4.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		mask.texOffs(6, 4).addBox(3.0F, -33.0F, 4.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		mask.texOffs(13, 12).addBox(-4.0F, -33.0F, -6.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
		mask.texOffs(0, 0).addBox(4.0F, -28.0F, -6.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
		mask.texOffs(0, 12).addBox(-5.0F, -28.0F, -6.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
		mask.texOffs(13, 0).addBox(3.0F, -33.0F, -6.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
		mask.texOffs(0, 4).addBox(3.0F, -32.0F, -6.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);
		mask.texOffs(0, 0).addBox(-1.0F, -27.0F, -8.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		mask.texOffs(13, 3).addBox(-1.0F, -28.0F, -8.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		mask.texOffs(13, 0).addBox(-1.0F, -25.0F, -8.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		mask.texOffs(13, 12).addBox(-2.0F, -27.0F, -8.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		mask.texOffs(13, 6).addBox(1.0F, -27.0F, -8.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {

	}



	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		mask.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}