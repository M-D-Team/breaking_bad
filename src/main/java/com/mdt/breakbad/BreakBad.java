package com.mdt.breakbad;

import com.mdt.breakbad.core.init.*;
import com.mdt.breakbad.util.BetterBrewingRecipe;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BreakBad.MODID)
public class BreakBad
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "breakbad";
    public static CreativeModeTab BREAKBAD_TAB;
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public BreakBad()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        BreakBadItems.ITEMS.register(modEventBus);
        BreakBadBlocks.BLOCKS.register(modEventBus);
        BreakBadEntities.ENTITIES.register(modEventBus);
        BreakBadEffects.MOB_EFFECTS.register(modEventBus);
        BreakBadPotions.POTIONS.register(modEventBus);
        BreakBadSounds.SOUNDS.register(modEventBus);
        BreakBadTiles.BLOCK_ENTITIES.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::registerTabs);
        modEventBus.addListener(this::addCreative);

    }


    private void registerTabs(CreativeModeTabEvent.Register event)
    {
        BREAKBAD_TAB = event.registerCreativeModeTab(new ResourceLocation(MODID, "breakbad_tab"), builder -> builder
                .icon(() -> new ItemStack(BreakBadItems.METH.get()))
                .title(Component.translatable("tabs.breakbad.breakbad_tab"))
                .displayItems((featureFlags, output, hasOp) -> {
                    // Try and group them together.
                    output.accept(PotionUtils.setPotion(Items.POTION.getDefaultInstance(),BreakBadPotions.CRYSTLAMINE_POTION.get()));
                    output.accept(PotionUtils.setPotion(Items.POTION.getDefaultInstance(),BreakBadPotions.PURE_COMPOUND.get()));
                    output.accept(PotionUtils.setPotion(Items.POTION.getDefaultInstance(),BreakBadPotions.SEAWEED_EXTRACT.get()));
                    output.accept(BreakBadItems.FULMINATE.get());
                    output.accept(BreakBadItems.METH.get());
                    output.accept(BreakBadItems.FLAVOURING_EXTRACT.get());
                    output.accept(BreakBadItems.AMETHYST_DUST.get());
                    output.accept(BreakBadBlocks.BARREL.get().asItem());
                })
        );
    }
    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD,BreakBadItems.AMETHYST_DUST.get(), BreakBadPotions.CRYSTLAMINE_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD, Items.KELP, BreakBadPotions.SEAWEED_EXTRACT.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(BreakBadPotions.SEAWEED_EXTRACT.get(), PotionUtils.setPotion(Items.POTION.getDefaultInstance(),BreakBadPotions.CRYSTLAMINE_POTION.get()).getItem(),BreakBadPotions.PURE_COMPOUND.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(BreakBadPotions.CRYSTLAMINE_POTION.get(), PotionUtils.setPotion(Items.POTION.getDefaultInstance(),BreakBadPotions.SEAWEED_EXTRACT.get()).getItem(),BreakBadPotions.PURE_COMPOUND.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(BreakBadPotions.PURE_COMPOUND.get(), BreakBadItems.FLAVOURING_EXTRACT.get(),BreakBadItems.METH.get()));
        });
    }


    private void addCreative(CreativeModeTabEvent.BuildContents event)
    {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
