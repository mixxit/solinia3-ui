package com.solinia.solinia3ui;

import org.lwjgl.glfw.GLFW;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class KeyBinds
{
    public KeyBinding targetnearestnpc;
    public KeyBinding toggleautoattack;
    public KeyBinding canceltarget;
    public KeyBinding targetself;
    public KeyBinding targetteammember1;
    public KeyBinding targetteammember2;
    public KeyBinding targetteammember3;
    public KeyBinding targetteammember4;
    public KeyBinding targetteammember5;
    public KeyBinding togglesitstand;
    public KeyBinding castspell1;
    public KeyBinding castspell2;
    public KeyBinding castspell3;
    public KeyBinding castspell4;
    public KeyBinding castspell5;
    public KeyBinding castspell6;
    public KeyBinding castspell7;
    public KeyBinding castspell8;
    public KeyBinding consider;
    public KeyBinding targetpet;
    public KeyBinding openspellbook;
 
    public void registerKeyBinds()
    {
    	targetnearestnpc = new KeyBinding("key.targetnearestnpc", KeyConflictContext.IN_GAME,KeyModifier.NONE, InputMappings.Type.KEYSYM, GLFW.GLFW_KEY_R, "key.categories.solinia");
    	toggleautoattack = new KeyBinding("key.toggleautoattack", KeyConflictContext.IN_GAME,KeyModifier.NONE,InputMappings.Type.KEYSYM,  GLFW.GLFW_KEY_Z, "key.categories.solinia");
    	canceltarget = new KeyBinding("key.canceltarget", KeyConflictContext.IN_GAME, KeyModifier.NONE,InputMappings.Type.KEYSYM,  GLFW.GLFW_KEY_GRAVE_ACCENT, "key.categories.solinia");
    	targetself = new KeyBinding("key.targetself", KeyConflictContext.IN_GAME,KeyModifier.NONE,InputMappings.Type.KEYSYM,  GLFW.GLFW_KEY_X, "key.categories.solinia");
    	targetpet = new KeyBinding("key.targetpet", KeyConflictContext.IN_GAME,KeyModifier.NONE,InputMappings.Type.KEYSYM,  GLFW.GLFW_KEY_P, "key.categories.gameplay");
    	targetteammember1 = new KeyBinding("key.targetteammember1", KeyConflictContext.IN_GAME,KeyModifier.NONE,InputMappings.Type.KEYSYM,  GLFW.GLFW_KEY_F5, "key.categories.solinia");
    	targetteammember2 = new KeyBinding("key.targetteammember2", KeyConflictContext.IN_GAME,KeyModifier.NONE, InputMappings.Type.KEYSYM, GLFW.GLFW_KEY_F6, "key.categories.solinia");
    	targetteammember3 = new KeyBinding("key.targetteammember3", KeyConflictContext.IN_GAME,KeyModifier.NONE, InputMappings.Type.KEYSYM, GLFW.GLFW_KEY_F7, "key.categories.solinia");
    	targetteammember4 = new KeyBinding("key.targetteammember4", KeyConflictContext.IN_GAME,KeyModifier.NONE,InputMappings.Type.KEYSYM,  GLFW.GLFW_KEY_F8, "key.categories.solinia");
    	targetteammember5 = new KeyBinding("key.targetteammember5", KeyConflictContext.IN_GAME,KeyModifier.NONE,InputMappings.Type.KEYSYM,  GLFW.GLFW_KEY_F9, "key.categories.solinia");
    	togglesitstand = new KeyBinding("key.togglesitstand", KeyConflictContext.IN_GAME,KeyModifier.NONE, InputMappings.Type.KEYSYM, GLFW.GLFW_KEY_V, "key.categories.solinia");
    	castspell1 = new KeyBinding("key.castspell1", KeyConflictContext.IN_GAME,KeyModifier.NONE,InputMappings.Type.KEYSYM,  GLFW.GLFW_KEY_1, "key.categories.solinia");
    	castspell2 = new KeyBinding("key.castspell2", KeyConflictContext.IN_GAME,KeyModifier.NONE,InputMappings.Type.KEYSYM,  GLFW.GLFW_KEY_2, "key.categories.solinia");
    	castspell3 = new KeyBinding("key.castspell3", KeyConflictContext.IN_GAME,KeyModifier.NONE,InputMappings.Type.KEYSYM,  GLFW.GLFW_KEY_3, "key.categories.solinia");
    	castspell4 = new KeyBinding("key.castspell4", KeyConflictContext.IN_GAME,KeyModifier.NONE,InputMappings.Type.KEYSYM,  GLFW.GLFW_KEY_4, "key.categories.solinia");
    	castspell5 = new KeyBinding("key.castspell5", KeyConflictContext.IN_GAME,KeyModifier.NONE,InputMappings.Type.KEYSYM,  GLFW.GLFW_KEY_5, "key.categories.solinia");
    	castspell6 = new KeyBinding("key.castspell6", KeyConflictContext.IN_GAME,KeyModifier.NONE,InputMappings.Type.KEYSYM,  GLFW.GLFW_KEY_6, "key.categories.solinia");
    	castspell7 = new KeyBinding("key.castspell7", KeyConflictContext.IN_GAME,KeyModifier.NONE,InputMappings.Type.KEYSYM,  GLFW.GLFW_KEY_7, "key.categories.solinia");
    	castspell8 = new KeyBinding("key.castspell8", KeyConflictContext.IN_GAME,KeyModifier.NONE,InputMappings.Type.KEYSYM,  GLFW.GLFW_KEY_8, "key.categories.solinia");
       	consider = new KeyBinding("key.consider", KeyConflictContext.IN_GAME,KeyModifier.NONE,InputMappings.Type.KEYSYM,  GLFW.GLFW_KEY_C, "key.categories.solinia");
       	openspellbook = new KeyBinding("key.openspellbook", KeyConflictContext.IN_GAME,KeyModifier.NONE,InputMappings.Type.KEYSYM,  GLFW.GLFW_KEY_K, "key.categories.solinia");
        
        ClientRegistry.registerKeyBinding(targetnearestnpc);
        ClientRegistry.registerKeyBinding(toggleautoattack);
        ClientRegistry.registerKeyBinding(targetself);
        ClientRegistry.registerKeyBinding(canceltarget);
        ClientRegistry.registerKeyBinding(targetteammember1);
        ClientRegistry.registerKeyBinding(targetteammember2);
        ClientRegistry.registerKeyBinding(targetteammember3);
        ClientRegistry.registerKeyBinding(targetteammember4);
        ClientRegistry.registerKeyBinding(targetteammember5);
        ClientRegistry.registerKeyBinding(togglesitstand);
        ClientRegistry.registerKeyBinding(castspell1);
        ClientRegistry.registerKeyBinding(castspell2);
        ClientRegistry.registerKeyBinding(castspell3);
        ClientRegistry.registerKeyBinding(castspell4);
        ClientRegistry.registerKeyBinding(castspell5);
        ClientRegistry.registerKeyBinding(castspell6);
        ClientRegistry.registerKeyBinding(castspell7);
        ClientRegistry.registerKeyBinding(castspell8);
        ClientRegistry.registerKeyBinding(consider);
        ClientRegistry.registerKeyBinding(targetpet);
        ClientRegistry.registerKeyBinding(openspellbook);
    }
}