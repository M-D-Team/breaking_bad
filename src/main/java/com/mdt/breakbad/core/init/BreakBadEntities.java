package com.mdt.breakbad.core.init;

import com.mdt.breakbad.BreakBad;
import com.mdt.breakbad.common.entities.Fulminate;
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
}