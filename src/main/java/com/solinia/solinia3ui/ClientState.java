package com.solinia.solinia3ui;

public class ClientState {

    private static volatile ClientState instance;
	private MemorisedSpells memorisedSpells = new MemorisedSpells();
	private int selectedSpellSlot = -1;

    private ClientState(){

        if (instance != null){
            throw new RuntimeException("Only accessible via getInstance()");
        }
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
}