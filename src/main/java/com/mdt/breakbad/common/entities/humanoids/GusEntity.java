package com.mdt.breakbad.common.entities.humanoids;

import com.mdt.breakbad.BreakBad;
import com.mdt.breakbad.common.entities.HumanoidEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class GusEntity extends HumanoidEntity {
    private static final ResourceLocation GUS_TEXTURE = new ResourceLocation(BreakBad.MODID,"textures/entities/humanoid/gus.png");
    public GusEntity(EntityType<? extends GusEntity> entityType, Level level) {
        super(entityType, level, "Gus", GUS_TEXTURE);
    }
}
