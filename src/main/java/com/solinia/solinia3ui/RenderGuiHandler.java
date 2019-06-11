package com.solinia.solinia3ui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class RenderGuiHandler {
	private solinia3ui _parent;
	
	public static final ResourceLocation spellbarUi = new ResourceLocation( "solinia3ui", "textures/gui/spellbar.png" );

	public RenderGuiHandler(solinia3ui parent)
	{
		_parent = parent;
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onRenderGameOverlayEvent(RenderGameOverlayEvent.Post event) {
		if (event.isCanceled())
			return;
		
		if (Minecraft.getInstance() == null)
			return;
		
		if (Minecraft.getInstance().mainWindow == null)
			return;
		
		if (_parent == null)
			return;
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onRenderSpellbook(RenderGameOverlayEvent.Post event)
	{
		if (event.isCanceled() || event.getType() != ElementType.FOOD) { return; }
		
		//Mouse.setGrabbed(false);
		
		//int spellUiWidth = 256;
		//int spellUiHeight = 168;
		//Minecraft.getInstance().textureManager.bindTexture(spellbookUi);
		//drawTexturedModalRect(50, 50, 0, 0, spellUiWidth, spellUiHeight, 6);
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onRenderSpellbar(RenderGameOverlayEvent.Post event) {
		int width = Minecraft.getInstance().mainWindow.getScaledWidth();
		int height = Minecraft.getInstance().mainWindow.getScaledHeight();
		
		if (event.isCanceled() || event.getType() != ElementType.FOOD) { return; }
		
		int spellbarUiWidth = 108;
		int spellbarUiHeight = 14;
		Minecraft.getInstance().textureManager.bindTexture(spellbarUi);
		drawTexturedModalRect(3, height-20-spellbarUiHeight, 0, 0, spellbarUiWidth, spellbarUiHeight, 5);
	}
	
	public void drawTexturedModalRect(int x, int y, int textureX, int textureY, int width, int height, int zLevel) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();
        bufferbuilder.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
        bufferbuilder.pos(x + 0, y + height, zLevel).tex(textureX * 0.00390625F, (textureY + height) * 0.00390625F).endVertex();
        bufferbuilder.pos(x + width, y + height, zLevel).tex((textureX + width) * 0.00390625F, (textureY + height) * 0.00390625F).endVertex();
        bufferbuilder.pos(x + width, y + 0, zLevel).tex((textureX + width) * 0.00390625F, textureY * 0.00390625F).endVertex();
        bufferbuilder.pos(x + 0, y + 0, zLevel).tex(textureX * 0.00390625F, textureY * 0.00390625F).endVertex();
        tessellator.draw();
	}

}
