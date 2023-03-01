package com.mdt.breakbad.core.init;

import com.mdt.breakbad.BreakBad;
import com.mdt.breakbad.common.entities.Fulminate;
import com.mdt.breakbad.common.entities.HumanoidEntity;
import com.mdt.breakbad.common.entities.humanoids.*;
import com.mdt.breakbad.common.entities.humanoids.merchants.GusEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BreakBadEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, BreakBad.MODID);

    public static final RegistryObject<EntityType<Fulminate>> FULMINATE = ENTITIES.register("fulminate",() ->
            EntityType.Builder.<Fulminate>of(Fulminate::new, MobCategory.MISC)
                    .sized(0.25F, 0.25F)
                    .clientTrackingRange(4).updateInterval(10)
                    .build(new ResourceLocation(BreakBad.MODID,"fulminate").toString()));
    public static final RegistryObject<EntityType<HumanoidEntity>> HUMANOID_ENTITY = ENTITIES.register("humanoid_entity", () ->
            EntityType.Builder.<HumanoidEntity>of(HumanoidEntity::new, MobCategory.CREATURE).sized(0.6f,1.8f).build(new ResourceLocation(BreakBad.MODID,"humanoid_entity").toString()));
    public static final RegistryObject<EntityType<? extends HumanoidEntity>> GUS_ENTITY = ENTITIES.register("gus_entity", () ->
            EntityType.Builder.of(GusEntity::new, MobCategory.CREATURE).sized(0.6f,1.8f).build(new ResourceLocation(BreakBad.MODID,"gus_entity").toString()));
    public static final RegistryObject<EntityType<? extends HumanoidEntity>> JESSE_ENTITY = ENTITIES.register("jesse_entity", () ->
            EntityType.Builder.of(JesseEntity::new, MobCategory.CREATURE).sized(0.6f,1.8f).build(new ResourceLocation(BreakBad.MODID,"jesse_entity").toString()));
    public static final RegistryObject<EntityType<? extends HumanoidEntity>> JESSE_SUIT_ENTITY = ENTITIES.register("jesse_suit_entity", () ->
            EntityType.Builder.of(JesseSuitEntity::new, MobCategory.CREATURE).sized(0.6f,1.8f).build(new ResourceLocation(BreakBad.MODID,"jesse_suit_entity").toString()));
    public static final RegistryObject<EntityType<? extends HumanoidEntity>> WALTER_ENTITY = ENTITIES.register("walter_entity", () ->
            EntityType.Builder.of(WalterEntity::new, MobCategory.CREATURE).sized(0.6f,1.8f).build(new ResourceLocation(BreakBad.MODID,"walter_entity").toString()));
    public static final RegistryObject<EntityType<? extends HumanoidEntity>> WALTER_SUIT_ENTITY = ENTITIES.register("walter_suit_entity", () ->
            EntityType.Builder.of(WalterSuitEntity::new, MobCategory.CREATURE).sized(0.6f,1.8f).build(new ResourceLocation(BreakBad.MODID,"walter_suit_entity").toString()));
}
