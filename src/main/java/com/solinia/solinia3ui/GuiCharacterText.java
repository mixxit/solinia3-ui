package com.solinia.solinia3ui;

import org.lwjgl.opengl.GL11;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.BossInfo.Color;

public class GuiCharacterText extends AbstractGui {
	private static final ResourceLocation GUI_BARS_TEXTURES = new ResourceLocation("textures/gui/bars.png");

	   
	public GuiCharacterText()
	{
		render();
	}
	
	public void render()
	{
		if (Minecraft.getInstance().player == null)
			return;
		
		int scaledWidth = Minecraft.getInstance().mainWindow.getScaledWidth();
        int verticalPosition = 65;
        int progressBarWidth = 80;
        int progressBarDistances = 4;
        int increment = 16;
    	float fontHeight = 0.5f;
    	String playerName = "";
    	float playerHealth = 0.0F;
    	float playerMana = 0.0F;
    	if (ClientState.getInstance().getEntityVital(0) != null)
    	{
    		if (ClientState.getInstance().getEntityVital(0).getName() != null)
    			playerName = ClientState.getInstance().getEntityVital(0).getName();
    		playerHealth = ClientState.getInstance().getEntityVital(0).getHealthPercent();
    		playerMana = ClientState.getInstance().getEntityVital(0).getManaPercent();
    	}
        
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
    	GL11.glScalef(fontHeight,fontHeight,fontHeight);
        float mSize = (float)Math.pow(fontHeight,-1);
        int lengthOfText1 = (int)(Minecraft.getInstance().fontRenderer.getStringWidth(playerName)*fontHeight);
        int horizontalTextPosition1 = scaledWidth - lengthOfText1;
        int vertitalTextPosition1 = verticalPosition - (int)(10*fontHeight);
        int maxVerticalPosition = Minecraft.getInstance().mainWindow.getScaledHeight();
        Minecraft.getInstance().fontRenderer.drawString(playerName, Math.round(horizontalTextPosition1 / fontHeight),Math.round(vertitalTextPosition1 / fontHeight), 16777215);
        GL11.glScalef(mSize,mSize,mSize);
    	int overlayType = 0;
    	int progressBarHorizontalPosition = scaledWidth - progressBarWidth;
    	Minecraft.getInstance().getTextureManager().bindTexture(GUI_BARS_TEXTURES);
        this.renderProgressBar(progressBarHorizontalPosition, verticalPosition, Color.RED, playerHealth, overlayType, progressBarWidth);
        Minecraft.getInstance().getTextureManager().bindTexture(GUI_BARS_TEXTURES);
        this.renderProgressBar(progressBarHorizontalPosition, verticalPosition+(progressBarDistances*1), Color.BLUE, playerMana, overlayType, progressBarWidth);
    	Minecraft.getInstance().getTextureManager().bindTexture(GUI_BARS_TEXTURES);
        this.renderProgressBar(progressBarHorizontalPosition, verticalPosition+(progressBarDistances*2), Color.YELLOW, (float) ClientState.getInstance().getCastingPercent(), overlayType, progressBarWidth);
        
        if (ClientState.getInstance().getEntityVital(-1) != null)
        {
        	String targetName = "None";
        	if (ClientState.getInstance().getEntityVital(-1) != null && ClientState.getInstance().getEntityVital(-1).getName() != null)
        		targetName = ClientState.getInstance().getEntityVital(-1).getName();
        	
        	if (ClientState.getInstance().getEntityVital(-1) != null)
        	{
	            Minecraft.getInstance().getTextureManager().bindTexture(GUI_BARS_TEXTURES);
	            this.renderProgressBar(progressBarHorizontalPosition, verticalPosition+(progressBarDistances*5), Color.RED, (float) (ClientState.getInstance().getEntityVital(-1).getHealthPercent()), overlayType, progressBarWidth);
        	}

        	GL11.glScalef(fontHeight,fontHeight,fontHeight);
            mSize = (float)Math.pow(fontHeight,-1);
        	String targetText = "Target: " + targetName; 
        	int lengthOfText = (int)(Minecraft.getInstance().fontRenderer.getStringWidth(targetText)*fontHeight);
	        int horizontalTextPosition = scaledWidth - lengthOfText;
	        int vertitalTextPosition = verticalPosition + (progressBarDistances*2) + (int)(15*fontHeight);
	        Minecraft.getInstance().fontRenderer.drawString(targetText, Math.round(horizontalTextPosition / fontHeight),Math.round(vertitalTextPosition / fontHeight), 16777215);
	        GL11.glScalef(mSize,mSize,mSize);
        }
        
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
        Minecraft.getInstance().fontRenderer.drawString(targetText, Math.round(horizontalTextPosition / fontHeight),Math.round(vertitalTextPosition / fontHeight), 16777215);
        GL11.glScalef(mSize,mSize,mSize);
        
        for(int i = 1; i <= 5; i++)
        {
        	if (ClientState.getInstance().getEntityVital(i) != null && ClientState.getInstance().getEntityVital(i).getUniqueId() != null)
        	{
        		GL11.glScalef(fontHeight,fontHeight,fontHeight);
                mSize = (float)Math.pow(fontHeight,-1);
            	String memberText = ClientState.getInstance().getEntityVital(i).getName(); 
            	int memberlengthOfText = (int)(Minecraft.getInstance().fontRenderer.getStringWidth(memberText)*fontHeight);
    	        int mhorizontalTextPosition = scaledWidth - memberlengthOfText;
    	        int mvertitalTextPosition = verticalPosition + (progressBarDistances*3) + (int)(15*fontHeight);
    	        Minecraft.getInstance().fontRenderer.drawString(memberText, Math.round(mhorizontalTextPosition / fontHeight),Math.round(mvertitalTextPosition / fontHeight), 16777215);
    	        GL11.glScalef(mSize,mSize,mSize);
    	        
    	    	Minecraft.getInstance().getTextureManager().bindTexture(GUI_BARS_TEXTURES);
    	        this.renderProgressBar(progressBarHorizontalPosition, verticalPosition + (progressBarDistances*6), Color.RED, (float) (ClientState.getInstance().getEntityVital(i).getHealthPercent()), overlayType, progressBarWidth);
    	        Minecraft.getInstance().getTextureManager().bindTexture(GUI_BARS_TEXTURES);
    	        this.renderProgressBar(progressBarHorizontalPosition, verticalPosition+(progressBarDistances*7), Color.BLUE, (float) (ClientState.getInstance().getEntityVital(i).getManaPercent()), overlayType, progressBarWidth);
    	        
    	        verticalPosition += increment;
                if (verticalPosition >= maxVerticalPosition) {
                   break;
                }
        	}
        }
	}
	
	private void renderProgressBar(int x, int y, Color color, float percent, int overlayType, int progressBarWidth)
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
}
