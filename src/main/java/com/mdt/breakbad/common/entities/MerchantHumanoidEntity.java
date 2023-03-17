package com.mdt.breakbad.common.entities;

import com.mdt.breakbad.common.goals.HumanoidLookAtTradingPlayerGoal;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.InventoryCarrier;
import net.minecraft.world.entity.npc.Npc;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.Merchant;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

public abstract class MerchantHumanoidEntity extends HumanoidEntity implements InventoryCarrier, Npc, Merchant {
    public static final int MERCHANT_SLOT_OFFSET = 300;
    private static final int MERCHANT_INVENTORY_SIZE = 8;
    @Nullable
    private Player tradingPlayer;
    @Nullable
    protected MerchantOffers offers;

    // A list of trades for the merchant to have, of type MerchantOffer.
    // Override this in your child of this class to add new trades
    // for an example see the Gus entity.
    public MerchantOffer[] offerList = {};
    private final SimpleContainer inventory = new SimpleContainer(8);
    public MerchantHumanoidEntity(EntityType<? extends MerchantHumanoidEntity> entityType, Level level) {
        super(entityType, level);
    }

    public MerchantHumanoidEntity(EntityType<? extends MerchantHumanoidEntity> entityType, Level level, String customName, ResourceLocation skin) {
        super(entityType, level, customName, skin);
    }

    public MerchantHumanoidEntity(EntityType<? extends MerchantHumanoidEntity> entityType, Level level, String customName) {
        super(entityType, level, customName);
    }

    public MerchantHumanoidEntity(EntityType<? extends MerchantHumanoidEntity> entityType, Level level, ResourceLocation skin) {
        super(entityType, level, skin);
    }

    @Override
    protected InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (this.isAlive() && !this.isTrading() && !this.isSleeping() && !player.isSecondaryUseActive()) {
                boolean flag = this.getOffers().isEmpty();
                if (hand == InteractionHand.MAIN_HAND) {
                    player.awardStat(Stats.TALKED_TO_VILLAGER);
                }

                if (flag) {
                    return InteractionResult.sidedSuccess(this.level.isClientSide);
                } else {
                    if (!this.level.isClientSide && !this.offers.isEmpty()) {
                        this.startTrading(player);
                    }

                    return InteractionResult.sidedSuccess(this.level.isClientSide);
                }
            } else {
            return super.mobInteract(player, hand);
        }
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new HumanoidLookAtTradingPlayerGoal(this));
    }

    private void startTrading(Player p_35537_) {
        this.setTradingPlayer(p_35537_);
        this.openTradingScreen(p_35537_, this.getDisplayName(), 0);
    }

    @Override
    public SimpleContainer getInventory() {
        return this.inventory;
    }

    @Override
    public void setTradingPlayer(@Nullable Player player) {
        this.tradingPlayer = player;
    }

    @Nullable
    @Override
    public Player getTradingPlayer() {
        return this.tradingPlayer;
    }

    public boolean isTrading() {
        return this.tradingPlayer != null;
    }

    @Override
    public MerchantOffers getOffers() {
        if (this.offers == null) {
            this.offers = new MerchantOffers();
            // Adds all the trades
            this.offers.addAll(Arrays.asList(offerList));
        }
        return this.offers;
    }

    @Override
    public void overrideOffers(MerchantOffers p_45306_) {

    }

    @Override
    public void notifyTrade(MerchantOffer p_45305_) {

    }

    @Override
    public void notifyTradeUpdated(ItemStack p_45308_) {

    }

    @Override
    public int getVillagerXp() {
        return 0;
    }

    @Override
    public void overrideXp(int p_45309_) {

    }

    @Override
    public boolean showProgressBar() {
        return false;
    }

    @Override
    public SoundEvent getNotifyTradeSound() {
        return null;
    }

    @Override
    public boolean isClientSide() {
        return this.level.isClientSide;
    }
}
