package com.solinia.solinia3ui.Handlers;

import com.solinia.solinia3ui.ClientState;
import com.solinia.solinia3ui.Events.SpellbookOpenPageEvent;
import com.solinia.solinia3ui.Models.SpellbookPage;

import net.minecraft.client.Minecraft;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class SpellBookOpenPageHandler {
	@SubscribeEvent
	public void onSpellbookOpenPage(SpellbookOpenPageEvent event)
	{
		if (event.isCanceled())
			return;
		
		if (event.getSpellbookPage() == null)
		{
			event.setCanceled(true);
			return;
		}
		
		// not in game check
		if (Minecraft.getInstance().player == null)
			return;
		
		ClientState.getInstance().setSpellbookPage(event.getSpellbookPage());
		ClientState.getInstance().tryOpenSpellbook();
	}
}
