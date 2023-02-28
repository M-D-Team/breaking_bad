package com.mdt.breakbad.events;

import com.mdt.breakbad.BreakBad;
import com.mdt.breakbad.common.entities.HumanoidEntity;
import com.mdt.breakbad.core.init.BreakBadEntities;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = BreakBad.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BreakBadModEvents {
    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {});
    }

    @SubscribeEvent
    public static void entityAttributes(EntityAttributeCreationEvent event) {
        event.put(BreakBadEntities.HUMANOID_ENTITY.get(), HumanoidEntity.getHumanoidAttributes().build());
        event.put(BreakBadEntities.GUS_ENTITY.get(), HumanoidEntity.getHumanoidAttributes().build());
        event.put(BreakBadEntities.JESSE_ENTITY.get(), HumanoidEntity.getHumanoidAttributes().build());
        event.put(BreakBadEntities.JESSE_SUIT_ENTITY.get(), HumanoidEntity.getHumanoidAttributes().build());
        event.put(BreakBadEntities.WALTER_ENTITY.get(), HumanoidEntity.getHumanoidAttributes().build());
        event.put(BreakBadEntities.WALTER_SUIT_ENTITY.get(), HumanoidEntity.getHumanoidAttributes().build());
    }
}