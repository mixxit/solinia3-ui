package com.solinia.solinia3ui.Guis;

import com.solinia.solinia3ui.ClientState;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.button.Button;

public class GuiSpellCloseBookButtonPressable implements Button.IPressable {
	@Override
	public void onPress(Button button) {
		// TODO Auto-generated method stub
		ClientState.getInstance().setSelectedSpellSlot(-1);

		Minecraft.getInstance().player.closeScreen();
	}
}
