package com.mdt.breakbad.core.init;

import com.mdt.breakbad.BreakBad;
import com.mdt.breakbad.core.init.recipe.PureCompoundCustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BreakBadRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, BreakBad.MODID);

    public static final RegistryObject<RecipeSerializer<PureCompoundCustomRecipe>> PURE_COMPOUND_SERIALIZER =
            SERIALIZERS.register("crafting_pure_compound", () -> PureCompoundCustomRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
