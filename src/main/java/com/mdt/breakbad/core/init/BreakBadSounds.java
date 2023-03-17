package com.mdt.breakbad.core.init;

import com.mdt.breakbad.BreakBad;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BreakBadSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, BreakBad.MODID);

    // Saul Sounds
    public static final RegistryObject<SoundEvent> SAUL_DEEP = SOUNDS.register("saul_deep", () -> SoundEvent.createFixedRangeEvent(
            new ResourceLocation(BreakBad.MODID,"saul_deep_bcs"), 8f
    ));
    public static final RegistryObject<SoundEvent> SAUL_FIGHT = SOUNDS.register("saul_fight", () -> SoundEvent.createFixedRangeEvent(
            new ResourceLocation(BreakBad.MODID,"saul_fight"), 8f
    ));
    public static final RegistryObject<SoundEvent> SAUL_FULL = SOUNDS.register("saul_full", () -> SoundEvent.createFixedRangeEvent(
            new ResourceLocation(BreakBad.MODID,"saul_full"), 8f
    ));
    public static final RegistryObject<SoundEvent> SAUL_INNOCENT = SOUNDS.register("saul_innocent", () -> SoundEvent.createFixedRangeEvent(
            new ResourceLocation(BreakBad.MODID,"saul_innocent"), 8f
    ));
    public static final RegistryObject<SoundEvent> SAUL_RIGHTS = SOUNDS.register("saul_rights", () -> SoundEvent.createFixedRangeEvent(
            new ResourceLocation(BreakBad.MODID,"saul_rights"), 8f
    ));
}
