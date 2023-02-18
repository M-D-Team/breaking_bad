package com.mdt.breakbad.core.init;

import com.mdt.breakbad.common.BreakBadArmourMaterials;
import com.mdt.breakbad.common.items.FulminateItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.mdt.breakbad.BreakBad.MODID;

public class BreakBadItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Item> METH = ITEMS.register("meth", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,4000,1),1f).build())));
    public static final RegistryObject<Item> FULMINATE = ITEMS.register("fulminate", () -> new FulminateItem(new Item.Properties()));
    public static final RegistryObject<Item> GAS_MASK = ITEMS.register("gas_mask", () -> new ArmorItem(BreakBadArmourMaterials.GAS_MASK, EquipmentSlot.HEAD,new Item.Properties()));
}
