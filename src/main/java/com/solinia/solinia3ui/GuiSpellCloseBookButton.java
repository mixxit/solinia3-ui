package com.solinia.solinia3ui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

public class GuiSpellCloseBookButton extends GuiButton {
	public GuiSpellCloseBookButton(int buttonId, int x, int y, String buttonText) {
		super(buttonId, x, y, buttonText);
	}
	
	public GuiSpellCloseBookButton(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText) {
		super(buttonId, x, y, widthIn, heightIn, buttonText);
	}
	
	@Override
	public void onClick(double mouseX, double mouseY) 
	{
		Minecraft.getInstance().player.closeScreen();
	}
}
