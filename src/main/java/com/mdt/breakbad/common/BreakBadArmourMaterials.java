//package com.mdt.breakbad.common;
//
//import net.minecraft.sounds.SoundEvent;
//import net.minecraft.sounds.SoundEvents;
//import net.minecraft.util.LazyLoadedValue;
//import net.minecraft.world.entity.EquipmentSlot;
//import net.minecraft.world.item.ArmorItem;
//import net.minecraft.world.item.ArmorMaterial;
//import net.minecraft.world.item.Items;
//import net.minecraft.world.item.crafting.Ingredient;
//
//import java.util.function.Supplier;
//
//public enum BreakBadArmourMaterials implements ArmorMaterial {
//    GAS_MASK("gas_mask", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
//        return Ingredient.of(Items.IRON_INGOT);
//    });
//
//    private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
//    private final String name;
//    private final int durabilityMultiplier;
//    private final int[] slotProtections;
//    private final int enchantmentValue;
//    private final SoundEvent sound;
//    private final float toughness;
//    private final float knockbackResistance;
//    private final LazyLoadedValue<Ingredient> repairIngredient;
//
//    private BreakBadArmourMaterials(String p_40474_, int p_40475_, int[] p_40476_, int p_40477_, SoundEvent p_40478_, float p_40479_, float p_40480_, Supplier<Ingredient> p_40481_) {
//        this.name = p_40474_;
//        this.durabilityMultiplier = p_40475_;
//        this.slotProtections = p_40476_;
//        this.enchantmentValue = p_40477_;
//        this.sound = p_40478_;
//        this.toughness = p_40479_;
//        this.knockbackResistance = p_40480_;
//        this.repairIngredient = new LazyLoadedValue<>(p_40481_);
//    }
//
//    public int getDurabilityForSlot(EquipmentSlot p_40484_) {
//        return HEALTH_PER_SLOT[p_40484_.getIndex()] * this.durabilityMultiplier;
//    }
//
//    public int getDefenseForSlot(EquipmentSlot p_40487_) {
//        return this.slotProtections[p_40487_.getIndex()];
//    }
//
//    @Override
//    public int getDurabilityForType(ArmorItem.Type p_266807_) {
//        return 0;
//    }
//
//    @Override
//    public int getDefenseForType(ArmorItem.Type p_267168_) {
//        return 0;
//    }
//
//    public int getEnchantmentValue() {
//        return this.enchantmentValue;
//    }
//
//    public SoundEvent getEquipSound() {
//        return this.sound;
//    }
//
//    public Ingredient getRepairIngredient() {
//        return this.repairIngredient.get();
//    }
//
//    public String getName() {
//        return this.name;
//    }
//
//    public float getToughness() {
//        return this.toughness;
//    }
//
//    public float getKnockbackResistance() {
//        return this.knockbackResistance;
//    }
//}