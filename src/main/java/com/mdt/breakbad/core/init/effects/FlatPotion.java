package com.mdt.breakbad.core.init.effects;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;

// just the regular potion but without the foil
public class FlatPotion extends Potion {
    public FlatPotion(MobEffectInstance mobEffectInstance) {
        super(mobEffectInstance);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return false;
    }
}
