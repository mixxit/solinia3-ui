package com.solinia.solinia3ui;

import java.util.concurrent.ConcurrentHashMap;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.GuiScreenEvent.MouseClickedEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class RenderGuiHandler {
	public static final int spellbarDistanceFromLeft = 3;
	public static final int spellbarDistanceFromBottom = 16;
	public static final int spellbarUiWidth = 16;
	public static final int spellbarUiHeight = 16;
	public static final int edgePositionX = 0;
	public static final int hotbarCount = 8;
	
	public static final int memorisedSpellSize = 16;
	
	public ConcurrentHashMap<Integer,Button> memorisedButtons = new ConcurrentHashMap<Integer,Button>();
	
	public static final ResourceLocation spellbarUi = new ResourceLocation( "solinia3ui", "textures/gui/spellbar.png" );

	public RenderGuiHandler()
	{
		int baseX = 0;
        int baseY = 0;
        
		for(int i = 0; i < hotbarCount; i++)
		{
			int slot = (i+1);
			this.memorisedButtons.put(i,new GuiSpellIconButton(memorisedSpellSize*i,0,16,16,-1+"^"+Integer.toString(slot), new GuiMemorisedSpellButtonPressable(slot)));
			//Minecraft.getInstance().textureManager.bindTexture(spellbarUi);
			//drawTexturedModalRect(edgePositionX+spellbarDistanceFromLeft+(i*spellbarUiWidth), height-spellbarDistanceFromBottom-spellbarUiHeight, 0, 0, spellbarUiWidth, spellbarUiHeight, 5);
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onMouseClickEvent(MouseClickedEvent.Post event)
	{
		if (event.isCanceled())
			return;
		
		if (event.getGui() instanceof GuiSpellbook)
		{
			handleMainScreenClickWithSpellbookOpen((GuiSpellbook)event.getGui(), event.getMouseX(), event.getMouseY());
		}
	}
	
	private void handleMainScreenClickWithSpellbookOpen(GuiSpellbook spellBook, double x, double y) {
		int selectedSpellid = spellBook.getSelectedSpellId();
		if (selectedSpellid < 1)
			return; 
		int memorisedSpellSlot = getMemorisedSpellSlotByMouseCoords((int)Math.round(x), (int)Math.round(y));
		if (memorisedSpellSlot < 1)
			return; 
		
		System.out.println("/memorisespell " + memorisedSpellSlot + " " + selectedSpellid);
		Minecraft.getInstance().player.sendChatMessage("/memorisespell " + memorisedSpellSlot + " " + selectedSpellid);
	}

	private int getMemorisedSpellSlotByMouseCoords(int mouseX, int mouseY) {
		for (int i = 0; i < memorisedButtons.size(); i++)
		{
			if (memorisedButtons.get(i).isMouseOver(mouseX, mouseY))
				return (i+1);
			
		}
		return -1;
	}

	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onRenderSpellbar(RenderGameOverlayEvent.Post event) {
		if (event.isCanceled() || event.getType() != ElementType.FOOD) { return; }
		
		for(int i = 0; i < memorisedButtons.size(); i++)
		{
			int slot = (i+1);
			if (ClientState.getInstance().getMemorisedSpells().getSpellIcon(slot) > 0)
			{
				memorisedButtons.get(i).setMessage(ClientState.getInstance().getMemorisedSpells().getNewIcon(slot)+"^"+Integer.toString(slot));
				//this.memorisedButtons.put(i,new GuiSpellIconButton(memorisedSpellSize*i,0,16,16,memorisedSpells.getNewIcon(slot)+"^"+Integer.toString(slot), new GuiMemorisedSpellButtonPressable(slot)));
			}
			
			memorisedButtons.get(i).render(memorisedSpellSize*i, 0, 1.0F);
		}
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
