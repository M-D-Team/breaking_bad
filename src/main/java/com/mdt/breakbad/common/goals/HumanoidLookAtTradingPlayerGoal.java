package com.mdt.breakbad.common.goals;

import com.mdt.breakbad.common.entities.MerchantHumanoidEntity;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;

public class HumanoidLookAtTradingPlayerGoal extends LookAtPlayerGoal {
    private final MerchantHumanoidEntity merchant;

    public HumanoidLookAtTradingPlayerGoal(MerchantHumanoidEntity p_25538_) {
        super(p_25538_, Player.class, 8.0F);
        this.merchant = p_25538_;
    }

    public boolean canUse() {
        if (this.merchant.isTrading()) {
            this.lookAt = this.merchant.getTradingPlayer();
            return true;
        } else {
            return false;
        }
    }
}