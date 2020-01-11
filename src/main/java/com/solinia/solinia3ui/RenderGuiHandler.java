package com.solinia.solinia3ui;

import java.awt.Point;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraftforge.client.event.GuiScreenEvent.MouseClickedEvent;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.config.GuiUtils;

public class RenderGuiHandler {
	public static final int hotbarCount = 8;
	
	public static final int memorisedSpellSize = 20;
	public static final int effectSize = 10;
	public static final int effectSlotLimit = 20;
	
	public ConcurrentHashMap<Integer,GuiMemSpellIconButton> memorisedButtons = new ConcurrentHashMap<Integer,GuiMemSpellIconButton>();
	public ConcurrentHashMap<Integer,Button> effectSlotButtons = new ConcurrentHashMap<Integer,Button>();
	
	public RenderGuiHandler()
	{
		int baseX = 0;
        int baseY = 0;
        
        solinia3ui.LOGGER.info("Test");
        
		for(int i = 0; i < hotbarCount; i++)
		{
			int slot = (i+1);
			this.memorisedButtons.put(i,new GuiMemSpellIconButton(memorisedSpellSize*i,0,memorisedSpellSize,memorisedSpellSize,-1+"^"+Integer.toString(slot), new GuiMemorisedSpellButtonPressable(slot)));
		}

		int startX = Minecraft.getInstance().mainWindow.getScaledWidth()-(effectSize*6);
		int startY = 20-effectSize;
		int rowSize = 5;
		
		int currentRow = 1;
		int currentColumn = 1;
		for(int i = 0; i < effectSlotLimit; i++)
		{
			int slot = (i+1);
			
			int positionOfIconX = ((startX-effectSize)+(currentColumn*effectSize));
			int positionOfIconY = ((startY-effectSize)+(currentRow*effectSize));
			this.effectSlotButtons.put(i,new GuiEffectIconButton(positionOfIconX,positionOfIconY,effectSize,effectSize,-1+"^"+-1+"^", new GuiEffectButtonPressable(slot)));
			
			if (currentColumn < rowSize)
			{
				currentColumn++;
			}
			else
			{
				currentColumn = 1;
				currentRow++;
			}
		}
	}
	
	
	@SubscribeEvent(priority = EventPriority.LOWEST, receiveCanceled = true)
	public void onGui(GuiOpenEvent event)
	{
		if (event.isCanceled())
			return;
		
		if (Minecraft.getInstance().player == null)
			return;

		
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onMouseClickEvent(MouseClickedEvent.Post event)
	{
		if (event.isCanceled())
			return;
		
		// not in game check
		if (Minecraft.getInstance().player == null)
			return;
		
		if (event.getGui() instanceof GuiSpellbook)
		{
			handleMainScreenClickWithSpellbookOpen((GuiSpellbook)event.getGui(), event.getMouseX(), event.getMouseY(), event.getButton());
		} else {
			int memorisedSpellSlot = getMemorisedSpellSlotByMouseCoords((int)Math.round(event.getMouseX()), (int)Math.round(event.getMouseY()));
			if (event.getButton() != 0)
			{
				if (memorisedSpellSlot > 0)
					removeSpellSlot(memorisedSpellSlot);
			}
		}
		
		if (event.getButton() != 0)
		{
			GuiEffectIconButton effectSlotButton = getEffectSlotButtonByMouseCoords((int)Math.round(event.getMouseX()), (int)Math.round(event.getMouseY()));
			if (effectSlotButton != null)
				removeEffectSpellId(effectSlotButton.getSpellId());
		}
	}
	
	private void removeSpellSlot(int memorisedSpellSlot) {
		Minecraft.getInstance().player.sendChatMessage("/solinia3core:memorisespell " + memorisedSpellSlot + " " + 0);
	}

	private void removeEffectSpellId(int spellId) {
		Minecraft.getInstance().player.sendChatMessage("/solinia3core:effects remove " + spellId);
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
	
	boolean neverSent = true;

	private int getMemorisedSpellSlotByMouseCoords(int mouseX, int mouseY) {
		for (int i = 0; i < memorisedButtons.size(); i++)
		{
			if (memorisedButtons.get(i).isMouseOver(mouseX, mouseY))
				return (i+1);
			
		}
		return -1;
	}
	
	private GuiEffectIconButton getEffectSlotButtonByMouseCoords(int mouseX, int mouseY) {
		for (int i = 0; i < effectSlotButtons.size(); i++)
		{
			if (effectSlotButtons.get(i).isMouseOver(mouseX, mouseY) && effectSlotButtons.get(i) instanceof GuiEffectIconButton)
			{
				return (GuiEffectIconButton)effectSlotButtons.get(i);
			}
			
		}
		return null;
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onRenderGameOverlay(RenderGameOverlayEvent.Text event)
	{
		if (event.isCanceled())
			return;
		
		if (Minecraft.getInstance().player == null)
			return;
		
		new GuiCharacterText();
		
		for(int i = 0; i < memorisedButtons.size(); i++)
		{
			int slot = (i+1);
			if (ClientState.getInstance().getMemorisedSpells().getSlotNewIcon(slot) > 0)
			{
				memorisedButtons.get(i).setMessage(ClientState.getInstance().getMemorisedSpells().getSlotNewIcon(slot)+"^"+Integer.toString(slot)+"^"+ClientState.getInstance().getMemorisedSpells().getSlotName(slot));
			} else {
				memorisedButtons.get(i).setMessage(-1+"^"+Integer.toString(slot)+"^"+"");
			}
			
			memorisedButtons.get(i).render(memorisedSpellSize*i, 0, 1.0F);
		}
		
		int i = 0;
		if (ClientState.getInstance().getEffects().getSlots().entrySet().size() > 0)
		{
			for(Entry<Integer, EffectSlot> effectSlots : ClientState.getInstance().getEffects().getSlots().entrySet())
			{
				if (effectSlots.getValue() != null)
				{
					effectSlotButtons.get(i).setMessage(effectSlots.getValue().NewIcon+"^"+effectSlots.getValue().SpellId+"^"+effectSlots.getValue().Name);
				} else {
					effectSlotButtons.get(i).setMessage("-1^-1^");
				}
				
				effectSlotButtons.get(i).render(effectSize*i, 10, 1.0F);
				
				i++;
			}
		} else {
			for(int es = 0; es < 16; es++)
			{
				if (effectSlotButtons.get(es) == null || effectSlotButtons.get(es).getMessage().equals("-1^-1^"))
					continue;
				
				effectSlotButtons.get(es).setMessage("-1^-1^");
				effectSlotButtons.get(es).render(effectSize*es, 10, 1.0F);
			}
		}
		
		
		
		int memorisedSpellSlotPosition = getMemorisedSpellSlotByMouseCoords((int)Math.round(Minecraft.getInstance().mouseHelper.getMouseX() * (double)Minecraft.getInstance().mainWindow.getScaledWidth() / (double)Minecraft.getInstance().mainWindow.getWidth()),(int)Math.round(Minecraft.getInstance().mouseHelper.getMouseY() * (double)Minecraft.getInstance().mainWindow.getScaledHeight() / (double)Minecraft.getInstance().mainWindow.getHeight()));
		if (memorisedSpellSlotPosition > 0 && memorisedButtons.get(memorisedSpellSlotPosition-1) != null && memorisedButtons.get(memorisedSpellSlotPosition-1).getMessage() != null )
		{
			if (memorisedButtons.get(memorisedSpellSlotPosition-1).getMessage().split("\\^").length >= 3)
			{
				String[] text = {memorisedButtons.get(memorisedSpellSlotPosition-1).getMessage().split("\\^")[2]};
		        List temp = Arrays.asList(text);
		        int maxTextWidth = 120;
		        
		        GuiUtils.drawHoveringText(temp, (int)Math.round(Minecraft.getInstance().mouseHelper.getMouseX() * (double)Minecraft.getInstance().mainWindow.getScaledWidth() / (double)Minecraft.getInstance().mainWindow.getWidth()),(int)Math.round(Minecraft.getInstance().mouseHelper.getMouseY() * (double)Minecraft.getInstance().mainWindow.getScaledHeight() / (double)Minecraft.getInstance().mainWindow.getHeight()), Minecraft.getInstance().mainWindow.getScaledWidth(), Minecraft.getInstance().mainWindow.getScaledHeight(), maxTextWidth, Minecraft.getInstance().fontRenderer); // makes all that nice default tool tip box from vanilla minecraft 
			}
		}
		
		GuiEffectIconButton effectSlotButton = getEffectSlotButtonByMouseCoords((int)Math.round(Minecraft.getInstance().mouseHelper.getMouseX() * (double)Minecraft.getInstance().mainWindow.getScaledWidth() / (double)Minecraft.getInstance().mainWindow.getWidth()),(int)Math.round(Minecraft.getInstance().mouseHelper.getMouseY() * (double)Minecraft.getInstance().mainWindow.getScaledHeight() / (double)Minecraft.getInstance().mainWindow.getHeight()));
		if (effectSlotButton != null && effectSlotButton.getSpellName() != null && !effectSlotButton.getSpellName().equals(""))
		{
			
			String[] text = {effectSlotButton.getSpellName()};
	        List temp = Arrays.asList(text);
	        int maxTextWidth = 120;
	        
	        GuiUtils.drawHoveringText(temp, (int)Math.round(Minecraft.getInstance().mouseHelper.getMouseX() * (double)Minecraft.getInstance().mainWindow.getScaledWidth() / (double)Minecraft.getInstance().mainWindow.getWidth()),(int)Math.round(Minecraft.getInstance().mouseHelper.getMouseY() * (double)Minecraft.getInstance().mainWindow.getScaledHeight() / (double)Minecraft.getInstance().mainWindow.getHeight()), Minecraft.getInstance().mainWindow.getScaledWidth(), Minecraft.getInstance().mainWindow.getScaledHeight(), maxTextWidth, Minecraft.getInstance().fontRenderer); // makes all that nice default tool tip box from vanilla minecraft 
		}
	}
}
