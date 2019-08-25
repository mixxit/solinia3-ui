package com.solinia.solinia3ui;

import java.util.ArrayList;
import java.util.List;

public class SpellBookData {
	public int PageNo = 0;
	
	public int SpellSlot1Id = 0;
	public int SpellSlot2Id = 0;
	public int SpellSlot3Id = 0;
	public int SpellSlot4Id = 0;
	public int SpellSlot5Id = 0;
	public int SpellSlot6Id = 0;
	public int SpellSlot7Id = 0;
	public int SpellSlot8Id = 0;
	public int SpellSlot9Id = 0;
	public int SpellSlot10Id = 0;
	public int SpellSlot11Id = 0;
	public int SpellSlot12Id = 0;
	public int SpellSlot13Id = 0;
	public int SpellSlot14Id = 0;
	public int SpellSlot15Id = 0;
	public int SpellSlot16Id = 0;

	public String SpellSlot1Name = "";
	public String SpellSlot2Name = "";
	public String SpellSlot3Name = "";
	public String SpellSlot4Name = "";
	public String SpellSlot5Name = "";
	public String SpellSlot6Name = "";
	public String SpellSlot7Name = "";
	public String SpellSlot8Name = "";
	public String SpellSlot9Name = "";
	public String SpellSlot10Name = "";
	public String SpellSlot11Name = "";
	public String SpellSlot12Name = "";
	public String SpellSlot13Name = "";
	public String SpellSlot14Name = "";
	public String SpellSlot15Name = "";
	public String SpellSlot16Name = "";

	public int SpellSlot1Icon = 0;
	public int SpellSlot2Icon = 0;
	public int SpellSlot3Icon = 0;
	public int SpellSlot4Icon = 0;
	public int SpellSlot5Icon = 0;
	public int SpellSlot6Icon = 0;
	public int SpellSlot7Icon = 0;
	public int SpellSlot8Icon = 0;
	public int SpellSlot9Icon = 0;
	public int SpellSlot10Icon = 0;
	public int SpellSlot11Icon = 0;
	public int SpellSlot12Icon = 0;
	public int SpellSlot13Icon = 0;
	public int SpellSlot14Icon = 0;
	public int SpellSlot15Icon = 0;
	public int SpellSlot16Icon = 0;
	
	public int SpellSlot1MemIcon = 0;
	public int SpellSlot2MemIcon = 0;
	public int SpellSlot3MemIcon = 0;
	public int SpellSlot4MemIcon = 0;
	public int SpellSlot5MemIcon = 0;
	public int SpellSlot6MemIcon = 0;
	public int SpellSlot7MemIcon = 0;
	public int SpellSlot8MemIcon = 0;
	public int SpellSlot9MemIcon = 0;
	public int SpellSlot10MemIcon = 0;
	public int SpellSlot11MemIcon = 0;
	public int SpellSlot12MemIcon = 0;
	public int SpellSlot13MemIcon = 0;
	public int SpellSlot14MemIcon = 0;
	public int SpellSlot15MemIcon = 0;
	public int SpellSlot16MemIcon = 0;
	
	public int SpellSlot1NewIcon = 0;
	public int SpellSlot2NewIcon = 0;
	public int SpellSlot3NewIcon = 0;
	public int SpellSlot4NewIcon = 0;
	public int SpellSlot5NewIcon = 0;
	public int SpellSlot6NewIcon = 0;
	public int SpellSlot7NewIcon = 0;
	public int SpellSlot8NewIcon = 0;
	public int SpellSlot9NewIcon = 0;
	public int SpellSlot10NewIcon = 0;
	public int SpellSlot11NewIcon = 0;
	public int SpellSlot12NewIcon = 0;
	public int SpellSlot13NewIcon = 0;
	public int SpellSlot14NewIcon = 0;
	public int SpellSlot15NewIcon = 0;
	public int SpellSlot16NewIcon = 0;
	
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
			case 9:
				return SpellSlot9Icon;
			case 10:
				return SpellSlot10Icon;
			case 11:
				return SpellSlot11Icon;
			case 12:
				return SpellSlot12Icon;
			case 13:
				return SpellSlot13Icon;
			case 14:
				return SpellSlot14Icon;
			case 15:
				return SpellSlot15Icon;
			case 16:
				return SpellSlot16Icon;
			default:
				return -1;
		}
	}
	
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
		if (SpellSlot9Id > 0)
			returnIds.add(SpellSlot9Id);
		if (SpellSlot10Id > 0)
			returnIds.add(SpellSlot10Id);
		if (SpellSlot11Id > 0)
			returnIds.add(SpellSlot11Id);
		if (SpellSlot12Id > 0)
			returnIds.add(SpellSlot12Id);
		if (SpellSlot13Id > 0)
			returnIds.add(SpellSlot13Id);
		if (SpellSlot14Id > 0)
			returnIds.add(SpellSlot14Id);
		if (SpellSlot15Id > 0)
			returnIds.add(SpellSlot15Id);
		if (SpellSlot16Id > 0)
			returnIds.add(SpellSlot16Id);		
		return returnIds;
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
			case 9:
				return SpellSlot9NewIcon;
			case 10:
				return SpellSlot10NewIcon;
			case 11:
				return SpellSlot11NewIcon;
			case 12:
				return SpellSlot12NewIcon;
			case 13:
				return SpellSlot13NewIcon;
			case 14:
				return SpellSlot14NewIcon;
			case 15:
				return SpellSlot15NewIcon;
			case 16:
				return SpellSlot16NewIcon;
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
			case 9:
				return SpellSlot9Name;
			case 10:
				return SpellSlot10Name;
			case 11:
				return SpellSlot11Name;
			case 12:
				return SpellSlot12Name;
			case 13:
				return SpellSlot13Name;
			case 14:
				return SpellSlot14Name;
			case 15:
				return SpellSlot15Name;
			case 16:
				return SpellSlot16Name;
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
			case 9:
				return SpellSlot9Id;
			case 10:
				return SpellSlot10Id;
			case 11:
				return SpellSlot11Id;
			case 12:
				return SpellSlot12Id;
			case 13:
				return SpellSlot13Id;
			case 14:
				return SpellSlot14Id;
			case 15:
				return SpellSlot15Id;
			case 16:
				return SpellSlot16Id;
			default:
				return -1;
		}
	}
}
