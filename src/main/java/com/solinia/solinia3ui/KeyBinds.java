package com.solinia.solinia3ui;

import org.lwjgl.glfw.GLFW;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class KeyBinds
{
    public static KeyBinding targetNearestNPC;
 
    public static void register()
    {
    	targetNearestNPC = new KeyBinding("key.targetnearestnpc", GLFW.GLFW_KEY_Q, "key.categories.gameplay");
 
        ClientRegistry.registerKeyBinding(targetNearestNPC);
    }
}