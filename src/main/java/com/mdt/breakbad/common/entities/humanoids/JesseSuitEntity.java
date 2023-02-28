package com.mdt.breakbad.common.entities.humanoids;

import com.mdt.breakbad.BreakBad;
import com.mdt.breakbad.common.entities.HumanoidEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class JesseSuitEntity extends JesseEntity {
    private static final ResourceLocation JESSE_SUIT_TEXTURE = new ResourceLocation(BreakBad.MODID,"textures/entities/humanoid/jesse_suit.png");
    public JesseSuitEntity(EntityType<? extends HumanoidEntity> entityType, Level level) {
        super(entityType, level);
        this.skin = JESSE_SUIT_TEXTURE;
    }
}
