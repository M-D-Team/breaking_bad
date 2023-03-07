package com.mdt.breakbad.common.entities.humanoids;

import com.mdt.breakbad.BreakBad;
import com.mdt.breakbad.common.entities.HumanoidEntity;
import com.mdt.breakbad.core.init.BreakBadItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.Level;

import java.util.Random;

public class SaulEntity extends HumanoidEntity {
    private final ResourceLocation[] skinList = {
            new ResourceLocation(BreakBad.MODID,"textures/entities/humanoid/saul_variant_1.png"),
            new ResourceLocation(BreakBad.MODID,"textures/entities/humanoid/saul_variant_2.png"),
            new ResourceLocation(BreakBad.MODID,"textures/entities/humanoid/saul_variant_3.png"),
            new ResourceLocation(BreakBad.MODID,"textures/entities/humanoid/saul_variant_4.png"),
            new ResourceLocation(BreakBad.MODID,"textures/entities/humanoid/saul_variant_5.png"),
            new ResourceLocation(BreakBad.MODID,"textures/entities/humanoid/saul_variant_6.png"),
            new ResourceLocation(BreakBad.MODID,"textures/entities/humanoid/saul_variant_7.png"),
            new ResourceLocation(BreakBad.MODID,"textures/entities/humanoid/saul_variant_8.png"),
            new ResourceLocation(BreakBad.MODID,"textures/entities/humanoid/saul_variant_9.png")
    };
    public SaulEntity(EntityType<? extends HumanoidEntity> entityType, Level level) {
        super(entityType, level,"Saul Goodman");
        this.skin = selectRandomSkin(this.skinList);
    }

    public static ResourceLocation selectRandomSkin(ResourceLocation[] list) {
        Random random = new Random();
        int selection = random.nextInt(list.length);
        return list[selection];
    }
}
