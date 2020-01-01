package com.solinia.solinia3ui;

import net.minecraft.client.gui.widget.button.Button;

public class GuiMemorisedSpellButtonPressable implements Button.IPressable {

	private int slotId = -1;
	public GuiMemorisedSpellButtonPressable(int slotId) {
		this.slotId = slotId;
	}

	@Override
	public void onPress(Button button) {
		// TODO Auto-generated method stub
		solinia3ui.LOGGER.info("You clicked memorised slot Id: " + slotId);
	}


}
