package com.mdt.breakbad.common.entities.humanoids;

import com.mdt.breakbad.BreakBad;
import com.mdt.breakbad.common.entities.HumanoidEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class WalterSuitEntity extends WalterEntity {
    private static final ResourceLocation WALTER_SUIT_TEXTURE = new ResourceLocation(BreakBad.MODID,"textures/entities/humanoid/walter_suit.png");
    public WalterSuitEntity(EntityType<? extends HumanoidEntity> entityType, Level level) {
        super(entityType, level);
        this.skin = WALTER_SUIT_TEXTURE;
    }
}
