package com.solinia.solinia3ui;

import org.lwjgl.opengl.GL11;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.ClientBossInfo;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfo.Color;

public class GuiCharacterText extends AbstractGui {
	private static final ResourceLocation GUI_BARS_TEXTURES = new ResourceLocation("textures/gui/bars.png");

	   
	public GuiCharacterText()
	{
		//renderState();
		render();
	}
	
	public void render()
	{
		int scaledWidth = Minecraft.getInstance().mainWindow.getScaledWidth();
        int verticalPosition = 65;
        int progressBarWidth = 80;
        int progressBarDistances = 4;
        int increment = 16;
    	float fontHeight = 0.5f;
        String playerName = ClientState.getInstance().getName();
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
    	GL11.glScalef(fontHeight,fontHeight,fontHeight);
        float mSize = (float)Math.pow(fontHeight,-1);
        int lengthOfText1 = (int)(Minecraft.getInstance().fontRenderer.getStringWidth(playerName)*fontHeight);
        int horizontalTextPosition1 = scaledWidth - lengthOfText1;
        int vertitalTextPosition1 = verticalPosition - (int)(10*fontHeight);
        int maxVerticalPosition = Minecraft.getInstance().mainWindow.getScaledHeight();
        Minecraft.getInstance().fontRenderer.drawStringWithShadow(playerName, Math.round(horizontalTextPosition1 / fontHeight),Math.round(vertitalTextPosition1 / fontHeight), 16777215);
        GL11.glScalef(mSize,mSize,mSize);
    	int overlayType = 0;
    	int progressBarHorizontalPosition = scaledWidth - progressBarWidth;
    	Minecraft.getInstance().getTextureManager().bindTexture(GUI_BARS_TEXTURES);
        this.renderSpellbar(progressBarHorizontalPosition, verticalPosition, Color.RED, (float) (ClientState.getInstance().getHealthPercent()), overlayType, progressBarWidth);
        Minecraft.getInstance().getTextureManager().bindTexture(GUI_BARS_TEXTURES);
        this.renderSpellbar(progressBarHorizontalPosition, verticalPosition+(progressBarDistances*1), Color.BLUE, (float) (ClientState.getInstance().getManaPercent()), overlayType, progressBarWidth);
    	Minecraft.getInstance().getTextureManager().bindTexture(GUI_BARS_TEXTURES);
        this.renderSpellbar(progressBarHorizontalPosition, verticalPosition+(progressBarDistances*2), Color.YELLOW, (float) ClientState.getInstance().getCastingProgress(), overlayType, progressBarWidth);
        Minecraft.getInstance().getTextureManager().bindTexture(GUI_BARS_TEXTURES);
        this.renderSpellbar(progressBarHorizontalPosition, verticalPosition+(progressBarDistances*5), Color.RED, (float) (ClientState.getInstance().getTargetHealthPercent()), overlayType, progressBarWidth);
        
        if (ClientState.getInstance().getTargetName() != null)
        {
        	GL11.glScalef(fontHeight,fontHeight,fontHeight);
            mSize = (float)Math.pow(fontHeight,-1);
        	String targetText = "Target: " + ClientState.getInstance().getTargetName(); 
        	int lengthOfText = (int)(Minecraft.getInstance().fontRenderer.getStringWidth(targetText)*fontHeight);
	        int horizontalTextPosition = scaledWidth - lengthOfText;
	        int vertitalTextPosition = verticalPosition + (progressBarDistances*2) + (int)(15*fontHeight);
	        Minecraft.getInstance().fontRenderer.drawStringWithShadow(targetText, Math.round(horizontalTextPosition / fontHeight),Math.round(vertitalTextPosition / fontHeight), 16777215);
	        GL11.glScalef(mSize,mSize,mSize);
        }
        
        if (ClientState.getInstance().getPartyWindow() != null)
        {
        	verticalPosition += increment;
            if (verticalPosition >= maxVerticalPosition) {
               return;
            }
            
        	GL11.glScalef(fontHeight,fontHeight,fontHeight);
            mSize = (float)Math.pow(fontHeight,-1);
        	String targetText = "Party"; 
        	int lengthOfText = (int)(Minecraft.getInstance().fontRenderer.getStringWidth(targetText)*fontHeight);
	        int horizontalTextPosition = scaledWidth - lengthOfText;
	        int vertitalTextPosition = verticalPosition + (progressBarDistances) + (int)(15*fontHeight);
	        Minecraft.getInstance().fontRenderer.drawStringWithShadow(targetText, Math.round(horizontalTextPosition / fontHeight),Math.round(vertitalTextPosition / fontHeight), 16777215);
	        GL11.glScalef(mSize,mSize,mSize);
        }
        
        if (ClientState.getInstance().getPartyWindow() != null && ClientState.getInstance().getPartyWindow().PartyMembers != null && ClientState.getInstance().getPartyWindow().PartyMembers.size() > 0)
        {
        	for(int p = 0; p < ClientState.getInstance().getPartyWindow().PartyMembers.size(); p++)
        	{
        		PartyWindowPlayer partyMember = ClientState.getInstance().getPartyWindow().PartyMembers.get(p);
        		if (partyMember == null)
        			continue;
        		
        		GL11.glScalef(fontHeight,fontHeight,fontHeight);
                mSize = (float)Math.pow(fontHeight,-1);
            	String targetText = partyMember.Name; 
            	int lengthOfText = (int)(Minecraft.getInstance().fontRenderer.getStringWidth(targetText)*fontHeight);
    	        int horizontalTextPosition = scaledWidth - lengthOfText;
    	        int vertitalTextPosition = verticalPosition + (progressBarDistances*3) + (int)(15*fontHeight);
    	        Minecraft.getInstance().fontRenderer.drawStringWithShadow(targetText, Math.round(horizontalTextPosition / fontHeight),Math.round(vertitalTextPosition / fontHeight), 16777215);
    	        GL11.glScalef(mSize,mSize,mSize);
    	        
    	    	Minecraft.getInstance().getTextureManager().bindTexture(GUI_BARS_TEXTURES);
    	        this.renderSpellbar(progressBarHorizontalPosition, verticalPosition + (progressBarDistances*6), Color.RED, (float) (partyMember.HealthPercent), overlayType, progressBarWidth);
    	        Minecraft.getInstance().getTextureManager().bindTexture(GUI_BARS_TEXTURES);
    	        this.renderSpellbar(progressBarHorizontalPosition, verticalPosition+(progressBarDistances*7), Color.BLUE, (float) (partyMember.ManaPercent), overlayType, progressBarWidth);
    	        
    	        verticalPosition += increment;
                if (verticalPosition >= maxVerticalPosition) {
                   break;
                }
        	}
        }
	}
	
	private void renderSpellbar(int x, int y, Color color, float percent, int overlayType, int progressBarWidth)
	{
		int width = 50;
		float progressBarWidthMultiplier = 81.0F;
		this.blit(x, y, 0, color.ordinal() * 5 * 2, progressBarWidth, 5);
	      if (overlayType != 0) {
	         this.blit(x, y, 0, width + (overlayType - 1) * 5 * 2, progressBarWidth, 5);
	      }

	      int i = (int)(percent * progressBarWidthMultiplier);
	      if (i > 0) {
	         this.blit(x, y, 0, color.ordinal() * 5 * 2 + 5, i, 5);
	         if (overlayType != 0) {
	            this.blit(x, y, 0, width + (overlayType - 1) * 5 * 2 + 5, i, 5);
	         }
	      }
	}
		
	public void renderState()
	{
		//GL11.glColor4f(1, 1, 1, 1);
		
		drawRightAlignedString(Minecraft.getInstance().fontRenderer, "HP: " + ClientState.getInstance().getHealthPercent() + " MP: " + ClientState.getInstance().getManaPercent(), 0, 0, Integer.parseInt("FFAA00",16));
		drawRightAlignedString(Minecraft.getInstance().fontRenderer, "Casting: " + ClientState.getInstance().getCastingProgress() + "/1", 0, 10, Integer.parseInt("FFAA00",16));
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
