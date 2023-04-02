package com.mdt.breakbad.core.init;

import com.mdt.breakbad.common.BreakBadArmourMaterials;
import com.mdt.breakbad.common.items.FulminateItem;
import com.mdt.breakbad.common.items.MethItem;
import com.mdt.breakbad.common.items.WearableItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.mdt.breakbad.BreakBad.MODID;

public class BreakBadItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Item> METH = ITEMS.register("meth", () -> new MethItem(new Item.Properties().food(new FoodProperties.Builder()
             // POSITIVE EFFECTS
            .effect(new MobEffectInstance(MobEffects.DIG_SPEED, 3600,1),0.25f)
            .effect(new MobEffectInstance(MobEffects.JUMP,3600,1),0.25f)
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,3600,1),0.25f)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,3600,1),0.5f)
            .effect(new MobEffectInstance(MobEffects.LUCK,3600,1),0.25f)
            .effect(new MobEffectInstance(MobEffects.REGENERATION,3600,1),0.5f)
             // NEGATIVE EFFECTS
            .effect(new MobEffectInstance(MobEffects.LEVITATION,300,1),0.5f)
            .effect(new MobEffectInstance(MobEffects.POISON,600,1),0.5f)
            .effect(new MobEffectInstance(MobEffects.HUNGER,600,1),0.5f)
            .effect(new MobEffectInstance(MobEffects.CONFUSION,600,1),0.5f)
            .effect(new MobEffectInstance(MobEffects.DARKNESS,1200,1),0.75f)
            .build())));


    public static final RegistryObject<Item> FLAVOURING_EXTRACT = ITEMS.register("flavouring_extract", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().effect(new MobEffectInstance(MobEffects.DARKNESS,200,1),1f).build())));
    public static final RegistryObject<Item> AMETHYST_DUST = ITEMS.register("amethyst_dust", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BREAKING_BREAD = ITEMS.register("breaking_bread", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(99).saturationMod(99).build())));
    public static final RegistryObject<Item> CURLY_FRIES = ITEMS.register("curly_fries", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationMod(1f).build())));
    public static final RegistryObject<Item> FULMINATE = ITEMS.register("fulminate", () -> new FulminateItem(new Item.Properties()));
    public static final RegistryObject<Item> GAS_MASK = ITEMS.register("gas_mask", () -> new WearableItem(BreakBadArmourMaterials.GAS_MASK, EquipmentSlot.HEAD,new Item.Properties()));
}
