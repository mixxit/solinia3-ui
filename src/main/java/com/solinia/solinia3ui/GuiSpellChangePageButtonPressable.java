package com.solinia.solinia3ui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.button.Button;

public class GuiSpellChangePageButtonPressable implements Button.IPressable {

	@Override
	public void onPress(Button buttonPressed) {
		String[] data = buttonPressed.getMessage().split(" ");
		
		int page = 0;
		
		for (int i = 0; i < data.length; i++)
		{
			if (data[i].contains("<"))
				continue;
			if (data[i].contains(">"))
				continue;
			
			try
			{
				page = Integer.parseInt(data[i]);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		
		Minecraft.getInstance().player.closeScreen();
		Minecraft.getInstance().player.sendChatMessage("/openspellbook " + page);
	}
}
