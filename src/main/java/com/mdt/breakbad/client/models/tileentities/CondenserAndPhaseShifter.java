package com.mdt.breakbad.client.models.tileentities;// Made with Blockbench 4.6.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mdt.breakbad.BreakBad;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class CondenserAndPhaseShifter<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(BreakBad.MODID, "condenser"), "main");
	public final ModelPart arm;
	public final ModelPart stoppers;
	public final ModelPart flask;
	public final ModelPart holder;
	public final ModelPart candle;

	public CondenserAndPhaseShifter(ModelPart root) {
		this.arm = root.getChild("arm");
		this.stoppers = root.getChild("stoppers");
		this.flask = root.getChild("flask");
		this.holder = root.getChild("holder");
		this.candle = root.getChild("candle");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition arm = partdefinition.addOrReplaceChild("arm", CubeListBuilder.create(), PartPose.offset(-7.3904F, 19.767F, 0.0F));

		PartDefinition cube_r1 = arm.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(43, 35).addBox(-28.0F, -7.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(25, 13).addBox(-28.0F, -9.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(5.6576F, 4.0074F, 0.0F, 0.0F, 0.0F, 1.7017F));

		PartDefinition cube_r2 = arm.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 13).addBox(-27.375F, 0.25F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.25F))
		.texOffs(38, 35).addBox(-27.375F, -3.75F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.75F, 0.0F, 0.0F, 0.0F, 2.4871F));

		PartDefinition cube_r3 = arm.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(29, 35).addBox(-5.0F, -27.0F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(7.3904F, 3.483F, 0.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition stoppers = partdefinition.addOrReplaceChild("stoppers", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r4 = stoppers.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(43, 39).addBox(3.0F, -16.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, -0.75F, 0.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition cube_r5 = stoppers.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(43, 43).addBox(-5.0F, -16.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, -0.75F, 0.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition flask = partdefinition.addOrReplaceChild("flask", CubeListBuilder.create().texOffs(35, 10).addBox(-3.0F, -15.75F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(25, 20).addBox(-4.0F, -13.75F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-5.0F, -10.75F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(-0.25F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r6 = flask.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 28).addBox(-5.0F, -16.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.75F, 0.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition cube_r7 = flask.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(9, 28).addBox(3.0F, -16.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.75F, 0.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition one = flask.addOrReplaceChild("one", CubeListBuilder.create().texOffs(0, 13).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(-0.25F)), PartPose.offset(0.0F, -0.75F, 0.0F));

		PartDefinition two = flask.addOrReplaceChild("two", CubeListBuilder.create().texOffs(0, 13).addBox(-4.0F, -9.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(-0.25F)), PartPose.offset(0.0F, -0.75F, 0.0F));

		PartDefinition three = flask.addOrReplaceChild("three", CubeListBuilder.create().texOffs(0, 13).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(-0.25F)), PartPose.offset(0.0F, -0.75F, 0.0F));

		PartDefinition four = flask.addOrReplaceChild("four", CubeListBuilder.create().texOffs(0, 13).addBox(-4.0F, -11.0F, -4.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(-0.25F)), PartPose.offset(0.0F, -0.75F, 0.0F));

		PartDefinition five = flask.addOrReplaceChild("five", CubeListBuilder.create().texOffs(0, 13).addBox(-4.0F, -12.0F, -4.0F, 8.0F, 5.0F, 8.0F, new CubeDeformation(-0.25F)), PartPose.offset(0.0F, -0.75F, 0.0F));

		PartDefinition six = flask.addOrReplaceChild("six", CubeListBuilder.create().texOffs(0, 13).addBox(-4.0F, -13.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(-0.25F)), PartPose.offset(0.0F, -0.75F, 0.0F));

		PartDefinition holder = partdefinition.addOrReplaceChild("holder", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r8 = holder.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(31, 0).addBox(-7.0F, -9.0F, 0.0F, 14.0F, 9.0F, 0.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r9 = holder.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 35).addBox(-7.0F, -9.0F, 0.0F, 14.0F, 9.0F, 0.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition candle = partdefinition.addOrReplaceChild("candle", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 18.0F, 0.0F));

		PartDefinition cube_r10 = candle.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(7, 0).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r11 = candle.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(5, 13).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		stoppers.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		flask.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		holder.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		candle.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void render(PoseStack pPoseStack, VertexConsumer buffer, int lightLevel, int noOverlay, int i, int i1, int i2, int i3) {
		this.renderToBuffer(pPoseStack, buffer, lightLevel, lightLevel, 1, 1, 1, 1);
	}
}