package com.solinia.solinia3ui;

import org.lwjgl.opengl.GL11;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;

public class GuiCharacterText extends AbstractGui {
	public GuiCharacterText()
	{
		//renderText();
	}
	
	public void renderText()
	{
		drawString(Minecraft.getInstance().fontRenderer, getName(), 0, 0, Integer.parseInt("FFAA00",16));
		drawString(Minecraft.getInstance().fontRenderer, "HP: " + getHPOutOfHP(), 0, 10, Integer.parseInt("FF0000",16));
		drawString(Minecraft.getInstance().fontRenderer, "Mana: " + getManaOutOfMana(), 0, 20, Integer.parseInt("0000FF",16));
		drawString(Minecraft.getInstance().fontRenderer, "XP: " + getExperienceOutoFExpression(), 0, 30, Integer.parseInt("FFFF00",16));
		drawString(Minecraft.getInstance().fontRenderer, "Target: " + getTarget(), 0, 40, Integer.parseInt("FFFFFF",16));
		drawString(Minecraft.getInstance().fontRenderer, "Pet", 0, 50, Integer.parseInt("FFAA00",16));
		drawString(Minecraft.getInstance().fontRenderer, "-----------", 0, 60, Integer.parseInt("FFAA00",16));
		drawString(Minecraft.getInstance().fontRenderer, getPet(), 0, 70, Integer.parseInt("FFFFFF",16));
		drawString(Minecraft.getInstance().fontRenderer, "Party", 0, 80, Integer.parseInt("FFAA00",16));
		drawString(Minecraft.getInstance().fontRenderer, "-----------", 0, 90, Integer.parseInt("FFAA00",16));
		drawString(Minecraft.getInstance().fontRenderer, getPartyMember(1), 0, 100, Integer.parseInt("FFFFFF",16));
		drawString(Minecraft.getInstance().fontRenderer, getPartyMember(2), 0, 110, Integer.parseInt("FFFFFF",16));
		drawString(Minecraft.getInstance().fontRenderer, getPartyMember(3), 0, 120, Integer.parseInt("FFFFFF",16));
		drawString(Minecraft.getInstance().fontRenderer, getPartyMember(4), 0, 130, Integer.parseInt("FFFFFF",16));
		drawString(Minecraft.getInstance().fontRenderer, getPartyMember(5), 0, 140, Integer.parseInt("FFFFFF",16));
	}
	
	private String getPet() {
		// TODO Auto-generated method stub
		return "";
	}

	private String getPartyMember(int i) {
		// TODO Auto-generated method stub
		return "";
	}

	private String getTarget() {
		// TODO Auto-generated method stub
		return "No Target";
	}

	private String getExperienceOutoFExpression() {
		// TODO Auto-generated method stub
		return "100%";
	}

	private String getManaOutOfMana() {
		// TODO Auto-generated method stub
		return "100%";
	}

	private String getHPOutOfHP() {
		// TODO Auto-generated method stub
		return "100%";
	}

	private String getName() {
		// TODO Auto-generated method stub
		return Minecraft.getInstance().player.getDisplayName().getFormattedText();
	}
}
