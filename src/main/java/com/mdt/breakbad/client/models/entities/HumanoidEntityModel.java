package com.mdt.breakbad.client.models.entities;// Made with Blockbench 4.6.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mdt.breakbad.BreakBad;
import com.mdt.breakbad.common.entities.HumanoidEntity;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;

// This class practically already existed as PlayerModel, so im just making it extend PlayerModel instead.
public class HumanoidEntityModel extends PlayerModel<HumanoidEntity> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(BreakBad.MODID, "humanoid_entity"),"main");

	public ModelPart cloak;
	public ModelPart ear;
	public HumanoidEntityModel(ModelPart p_170821_) {
		super(p_170821_, true);
		this.ear = p_170821_.getChild("ear");
		this.cloak = p_170821_.getChild("cloak");
	}
}