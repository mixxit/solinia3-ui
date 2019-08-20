package com.solinia.solinia3ui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.button.Button;

public class GuiSpellCloseBookButtonPressable implements Button.IPressable {
	@Override
	public void onPress(Button button) {
		// TODO Auto-generated method stub
		Minecraft.getInstance().player.closeScreen();
	}
}
