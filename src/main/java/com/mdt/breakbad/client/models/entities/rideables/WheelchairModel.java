package com.mdt.breakbad.client.models.entities.rideables;// Made with Blockbench 4.6.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mdt.breakbad.BreakBad;
import com.mdt.breakbad.common.entities.rideables.WheelchairEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;

public class WheelchairModel<T extends WheelchairEntity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(BreakBad.MODID, "wheelchair"), "main");
	private final ModelPart body;

	public WheelchairModel(ModelPart root) {
		this.body = root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(47, 49).addBox(6.0F, -9.0F, -5.0F, 1.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-6.0F, -8.0F, -5.0F, 12.0F, 1.0F, 12.0F, new CubeDeformation(0.001F))
		.texOffs(49, 25).addBox(-7.0F, -21.0F, 7.0F, 14.0F, 13.0F, 0.0F, new CubeDeformation(0.001F))
		.texOffs(18, 15).addBox(5.0F, -11.0F, -6.0F, 2.0F, 0.0F, 13.0F, new CubeDeformation(0.001F))
		.texOffs(0, 14).addBox(-7.0F, -11.0F, -6.0F, 2.0F, 0.0F, 13.0F, new CubeDeformation(0.001F))
		.texOffs(0, 49).addBox(-7.0F, -9.0F, -5.0F, 1.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(28, 61).addBox(-6.5F, -11.0F, -5.0F, 0.0F, 2.0F, 12.0F, new CubeDeformation(0.001F))
		.texOffs(15, 52).addBox(6.5F, -11.0F, -5.0F, 0.0F, 2.0F, 12.0F, new CubeDeformation(0.001F))
		.texOffs(6, 3).addBox(2.0F, -21.0F, 7.1F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.001F))
		.texOffs(4, 0).addBox(2.0F, -21.0F, 7.1F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(6, 6).addBox(-3.0F, -21.0F, 7.1F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.001F))
		.texOffs(0, 0).addBox(-3.0F, -21.0F, 7.1F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bell = body.addOrReplaceChild("bell", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = bell.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 14).addBox(-7.25F, -12.5F, -4.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 19).addBox(-6.75F, -14.5F, -4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(9, 0).addBox(-5.75F, -15.0F, -3.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0275F, -0.3042F, -0.1267F));

		PartDefinition wheels = body.addOrReplaceChild("wheels", CubeListBuilder.create().texOffs(39, 4).addBox(-8.0F, -5.0F, -5.0F, 1.0F, 10.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 28).addBox(-8.0F, -5.0F, -5.0F, 1.0F, 10.0F, 10.0F, new CubeDeformation(0.25F))
		.texOffs(36, 40).addBox(7.0F, -5.0F, -5.0F, 1.0F, 10.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(23, 29).addBox(7.0F, -5.0F, -5.0F, 1.0F, 10.0F, 10.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, -5.0F, 1.0F));

		PartDefinition tnt = body.addOrReplaceChild("tnt", CubeListBuilder.create().texOffs(52, 3).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.body.getChild("bell").visible = entity.hasBell();
		this.body.getChild("tnt").visible = entity.hasTNT();
		this.body.getChild("wheels").xRot = limbSwing / 12;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}