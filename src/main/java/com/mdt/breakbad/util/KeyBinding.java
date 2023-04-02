package com.mdt.breakbad.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {
    public static final String KEY_CATEGORY_BREAKBAD = "key.category.mdt.breakbad";
    public static final String KEY_RING_BELL = "key.mdt.ring_bell";
    public static final String KEY_IGNITE_TNT = "key.mdt.ignite_tnt";
    public static final KeyMapping RING_BELL = new KeyMapping(KEY_RING_BELL,
            KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_B, KEY_CATEGORY_BREAKBAD);

    public static final KeyMapping IGNITE_TNT = new KeyMapping(
            KEY_IGNITE_TNT,
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_V,
            KEY_CATEGORY_BREAKBAD
    );
}
