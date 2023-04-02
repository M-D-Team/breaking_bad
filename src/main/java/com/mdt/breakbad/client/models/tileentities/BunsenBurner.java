package com.mdt.breakbad.client.models.tileentities;// Made with Blockbench 4.6.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class BunsenBurner<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "custom_model"), "main");
	private final ModelPart plate_stands;
	private final ModelPart candle;
	private final ModelPart flask;
	private final ModelPart one;
	private final ModelPart two;
	private final ModelPart three;
	private final ModelPart four;
	private final ModelPart five;
	private final ModelPart six;
	private final ModelPart seven;

	public BunsenBurner(ModelPart root) {
		this.plate_stands = root.getChild("plate_stands");
		this.candle = root.getChild("candle");
		this.flask = root.getChild("flask");
		this.one = root.getChild("one");
		this.two = root.getChild("two");
		this.three = root.getChild("three");
		this.four = root.getChild("four");
		this.five = root.getChild("five");
		this.six = root.getChild("six");
		this.seven = root.getChild("seven");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition plate_stands = partdefinition.addOrReplaceChild("plate_stands", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -12.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = plate_stands.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 10).addBox(-5.0F, -11.0F, 0.0F, 10.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r2 = plate_stands.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(21, 10).addBox(-5.0F, -11.0F, 0.0F, 10.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition candle = partdefinition.addOrReplaceChild("candle", CubeListBuilder.create().texOffs(0, 22).addBox(-1.0F, -0.25F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 18.25F, 0.0F));

		PartDefinition cube_r3 = candle.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.25F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r4 = candle.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 2).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.25F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition flask = partdefinition.addOrReplaceChild("flask", CubeListBuilder.create().texOffs(3, 25).addBox(-3.0F, -19.1F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(27, 25).addBox(-3.0F, -19.1F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition one = partdefinition.addOrReplaceChild("one", CubeListBuilder.create().texOffs(3, 38).addBox(-3.0F, -13.1F, -3.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(-0.25F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition two = partdefinition.addOrReplaceChild("two", CubeListBuilder.create().texOffs(3, 38).addBox(-3.0F, -14.1F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(-0.25F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition three = partdefinition.addOrReplaceChild("three", CubeListBuilder.create().texOffs(3, 38).addBox(-3.0F, -15.1F, -3.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(-0.25F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition four = partdefinition.addOrReplaceChild("four", CubeListBuilder.create().texOffs(3, 38).addBox(-3.0F, -16.1F, -3.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(-0.25F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition five = partdefinition.addOrReplaceChild("five", CubeListBuilder.create().texOffs(3, 38).addBox(-3.0F, -17.1F, -3.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(-0.25F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition six = partdefinition.addOrReplaceChild("six", CubeListBuilder.create().texOffs(3, 38).addBox(-3.0F, -18.1F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(-0.25F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition seven = partdefinition.addOrReplaceChild("seven", CubeListBuilder.create().texOffs(3, 38).addBox(-3.0F, -19.1F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(-0.25F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		plate_stands.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		candle.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		flask.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		one.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		two.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		three.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		four.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		five.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		six.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		seven.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}