package com.mdt.breakbad.common.entities.humanoids;

import com.mdt.breakbad.BreakBad;
import com.mdt.breakbad.common.entities.HumanoidEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class WalterEntity extends HumanoidEntity {
    private static final ResourceLocation WALTER_TEXTURE = new ResourceLocation(BreakBad.MODID,"textures/entities/humanoid/walter.png");
    public WalterEntity(EntityType<? extends HumanoidEntity> entityType, Level level) {
        super(entityType, level,"Walter");
        this.skin = WALTER_TEXTURE;
    }
}
