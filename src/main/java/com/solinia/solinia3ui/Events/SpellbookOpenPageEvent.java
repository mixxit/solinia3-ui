package com.solinia.solinia3ui.Events;

import com.solinia.solinia3ui.Models.SpellbookPage;

import net.minecraftforge.eventbus.api.Event;

public class SpellbookOpenPageEvent extends Event {
	private SpellbookPage spellbookPage;

	public SpellbookOpenPageEvent(SpellbookPage spellbookPage)
	{
		super();
		this.spellbookPage = spellbookPage;
	}

	public SpellbookPage getSpellbookPage() {
		return spellbookPage;
	}

}
