package com.solinia.solinia3ui;

import java.util.concurrent.ConcurrentHashMap;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.GuiScreenEvent.MouseClickedEvent;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class RenderGuiHandler {
//	public static final int spellbarDistanceFromLeft = 3;
//	public static final int spellbarDistanceFromBottom = 16;
//	public static final int spellbarUiWidth = 16;
//	public static final int spellbarUiHeight = 16;
//	public static final int edgePositionX = 0;
	public static final int hotbarCount = 8;
	
	public static final int memorisedSpellSize = 20;
	
	public ConcurrentHashMap<Integer,Button> memorisedButtons = new ConcurrentHashMap<Integer,Button>();
	
	public RenderGuiHandler()
	{
		int baseX = 0;
        int baseY = 0;
        
		for(int i = 0; i < hotbarCount; i++)
		{
			int slot = (i+1);
			this.memorisedButtons.put(i,new GuiSpellIconButton(memorisedSpellSize*i,0,memorisedSpellSize,memorisedSpellSize,-1+"^"+Integer.toString(slot), new GuiMemorisedSpellButtonPressable(slot)));
		}

	}
	
	
	@SubscribeEvent(priority = EventPriority.LOWEST, receiveCanceled = true)
	public void onGui(GuiOpenEvent event)
	{
		if (event.isCanceled())
			return;
		
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onMouseClickEvent(MouseClickedEvent.Post event)
	{
		System.out.println("Clicked " + event.getGui());

		if (event.isCanceled())
			return;
		
		if (event.getGui() instanceof GuiSpellbook)
		{
			handleMainScreenClickWithSpellbookOpen((GuiSpellbook)event.getGui(), event.getMouseX(), event.getMouseY(), event.getButton());
		} else {
			if (event.getButton() != 0)
			{
				int memorisedSpellSlot = getMemorisedSpellSlotByMouseCoords((int)Math.round(event.getMouseX()), (int)Math.round(event.getMouseY()));
				if (memorisedSpellSlot < 1)
					return; 
				
				removeSpellSlot(memorisedSpellSlot);
			}
		}
	}
	
	private void removeSpellSlot(int memorisedSpellSlot) {
		Minecraft.getInstance().player.sendChatMessage("/solinia3core:memorisespell " + memorisedSpellSlot + " " + 0);
	}


	private void handleMainScreenClickWithSpellbookOpen(GuiSpellbook spellBook, double x, double y, int button) {
		int memorisedSpellSlot = getMemorisedSpellSlotByMouseCoords((int)Math.round(x), (int)Math.round(y));
		if (memorisedSpellSlot < 1)
			return; 

		if (button == 0)
		{
			int selectedSpellid = spellBook.getSelectedSpellId();
			if (selectedSpellid < 1)
				return; 
		
			Minecraft.getInstance().player.sendChatMessage("/solinia3core:memorisespell " + memorisedSpellSlot + " " + selectedSpellid);
		} else {
			removeSpellSlot(memorisedSpellSlot);
		}
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
	public void onRenderGameOverlay(RenderGameOverlayEvent.Text event)
	{
		if (event.isCanceled())
			return;
		
		new GuiCharacterText();
		
		for(int i = 0; i < memorisedButtons.size(); i++)
		{
			int slot = (i+1);
			if (ClientState.getInstance().getMemorisedSpells().getSlotNewIcon(slot) > 0)
			{
				memorisedButtons.get(i).setMessage(ClientState.getInstance().getMemorisedSpells().getSlotNewIcon(slot)+"^"+Integer.toString(slot));
				//this.memorisedButtons.put(i,new GuiSpellIconButton(memorisedSpellSize*i,0,16,16,memorisedSpells.getNewIcon(slot)+"^"+Integer.toString(slot), new GuiMemorisedSpellButtonPressable(slot)));
			} else {
				memorisedButtons.get(i).setMessage(-1+"^"+Integer.toString(slot));
			}
			
			memorisedButtons.get(i).render(memorisedSpellSize*i, 0, 1.0F);
		}
	}
}
