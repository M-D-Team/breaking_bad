package com.mdt.breakbad.common.entities.humanoids.merchants;

import com.mdt.breakbad.BreakBad;
import com.mdt.breakbad.common.entities.MerchantHumanoidEntity;
import com.mdt.breakbad.core.init.BreakBadItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;

import java.util.Arrays;

public class GusEntity extends MerchantHumanoidEntity {
    private static final ResourceLocation GUS_TEXTURE = new ResourceLocation(BreakBad.MODID,"textures/entities/humanoid/gus.png");
    public GusEntity(EntityType<? extends GusEntity> entityType, Level level) {
        super(entityType, level, "Gus", GUS_TEXTURE);
        this.offerList = new MerchantOffer[]{
                new MerchantOffer(Items.EMERALD.getDefaultInstance(), Items.COOKED_CHICKEN.getDefaultInstance(), 1, 16, 1f),
                new MerchantOffer(Items.EMERALD.getDefaultInstance(), BreakBadItems.CURLY_FRIES.get().getDefaultInstance(), 1, 16, 1f)
        };
    }
}
