package com.solinia.solinia3ui;

import net.minecraft.client.gui.widget.button.Button;

public class GuiSpellIconButtonPressable implements Button.IPressable {

	private int spellId = -1;
	private int spellBookSlotId = -1;
	public GuiSpellIconButtonPressable(int spellBookSlotId, int spellId) {
		this.spellId = spellId;
		this.spellBookSlotId = spellBookSlotId;
	}

	@Override
	public void onPress(Button button) {
		System.out.println("You clicked spellId: " + spellId + " in spellBookSlotId " + spellBookSlotId);
		ClientState.getInstance().setSelectedSpellSlot(spellBookSlotId);
	}

}
