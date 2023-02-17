package com.mdt.breakbad.common.entities;

import com.mdt.breakbad.core.init.BreakBadEntities;
import com.mdt.breakbad.core.init.BreakBadItems;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class Fulminate extends ThrowableItemProjectile {
    public int explosionRadius = 3;
    public Fulminate(EntityType<? extends Fulminate> type, Level level) {
        super(type, level);
    }

    public Fulminate(Level level, LivingEntity entity) {
        super(BreakBadEntities.FULMINATE_ENTITY.get(), entity, level);
    }

    public Fulminate(Level level, double xPos, double yPos, double zPos) {
        super(BreakBadEntities.FULMINATE_ENTITY.get(), xPos, yPos, zPos, level);
    }

    protected Item getDefaultItem() {
        return BreakBadItems.FULMINATE.get();
    }

    private ParticleOptions getParticle() {
        ItemStack itemstack = this.getItemRaw();
        return (ParticleOptions)(itemstack.isEmpty() ? ParticleTypes.ITEM_SNOWBALL : new ItemParticleOption(ParticleTypes.ITEM, itemstack));
    }

    public void handleEntityEvent(byte p_37402_) {
        if (p_37402_ == 3) {
            ParticleOptions particleoptions = this.getParticle();

            for(int i = 0; i < 8; ++i) {
                this.level.addParticle(particleoptions, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
            }
        }

    }

    public void explode(Fulminate entity) {
        if (!this.level.isClientSide) {
            this.level.explode(null, entity.getX(), entity.getY(),entity.getZ(),entity.explosionRadius,Level.ExplosionInteraction.MOB);
        }
    }
    protected void onHitEntity(EntityHitResult hitResult) {
        super.onHitEntity(hitResult);
        Entity entity = hitResult.getEntity();
        entity.hurt(DamageSource.thrown(this, this.getOwner()), (float)0);
        explode(this);
    }

    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);
        if (!this.level.isClientSide) {
            this.level.broadcastEntityEvent(this, (byte)3);
            explode(this);
            this.discard();
        }

    }
}