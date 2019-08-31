package com.solinia.solinia3ui;

import java.util.ArrayList;
import java.util.List;

public class SpellbookPage {
	public int PageNo;
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
	public String SpellSlot1Name;
	public String SpellSlot2Name;
	public String SpellSlot3Name;
	public String SpellSlot4Name;
	public String SpellSlot5Name;
	public String SpellSlot6Name;
	public String SpellSlot7Name;
	public String SpellSlot8Name;
	public String SpellSlot9Name;
	public String SpellSlot10Name;
	public String SpellSlot11Name;
	public String SpellSlot12Name;
	public String SpellSlot13Name;
	public String SpellSlot14Name;
	public String SpellSlot15Name;
	public String SpellSlot16Name;
	public int SpellSlot1Icon;
	public int SpellSlot2Icon;
	public int SpellSlot3Icon;
	public int SpellSlot4Icon;
	public int SpellSlot5Icon;
	public int SpellSlot6Icon;
	public int SpellSlot7Icon;
	public int SpellSlot8Icon;
	public int SpellSlot9Icon;
	public int SpellSlot10Icon;
	public int SpellSlot11Icon;
	public int SpellSlot12Icon;
	public int SpellSlot13Icon;
	public int SpellSlot14Icon;
	public int SpellSlot15Icon;
	public int SpellSlot16Icon;
	public int SpellSlot1MemIcon;
	public int SpellSlot2MemIcon;
	public int SpellSlot3MemIcon;
	public int SpellSlot4MemIcon;
	public int SpellSlot5MemIcon;
	public int SpellSlot6MemIcon;
	public int SpellSlot7MemIcon;
	public int SpellSlot8MemIcon;
	public int SpellSlot9MemIcon;
	public int SpellSlot10MemIcon;
	public int SpellSlot11MemIcon;
	public int SpellSlot12MemIcon;
	public int SpellSlot13MemIcon;
	public int SpellSlot14MemIcon;
	public int SpellSlot15MemIcon;
	public int SpellSlot16MemIcon;
	public int SpellSlot1NewIcon;
	public int SpellSlot2NewIcon;
	public int SpellSlot3NewIcon;
	public int SpellSlot4NewIcon;
	public int SpellSlot5NewIcon;
	public int SpellSlot6NewIcon;
	public int SpellSlot7NewIcon;
	public int SpellSlot8NewIcon;
	public int SpellSlot9NewIcon;
	public int SpellSlot10NewIcon;
	public int SpellSlot11NewIcon;
	public int SpellSlot12NewIcon;
	public int SpellSlot13NewIcon;
	public int SpellSlot14NewIcon;
	public int SpellSlot15NewIcon;
	public int SpellSlot16NewIcon;
	
	public SpellbookPage()
	{
		
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
	
	public int getSlotId(int slot) {
		switch(slot)
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
				return 0;
		}
	}
	
	public String getSlotName(int slot) {
		switch(slot)
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
				return null;
		}
	}
	
	public int getSlotIcon(int slot) {
		switch(slot)
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
				return 0;
		}
	}

	public int getSlotMemIcon(int slot) {
		switch(slot)
		{
			case 1:
				return SpellSlot1MemIcon;
			
			case 2:
				return SpellSlot2MemIcon;
			
			case 3:
				return SpellSlot3MemIcon;
			
			case 4:
				return SpellSlot4MemIcon;
			
			case 5:
				return SpellSlot5MemIcon;
			
			case 6:
				return SpellSlot6MemIcon;
			
			case 7:
				return SpellSlot7MemIcon;
			
			case 8:
				return SpellSlot8MemIcon;
			
			case 9:
				return SpellSlot9MemIcon;
				
			case 10:
				return SpellSlot10MemIcon;
				
			case 11:
				return SpellSlot11MemIcon;
				
			case 12:
				return SpellSlot12MemIcon;
				
			case 13:
				return SpellSlot13MemIcon;
				
			case 14:
				return SpellSlot14MemIcon;
				
			case 15:
				return SpellSlot15MemIcon;
				
			case 16:
				return SpellSlot16MemIcon;
				
			default:
				return 0;
		}
	}

	public int getSlotNewIcon(int slot) {
		switch(slot)
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
				return 0;
		}
	}

	public void setSpellSlot(int spellSlot, int id, int icon, int newIcon, int memIcon, String name) {
		switch(spellSlot)
		{
			case 1:
				SpellSlot1Id = id;
				SpellSlot1Name = name;
				SpellSlot1Icon = icon;
				SpellSlot1MemIcon = memIcon;
				SpellSlot1NewIcon = newIcon;
			break;
			case 2:
				SpellSlot2Id = id;
				SpellSlot2Name = name;
				SpellSlot2Icon = icon;
				SpellSlot2MemIcon = memIcon;
				SpellSlot2NewIcon = newIcon;
			break;
			case 3:
				SpellSlot3Id = id;
				SpellSlot3Name = name;
				SpellSlot3Icon = icon;
				SpellSlot3MemIcon = memIcon;
				SpellSlot3NewIcon = newIcon;
			break;
			case 4:
				SpellSlot4Id = id;
				SpellSlot4Name = name;
				SpellSlot4Icon = icon;
				SpellSlot4MemIcon = memIcon;
				SpellSlot4NewIcon = newIcon;
			break;
			case 5:
				SpellSlot5Id = id;
				SpellSlot5Name = name;
				SpellSlot5Icon = icon;
				SpellSlot5MemIcon = memIcon;
				SpellSlot5NewIcon = newIcon;
			break;
			case 6:
				SpellSlot6Id = id;
				SpellSlot6Name = name;
				SpellSlot6Icon = icon;
				SpellSlot6MemIcon = memIcon;
				SpellSlot6NewIcon = newIcon;
			break;
			case 7:
				SpellSlot7Id = id;
				SpellSlot7Name = name;
				SpellSlot7Icon = icon;
				SpellSlot7MemIcon = memIcon;
				SpellSlot7NewIcon = newIcon;
			break;
			case 8:
				SpellSlot8Id = id;
				SpellSlot8Name = name;
				SpellSlot8Icon = icon;
				SpellSlot8MemIcon = memIcon;
				SpellSlot8NewIcon = newIcon;
			break;
			case 9:
				SpellSlot9Id = id;
				SpellSlot9Name = name;
				SpellSlot9Icon = icon;
				SpellSlot9MemIcon = memIcon;
				SpellSlot9NewIcon = newIcon;
				break;
			case 10:
				SpellSlot10Id = id;
				SpellSlot10Name = name;
				SpellSlot10Icon = icon;
				SpellSlot10MemIcon = memIcon;
				SpellSlot10NewIcon = newIcon;
				break;
			case 11:
				SpellSlot11Id = id;
				SpellSlot11Name = name;
				SpellSlot11Icon = icon;
				SpellSlot11MemIcon = memIcon;
				SpellSlot11NewIcon = newIcon;
				break;
			case 12:
				SpellSlot12Id = id;
				SpellSlot12Name = name;
				SpellSlot12Icon = icon;
				SpellSlot12MemIcon = memIcon;
				SpellSlot12NewIcon = newIcon;
				break;
			case 13:
				SpellSlot13Id = id;
				SpellSlot13Name = name;
				SpellSlot13Icon = icon;
				SpellSlot13MemIcon = memIcon;
				SpellSlot13NewIcon = newIcon;
				break;
			case 14:
				SpellSlot14Id = id;
				SpellSlot14Name = name;
				SpellSlot14Icon = icon;
				SpellSlot14MemIcon = memIcon;
				SpellSlot14NewIcon = newIcon;
				break;
			case 15:
				SpellSlot15Id = id;
				SpellSlot15Name = name;
				SpellSlot15Icon = icon;
				SpellSlot15MemIcon = memIcon;
				SpellSlot15NewIcon = newIcon;
				break;
			case 16:
				SpellSlot16Id = id;
				SpellSlot16Name = name;
				SpellSlot16Icon = icon;
				SpellSlot16MemIcon = memIcon;
				SpellSlot16NewIcon = newIcon;
				break;
			default:
				return;
		}
	}
}