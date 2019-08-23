package com.solinia.solinia3ui;

import java.io.BufferedReader;
import java.io.StringReader;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

public class GenericPacketMessage {
	public MemorisedSpells MemorisedSpellSlots = null;
	public SpellBookData SpellbookPage = null;
	
	public static GenericPacketMessage fromJson(String message) {
		GenericPacketMessage data = new GenericPacketMessage();
		try
		{
			Gson gson = new Gson();
			BufferedReader br = new BufferedReader(new StringReader(message));
			data = gson.fromJson(br, new TypeToken<GenericPacketMessage>(){

				/**
				 * 
				 */
				private static final long serialVersionUID = -4475004906885001810L;}.getType());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return data;
	}
}
