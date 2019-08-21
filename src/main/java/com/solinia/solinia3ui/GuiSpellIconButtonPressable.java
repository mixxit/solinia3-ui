package com.solinia.solinia3ui;

import net.minecraft.client.gui.widget.button.Button;

public class GuiSpellIconButtonPressable implements Button.IPressable {

	private int spellId = -1;
	private int spellBookSlotId = -1;
	private GuiSpellbook parent;
	public GuiSpellIconButtonPressable(GuiSpellbook guiSpellbook, int spellBookSlotId, int spellId) {
		this.spellId = spellId;
		this.spellBookSlotId = spellBookSlotId;
		this.parent = guiSpellbook;
	}

	@Override
	public void onPress(Button button) {
		// TODO Auto-generated method stub
		System.out.println("You clicked spellId: " + spellId + " in spellBookSlotId " + spellBookSlotId);
		this.parent.setSelectedSlotId(spellBookSlotId);
	}

}
