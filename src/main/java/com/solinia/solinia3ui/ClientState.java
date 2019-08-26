package com.solinia.solinia3ui;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import net.minecraft.client.Minecraft;

public class ClientState {

    private static volatile ClientState instance;
	private MemorisedSpells memorisedSpells = new MemorisedSpells();
	private int selectedSpellSlot = -1;
	private KeyBinds keyBinds = new KeyBinds();
	private PartyWindow partyWindow = null;
	private double castingProgress = 0D;
	private String targetName = null;
	private UUID targetUUID = null;
	private double targetHealthPercent = 0D;
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
    
    public PartyWindow getPartyWindow()
    {
    	return this.partyWindow;
    }
    
    public void setPartyWindow(PartyWindow partyWindow)
    {
    	List<PartyWindowPlayer> backedUpMembers = new ArrayList<PartyWindowPlayer>();
    	// Copy old members
    	if (partyWindow != null && partyWindow.PartyMembers == null && this.partyWindow != null && this.partyWindow.PartyMembers != null && this.partyWindow.PartyMembers.size() > 0)
    	{
    		for (PartyWindowPlayer player : this.partyWindow.PartyMembers) 
    			backedUpMembers.add(player.Clone());
    	}
    	
    	this.partyWindow = partyWindow;
    	
    	if (partyWindow != null && partyWindow.PartyMembers == null && this.partyWindow != null && this.partyWindow.PartyMembers == null && backedUpMembers.size() > 0)
        	this.partyWindow.PartyMembers = backedUpMembers;
    }
    
    public String getName()
    {
    	if (this.partyWindow == null)
    		return "";
    	
    	return this.partyWindow.Me.Name;
    }
    
    public double getHealthPercent()
    {
    	if (this.partyWindow == null)
    		return 0D;
    	
    	return this.partyWindow.Me.HealthPercent;
    }
    
    public double getManaPercent()
    {
    	if (this.partyWindow == null)
    		return 0D;
    	
    	return this.partyWindow.Me.ManaPercent;
    }
    
    public void setSelectedSpellSlot(int spellSlotId)
    {
    	this.selectedSpellSlot = spellSlotId;
    }
    
    public void setTargetHealthPercent(double targetHealthPercent)
    {
    	this.targetHealthPercent = targetHealthPercent;
    }
    
    public double getTargetHealthPercent()
    {
    	return this.targetHealthPercent;
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
	
	private boolean openSpellbook() {
		Minecraft.getInstance().player.sendChatMessage("/openspellbook");
		solinia3ui.LOGGER.info("Opening Spell Book");
		return true;
	}
	
	private boolean toggleSitStand() {
		Minecraft.getInstance().player.sendChatMessage("/sit");
		solinia3ui.LOGGER.info("Sitting");
		return true;
	}

	private boolean targetPet() {
		Minecraft.getInstance().player.sendChatMessage("/target pet");
		solinia3ui.LOGGER.info("Targetting pet");
		return true;
	}

	private boolean consider() {
		Minecraft.getInstance().player.sendChatMessage("/consider");
		solinia3ui.LOGGER.info("Considering");
		return true;
	}

	private boolean castSpell(int i) {
		Minecraft.getInstance().player.sendChatMessage("/castslot " + i);
		solinia3ui.LOGGER.info("Casting spell slot " + i);
		return true;
	}

	private boolean targetTeamMember(int i) {
		Minecraft.getInstance().player.sendChatMessage("/target " + i);
		solinia3ui.LOGGER.info("Targetting team member " + i);
		return true;
	}

	private boolean targetSelf() {
		Minecraft.getInstance().player.sendChatMessage("/target self");
		solinia3ui.LOGGER.info("Chat message sent");
		return true;
	}

	private boolean cancelTarget() {
		Minecraft.getInstance().player.sendChatMessage("/target clear");
		solinia3ui.LOGGER.info("Clearing target");
		return true;
	}

	private boolean toggleAutoAttack() {
		Minecraft.getInstance().player.sendChatMessage("/autoattack");
		solinia3ui.LOGGER.info("Auto attacking");
		return true;
	}

	private boolean targetNearestNpc() {
		Minecraft.getInstance().player.sendChatMessage("/target nearestnpc");
		solinia3ui.LOGGER.info("Targetting nearest npc");
		return true;
	}

	public void setCastingProgress(double castingProgress) {
		this.castingProgress = castingProgress;
	}
	
	public double getCastingProgress()
	{
		return this.castingProgress;
	}
	
	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}
	
	public String getTargetName()
	{
		return this.targetName;
	}
	
	public void setTargetUUID(UUID targetUUID) {
		this.targetUUID = targetUUID;
	}
	
	public UUID getTargetUUID()
	{
		return this.targetUUID;
	}
}