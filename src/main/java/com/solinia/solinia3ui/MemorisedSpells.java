package com.solinia.solinia3ui;

import java.io.BufferedReader;
import java.io.StringReader;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MemorisedSpells {
	public static MemorisedSpells fromJson(String message) {
		MemorisedSpells data = new MemorisedSpells();
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
}
