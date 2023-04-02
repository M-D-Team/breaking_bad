package com.mdt.breakbad.core.init;

import com.mdt.breakbad.BreakBad;
import com.mdt.breakbad.common.entities.Fulminate;
import com.mdt.breakbad.common.entities.HumanoidEntity;
import com.mdt.breakbad.common.entities.humanoids.*;
import com.mdt.breakbad.common.entities.humanoids.merchants.GusEntity;
import com.mdt.breakbad.common.entities.humanoids.merchants.LPHWorkerEntity;
import com.mdt.breakbad.common.entities.rideables.WheelchairEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BreakBadEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, BreakBad.MODID);

    public static final RegistryObject<EntityType<WheelchairEntity>> WHEELCHAIR_ENTITY = ENTITIES.register("wheelchair_entity", () ->
            EntityType.Builder.of(WheelchairEntity::new, MobCategory.MISC)
                    .sized(1.25F, 1F)
                    .build(new ResourceLocation(BreakBad.MODID, "wheelchair_entity").toString()));

    // Items
    public static final RegistryObject<EntityType<Fulminate>> FULMINATE = ENTITIES.register("fulminate",() ->
            EntityType.Builder.<Fulminate>of(Fulminate::new, MobCategory.MISC)
                    .sized(0.25F, 0.25F)
                    .clientTrackingRange(4).updateInterval(10)
                    .build(new ResourceLocation(BreakBad.MODID,"fulminate").toString()));

    // Humanoids
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
    public static final RegistryObject<EntityType<? extends HumanoidEntity>> LPH_WORKER_ENTITY = ENTITIES.register("lph_worker_entity",
            () -> EntityType.Builder.of(LPHWorkerEntity::new, MobCategory.CREATURE).sized(0.6f, 1.8f).build(new ResourceLocation(BreakBad.MODID, "lph_worker_entity").toString()));
    public static final RegistryObject<EntityType<? extends HumanoidEntity>> SAUL_ENTITY = ENTITIES.register("saul_entity", () ->
            EntityType.Builder.of(SaulEntity::new, MobCategory.CREATURE).sized(0.6f,1.8f).build(new ResourceLocation(BreakBad.MODID,"saul_entity").toString()));
    public static final RegistryObject<EntityType<? extends HumanoidEntity>> HECTOR_ENTITY = ENTITIES.register("hector_entity", () ->
            EntityType.Builder.of(HectorEntity::new, MobCategory.CREATURE).sized(0.6f,1.8f).build(new ResourceLocation(BreakBad.MODID,"hector_entity").toString()));
}
