package com.solinia.solinia3ui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class GuiSpellIconButton extends GuiButton {

	protected static final ResourceLocation SPELLICONS = new ResourceLocation( "solinia3ui", "textures/gui/spellicons.png");
	
	public GuiSpellIconButton(int buttonId, int x, int y, String buttonText, int spellIcon) {
		super(buttonId, x, y, buttonText);
	}

	public GuiSpellIconButton(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText, int spellIcon) {
		super(buttonId, x, y, widthIn, heightIn, buttonText);
	}

	@Override
	public void render(int mouseX, int mouseY, float partialTicks) {
		if (!this.visible)
			return;
		
		//Minecraft.getInstance().getTextureManager().bindTexture(SPELLTEXTURES1);
		//GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		//this.hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width
		//		&& mouseY < this.y + this.height;
		//int i = this.getHoverState(this.hovered);
		//int i = this.getHoverState(false); // we have only one icon
		//GlStateManager.enableBlend();
		//GlStateManager.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA,
		//		GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE,
		//		GlStateManager.DestFactor.ZERO);
		//GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA,
		//		GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
		//this.drawTexturedModalRect(this.x, this.y, 0, 46 + i * 20, this.width / 2, this.height);
		//this.drawTexturedModalRect(this.x + this.width / 2, this.y, 200 - this.width / 2, 46 + i * 20,
		//		this.width / 2, this.height);
		//this.renderBg(minecraft, mouseX, mouseY);
		
		Minecraft.getInstance().getTextureManager().bindTexture(SPELLICONS);
		drawSpellIcon(this.x, this.y);
		
		int j = 14737632;
		if (packedFGColor != 0) {
			j = packedFGColor;
		} else if (!this.enabled) {
			j = 10526880;
		} else if (this.hovered) {
			j = 16777120;
		}

		this.drawStringCenteredScale(Minecraft.getInstance().fontRenderer, this.displayString, this.x + this.width /2,this.y + (this.height - 8) + Minecraft.getInstance().fontRenderer.FONT_HEIGHT, 0.5f, j);
	}
	
	public void drawSpellIcon(int x, int y)
	{
		int texturex = 0;
		int texturey = 0;
		int sizex = 40;
		int sizey = 40;

		drawTexturedModalRect(x,y,texturex,texturey,sizex,sizey);
	}
	
	public void drawStringCenteredScale(FontRenderer fontRendererIn, String text, int x, int y, float size, int color) {
        GL11.glScalef(size,size,size);
        float mSize = (float)Math.pow(size,-1);
        this.drawCenteredString(fontRendererIn,text,Math.round(x / size),Math.round(y / size),color);
        GL11.glScalef(mSize,mSize,mSize);
    }
}
