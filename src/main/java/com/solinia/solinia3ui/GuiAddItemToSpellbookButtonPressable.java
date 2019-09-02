package com.solinia.solinia3ui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.button.Button.IPressable;
import net.minecraft.item.ItemStack;

public class GuiAddItemToSpellbookButtonPressable implements IPressable {
	@Override
	public void onPress(Button button) {
		// TODO Auto-generated method stub
		System.out.println("You clicked the spellbook button");
		ItemStack activeItemStack = Minecraft.getInstance().player.getActiveItemStack();
		if (activeItemStack == null)
		{
			Minecraft.getInstance().player.sendChatMessage("/spellbook");
		} else {
			Minecraft.getInstance().player.sendChatMessage("/spellbook addcursor");			
		}
	}

}
