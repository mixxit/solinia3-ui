package com.solinia.solinia3ui;

import org.lwjgl.glfw.GLFW;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class KeyBinds
{
    public static KeyBinding targetnearestnpc;
    public static KeyBinding toggleautoattack;
    public static KeyBinding canceltarget;
    public static KeyBinding targetself;
    public static KeyBinding targetteammember1;
    public static KeyBinding targetteammember2;
    public static KeyBinding targetteammember3;
    public static KeyBinding targetteammember4;
    public static KeyBinding targetteammember5;
    public static KeyBinding togglesitstand;
    public static KeyBinding castspell1;
    public static KeyBinding castspell2;
    public static KeyBinding castspell3;
    public static KeyBinding castspell4;
    public static KeyBinding castspell5;
    public static KeyBinding castspell6;
    public static KeyBinding castspell7;
    public static KeyBinding castspell8;
    public static KeyBinding castspell9;
    public static KeyBinding castspell0;
    public static KeyBinding consider;
    public static KeyBinding targetpet;
 
    public static void register()
    {
    	targetnearestnpc = new KeyBinding("key.targetnearestnpc", GLFW.GLFW_KEY_Q, "key.categories.gameplay");
    	toggleautoattack = new KeyBinding("key.toggleautoattack", GLFW.GLFW_KEY_Z, "key.categories.gameplay");
    	canceltarget = new KeyBinding("key.canceltarget", GLFW.GLFW_KEY_ESCAPE, "key.categories.gameplay");
    	targetself = new KeyBinding("key.targetself", GLFW.GLFW_KEY_F1, "key.categories.gameplay");
    	targetpet = new KeyBinding("key.targetpet", GLFW.GLFW_KEY_F7, "key.categories.gameplay");
    	targetteammember1 = new KeyBinding("key.targetteammember1", GLFW.GLFW_KEY_F2, "key.categories.gameplay");
    	targetteammember2 = new KeyBinding("key.targetteammember2", GLFW.GLFW_KEY_F3, "key.categories.gameplay");
    	targetteammember3 = new KeyBinding("key.targetteammember3", GLFW.GLFW_KEY_F4, "key.categories.gameplay");
    	targetteammember4 = new KeyBinding("key.targetteammember4", GLFW.GLFW_KEY_F5, "key.categories.gameplay");
    	targetteammember5 = new KeyBinding("key.targetteammember5", GLFW.GLFW_KEY_F6, "key.categories.gameplay");
    	castspell1 = new KeyBinding("key.castspell1", GLFW.GLFW_KEY_1, "key.categories.gameplay");
    	castspell2 = new KeyBinding("key.castspell2", GLFW.GLFW_KEY_2, "key.categories.gameplay");
    	castspell3 = new KeyBinding("key.castspell3", GLFW.GLFW_KEY_3, "key.categories.gameplay");
    	castspell4 = new KeyBinding("key.castspell4", GLFW.GLFW_KEY_4, "key.categories.gameplay");
    	castspell5 = new KeyBinding("key.castspell5", GLFW.GLFW_KEY_5, "key.categories.gameplay");
    	castspell6 = new KeyBinding("key.castspell6", GLFW.GLFW_KEY_6, "key.categories.gameplay");
    	castspell7 = new KeyBinding("key.castspell7", GLFW.GLFW_KEY_7, "key.categories.gameplay");
    	castspell8 = new KeyBinding("key.castspell8", GLFW.GLFW_KEY_8, "key.categories.gameplay");
    	castspell9 = new KeyBinding("key.castspell9", GLFW.GLFW_KEY_9, "key.categories.gameplay");
    	castspell0 = new KeyBinding("key.castspell0", GLFW.GLFW_KEY_0, "key.categories.gameplay");
       	consider = new KeyBinding("key.consider", GLFW.GLFW_KEY_C, "key.categories.gameplay");
        
        ClientRegistry.registerKeyBinding(targetnearestnpc);
        ClientRegistry.registerKeyBinding(toggleautoattack);
        ClientRegistry.registerKeyBinding(targetself);
        ClientRegistry.registerKeyBinding(canceltarget);
        ClientRegistry.registerKeyBinding(targetteammember1);
        ClientRegistry.registerKeyBinding(targetteammember2);
        ClientRegistry.registerKeyBinding(targetteammember3);
        ClientRegistry.registerKeyBinding(targetteammember4);
        ClientRegistry.registerKeyBinding(targetteammember5);
        ClientRegistry.registerKeyBinding(castspell1);
        ClientRegistry.registerKeyBinding(castspell2);
        ClientRegistry.registerKeyBinding(castspell3);
        ClientRegistry.registerKeyBinding(castspell4);
        ClientRegistry.registerKeyBinding(castspell5);
        ClientRegistry.registerKeyBinding(castspell6);
        ClientRegistry.registerKeyBinding(castspell7);
        ClientRegistry.registerKeyBinding(castspell8);
        ClientRegistry.registerKeyBinding(castspell9);
        ClientRegistry.registerKeyBinding(castspell0);
        ClientRegistry.registerKeyBinding(consider);
        ClientRegistry.registerKeyBinding(targetpet);
    }
}