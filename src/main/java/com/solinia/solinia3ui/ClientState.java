package com.solinia.solinia3ui;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraftforge.client.model.ItemLayerModel.Loader;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.moddiscovery.ModInfo;

public class ClientState {

    private static volatile ClientState instance;
	private MemorisedSpells memorisedSpells = new MemorisedSpells();
	private int selectedSpellSlot = -1;
	private KeyBinds keyBinds = new KeyBinds();
	private double castingPercent = 0F;
	
	private ConcurrentHashMap<Integer,EntityVital> entityVitals = new ConcurrentHashMap<Integer,EntityVital>();
	
    private ClientState(){

        if (instance != null){
            throw new RuntimeException("Only accessible via getInstance()");
        }
    }
    
    public KeyBinds getKeyBinds()
    {
    	return keyBinds;
    }

    public static ClientState getInstance() {
        if (instance == null) {
          
            synchronized (ClientState.class) {
            	if (instance == null) 
            		instance = new ClientState();
            }
        }

        return instance;
    }
    
    
    public void setSelectedSpellSlot(int spellSlotId)
    {
    	this.selectedSpellSlot = spellSlotId;
    }
    
    public int getSelectedSpellSlot()
    {
    	return this.selectedSpellSlot;
    }

	public void setMemorisedSpells(MemorisedSpells memorisedSpells) {
		this.memorisedSpells = memorisedSpells;
	}
	
	public MemorisedSpells getMemorisedSpells()
	{
		return this.memorisedSpells;
	}

	public boolean isModKeyBind() {
		KeyBinds keyBinds = getKeyBinds();
		if (keyBinds.targetnearestnpc != null && keyBinds.targetnearestnpc.isKeyDown())
			return true;
		if (keyBinds.toggleautoattack != null && keyBinds.toggleautoattack.isKeyDown())
			return true;
		if (keyBinds.canceltarget != null && keyBinds.canceltarget.isKeyDown())
			return true;
		if (keyBinds.targetself != null && keyBinds.targetself.isKeyDown())
			return true;
		if (keyBinds.togglesitstand != null && keyBinds.togglesitstand.isKeyDown())
			return true;
		if (keyBinds.targetteammember1 != null && keyBinds.targetteammember1.isKeyDown())
			return true;
		if (keyBinds.targetteammember2 != null && keyBinds.targetteammember2.isKeyDown())
			return true;
		if (keyBinds.targetteammember3 != null && keyBinds.targetteammember3.isKeyDown())
			return true;
		if (keyBinds.targetteammember4 != null && keyBinds.targetteammember4.isKeyDown())
			return true;
		if (keyBinds.targetteammember5 != null && keyBinds.targetteammember5.isKeyDown())
			return true;
		if (keyBinds.castspell1 != null && keyBinds.castspell1.isKeyDown())
			return true;
		if (keyBinds.castspell2 != null && keyBinds.castspell2.isKeyDown())
			return true;
		if (keyBinds.castspell3 != null && keyBinds.castspell3.isKeyDown())
			return true;
		if (keyBinds.castspell4 != null && keyBinds.castspell4.isKeyDown())
			return true;
		if (keyBinds.castspell5 != null && keyBinds.castspell5.isKeyDown())
			return true;
		if (keyBinds.castspell6 != null && keyBinds.castspell6.isKeyDown())
			return true;
		if (keyBinds.castspell7 != null && keyBinds.castspell7.isKeyDown())
			return true;
		if (keyBinds.castspell8 != null && keyBinds.castspell8.isKeyDown())
			return true;
		if (keyBinds.consider != null && keyBinds.consider.isKeyDown())
			return true;
		if (keyBinds.targetpet != null && keyBinds.targetpet.isKeyDown())
			return true;
		if (keyBinds.openspellbook != null && keyBinds.openspellbook.isKeyDown())
			return true;
		
		return false;
	}
	
	public void attemptUseModKeybinds() {
		KeyBinds keyBinds = getKeyBinds();
		if (keyBinds.hail != null && keyBinds.hail.isKeyDown())
			hail();
		if (keyBinds.targetnearestnpc != null && keyBinds.targetnearestnpc.isKeyDown())
			targetNearestNpc();
		if (keyBinds.toggleautoattack != null && keyBinds.toggleautoattack.isKeyDown())
			toggleAutoAttack();
		if (keyBinds.canceltarget != null && keyBinds.canceltarget.isKeyDown())
			cancelTarget();
		if (keyBinds.targetself != null && keyBinds.targetself.isKeyDown())
			targetSelf();
		if (keyBinds.togglesitstand != null && keyBinds.togglesitstand.isKeyDown())
			toggleSitStand();
		if (keyBinds.targetteammember1 != null && keyBinds.targetteammember1.isKeyDown())
			targetTeamMember(1);
		if (keyBinds.targetteammember2 != null && keyBinds.targetteammember2.isKeyDown())
			targetTeamMember(2);
		if (keyBinds.targetteammember3 != null && keyBinds.targetteammember3.isKeyDown())
			targetTeamMember(3);
		if (keyBinds.targetteammember4 != null && keyBinds.targetteammember4.isKeyDown())
			targetTeamMember(4);
		if (keyBinds.targetteammember5 != null && keyBinds.targetteammember5.isKeyDown())
			targetTeamMember(5);
		if (keyBinds.castspell1 != null && keyBinds.castspell1.isKeyDown())
			castSpell(1);
		if (keyBinds.castspell2 != null && keyBinds.castspell2.isKeyDown())
			castSpell(2);
		if (keyBinds.castspell3 != null && keyBinds.castspell3.isKeyDown())
			castSpell(3);
		if (keyBinds.castspell4 != null && keyBinds.castspell4.isKeyDown())
			castSpell(4);
		if (keyBinds.castspell5 != null && keyBinds.castspell5.isKeyDown())
			castSpell(5);
		if (keyBinds.castspell6 != null && keyBinds.castspell6.isKeyDown())
			castSpell(6);
		if (keyBinds.castspell7 != null && keyBinds.castspell7.isKeyDown())
			castSpell(7);
		if (keyBinds.castspell8 != null && keyBinds.castspell8.isKeyDown())
			castSpell(8);
		if (keyBinds.consider != null && keyBinds.consider.isKeyDown())
			consider();
		if (keyBinds.targetpet != null && keyBinds.targetpet.isKeyDown())
			targetPet();
		if (keyBinds.openspellbook != null && keyBinds.openspellbook.isKeyDown())
			openSpellbook();
	}
	
	private boolean hail() {
		Minecraft.getInstance().player.sendChatMessage("/solinia3core:say HAIL");
		return true;
	}

	private boolean openSpellbook() {
		Minecraft.getInstance().player.sendChatMessage("/solinia3core:openspellbook");
		solinia3ui.LOGGER.info("Opening Spell Book");
		return true;
	}
	
	private boolean toggleSitStand() {
		Minecraft.getInstance().player.sendChatMessage("/solinia3core:sit");
		solinia3ui.LOGGER.info("Sitting");
		return true;
	}

	private boolean targetPet() {
		Minecraft.getInstance().player.sendChatMessage("/solinia3core:target pet");
		solinia3ui.LOGGER.info("Targetting pet");
		return true;
	}

	private boolean consider() {
		Minecraft.getInstance().player.sendChatMessage("/solinia3core:consider");
		solinia3ui.LOGGER.info("Considering");
		return true;
	}

	private boolean castSpell(int i) {
		Minecraft.getInstance().player.sendChatMessage("/solinia3core:castslot " + i);
		solinia3ui.LOGGER.info("Casting spell slot " + i);
		return true;
	}

	private boolean targetTeamMember(int i) {
		Minecraft.getInstance().player.sendChatMessage("/solinia3core:target " + i);
		solinia3ui.LOGGER.info("Targetting team member " + i);
		return true;
	}

	private boolean targetSelf() {
		Minecraft.getInstance().player.sendChatMessage("/solinia3core:target self");
		solinia3ui.LOGGER.info("Chat message sent");
		return true;
	}

	private boolean cancelTarget() {
		Minecraft.getInstance().player.sendChatMessage("/solinia3core:target clear");
		solinia3ui.LOGGER.info("Clearing target");
		return true;
	}

	private boolean toggleAutoAttack() {
		Minecraft.getInstance().player.sendChatMessage("/solinia3core:autoattack");
		solinia3ui.LOGGER.info("Auto attacking");
		return true;
	}

	private boolean targetNearestNpc() {
		Minecraft.getInstance().player.sendChatMessage("/solinia3core:target nearestnpc");
		solinia3ui.LOGGER.info("Targetting nearest npc");
		return true;
	}

	public void setCastingPercent(float castingPercent) {
		this.castingPercent = castingPercent;
	}
	
	public double getCastingPercent()
	{
		return this.castingPercent;
	}
	
	public EntityVital getEntityVital(int partyMember) {
		return this.entityVitals.get(partyMember);
	}

	public void setEntityVital(int partyMember, float healthPercent, float manaPercent, UUID uniqueId, String name) {
		EntityVital entityVital = new EntityVital(healthPercent,manaPercent,uniqueId,name);
		//System.out.println("Setting entity vital: " + partyMember + " : " + name);
		this.entityVitals.put(partyMember,entityVital);
	}

	public String getModVersion() throws Exception {
		for (ModInfo mod : ModList.get().getMods())
		{
			if (!mod.getModId().equals("solinia3ui"))
				continue;
			
			return mod.getVersion().toString();
		}
		
		throw new Exception("Mod not found");
	}
}