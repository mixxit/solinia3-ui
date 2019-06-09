package com.solinia.solinia3ui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

public class GuiSpellChangePageButton extends GuiButton {
	public GuiSpellChangePageButton(int buttonId, int x, int y, String buttonText) {
		super(buttonId, x, y, buttonText);
	}
	
	public GuiSpellChangePageButton(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText) {
		super(buttonId, x, y, widthIn, heightIn, buttonText);
	}
	

	@Override
	public void onClick(double mouseX, double mouseY) 
	{
		String[] data = this.displayString.split(" ");
		
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
