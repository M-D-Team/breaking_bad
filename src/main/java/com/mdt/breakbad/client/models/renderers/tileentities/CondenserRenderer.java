package com.mdt.breakbad.client.models.renderers.tileentities;

import com.mdt.breakbad.BreakBad;
import com.mdt.breakbad.client.models.tileentities.BunsenBurner;
import com.mdt.breakbad.client.models.tileentities.CondenserAndPhaseShifter;
import com.mdt.breakbad.common.blockentities.BunsenBurnerTile;
import com.mdt.breakbad.common.blockentities.CondenserTile;
import com.mdt.breakbad.common.blocks.BunsenBurnerBlock;
import com.mdt.breakbad.common.blocks.CondenserBlock;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Block;

public class CondenserRenderer implements BlockEntityRenderer<CondenserTile> {

    private final CondenserAndPhaseShifter model;

    public static final ResourceLocation CONDENSER = new ResourceLocation(BreakBad.MODID, "textures/tileentities/condenser_phase_shifter.png");

    public int MaxLight = 15728880;

    public CondenserRenderer(BlockEntityRendererProvider.Context ctx) {
        this.model = new CondenserAndPhaseShifter<>(ctx.bakeLayer(CondenserAndPhaseShifter.LAYER_LOCATION));
    }

    @Override
    public void render(CondenserTile pBlockEntity, float pPartialTick, PoseStack pPoseStack,
                       MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        Block block = pBlockEntity.getBlockState().getBlock();
        pPoseStack.pushPose();
        pPoseStack.translate(0.5f, 1.5f, 0.5f);
        pPoseStack.mulPose(Axis.XP.rotationDegrees(180));
//        System.out.println(getLightLevel(pBlockEntity.getLevel(), pBlockEntity.getBlockPos()));
        switch (pBlockEntity.getBlockState().getValue(CondenserBlock.FACING)) {
            case NORTH -> pPoseStack.mulPose(Axis.YP.rotationDegrees(0));
            case EAST -> pPoseStack.mulPose(Axis.YP.rotationDegrees(90));
            case SOUTH -> pPoseStack.mulPose(Axis.YP.rotationDegrees(180));
            case WEST -> pPoseStack.mulPose(Axis.YP.rotationDegrees(270));
        }

        // Make sure they're all invisible first
        this.model.flask.getChild("one").visible = false;
        this.model.flask.getChild("two").visible = false;
        this.model.flask.getChild("three").visible = false;
        this.model.flask.getChild("four").visible = false;
        this.model.flask.getChild("five").visible = false;
        this.model.flask.getChild("six").visible = false;
        this.model.candle.visible = ((CondenserBlock) block).doesItHaveCandle();
        // * Get the block and its liquid level
        int liquidLevel = ((CondenserBlock) block).getLiquidLevel();

        if (liquidLevel == 1) {this.model.flask.getChild("one").visible = true;}
        if (liquidLevel == 2) {this.model.flask.getChild("two").visible = true;}
        if (liquidLevel == 3) {this.model.flask.getChild("three").visible = true;}
        if (liquidLevel == 4) {this.model.flask.getChild("four").visible = true;}
        if (liquidLevel == 5) {this.model.flask.getChild("five").visible = true;}
        if (liquidLevel == 6) {this.model.flask.getChild("six").visible = true;}


        this.model.render(pPoseStack, pBufferSource.getBuffer(RenderType.entitySmoothCutout(CONDENSER)),
                getLightLevel(pBlockEntity.getLevel(), pBlockEntity.getBlockPos()), OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        pPoseStack.popPose();
    }

    private int getLightLevel(Level level, BlockPos pos) {
        int bLight = level.getBrightness(LightLayer.BLOCK, pos);
        int sLight = level.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(bLight, sLight);
    }


}
