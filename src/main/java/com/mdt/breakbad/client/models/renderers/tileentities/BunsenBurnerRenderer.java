package com.mdt.breakbad.client.models.renderers.tileentities;

import com.mdt.breakbad.BreakBad;
import com.mdt.breakbad.client.models.tileentities.BunsenBurner;
import com.mdt.breakbad.common.blockentities.BunsenBurnerTile;
import com.mdt.breakbad.common.blocks.BunsenBurnerBlock;
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

public class BunsenBurnerRenderer implements BlockEntityRenderer<BunsenBurnerTile> {

    private final BunsenBurner model;

    public static final ResourceLocation BUNSEN_BURNER = new ResourceLocation(BreakBad.MODID, "textures/tileentities/bunsen_burner.png");

    public int MaxLight = 15728880;
    private int liquidLevel;
    private boolean hasCandle;

    public BunsenBurnerRenderer(BlockEntityRendererProvider.Context ctx) {
        this.model = new BunsenBurner<>(ctx.bakeLayer(BunsenBurner.LAYER_LOCATION));
    }

    @Override
    public void render(BunsenBurnerTile pBlockEntity, float pPartialTick, PoseStack pPoseStack,
                       MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        pPoseStack.pushPose();
        pPoseStack.translate(0.5f, 1.5f, 0.5f);
        pPoseStack.mulPose(Axis.XP.rotationDegrees(180));
//        System.out.println(getLightLevel(pBlockEntity.getLevel(), pBlockEntity.getBlockPos()));
        switch (pBlockEntity.getBlockState().getValue(BunsenBurnerBlock.FACING)) {
            case NORTH -> pPoseStack.mulPose(Axis.YP.rotationDegrees(0));
            case EAST -> pPoseStack.mulPose(Axis.YP.rotationDegrees(90));
            case SOUTH -> pPoseStack.mulPose(Axis.YP.rotationDegrees(180));
            case WEST -> pPoseStack.mulPose(Axis.YP.rotationDegrees(270));
        }

        // Make sure they're all invisible first
        this.model.one.visible = false;
        this.model.two.visible = false;
        this.model.three.visible = false;
        this.model.four.visible = false;
        this.model.five.visible = false;
        this.model.six.visible = false;
        this.model.seven.visible = false;


        // Set the liquid level based on the entities level
        /*
         * Switch statement doesnt seem to work here, so have to use a long loqor-like if statement.
        switch (pBlockEntity.getLiquidLevel()) {k
            default:
                // dont do shit
            case 1:
                this.model.one.visible = true;
            case 2:
                this.model.two.visible = true;
            case 3:
                this.model.three.visible = true;
            case 4:
                this.model.four.visible = true;
            case 5:
                this.model.five.visible = true;
            case 6:
                this.model.six.visible = true;
            case 7:
                this.model.seven.visible = true;
        }
         */

        // * Get the block and its liquid level
        // * * We know that rendering is always done on client, so the server needs to send us this data.
        this.liquidLevel = pBlockEntity.liquidLevel;
        this.hasCandle = pBlockEntity.hasCandle();

        if (liquidLevel == 1) {this.model.one.visible = true;}
        else if (liquidLevel == 2) {this.model.two.visible = true;}
        else if (liquidLevel == 3) {this.model.three.visible = true;}
        else if (liquidLevel == 4) {this.model.four.visible = true;}
        else if (liquidLevel == 5) {this.model.five.visible = true;}
        else if (liquidLevel == 6) {this.model.six.visible = true;}
        else if (liquidLevel == 7) {this.model.seven.visible = true;}
        this.model.candle.visible = this.hasCandle;

        this.model.render(pPoseStack, pBufferSource.getBuffer(RenderType.entitySmoothCutout(BUNSEN_BURNER)),
                getLightLevel(pBlockEntity.getLevel(), pBlockEntity.getBlockPos()), OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        pPoseStack.popPose();
    }

    private int getLightLevel(Level level, BlockPos pos) {
        int bLight = level.getBrightness(LightLayer.BLOCK, pos);
        int sLight = level.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(bLight, sLight);
    }



}
