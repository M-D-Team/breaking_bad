package com.mdt.breakbad.common.items;

import com.mdt.breakbad.common.entities.rideables.WheelchairEntity;
import com.mdt.breakbad.core.init.BreakBadEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class CustomSpawnItem extends Item {

    public CustomSpawnItem(Properties p_41383_) {
        super(p_41383_);
    }

    private WheelchairEntity spawnWheelchair(BlockPos blockPos, Level level, Player player) {
        WheelchairEntity wheelchair = new WheelchairEntity(BreakBadEntities.WHEELCHAIR_ENTITY.get(), level);
        wheelchair.moveTo(blockPos.getX() + 0.5, blockPos.getY() + 1, blockPos.getZ() + 0.5);
        wheelchair.setYBodyRot(-player.getYRot());
        level.addFreshEntity(wheelchair);
        return wheelchair;
    }

    @Override
    public InteractionResult useOn(UseOnContext p_41427_) {
        BlockPos spawnPos = p_41427_.getClickedPos();
        spawnWheelchair(spawnPos, p_41427_.getLevel(), p_41427_.getPlayer());
        return InteractionResult.SUCCESS;
    }
}
