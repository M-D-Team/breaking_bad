package com.mdt.breakbad.common.entities.rideables;

import com.mdt.breakbad.common.entities.HumanoidEntity;
import com.mdt.breakbad.common.entities.humanoids.HectorEntity;
import com.mdt.breakbad.core.init.BreakBadItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector3f;

import javax.annotation.Nullable;

public class WheelchairEntity extends Mob {
    public WheelchairEntity(EntityType<? extends Mob> p_20966_, Level p_20967_) {
        super(p_20966_, p_20967_);
    }

    public boolean bellAttained = false;
    public boolean tntAttained = false;

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        if (hand == InteractionHand.MAIN_HAND) {
            ItemStack handStack = player.getItemInHand(InteractionHand.MAIN_HAND);
            if(handStack != ItemStack.EMPTY) {
                // Add a bell if the players holding one
                if(compareItemStackToItem(handStack,Items.BELL)) {
                    this.setBell(true);
                    handStack.setCount(handStack.getCount() - 1);
                }
                // Add TNT if the players holding TNT
                if(compareItemStackToItem(handStack, Items.TNT)) {
                    this.setTNT(true);
                    handStack.setCount(handStack.getCount() - 1);
                }
            } else {
                // If the player is crouching and this has a bell then remove the bell
                if(this.hasBell() && player.isCrouching()) {
                    player.addItem(new ItemStack(Items.BELL));
                    this.setBell(false);
                    return InteractionResult.SUCCESS;
                }
                // If the player is crouching and this has TNT then remove the TNT
                else if (this.hasTNT() && player.isCrouching()) {
                    player.addItem(new ItemStack(Items.TNT));
                    this.setTNT(false);
                    return InteractionResult.SUCCESS;
                }
                player.startRiding(this);
            } return InteractionResult.SUCCESS;
        }
        return InteractionResult.SUCCESS;
    }

    /**
     * Compares if two {@link Item Items} are the same
     * @param first The first item
     * @param second The second item
     * @return If they're the same
     */
    public static boolean compareTwoItem(Item first, Item second) {
        return first == second;
    }

    /**
     * Compares if two {@link ItemStack ItemStacks} are the same
     * @param first First itemstack
     * @param second Second itemstack
     * @return If they're the same
     */
    public static boolean compareTwoItemStack(ItemStack first, ItemStack second) {
        return compareTwoItem(first.getItem(),second.getItem());
    }
    /**
     * Compares if an {@link ItemStack ItemStack} is the same to an {@link Item Item}
     * @param stack The ItemStack
     * @param item The Item
     * @return If they're the same
     */
    public static boolean compareItemStackToItem(ItemStack stack, Item item) {
        return compareTwoItem(stack.getItem(), item);
    }

    public boolean hasBell() {
        return this.bellAttained;
    }

    public void setBell(boolean b) {
        this.bellAttained = b;
    }

    public boolean hasTNT() {
        return this.tntAttained;
    }

    public void setTNT(boolean b) {
        this.tntAttained = b;
    }

    public void travel(Vec3 p_30633_) {
        if (this.isAlive()) {
            LivingEntity livingentity = this.getControllingPassenger();
            if (this.isVehicle() && livingentity != null) {
                this.setRot(livingentity.getYRot(), livingentity.getXRot() * 0.5F);
                this.yRotO = this.yBodyRot = this.yHeadRot = this.getYRot();
                float f = livingentity.xxa * 0.5F;
                float f1 = livingentity.zza;
                if (f1 <= 0.0F) {
                    f1 *= 0.25F;
                }

                this.flyingSpeed = this.getSpeed() * 0.1F;
                if (this.isControlledByLocalInstance()) {
                    this.setSpeed(this.getDrivenMovementSpeed(livingentity));
                    super.travel(new Vec3((double)f, p_30633_.y, (double)f1));
                } else if (livingentity instanceof Player) {
                    this.setDeltaMovement(this.getX() - this.xOld, this.getY() - this.yOld, this.getZ() - this.zOld);
                }

                this.calculateEntityAnimation(this, false);
                this.tryCheckInsideBlocks();
            } else {
                this.flyingSpeed = 0.02F;
                super.travel(p_30633_);
            }
        }
    }

    public double getMovingX() {
        return this.getDeltaMovement().x();
    }

    public double getMovingZ() {
        return this.getDeltaMovement().z();
    }

    @Nullable
    public LivingEntity getControllingPassenger() {
        Entity entity = this.getFirstPassenger();
        if (entity instanceof LivingEntity) {
            return (LivingEntity)entity;
        }

        return null;
    }

    protected float getDrivenMovementSpeed(LivingEntity p_250911_) {
        return (float)this.getAttributeValue(Attributes.MOVEMENT_SPEED);
    }

    @Override
    protected void dropCustomDeathLoot(DamageSource pSource, int pLooting, boolean pRecentlyHit) {
        super.dropCustomDeathLoot(pSource, pLooting, pRecentlyHit);
        this.spawnAtLocation(BreakBadItems.WHEELCHAIR_ITEM.get());
    }

    public void positionRider(Entity entity) {
        super.positionRider(entity);
        float f = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
        float f1 = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
        float f2 = 0.1F;
        float f3 = 0.0F;
        if(entity instanceof HumanoidEntity) {
            entity.setPos(this.getX() + (double) (0.1F * f), this.getY(-0.05D) + entity.getMyRidingOffset() + 0.0D, this.getZ() - (double) (0.1F * f1));
        } else {
            entity.setPos(this.getX() + (double) (0.1F * f), this.getY(0.25D) + entity.getMyRidingOffset() + 0.0D, this.getZ() - (double) (0.1F * f1));
        }
        if (entity instanceof LivingEntity) {
            ((LivingEntity) entity).yBodyRot = this.yBodyRot;
        }
    }

    public void explode() {
        this.getLevel().explode(this,this.getX(),this.getY(),this.getZ(),5, Level.ExplosionInteraction.MOB);
        this.kill();
    }

    @Override
    public void readAdditionalSaveData(CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);
        this.bellAttained = nbt.getBoolean("bellAttained");
        this.tntAttained = nbt.getBoolean("tntAttained");
    }

    @Override
    public void addAdditionalSaveData(CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);
        nbt.putBoolean("bellAttained", this.bellAttained);
        nbt.putBoolean("tntAttained", this.tntAttained);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getFirstPassenger() != null) {
            Entity passenger = this.getFirstPassenger();
            this.setXRot(passenger.getXRot());
            this.setYRot(passenger.getYRot());
            this.setYBodyRot(passenger.getYRot());
        }
    }

    public static AttributeSupplier.Builder getWheelchairAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 25.0D).add(Attributes.MOVEMENT_SPEED, 0.05D).add(Attributes.ATTACK_DAMAGE, 0D);
    }
}
