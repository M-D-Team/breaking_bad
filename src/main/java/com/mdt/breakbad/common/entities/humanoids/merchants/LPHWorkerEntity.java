package com.mdt.breakbad.common.entities.humanoids.merchants;

import com.mdt.breakbad.BreakBad;
import com.mdt.breakbad.common.entities.MerchantHumanoidEntity;
import com.mdt.breakbad.core.init.BreakBadItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.Level;

public class LPHWorkerEntity extends MerchantHumanoidEntity {
    private static final ResourceLocation LPH_LOQOR = new ResourceLocation(BreakBad.MODID,"textures/entities/humanoid/lph_loqor.png");
    public LPHWorkerEntity(EntityType<? extends LPHWorkerEntity> entityType, Level level) {
        super(entityType, level, "Loqor", LPH_LOQOR);
        this.offerList = new MerchantOffer[]{new MerchantOffer(Items.EMERALD.getDefaultInstance(), Items.COOKED_CHICKEN.getDefaultInstance(), 1, 16, 1f),new MerchantOffer(Items.EMERALD.getDefaultInstance(), BreakBadItems.CURLY_FRIES.get().getDefaultInstance(), 1, 16, 1f)};
    }
}
