package com.mdt.breakbad.common.entities.humanoids;

import com.mdt.breakbad.BreakBad;
import com.mdt.breakbad.common.entities.HumanoidEntity;
import com.mdt.breakbad.common.entities.rideables.WheelchairEntity;
import com.mdt.breakbad.core.init.BreakBadEntities;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HectorEntity extends HumanoidEntity {

    private static final ResourceLocation HECTOR_TEXTURE = new ResourceLocation(BreakBad.MODID,"textures/entities/humanoid/hector.png");
    public HectorEntity(EntityType<? extends HumanoidEntity> entityType, Level level) {
        super(entityType, level,"Hector Salamanca");
        this.skin = HECTOR_TEXTURE;
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_21434_, DifficultyInstance p_21435_, MobSpawnType p_21436_, @Nullable SpawnGroupData p_21437_, @Nullable CompoundTag p_21438_) {
        rideNewWheelchair(this);
        return super.finalizeSpawn(p_21434_, p_21435_, p_21436_, p_21437_, p_21438_);
    }

    private WheelchairEntity spawnWheelchair(Entity entity) {
        WheelchairEntity wheelchair = new WheelchairEntity(BreakBadEntities.WHEELCHAIR_ENTITY.get(), entity.level);
        wheelchair.moveTo(entity.blockPosition(), entity.getXRot(),entity.getYRot());
        this.level.addFreshEntity(wheelchair);
        return wheelchair;
    }

    private void rideNewWheelchair(Entity entity) {
        WheelchairEntity wheelchair = spawnWheelchair(entity);
        entity.startRiding(wheelchair);
    }

    private void rideNearestWheelchair(Entity entity, double radius) {
        List<WheelchairEntity> entityList = this.level.getEntitiesOfClass(WheelchairEntity.class, entity.getBoundingBox().inflate(radius));

        if (entityList.size() == 0) {return;}

        WheelchairEntity nearestEntity = entityList.get(0);
        entity.startRiding(nearestEntity);
    }
}
