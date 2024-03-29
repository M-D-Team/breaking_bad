package com.mdt.breakbad.common.entities;

import com.mdt.breakbad.BreakBad;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.level.Level;

/*
* Class information
* * How to allow picking up items
* * * When you want items to be allowed, simply call entity.setCanPickUpLoot( put a boolean here )
* * * If you want it to move towards nearby items, add MoveTowardsItemGoal as a new goal
 */

public class HumanoidEntity extends PathfinderMob {
    private static final ResourceLocation ERROR_TEXTURE = new ResourceLocation(BreakBad.MODID,"textures/entities/humanoid/error.png");
    public String customName = "ERROR";
    public ResourceLocation skin;

    public HumanoidEntity(EntityType<? extends HumanoidEntity> entityType, Level level) {
        super(entityType, level);
        this.skin = ERROR_TEXTURE;
        this.setCustomName(Component.translatable(this.customName));
        this.setCustomNameVisible(true);
    }

    public HumanoidEntity(EntityType<? extends HumanoidEntity> entityType, Level level,String customName, ResourceLocation skin) {
        this(entityType,level);
        this.customName = customName;
        this.skin = skin;
        this.setCustomName(Component.translatable(this.customName));
    }

    public HumanoidEntity(EntityType<? extends HumanoidEntity> entityType, Level level,String customName) {
        this(entityType,level);
        this.customName = customName;
        this.skin = ERROR_TEXTURE;
        this.setCustomName(Component.translatable(this.customName));
    }

    public HumanoidEntity(EntityType<? extends HumanoidEntity> entityType, Level level,ResourceLocation skin) {
        this(entityType,level);
        this.skin = skin;
        this.setCustomName(Component.translatable(this.customName));
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(3, new OpenDoorGoal(this,true));
        this.goalSelector.addGoal(2,new HurtByTargetGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.5D,true));
        this.goalSelector.addGoal(1, new FloatGoal(this));
    }

    public static AttributeSupplier.Builder getHumanoidAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 25.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 1D);
    }
}
