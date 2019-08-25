package com.solinia.solinia3ui;

import java.util.ArrayList;
import java.util.List;

public class MemorisedSpells {
	public int SpellSlot1Id = 0;
	public int SpellSlot2Id = 0;
	public int SpellSlot3Id = 0;
	public int SpellSlot4Id = 0;
	public int SpellSlot5Id = 0;
	public int SpellSlot6Id = 0;
	public int SpellSlot7Id = 0;
	public int SpellSlot8Id = 0;
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
	
	public List<Integer> getAllSpellIds() {
		List<Integer> returnIds = new ArrayList<Integer>();
		
		if (SpellSlot1Id > 0)
			returnIds.add(SpellSlot1Id);
		if (SpellSlot2Id > 0)
			returnIds.add(SpellSlot2Id);
		if (SpellSlot3Id > 0)
			returnIds.add(SpellSlot3Id);
		if (SpellSlot4Id > 0)
			returnIds.add(SpellSlot4Id);
		if (SpellSlot5Id > 0)
			returnIds.add(SpellSlot5Id);
		if (SpellSlot6Id > 0)
			returnIds.add(SpellSlot6Id);
		if (SpellSlot7Id > 0)
			returnIds.add(SpellSlot7Id);
		if (SpellSlot8Id > 0)
			returnIds.add(SpellSlot8Id);
		
		return returnIds;
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
				return -1;
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
				return -1;
		}
	} 
	

	public String getSpellName(int spellSlot)
	{
		switch(spellSlot)
		{
			case 1:
				return SpellSlot1Name;
			case 2:
				return SpellSlot2Name;
			case 3:
				return SpellSlot3Name;
			case 4:
				return SpellSlot4Name;
			case 5:
				return SpellSlot5Name;
			case 6:
				return SpellSlot6Name;
			case 7:
				return SpellSlot7Name;
			case 8:
				return SpellSlot8Name;
			default:
				return "";
		}
	}
	
	public int getSpellId(int spellSlot)
	{
		switch(spellSlot)
		{
			case 1:
				return SpellSlot1Id;
			case 2:
				return SpellSlot2Id;
			case 3:
				return SpellSlot3Id;
			case 4:
				return SpellSlot4Id;
			case 5:
				return SpellSlot5Id;
			case 6:
				return SpellSlot6Id;
			case 7:
				return SpellSlot7Id;
			case 8:
				return SpellSlot8Id;
			default:
				return -1;
		}
	}
}
