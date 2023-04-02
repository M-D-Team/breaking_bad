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
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;

public class WheelchairModel<T extends WheelchairEntity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(BreakBad.MODID, "wheelchair_entity"), "main");
	private final ModelPart right_wheel;
	private final ModelPart left_wheel;
	private final ModelPart bb_main;

	public WheelchairModel(ModelPart root) {
		this.right_wheel = root.getChild("right_wheel");
		this.left_wheel = root.getChild("left_wheel");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition right_wheel = partdefinition.addOrReplaceChild("right_wheel", CubeListBuilder.create().texOffs(30, 0).addBox(-6.0F, -1.0F, -4.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(10, 29).addBox(-6.0F, -8.0F, -4.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 11).addBox(-6.0F, -7.0F, 3.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 11).addBox(-6.0F, -7.0F, -4.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 24.0F, 0.0F));

		PartDefinition left_wheel = partdefinition.addOrReplaceChild("left_wheel", CubeListBuilder.create().texOffs(0, 24).addBox(-6.0F, -1.0F, -4.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(20, 21).addBox(-6.0F, -8.0F, -4.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(4, 0).addBox(-6.0F, -7.0F, 3.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-6.0F, -7.0F, -4.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(12.0F, 24.0F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(20, 11).addBox(-5.0F, -13.0F, 4.0F, 10.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(10, 16).addBox(-6.0F, -8.0F, -5.0F, 1.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 11).addBox(5.0F, -8.0F, -5.0F, 1.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		right_wheel.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_wheel.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}