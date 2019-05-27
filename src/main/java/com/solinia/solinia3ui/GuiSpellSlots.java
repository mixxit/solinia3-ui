package com.solinia.solinia3ui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;

public class GuiSpellSlots extends Gui {
	
	public GuiSpellSlots(Minecraft mc)
	{
		int width = mc.mainWindow.getScaledWidth();
		int height = mc.mainWindow.getScaledHeight();
		
		drawString(mc.fontRenderer, getName(mc), 0, 0, Integer.parseInt("FFAA00",16));
		drawString(mc.fontRenderer, "HP: " + getHPOutOfHP(mc), 0, 10, Integer.parseInt("FF0000",16));
		drawString(mc.fontRenderer, "Mana: " + getManaOutOfMana(mc), 0, 20, Integer.parseInt("0000FF",16));
		drawString(mc.fontRenderer, "XP: " + getExperienceOutoFExpression(mc), 0, 30, Integer.parseInt("FFFF00",16));
		drawString(mc.fontRenderer, "Target: " + getTarget(mc), 0, 40, Integer.parseInt("FFFFFF",16));
		drawString(mc.fontRenderer, "Pet", 0, 50, Integer.parseInt("FFAA00",16));
		drawString(mc.fontRenderer, "-----------", 0, 60, Integer.parseInt("FFAA00",16));
		drawString(mc.fontRenderer, getPet(mc), 0, 70, Integer.parseInt("FFFFFF",16));
		drawString(mc.fontRenderer, "Party", 0, 80, Integer.parseInt("FFAA00",16));
		drawString(mc.fontRenderer, "-----------", 0, 90, Integer.parseInt("FFAA00",16));
		drawString(mc.fontRenderer, getPartyMember(1,mc), 0, 100, Integer.parseInt("FFFFFF",16));
		drawString(mc.fontRenderer, getPartyMember(2,mc), 0, 110, Integer.parseInt("FFFFFF",16));
		drawString(mc.fontRenderer, getPartyMember(3,mc), 0, 120, Integer.parseInt("FFFFFF",16));
		drawString(mc.fontRenderer, getPartyMember(4,mc), 0, 130, Integer.parseInt("FFFFFF",16));
		drawString(mc.fontRenderer, getPartyMember(5,mc), 0, 140, Integer.parseInt("FFFFFF",16));
		try
		{	
			ResourceLocation spellSprites = new ResourceLocation( "solinia3ui", "textures/gui/gemicons03.png" );
			mc.getTextureManager().bindTexture(spellSprites);
			
			/*drawSpellGem(1);
			drawSpellGem(2);
			drawSpellGem(3);
			drawSpellGem(4);
			drawSpellGem(5);
			drawSpellGem(6);
			drawSpellGem(7);
			drawSpellGem(8);*/
		} catch (Exception e)
		{
			solinia3ui.LOGGER.info(e.getMessage() + " " + e.getStackTrace());
		}
	}

	private void drawSpellGem(int i) {
		int locx = 72;
		int locy = 110;
		int sizex = 36;
		int sizey = 30;

		int x = 0;
		int y = (i-1)*(sizey);
		
		drawTexturedModalRect(x,y,locx,locy,sizex,sizey);
	}

	private String getPet(Minecraft mc) {
		// TODO Auto-generated method stub
		return "";
	}

	private String getPartyMember(int i, Minecraft mc) {
		// TODO Auto-generated method stub
		return "";
	}

	private String getTarget(Minecraft mc) {
		// TODO Auto-generated method stub
		return "No Target";
	}

	private String getExperienceOutoFExpression(Minecraft mc) {
		// TODO Auto-generated method stub
		return "----------";
	}

	private String getManaOutOfMana(Minecraft mc) {
		// TODO Auto-generated method stub
		return "----------";
	}

	private String getHPOutOfHP(Minecraft mc) {
		// TODO Auto-generated method stub
		return "----------";
	}

	private String getName(Minecraft mc) {
		// TODO Auto-generated method stub
		return mc.player.getDisplayName().getFormattedText();
	}
}
