package com.mdt.breakbad.common.entities.humanoids;

import com.mdt.breakbad.BreakBad;
import com.mdt.breakbad.common.entities.HumanoidEntity;
import com.mdt.breakbad.core.init.BreakBadItems;
import com.mdt.breakbad.core.init.BreakBadSounds;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

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

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        Random random = new Random();
        int selection = random.nextInt(6); // Because theres 5 sound effects.
        switch (selection) {
            default -> {
                return super.getAmbientSound();
            }
            case 1 -> {
                return BreakBadSounds.SAUL_DEEP.get();
            }
            case 2 -> {
                return BreakBadSounds.SAUL_FIGHT.get();
            }
            case 3 -> {
                return BreakBadSounds.SAUL_FULL.get();
            }
            case 4 -> {
                return BreakBadSounds.SAUL_INNOCENT.get();
            }
            case 5 -> {
                return BreakBadSounds.SAUL_RIGHTS.get();
            }
        }
    }

    public static ResourceLocation selectRandomSkin(ResourceLocation[] list) {
        Random random = new Random();
        int selection = random.nextInt(list.length);
        return list[selection];
    }
}
