package com.mdt.breakbad.common.items;

import com.mdt.breakbad.BREAKBAD;
import com.mdt.breakbad.common.BreakBadArmourMaterials;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class GasMaskArmourItem extends ArmorItem {
    public GasMaskArmourItem(BreakBadArmourMaterials p_i48534_1_, EquipmentSlotType p_i48534_2_, Properties p_i48534_3_) {
        super(p_i48534_1_, p_i48534_2_, p_i48534_3_);
    }
    @Override
    public void inventoryTick(ItemStack pStack, World pLevel, Entity pEntity, int pItemSlot, boolean pIsSelected) {
        super.inventoryTick(pStack, pLevel, pEntity, pItemSlot, pIsSelected);
    }



    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return null;
    }

    @Nullable
    @Override
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default) {
        return null;
    }
}
