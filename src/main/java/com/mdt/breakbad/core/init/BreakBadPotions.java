package com.mdt.breakbad.core.init;

import com.mdt.breakbad.core.init.effects.FlatPotion;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.common.brewing.BrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.mdt.breakbad.BreakBad.MODID;

public class BreakBadPotions {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, MODID);
    public static final RegistryObject<Potion> CRYSTLAMINE_POTION = POTIONS.register("crystlamine_potion",
            () -> new FlatPotion(new MobEffectInstance(BreakBadEffects.CRYSTLAMINE_EFFECT.get(),0,0)));
    public static final RegistryObject<Potion> PURE_COMPOUND = POTIONS.register("pure_compound",
            () -> new FlatPotion(new MobEffectInstance(BreakBadEffects.PURE_EFFECT.get(),0,0)));
    public static final RegistryObject<Potion> SEAWEED_EXTRACT = POTIONS.register("seaweed_extract",
            () -> new FlatPotion(new MobEffectInstance(BreakBadEffects.SEAWEED_EFFECT.get(),0,0)));


    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
