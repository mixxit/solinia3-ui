package com.solinia.solinia3ui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.button.Button.IPressable;
import net.minecraft.item.ItemStack;

public class GuiInventorySlotButtonPressable implements IPressable {
	private int slotId;
	
	public GuiInventorySlotButtonPressable(int slotId)
	{
		this.slotId = slotId;
	}
	
	@Override
	public void onPress(Button button) {
		ItemStack activeItemStack = Minecraft.getInstance().player.getActiveItemStack();
		if (activeItemStack == null)
		{
			//Minecraft.getInstance().player.sendChatMessage("/solinia3core:reagent");
		} else {
			Minecraft.getInstance().player.sendChatMessage("/solinia3core:equip addcursor");			
		}
	}
}
