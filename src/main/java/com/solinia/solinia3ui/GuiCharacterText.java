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
	
	public void renderEntityHp(String entityName, float entityHp, int verticalPosition, int progressBarDistances, int progressBarWidth, int overlayType, float fontHeight)
	{
		entityName = entityName + " ["+(int)(entityHp*100)+"% HP]";
        //int increment = 16;
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
    	GL11.glScalef(fontHeight,fontHeight,fontHeight);
        float mSize = (float)Math.pow(fontHeight,-1);
        int lengthOfText1 = (int)(Minecraft.getInstance().fontRenderer.getStringWidth(entityName)*fontHeight);
        int horizontalTextPosition1 = Minecraft.getInstance().mainWindow.getScaledWidth() - lengthOfText1;
        int vertitalTextPosition1 = verticalPosition - (int)(10*fontHeight);
        //int maxVerticalPosition = Minecraft.getInstance().mainWindow.getScaledHeight();
        Minecraft.getInstance().fontRenderer.drawString(entityName, Math.round(horizontalTextPosition1 / fontHeight),Math.round(vertitalTextPosition1 / fontHeight), 16777215);
        GL11.glScalef(mSize,mSize,mSize);
    	
    	int progressBarHorizontalPosition = Minecraft.getInstance().mainWindow.getScaledWidth() - progressBarWidth;
    	Minecraft.getInstance().getTextureManager().bindTexture(GUI_BARS_TEXTURES);
        this.renderProgressBar(progressBarHorizontalPosition, verticalPosition, Color.RED, entityHp, overlayType, progressBarWidth);
	}
	
	public void renderEntityHpAndMana(String entityName, float entityHp, float entityMana, int verticalPosition, int progressBarDistances, int progressBarWidth, int overlayType, float fontHeight)
	{
		entityName = entityName + " ["+(int)(entityHp*100)+"% HP]";
        //int increment = 16;
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
    	GL11.glScalef(fontHeight,fontHeight,fontHeight);
        float mSize = (float)Math.pow(fontHeight,-1);
        int lengthOfText1 = (int)(Minecraft.getInstance().fontRenderer.getStringWidth(entityName)*fontHeight);
        int horizontalTextPosition1 = Minecraft.getInstance().mainWindow.getScaledWidth() - lengthOfText1;
        int vertitalTextPosition1 = verticalPosition - (int)(10*fontHeight);
        //int maxVerticalPosition = Minecraft.getInstance().mainWindow.getScaledHeight();
        Minecraft.getInstance().fontRenderer.drawString(entityName, Math.round(horizontalTextPosition1 / fontHeight),Math.round(vertitalTextPosition1 / fontHeight), 16777215);
        GL11.glScalef(mSize,mSize,mSize);
    	
    	int progressBarHorizontalPosition = Minecraft.getInstance().mainWindow.getScaledWidth() - progressBarWidth;
    	Minecraft.getInstance().getTextureManager().bindTexture(GUI_BARS_TEXTURES);
        this.renderProgressBar(progressBarHorizontalPosition, verticalPosition, Color.RED, entityHp, overlayType, progressBarWidth);
        Minecraft.getInstance().getTextureManager().bindTexture(GUI_BARS_TEXTURES);
        this.renderProgressBar(progressBarHorizontalPosition, verticalPosition+(progressBarDistances*1), Color.BLUE, entityMana, overlayType, progressBarWidth);
	}
	
	public void renderSpellBar(int verticalPosition, int progressBarDistances, int progressBarWidth, int overlayType)
	{
    	int progressBarHorizontalPosition = Minecraft.getInstance().mainWindow.getScaledWidth() - progressBarWidth;
    	Minecraft.getInstance().getTextureManager().bindTexture(GUI_BARS_TEXTURES);
        this.renderProgressBar(progressBarHorizontalPosition, verticalPosition+(progressBarDistances*2), Color.YELLOW, (float) ClientState.getInstance().getCastingPercent(), overlayType, progressBarWidth);
	}
	
	public void renderTarget(int verticalPosition, int progressBarDistances, int progressBarWidth, int overlayType, float fontHeight)
	{
		String targetName = "None";
    	if (ClientState.getInstance().getEntityVital(-1) != null && ClientState.getInstance().getEntityVital(-1).getName() != null)
    		targetName = ClientState.getInstance().getEntityVital(-1).getName();
    	
    	if (ClientState.getInstance().getEntityVital(-1) != null)
    	{
        	int progressBarHorizontalPosition = Minecraft.getInstance().mainWindow.getScaledWidth() - progressBarWidth;
            Minecraft.getInstance().getTextureManager().bindTexture(GUI_BARS_TEXTURES);
            this.renderProgressBar(progressBarHorizontalPosition, verticalPosition+(progressBarDistances*5), Color.RED, (float) (ClientState.getInstance().getEntityVital(-1).getHealthPercent()), overlayType, progressBarWidth);
    	}

    	GL11.glScalef(fontHeight,fontHeight,fontHeight);
    	float mSize = (float)Math.pow(fontHeight,-1);
    	String targetText = "Target: " + targetName+ " ["+(int)(ClientState.getInstance().getEntityVital(-1).getHealthPercent()*100)+"% HP]"; 
    	int lengthOfText = (int)(Minecraft.getInstance().fontRenderer.getStringWidth(targetText)*fontHeight);
        int horizontalTextPosition = Minecraft.getInstance().mainWindow.getScaledWidth() - lengthOfText;
        int vertitalTextPosition = verticalPosition + (progressBarDistances*2) + (int)(15*fontHeight);
        Minecraft.getInstance().fontRenderer.drawString(targetText, Math.round(horizontalTextPosition / fontHeight),Math.round(vertitalTextPosition / fontHeight), 16777215);
        GL11.glScalef(mSize,mSize,mSize);
	}
	
	public void render()
	{
		if (Minecraft.getInstance().player == null)
			return;

    	float fontHeight = 0.5f;
        int progressBarDistances = 4;
        int progressBarWidth = 80;
        int overlayType = 0;
        int verticalPosition = 65;
        
        if (ClientState.getInstance().getEntityVital(0) != null)
    	{
        	String entityName = "";
    		if (ClientState.getInstance().getEntityVital(0).getName() != null)
    			entityName = ClientState.getInstance().getEntityVital(0).getName();
    		
    		float entityHealth = ClientState.getInstance().getEntityVital(0).getHealthPercent();
    		float entityMana = ClientState.getInstance().getEntityVital(0).getManaPercent();

    		renderEntityHpAndMana(entityName, entityHealth, entityMana, verticalPosition, progressBarDistances, progressBarWidth, overlayType,fontHeight);
    		renderSpellBar(verticalPosition, progressBarDistances, progressBarWidth, overlayType);

    	}
        
        // Target
        if (ClientState.getInstance().getEntityVital(-1) != null)
        {
        	renderTarget(verticalPosition, progressBarDistances, progressBarWidth, overlayType,fontHeight);
        }
        
        // Pet
        if (ClientState.getInstance().getEntityVital(-2) != null && ClientState.getInstance().getEntityVital(-2).getName() != null && 
    			!ClientState.getInstance().getEntityVital(-2).getName().isEmpty())
        {
        	String entityName = "";
    		if (ClientState.getInstance().getEntityVital(-2).getName() != null)
    			entityName = ClientState.getInstance().getEntityVital(-2).getName();
    		
    		float entityHealth = ClientState.getInstance().getEntityVital(-2).getHealthPercent();

    		renderEntityHp(entityName, entityHealth, verticalPosition+35, progressBarDistances, progressBarWidth, overlayType,fontHeight);
    		
    		if (true)
            {
    	        GL11.glScalef(fontHeight,fontHeight,fontHeight);
    	        float mSize = (float)Math.pow(fontHeight,-1);
    	    	String targetText = "Pet:"; 
    	    	int lengthOfText = (int)(Minecraft.getInstance().fontRenderer.getStringWidth(targetText)*fontHeight)+69;
    	        int horizontalTextPosition = Minecraft.getInstance().mainWindow.getScaledWidth() - lengthOfText;
    	        int vertitalTextPosition = verticalPosition + (progressBarDistances) + (int)(50*fontHeight);
    	        Minecraft.getInstance().fontRenderer.drawString(targetText, Math.round(horizontalTextPosition / fontHeight),Math.round(vertitalTextPosition / fontHeight), 16777215);
    	        GL11.glScalef(mSize,mSize,mSize);
            }
        }
        
        
        
        if (true)
        {
	        GL11.glScalef(fontHeight,fontHeight,fontHeight);
	        float mSize = (float)Math.pow(fontHeight,-1);
	    	String targetText = "Party Members:"; 
	    	int lengthOfText = (int)(Minecraft.getInstance().fontRenderer.getStringWidth(targetText)*fontHeight)+40;
	        int horizontalTextPosition = Minecraft.getInstance().mainWindow.getScaledWidth() - lengthOfText;
	        int vertitalTextPosition = verticalPosition + (progressBarDistances) + (int)(85*fontHeight);
	        Minecraft.getInstance().fontRenderer.drawString(targetText, Math.round(horizontalTextPosition / fontHeight),Math.round(vertitalTextPosition / fontHeight), 16777215);
	        GL11.glScalef(mSize,mSize,mSize);
        }
        
        verticalPosition = verticalPosition+15;
        int distanceBetweenElements = 20;
        
        for(int i = 1; i <= 5; i++)
        {
        	if (ClientState.getInstance().getEntityVital(i) == null || 
        			ClientState.getInstance().getEntityVital(i).getName() == null || 
        			ClientState.getInstance().getEntityVital(i).getName().isEmpty()
        			)
        		continue;
        		
        	String entityName = "";
    		if (ClientState.getInstance().getEntityVital(i).getName() != null)
    			entityName = ClientState.getInstance().getEntityVital(i).getName() + " ["+i+"]";
    		
    		float entityHealth = ClientState.getInstance().getEntityVital(i).getHealthPercent();

    		renderEntityHp(entityName, entityHealth, verticalPosition+(distanceBetweenElements*(i+1)), progressBarDistances, progressBarWidth, overlayType,fontHeight);
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
