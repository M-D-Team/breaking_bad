package com.mdt.breakbad.util;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.event.entity.living.PotionColorCalculationEvent;

// BetterBrewingRecipe Class by CAS-ual-TY from https://github.com/CAS-ual-TY/Extra-Potions (GPL-3.0 License)
// https://github.com/CAS-ual-TY/Extra-Potions/blob/main/LICENSE
public class BetterBrewingRecipe implements IBrewingRecipe {
    private final Object input;
    private final Item ingredient;
    private final Object output;
    private boolean validParams;

    public BetterBrewingRecipe(Object input, Item ingredient,Object output) {
        this.input = input;
        this.ingredient = ingredient;
        this.output = output;
        // Because i want to be able to output Items AND Potions, im making this allow any object and then checking to see if its valid for Items or Potions.
        if (this.output instanceof Item || this.input instanceof Item) {
            this.validParams = true;
        } else if (this.output instanceof Potion || this.input instanceof Potion) {
            this.validParams = true;
        } else {
            this.validParams = false;
        }
    }

    @Override
    public boolean isInput(ItemStack input) {
        if (this.input instanceof Potion) {
            return PotionUtils.getPotion(input) == this.input;
        } else if (this.input instanceof Item) {
            return input == ((Item) this.input).getDefaultInstance();
        }
        return false;
    }

    @Override
    public boolean isIngredient(ItemStack ingredient) {
        return ingredient.getItem() == this.ingredient;
    }

    @Override
    public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
        if(!this.isInput(input) || !this.isIngredient(ingredient)) {
            return ItemStack.EMPTY;
        }
        if (!this.validParams) {
            return ItemStack.EMPTY;
        }
        if (this.output instanceof Potion) {
            ItemStack itemStack = new ItemStack(input.getItem());
            itemStack.setTag(new CompoundTag());
            PotionUtils.setPotion(itemStack, (Potion) this.output);
            return itemStack;
        } else if (this.output instanceof Item) {
            ItemStack itemStack = new ItemStack(((Item) this.output).asItem());
            return itemStack;
        }
        return null;
    }
}