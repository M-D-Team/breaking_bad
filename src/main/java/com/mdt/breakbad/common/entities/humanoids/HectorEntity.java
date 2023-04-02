package com.mdt.breakbad.common.entities.humanoids;

import com.mdt.breakbad.BreakBad;
import com.mdt.breakbad.common.entities.HumanoidEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class HectorEntity extends HumanoidEntity {

    private static final ResourceLocation HECTOR_TEXTURE = new ResourceLocation(BreakBad.MODID,"textures/entities/humanoid/hector.png");
    public HectorEntity(EntityType<? extends HumanoidEntity> entityType, Level level) {
        super(entityType, level,"Hector Salamanca");
        this.skin = HECTOR_TEXTURE;
    }
}
