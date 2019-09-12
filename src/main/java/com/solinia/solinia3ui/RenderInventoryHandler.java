package com.solinia.solinia3ui;

import java.util.concurrent.ConcurrentHashMap;

import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.InventoryScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.GuiScreenEvent.InitGuiEvent;
import net.minecraftforge.client.event.GuiScreenEvent.MouseClickedEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class RenderInventoryHandler {

	public ConcurrentHashMap<Integer,Button> inventoryButtons = new ConcurrentHashMap<Integer,Button>();
	int width = 19;

	public RenderInventoryHandler()
	{
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onRenderGameOverlay(RenderGameOverlayEvent.Text event)
	{
		if (event.isCanceled())
			return;
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onRenderGui(InitGuiEvent.Post event) {
		if (!(event.getGui() instanceof InventoryScreen))
			return;

		event.addWidget(new Button(Minecraft.getInstance().mainWindow.getScaledWidth()-width,20,width,width,"Spell",new GuiAddItemToSpellbookButtonPressable()));
		event.addWidget(new Button(Minecraft.getInstance().mainWindow.getScaledWidth()-width,40,width,width,"Reagent",new GuiAddItemToReagentsButtonPressable()));
		// Inventory slots
		// fingers
		event.addWidget(new GuiInventorySlotButton(Minecraft.getInstance().mainWindow.getScaledWidth()-width*3,20,width,width,"0",new GuiInventorySlotButtonPressable(0)));
		//shoulders
		event.addWidget(new GuiInventorySlotButton(Minecraft.getInstance().mainWindow.getScaledWidth()-width*3,45,width,width,"1",new GuiInventorySlotButtonPressable(1)));
		//neckl
		event.addWidget(new GuiInventorySlotButton(Minecraft.getInstance().mainWindow.getScaledWidth()-width*3,70,width,width,"2",new GuiInventorySlotButtonPressable(2)));
		//ears
		event.addWidget(new GuiInventorySlotButton(Minecraft.getInstance().mainWindow.getScaledWidth()-width*3,95,width,width,"3",new GuiInventorySlotButtonPressable(3)));
		//forearms
		event.addWidget(new GuiInventorySlotButton(Minecraft.getInstance().mainWindow.getScaledWidth()-width*3,120,width,width,"4",new GuiInventorySlotButtonPressable(4)));
		//arms
		event.addWidget(new GuiInventorySlotButton(Minecraft.getInstance().mainWindow.getScaledWidth()-width*3,145,width,width,"5",new GuiInventorySlotButtonPressable(5)));
		//hands
		event.addWidget(new GuiInventorySlotButton(Minecraft.getInstance().mainWindow.getScaledWidth()-width*3,170,width,width,"6",new GuiInventorySlotButtonPressable(6)));
		//waist
		event.addWidget(new GuiInventorySlotButton(Minecraft.getInstance().mainWindow.getScaledWidth()-width*3,195,width,width,"7",new GuiInventorySlotButtonPressable(7)));

	}
}
