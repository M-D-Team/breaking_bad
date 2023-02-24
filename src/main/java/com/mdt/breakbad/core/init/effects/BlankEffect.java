package com.mdt.breakbad.core.init.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

// I use this to create blank effects just to create colours,
// I do it this way because for some reason calling MobEffect dont worky so BlankEffect it is
public class BlankEffect extends MobEffect {
    public BlankEffect(MobEffectCategory category, int colour) {
        super(category, colour);
    }
}
