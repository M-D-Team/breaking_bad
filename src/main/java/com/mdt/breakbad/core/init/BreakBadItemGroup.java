package com.mdt.breakbad.core.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class BreakBadItemGroup {
    public static final ItemGroup BREAKING_BAD_TAB = new ItemGroup("breaking_bad_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(BreakBadItems.METH.get());
        }
    };
}
