package com.solinia.solinia3ui.Guis;

import com.solinia.solinia3ui.solinia3ui;

import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.button.Button.IPressable;

public class GuiEffectButtonPressable implements IPressable {

	private int slotId = -1;
	public GuiEffectButtonPressable(int slotId) {
		this.slotId = slotId;
	}

	@Override
	public void onPress(Button button) {
		// TODO Auto-generated method stub
		solinia3ui.LOGGER.info("You clicked effect slot Id: " + slotId);
	}

}
