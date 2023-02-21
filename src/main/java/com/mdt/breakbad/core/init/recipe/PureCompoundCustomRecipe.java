package com.mdt.breakbad.core.init.recipe;


import com.google.gson.JsonObject;
import com.mdt.breakbad.BreakBad;
import com.mdt.breakbad.core.init.BreakBadItems;
import com.mdt.breakbad.core.init.BreakBadPotions;
import com.mdt.breakbad.core.init.BreakBadRecipes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class PureCompoundCustomRecipe extends CustomRecipe {
    public PureCompoundCustomRecipe(ResourceLocation p_250995_, CraftingBookCategory p_252163_) {
        super(p_250995_, p_252163_);
    }

    public boolean matches(CraftingContainer p_44515_, Level p_44516_) {
        if (p_44515_.getWidth() == 3 && p_44515_.getHeight() == 3) {
            for(int i = 0; i < p_44515_.getWidth(); ++i) {
                for(int j = 0; j < p_44515_.getHeight(); ++j) {
                    ItemStack itemstack = p_44515_.getItem(i + j * p_44515_.getWidth());
                    if (itemstack.isEmpty()) {
                        return false;
                    }

                    if (i == 1 && j == 1) {
                        if (PotionUtils.getPotion(itemstack) != BreakBadPotions.CRYSTLAMINE_POTION.get()) {
                            return false;
                        }
                    } else if (PotionUtils.getPotion(itemstack) != BreakBadPotions.SEAWEED_EXTRACT.get()) {
                        return false;
                    }
                }
            }

            return true;
        } else {
            return false;
        }
    }

    public ItemStack assemble(CraftingContainer p_44513_) {
        ItemStack itemstack = p_44513_.getItem(1 + p_44513_.getWidth());
        if (PotionUtils.getPotion(itemstack) != BreakBadPotions.CRYSTLAMINE_POTION.get()) {
            return ItemStack.EMPTY;
        } else {
            ItemStack itemstack1 = new ItemStack(BreakBadItems.PURE_COMPOUND.get(), 1);
            PotionUtils.setPotion(itemstack1, PotionUtils.getPotion(itemstack));
            PotionUtils.setCustomEffects(itemstack1, PotionUtils.getCustomEffects(itemstack));
            return itemstack1;
        }
    }

    public boolean canCraftInDimensions(int p_44505_, int p_44506_) {
        return p_44505_ >= 2 && p_44506_ >= 2;
    }

    public static class Serializer implements RecipeSerializer<PureCompoundCustomRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(BreakBad.MODID, "pure_compound");

        @Override
        public PureCompoundCustomRecipe fromJson(ResourceLocation p_44103_, JsonObject p_44104_) {
            return null;
        }

        @Override
        public @Nullable PureCompoundCustomRecipe fromNetwork(ResourceLocation p_44105_, FriendlyByteBuf p_44106_) {
            return null;
        }

        @Override
        public void toNetwork(FriendlyByteBuf p_44101_, PureCompoundCustomRecipe p_44102_) {

        }
    }
    public RecipeSerializer<?> getSerializer() {
        return BreakBadRecipes.PURE_COMPOUND_SERIALIZER.get();
    }
}