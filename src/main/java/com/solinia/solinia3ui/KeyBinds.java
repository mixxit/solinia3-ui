package com.solinia.solinia3ui;

import org.lwjgl.glfw.GLFW;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class KeyBinds
{
    public Solinia3UIKeyBinding targetnearestnpc;
    public Solinia3UIKeyBinding toggleautoattack;
    public Solinia3UIKeyBinding canceltarget;
    public Solinia3UIKeyBinding targetself;
    public Solinia3UIKeyBinding targetteammember1;
    public Solinia3UIKeyBinding targetteammember2;
    public Solinia3UIKeyBinding targetteammember3;
    public Solinia3UIKeyBinding targetteammember4;
    public Solinia3UIKeyBinding targetteammember5;
    public Solinia3UIKeyBinding togglesitstand;
    public Solinia3UIKeyBinding castspell1;
    public Solinia3UIKeyBinding castspell2;
    public Solinia3UIKeyBinding castspell3;
    public Solinia3UIKeyBinding castspell4;
    public Solinia3UIKeyBinding castspell5;
    public Solinia3UIKeyBinding castspell6;
    public Solinia3UIKeyBinding castspell7;
    public Solinia3UIKeyBinding castspell8;
    public Solinia3UIKeyBinding consider;
    public Solinia3UIKeyBinding targetpet;
    public Solinia3UIKeyBinding openspellbook;
    public Solinia3UIKeyBinding hail;
    public Solinia3UIKeyBinding opencharactercreation;
    public Solinia3UIKeyBinding petattack;
 
    public void registerKeyBinds()
    {
    	hail = new Solinia3UIKeyBinding("key.hail", KeyConflictContext.IN_GAME,KeyModifier.NONE, InputMappings.Type.KEYSYM, GLFW.GLFW_KEY_H, "key.categories.solinia");
    	targetnearestnpc = new Solinia3UIKeyBinding("key.targetnearestnpc", KeyConflictContext.IN_GAME,KeyModifier.CONTROL, InputMappings.Type.KEYSYM, GLFW.GLFW_KEY_R, "key.categories.solinia");
    	toggleautoattack = new Solinia3UIKeyBinding("key.toggleautoattack", KeyConflictContext.IN_GAME,KeyModifier.NONE,InputMappings.Type.KEYSYM,  GLFW.GLFW_KEY_Z, "key.categories.solinia");
    	canceltarget = new Solinia3UIKeyBinding("key.canceltarget", KeyConflictContext.IN_GAME, KeyModifier.NONE,InputMappings.Type.KEYSYM,  GLFW.GLFW_KEY_GRAVE_ACCENT, "key.categories.solinia");
    	targetself = new Solinia3UIKeyBinding("key.targetself", KeyConflictContext.IN_GAME,KeyModifier.CONTROL,InputMappings.Type.KEYSYM,  GLFW.GLFW_KEY_1, "key.categories.solinia");
    	targetpet = new Solinia3UIKeyBinding("key.targetpet", KeyConflictContext.IN_GAME,KeyModifier.CONTROL,InputMappings.Type.KEYSYM,  GLFW.GLFW_KEY_P, "key.categories.gameplay");
    	targetteammember1 = new Solinia3UIKeyBinding("key.targetteammember1", KeyConflictContext.IN_GAME,KeyModifier.CONTROL,InputMappings.Type.KEYSYM, GLFW.GLFW_KEY_2, "key.categories.solinia");
    	targetteammember2 = new Solinia3UIKeyBinding("key.targetteammember2", KeyConflictContext.IN_GAME,KeyModifier.CONTROL, InputMappings.Type.KEYSYM, GLFW.GLFW_KEY_3, "key.categories.solinia");
    	targetteammember3 = new Solinia3UIKeyBinding("key.targetteammember3", KeyConflictContext.IN_GAME,KeyModifier.CONTROL, InputMappings.Type.KEYSYM, GLFW.GLFW_KEY_4, "key.categories.solinia");
    	targetteammember4 = new Solinia3UIKeyBinding("key.targetteammember4", KeyConflictContext.IN_GAME,KeyModifier.CONTROL,InputMappings.Type.KEYSYM,  GLFW.GLFW_KEY_5, "key.categories.solinia");
    	targetteammember5 = new Solinia3UIKeyBinding("key.targetteammember5", KeyConflictContext.IN_GAME,KeyModifier.CONTROL,InputMappings.Type.KEYSYM,  GLFW.GLFW_KEY_6, "key.categories.solinia");
    	togglesitstand = new Solinia3UIKeyBinding("key.togglesitstand", KeyConflictContext.IN_GAME,KeyModifier.NONE, InputMappings.Type.KEYSYM, GLFW.GLFW_KEY_V, "key.categories.solinia");
    	castspell1 = new Solinia3UIKeyBinding("key.castspell1", KeyConflictContext.IN_GAME,KeyModifier.ALT,InputMappings.Type.KEYSYM,  GLFW.GLFW_KEY_1, "key.categories.solinia");
    	castspell2 = new Solinia3UIKeyBinding("key.castspell2", KeyConflictContext.IN_GAME,KeyModifier.ALT,InputMappings.Type.KEYSYM,  GLFW.GLFW_KEY_2, "key.categories.solinia");
    	castspell3 = new Solinia3UIKeyBinding("key.castspell3", KeyConflictContext.IN_GAME,KeyModifier.ALT,InputMappings.Type.KEYSYM,  GLFW.GLFW_KEY_3, "key.categories.solinia");
    	castspell4 = new Solinia3UIKeyBinding("key.castspell4", KeyConflictContext.IN_GAME,KeyModifier.ALT,InputMappings.Type.KEYSYM,  GLFW.GLFW_KEY_4, "key.categories.solinia");
    	castspell5 = new Solinia3UIKeyBinding("key.castspell5", KeyConflictContext.IN_GAME,KeyModifier.ALT,InputMappings.Type.KEYSYM,  GLFW.GLFW_KEY_5, "key.categories.solinia");
    	castspell6 = new Solinia3UIKeyBinding("key.castspell6", KeyConflictContext.IN_GAME,KeyModifier.ALT,InputMappings.Type.KEYSYM,  GLFW.GLFW_KEY_6, "key.categories.solinia");
    	castspell7 = new Solinia3UIKeyBinding("key.castspell7", KeyConflictContext.IN_GAME,KeyModifier.ALT,InputMappings.Type.KEYSYM,  GLFW.GLFW_KEY_7, "key.categories.solinia");
    	castspell8 = new Solinia3UIKeyBinding("key.castspell8", KeyConflictContext.IN_GAME,KeyModifier.ALT,InputMappings.Type.KEYSYM,  GLFW.GLFW_KEY_8, "key.categories.solinia");
       	consider = new Solinia3UIKeyBinding("key.consider", KeyConflictContext.IN_GAME,KeyModifier.NONE,InputMappings.Type.KEYSYM,  GLFW.GLFW_KEY_C, "key.categories.solinia");
       	openspellbook = new Solinia3UIKeyBinding("key.openspellbook", KeyConflictContext.IN_GAME,KeyModifier.NONE,InputMappings.Type.KEYSYM,  GLFW.GLFW_KEY_K, "key.categories.solinia");
       	opencharactercreation = new Solinia3UIKeyBinding("key.opencharactercreation", KeyConflictContext.IN_GAME,KeyModifier.NONE,InputMappings.Type.KEYSYM,  GLFW.GLFW_KEY_SEMICOLON, "key.categories.solinia");
       	petattack = new Solinia3UIKeyBinding("key.petattack", KeyConflictContext.IN_GAME,KeyModifier.NONE,InputMappings.Type.KEYSYM,  GLFW.GLFW_KEY_R, "key.categories.solinia");
        
        ClientRegistry.registerKeyBinding(hail);
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
        ClientRegistry.registerKeyBinding(opencharactercreation);
        ClientRegistry.registerKeyBinding(petattack);
    }
}