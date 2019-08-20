package com.solinia.solinia3ui;

import java.io.BufferedReader;
import java.io.StringReader;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class SpellBookData {

	public static SpellBookData fromJson(String message) {
		SpellBookData data = new SpellBookData();
		try
		{
			Gson gson = new Gson();
			BufferedReader br = new BufferedReader(new StringReader(message));
			data = gson.fromJson(br, new TypeToken<SpellBookData>(){}.getType());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return data;
		
	}
	
	public int PageNo = 0;

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
}
