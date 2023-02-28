package com.mdt.breakbad.common.entities.humanoids;

import com.mdt.breakbad.BreakBad;
import com.mdt.breakbad.common.entities.HumanoidEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class JesseEntity extends HumanoidEntity {
    private static final ResourceLocation JESSE_TEXTURE = new ResourceLocation(BreakBad.MODID,"textures/entities/humanoid/jesse.png");
    public JesseEntity(EntityType<? extends HumanoidEntity> entityType, Level level) {
        super(entityType, level,"Jesse");
        this.skin = JESSE_TEXTURE;
    }
}
