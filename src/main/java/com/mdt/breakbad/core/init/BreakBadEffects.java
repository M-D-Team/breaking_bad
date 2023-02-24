package com.mdt.breakbad.core.init;

import com.mdt.breakbad.BreakBad;
import com.mdt.breakbad.core.init.effects.BlankEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BreakBadEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, BreakBad.MODID);

    public static final RegistryObject<MobEffect> CRYSTLAMINE_EFFECT = MOB_EFFECTS.register("crystlamine", () -> new BlankEffect(MobEffectCategory.NEUTRAL, 15522535));
    public static final RegistryObject<MobEffect> SEAWEED_EFFECT = MOB_EFFECTS.register("seaweed", () -> new BlankEffect(MobEffectCategory.NEUTRAL, 10928023));
    public static final RegistryObject<MobEffect> PURE_EFFECT = MOB_EFFECTS.register("pure_compound", () -> new BlankEffect(MobEffectCategory.NEUTRAL, 14932677));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
