package com.mdt.breakbad.common.blocks;

import com.mdt.breakbad.common.blockentities.BunsenBurnerTile;
import com.mdt.breakbad.common.blockentities.CondenserTile;
import com.mdt.breakbad.core.init.BreakBadTiles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CondenserBlock extends BaseEntityBlock {

    protected final ParticleOptions flameParticle;
    public int liquidLevel = 0;
    public boolean isLit = false;
    public boolean hasCandle = false;
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    private static final VoxelShape SHAPE = Block.box(4, 0, 4, 12, 20, 12);
    public CondenserBlock(Properties p_49795_, ParticleOptions pO) {
        super(p_49795_);
        this.flameParticle = pO;
    }

    public int getLiquidLevel() {
        return this.liquidLevel;
    }

    public boolean isCandleLit() {
        return this.isLit;
    }

    public boolean doesItHaveCandle() {
        return this.hasCandle;
    }

    public void updateLiquidLevel() {
        this.liquidLevel++;
        if (this.liquidLevel > 6) {this.liquidLevel = 0;}
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!level.isClientSide && hand == InteractionHand.MAIN_HAND) {
            BlockEntity blockEntity = level.getBlockEntity(blockPos);
            if (blockEntity instanceof CondenserTile) {
                if(player.getMainHandItem().isEmpty()) {
                    this.updateLiquidLevel();
                } else if (player.getMainHandItem().getItem() == Items.FLINT_AND_STEEL && this.doesItHaveCandle()) {
                    this.isLit = true;
                } else if (player.getMainHandItem().getItem() == Items.LIGHT_GRAY_CANDLE) {
                    this.hasCandle = true;
                }
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.FAIL;
    }

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return SHAPE;
    }

    @Override
    public RenderShape getRenderShape(BlockState p_49232_) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return level.isClientSide() ? null : ($0, $1, $2, blockEntity) -> {
            if(blockEntity instanceof CondenserTile) {
                CondenserTile condenser = (CondenserTile) blockEntity;
                condenser.tick();
            }
        };
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
        return BreakBadTiles.CONDENSER_TILE.get().create(p_153215_, p_153216_);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    public void animateTick(BlockState p_222593_, Level p_222594_, BlockPos p_222595_, RandomSource p_222596_) {
        if(this.isCandleLit()) {
            double d0 = (double) p_222595_.getX() + 0.5D;
            double d1 = (double) p_222595_.getY() + 0.5D;
            double d2 = (double) p_222595_.getZ() + 0.5D;
            p_222594_.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
            p_222594_.addParticle(this.flameParticle, d0, d1, d2, 0.0D, 0.0D, 0.0D);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
