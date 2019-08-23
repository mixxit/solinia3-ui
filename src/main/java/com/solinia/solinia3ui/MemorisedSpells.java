package com.solinia.solinia3ui;

public class MemorisedSpells {
	public String SpellSlot1Name = "";
	public String SpellSlot2Name = "";
	public String SpellSlot3Name = "";
	public String SpellSlot4Name = "";
	public String SpellSlot5Name = "";
	public String SpellSlot6Name = "";
	public String SpellSlot7Name = "";
	public String SpellSlot8Name = "";
	public int SpellSlot1Icon = 0;
	public int SpellSlot2Icon = 0;
	public int SpellSlot3Icon = 0;
	public int SpellSlot4Icon = 0;
	public int SpellSlot5Icon = 0;
	public int SpellSlot6Icon = 0;
	public int SpellSlot7Icon = 0;
	public int SpellSlot8Icon = 0;
	public int SpellSlot1MemIcon = 0;
	public int SpellSlot2MemIcon = 0;
	public int SpellSlot3MemIcon = 0;
	public int SpellSlot4MemIcon = 0;
	public int SpellSlot5MemIcon = 0;
	public int SpellSlot6MemIcon = 0;
	public int SpellSlot7MemIcon = 0;
	public int SpellSlot8MemIcon = 0;
	public int SpellSlot1NewIcon = 0;
	public int SpellSlot2NewIcon = 0;
	public int SpellSlot3NewIcon = 0;
	public int SpellSlot4NewIcon = 0;
	public int SpellSlot5NewIcon = 0;
	public int SpellSlot6NewIcon = 0;
	public int SpellSlot7NewIcon = 0;
	public int SpellSlot8NewIcon = 0;
	
	private int getSpellIdFromSpellNameData(String spellSlotNameData) {
		if(spellSlotNameData == null)
			return -1;
		
		if (!spellSlotNameData.contains("|"))
			return -1;
		
		String[] split = spellSlotNameData.split("\\|");
		int spellId = -1;
		
		try
		{
			spellId = Integer.parseInt(split[0]);
		} catch (Exception e)
		{
			
		}
		
		return spellId;
	}
	
	private String getSpellNameFromSpellNameData(String spellSlotNameData) {
		if(spellSlotNameData == null)
			return null;
		
		if (!spellSlotNameData.contains("|"))
			return spellSlotNameData;
		
		String[] split = spellSlotNameData.split("\\|");
		return split[1];	
	}
	
	public int getSpellIcon(int spellSlot)
	{
		switch(spellSlot)
		{
			case 1:
				return SpellSlot1Icon;
			case 2:
				return SpellSlot2Icon;
			case 3:
				return SpellSlot3Icon;
			case 4:
				return SpellSlot4Icon;
			case 5:
				return SpellSlot5Icon;
			case 6:
				return SpellSlot6Icon;
			case 7:
				return SpellSlot7Icon;
			case 8:
				return SpellSlot8Icon;
			default:
				return 0;
		}
	}
	
	public int getNewIcon(int spellSlot)
	{
		switch(spellSlot)
		{
			case 1:
				return SpellSlot1NewIcon;
			case 2:
				return SpellSlot2NewIcon;
			case 3:
				return SpellSlot3NewIcon;
			case 4:
				return SpellSlot4NewIcon;
			case 5:
				return SpellSlot5NewIcon;
			case 6:
				return SpellSlot6NewIcon;
			case 7:
				return SpellSlot7NewIcon;
			case 8:
				return SpellSlot8NewIcon;
			default:
				return 0;
		}
	} 
	
	public String getSpellName(int spellSlot)
	{
		switch(spellSlot)
		{
			case 1:
				return getSpellNameFromSpellNameData(SpellSlot1Name);
			case 2:
				return getSpellNameFromSpellNameData(SpellSlot2Name);
			case 3:
				return getSpellNameFromSpellNameData(SpellSlot3Name);
			case 4:
				return getSpellNameFromSpellNameData(SpellSlot4Name);
			case 5:
				return getSpellNameFromSpellNameData(SpellSlot5Name);
			case 6:
				return getSpellNameFromSpellNameData(SpellSlot6Name);
			case 7:
				return getSpellNameFromSpellNameData(SpellSlot7Name);
			case 8:
				return getSpellNameFromSpellNameData(SpellSlot8Name);
			default:
				return "";
		}
	}
	
	public int getSpellId(int spellSlot)
	{
		switch(spellSlot)
		{
			case 1:
				return getSpellIdFromSpellNameData(SpellSlot1Name);
			case 2:
				return getSpellIdFromSpellNameData(SpellSlot2Name);
			case 3:
				return getSpellIdFromSpellNameData(SpellSlot3Name);
			case 4:
				return getSpellIdFromSpellNameData(SpellSlot4Name);
			case 5:
				return getSpellIdFromSpellNameData(SpellSlot5Name);
			case 6:
				return getSpellIdFromSpellNameData(SpellSlot6Name);
			case 7:
				return getSpellIdFromSpellNameData(SpellSlot7Name);
			case 8:
				return getSpellIdFromSpellNameData(SpellSlot8Name);
			default:
				return -1;
		}
	}
}
