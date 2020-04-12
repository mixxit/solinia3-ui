package com.solinia.solinia3ui.Guis;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import com.mojang.blaze3d.platform.GlStateManager;
import com.solinia.solinia3ui.ClientState;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.BossInfo;

public class GuiCharacterText extends AbstractGui {
	private static final ResourceLocation GUI_BARS_TEXTURES = new ResourceLocation("textures/gui/bars.png");

	Minecraft minecraft;
	public GuiCharacterText(Minecraft minecraft)
	{
		this.minecraft = minecraft;
		render();
	}
	
	public void renderEntityHp(String entityName, float entityHp, int verticalPosition, int progressBarDistances, int progressBarWidth, int overlayType, float fontHeight, int index)
	{
		String ctrlShortcut = "CTRL-"+(index+1);
		if (index < 0)
			ctrlShortcut = "";
		entityName = entityName + " " + ctrlShortcut;
		String hp = "["+(int)(entityHp*100)+"% HP]";
        //int increment = 16;
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
    	GL11.glScalef(fontHeight,fontHeight,fontHeight);
        float mSize = (float)Math.pow(fontHeight,-1);
        int lengthOfText1 = (int)(this.minecraft.fontRenderer.getStringWidth(entityName)*fontHeight);
        int horizontalTextPosition1 = this.minecraft.mainWindow.getScaledWidth() - lengthOfText1;
        int vertitalTextPosition1 = verticalPosition - (int)(10*fontHeight);
        //int maxVerticalPosition = this.minecraft.mainWindow.getScaledHeight();
        this.minecraft.fontRenderer.drawString(entityName, Math.round(horizontalTextPosition1 / fontHeight),Math.round(vertitalTextPosition1 / fontHeight), 16777215);
        GL11.glScalef(mSize,mSize,mSize);
    	
    	int progressBarHorizontalPosition = this.minecraft.mainWindow.getScaledWidth() - progressBarWidth;
    	this.minecraft.getTextureManager().bindTexture(GUI_BARS_TEXTURES);
        this.renderProgressBar(progressBarHorizontalPosition, verticalPosition, BossInfo.Color.RED, entityHp, overlayType, progressBarWidth);
    	GL11.glScalef(fontHeight,fontHeight,fontHeight);
        this.minecraft.fontRenderer.drawString(hp, Math.round(horizontalTextPosition1 / fontHeight),Math.round(vertitalTextPosition1 / fontHeight)+12, 16777215);
        GL11.glScalef(mSize,mSize,mSize);
	}
	
	public void renderEntityHpAndMana(String entityName, float entityHp, float entityMana, int verticalPosition, int progressBarDistances, int progressBarWidth, int overlayType, float fontHeight, int index)
	{
		entityName = entityName + " " + "CTRL-"+(index+1);
		String hp = "["+(int)(entityHp*100)+"% HP]";
		//int increment = 16;
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
    	GL11.glScalef(fontHeight,fontHeight,fontHeight);
        float mSize = (float)Math.pow(fontHeight,-1);
        int lengthOfText1 = (int)(this.minecraft.fontRenderer.getStringWidth(entityName)*fontHeight);
        int horizontalTextPosition1 = this.minecraft.mainWindow.getScaledWidth() - lengthOfText1;
        int vertitalTextPosition1 = verticalPosition - (int)(10*fontHeight);
        //int maxVerticalPosition = this.minecraft.mainWindow.getScaledHeight();
        this.minecraft.fontRenderer.drawString(entityName, Math.round(horizontalTextPosition1 / fontHeight),Math.round(vertitalTextPosition1 / fontHeight), 16777215);
        GL11.glScalef(mSize,mSize,mSize);
    	
    	int progressBarHorizontalPosition = this.minecraft.mainWindow.getScaledWidth() - progressBarWidth;
    	this.minecraft.getTextureManager().bindTexture(GUI_BARS_TEXTURES);
        this.renderProgressBar(progressBarHorizontalPosition, verticalPosition, BossInfo.Color.RED, entityHp, overlayType, progressBarWidth);
        this.minecraft.getTextureManager().bindTexture(GUI_BARS_TEXTURES);
        this.renderProgressBar(progressBarHorizontalPosition, verticalPosition+(progressBarDistances*1), BossInfo.Color.BLUE, entityMana, overlayType, progressBarWidth);
    	GL11.glScalef(fontHeight,fontHeight,fontHeight);
        this.minecraft.fontRenderer.drawString(hp, Math.round(horizontalTextPosition1 / fontHeight)+15,Math.round(vertitalTextPosition1 / fontHeight)+12, 16777215);
        GL11.glScalef(mSize,mSize,mSize);
	}
	
	public void renderSpellBar(int verticalPosition, int progressBarDistances, int progressBarWidth, int overlayType)
	{
    	int progressBarHorizontalPosition = this.minecraft.mainWindow.getScaledWidth() - progressBarWidth;
    	this.minecraft.getTextureManager().bindTexture(GUI_BARS_TEXTURES);
        this.renderProgressBar(progressBarHorizontalPosition, verticalPosition+(progressBarDistances*2), BossInfo.Color.YELLOW, (float) ClientState.getInstance().getCastingPercent(), overlayType, progressBarWidth);
	}
	
	public void renderTarget(int verticalPosition, int progressBarDistances, int progressBarWidth, int overlayType, float fontHeight)
	{
    	int mylevel = 0;
    	int theirlevel = 0;
		String targetName = "None";
		
		if (ClientState.getInstance().getEntityVital(0) != null)
    	{
			if (ClientState.getInstance().getEntityVital(0).getLevel() > 0)
				mylevel = ClientState.getInstance().getEntityVital(0).getLevel();
    	}
		
    	if (ClientState.getInstance().getEntityVital(-1) != null)
    	{
        	if (ClientState.getInstance().getEntityVital(-1).getName() != null)
        		targetName = ClientState.getInstance().getEntityVital(-1).getName();

        	if (ClientState.getInstance().getEntityVital(-1).getLevel() > 0)
        		theirlevel = ClientState.getInstance().getEntityVital(-1).getLevel();
        	
        	int progressBarHorizontalPosition = this.minecraft.mainWindow.getScaledWidth() - progressBarWidth;
            this.minecraft.getTextureManager().bindTexture(GUI_BARS_TEXTURES);
            this.renderProgressBar(progressBarHorizontalPosition, verticalPosition+(progressBarDistances*5), BossInfo.Color.RED, (float) (ClientState.getInstance().getEntityVital(-1).getHealthPercent()), overlayType, progressBarWidth);
    	}
    	
    	TextFormatting con = this.getLevelCon(mylevel, theirlevel);

    	GL11.glScalef(fontHeight,fontHeight,fontHeight);
    	float mSize = (float)Math.pow(fontHeight,-1);
    	String hp = "["+(int)(ClientState.getInstance().getEntityVital(-1).getHealthPercent()*100)+"% HP]";
    	
    	String targetText = "Target: " + targetName; 
    	int lengthOfText = (int)(this.minecraft.fontRenderer.getStringWidth(targetText)*fontHeight);
        int horizontalTextPosition = this.minecraft.mainWindow.getScaledWidth() - lengthOfText;
        int vertitalTextPosition = verticalPosition + (progressBarDistances*2) + (int)(15*fontHeight);
        this.minecraft.fontRenderer.drawStringWithShadow(targetText, Math.round(horizontalTextPosition / fontHeight),Math.round(vertitalTextPosition / fontHeight), con.getColor());
        this.minecraft.fontRenderer.drawString(hp, Math.round(horizontalTextPosition / fontHeight)+15,Math.round(vertitalTextPosition / fontHeight)+12, 16777215);
        GL11.glScalef(mSize,mSize,mSize);
	}
	
	public static TextFormatting getLevelCon(int mylevel, int iOtherLevel) {
		TextFormatting conlevel = TextFormatting.WHITE;

		int diff = iOtherLevel - mylevel;

		if (diff == 0)
			return TextFormatting.WHITE;
		else if (diff >= 1 && diff <= 2)
			return TextFormatting.YELLOW;
		else if (diff >= 3)
			return TextFormatting.RED;

		if (mylevel <= 8) {
			if (diff <= -4)
				conlevel = TextFormatting.GRAY;
			else
				conlevel = TextFormatting.BLUE;
		} else if (mylevel <= 9) {
			if (diff <= -6)
				conlevel = TextFormatting.GRAY;
			else if (diff <= -4)
				conlevel = TextFormatting.AQUA;
			else
				conlevel = TextFormatting.BLUE;
		} else if (mylevel <= 13) {
			if (diff <= -7)
				conlevel = TextFormatting.GRAY;
			else if (diff <= -5)
				conlevel = TextFormatting.AQUA;
			else
				conlevel = TextFormatting.BLUE;
		} else if (mylevel <= 15) {
			if (diff <= -7)
				conlevel = TextFormatting.GRAY;
			else if (diff <= -5)
				conlevel = TextFormatting.AQUA;
			else
				conlevel = TextFormatting.BLUE;
		} else if (mylevel <= 17) {
			if (diff <= -8)
				conlevel = TextFormatting.GRAY;
			else if (diff <= -6)
				conlevel = TextFormatting.AQUA;
			else
				conlevel = TextFormatting.BLUE;
		} else if (mylevel <= 21) {
			if (diff <= -9)
				conlevel = TextFormatting.GRAY;
			else if (diff <= -7)
				conlevel = TextFormatting.AQUA;
			else
				conlevel = TextFormatting.BLUE;
		} else if (mylevel <= 25) {
			if (diff <= -10)
				conlevel = TextFormatting.GRAY;
			else if (diff <= -8)
				conlevel = TextFormatting.AQUA;
			else
				conlevel = TextFormatting.BLUE;
		} else if (mylevel <= 29) {
			if (diff <= -11)
				conlevel = TextFormatting.GRAY;
			else if (diff <= -9)
				conlevel = TextFormatting.AQUA;
			else
				conlevel = TextFormatting.BLUE;
		} else if (mylevel <= 31) {
			if (diff <= -12)
				conlevel = TextFormatting.GRAY;
			else if (diff <= -9)
				conlevel = TextFormatting.AQUA;
			else
				conlevel = TextFormatting.BLUE;
		} else if (mylevel <= 33) {
			if (diff <= -13)
				conlevel = TextFormatting.GRAY;
			else if (diff <= -10)
				conlevel = TextFormatting.AQUA;
			else
				conlevel = TextFormatting.BLUE;
		} else if (mylevel <= 37) {
			if (diff <= -14)
				conlevel = TextFormatting.GRAY;
			else if (diff <= -11)
				conlevel = TextFormatting.AQUA;
			else
				conlevel = TextFormatting.BLUE;
		} else if (mylevel <= 41) {
			if (diff <= -16)
				conlevel = TextFormatting.GRAY;
			else if (diff <= -12)
				conlevel = TextFormatting.AQUA;
			else
				conlevel = TextFormatting.BLUE;
		} else if (mylevel <= 45) {
			if (diff <= -17)
				conlevel = TextFormatting.GRAY;
			else if (diff <= -13)
				conlevel = TextFormatting.AQUA;
			else
				conlevel = TextFormatting.BLUE;
		} else if (mylevel <= 49) {
			if (diff <= -18)
				conlevel = TextFormatting.GRAY;
			else if (diff <= -14)
				conlevel = TextFormatting.AQUA;
			else
				conlevel = TextFormatting.BLUE;
		} else if (mylevel <= 53) {
			if (diff <= -19)
				conlevel = TextFormatting.GRAY;
			else if (diff <= -15)
				conlevel = TextFormatting.AQUA;
			else
				conlevel = TextFormatting.BLUE;
		} else if (mylevel <= 55) {
			if (diff <= -20)
				conlevel = TextFormatting.GRAY;
			else if (diff <= -15)
				conlevel = TextFormatting.AQUA;
			else
				conlevel = TextFormatting.BLUE;
		} else {
			if (diff <= -21)
				conlevel = TextFormatting.GRAY;
			else if (diff <= -16)
				conlevel = TextFormatting.AQUA;
			else
				conlevel = TextFormatting.BLUE;
		}

		return conlevel;
	}

	
	public void render()
	{
		if (this.minecraft.player == null)
			return;
		
		/*if (true)
			return;*/

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

    		renderEntityHpAndMana(entityName, entityHealth, entityMana, verticalPosition, progressBarDistances, progressBarWidth, overlayType,fontHeight,0);
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

    		renderEntityHp(entityName, entityHealth, verticalPosition+35, progressBarDistances, progressBarWidth, overlayType,fontHeight,-2);
    		
    		if (true)
            {
    	        GL11.glScalef(fontHeight,fontHeight,fontHeight);
    	        float mSize = (float)Math.pow(fontHeight,-1);
    	    	String targetText = "Pet CTRL-P"; 
    	    	int lengthOfText = (int)(this.minecraft.fontRenderer.getStringWidth(targetText)*fontHeight)+51;
    	        int horizontalTextPosition = this.minecraft.mainWindow.getScaledWidth() - lengthOfText;
    	        int vertitalTextPosition = verticalPosition + (progressBarDistances) + (int)(45*fontHeight);
    	        this.minecraft.fontRenderer.drawString(targetText, Math.round(horizontalTextPosition / fontHeight),Math.round(vertitalTextPosition / fontHeight), 16777215);
    	        GL11.glScalef(mSize,mSize,mSize);
            }
        }
        
        
        
        if (true)
        {
	        GL11.glScalef(fontHeight,fontHeight,fontHeight);
	        float mSize = (float)Math.pow(fontHeight,-1);
	    	String targetText = "Party Members:"; 
	    	int lengthOfText = (int)(this.minecraft.fontRenderer.getStringWidth(targetText)*fontHeight)+40;
	        int horizontalTextPosition = this.minecraft.mainWindow.getScaledWidth() - lengthOfText;
	        int vertitalTextPosition = verticalPosition + (progressBarDistances) + (int)(80*fontHeight);
	        this.minecraft.fontRenderer.drawString(targetText, Math.round(horizontalTextPosition / fontHeight),Math.round(vertitalTextPosition / fontHeight), 16777215);
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

    		renderEntityHp(entityName, entityHealth, verticalPosition+(distanceBetweenElements*(i+1)), progressBarDistances, progressBarWidth, overlayType,fontHeight,i);
        }
	}
	
	private void renderProgressBar(int x, int y, BossInfo.Color color, float percent, int overlayType, int progressBarWidth)
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
