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
    public static final RegistryObject<SoundEvent> SAUL_DEEP = SOUNDS.register("saul_deep", () -> SoundEvent.createVariableRangeEvent(
            new ResourceLocation(BreakBad.MODID,"saul_deep_bcs")
    ));
    public static final RegistryObject<SoundEvent> SAUL_FIGHT = SOUNDS.register("saul_fight", () -> SoundEvent.createVariableRangeEvent(
            new ResourceLocation(BreakBad.MODID,"saul_fight")
    ));
    public static final RegistryObject<SoundEvent> SAUL_FULL = SOUNDS.register("saul_full", () -> SoundEvent.createVariableRangeEvent(
            new ResourceLocation(BreakBad.MODID,"saul_full")
    ));
    public static final RegistryObject<SoundEvent> SAUL_INNOCENT = SOUNDS.register("saul_innocent", () -> SoundEvent.createVariableRangeEvent(
            new ResourceLocation(BreakBad.MODID,"saul_innocent")
    ));
    public static final RegistryObject<SoundEvent> SAUL_RIGHTS = SOUNDS.register("saul_rights", () -> SoundEvent.createVariableRangeEvent(
            new ResourceLocation(BreakBad.MODID,"saul_rights")
    ));
}
