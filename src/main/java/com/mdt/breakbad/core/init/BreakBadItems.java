package com.mdt.breakbad.core.init;

import com.mdt.breakbad.BREAKBAD;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BreakBadItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BREAKBAD.MOD_ID);

    // gives the player an effect
    public static final RegistryObject<Item> METH = ITEMS.register("meth",() -> new Item(new Item.Properties().tab(BreakBadItemGroup.BREAKING_BAD_TAB).food(new Food.Builder().effect(new EffectInstance(Effects.MOVEMENT_SPEED,4000,1),1f).build())));

    public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}
