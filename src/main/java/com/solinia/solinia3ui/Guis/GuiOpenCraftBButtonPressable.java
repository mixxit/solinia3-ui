package com.solinia.solinia3ui.Guis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.button.Button.IPressable;
import net.minecraft.item.ItemStack;

public class GuiOpenCraftBButtonPressable implements IPressable {
	@Override
	public void onPress(Button button) {
		Minecraft.getInstance().player.sendChatMessage("/solinia3core:craft");
	}
}
