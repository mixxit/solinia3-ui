package com.solinia.solinia3ui.Guis;

import com.solinia.solinia3ui.ClientState;

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
		if (ClientState.getInstance().getSelectedSpellSlot() == spellBookSlotId)
		{
			// Clear if its the same one we already clicked
			ClientState.getInstance().setSelectedSpellSlot(-1);
		} else {
			ClientState.getInstance().setSelectedSpellSlot(spellBookSlotId);
		}
		
	}

}
