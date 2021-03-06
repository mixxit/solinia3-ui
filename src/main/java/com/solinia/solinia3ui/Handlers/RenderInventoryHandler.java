package com.solinia.solinia3ui.Handlers;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

import com.solinia.solinia3ui.solinia3ui;
import com.solinia.solinia3ui.Guis.GuiAddItemToReagentsButtonPressable;
import com.solinia.solinia3ui.Guis.GuiAddItemToSpellbookButtonPressable;
import com.solinia.solinia3ui.Guis.GuiCraftButton;
import com.solinia.solinia3ui.Guis.GuiInventorySlotButton;
import com.solinia.solinia3ui.Guis.GuiInventorySlotButtonPressable;
import com.solinia.solinia3ui.Guis.GuiInventorySlotUnequipButtonPressable;
import com.solinia.solinia3ui.Guis.GuiOpenCraftBButtonPressable;
import com.solinia.solinia3ui.Guis.GuiReagentButton;
import com.solinia.solinia3ui.Guis.GuiSpellbookButton;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.InventoryScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.GuiContainerEvent;
import net.minecraftforge.client.event.GuiScreenEvent.InitGuiEvent;
import net.minecraftforge.client.event.GuiScreenEvent.InitGuiEvent.Post;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class RenderInventoryHandler {
	protected static final ResourceLocation WINDOWPIECES = new ResourceLocation( solinia3ui.MOD_ID, "textures/gui/window_pieces01");

	public ConcurrentHashMap<Integer, GuiInventorySlotButton> inventoryButtons = new ConcurrentHashMap<Integer,GuiInventorySlotButton>();
	int width = 19;
	Minecraft minecraft;

	public RenderInventoryHandler(Minecraft minecraft)
	{
		this.minecraft = minecraft;
		UpdateInventoryButtons();
	}
	
	public void UpdateInventoryButtons()
	{
		inventoryButtons.clear();
		// Inventory slots
		// fingers
		inventoryButtons.put(0,new GuiInventorySlotButton(minecraft,minecraft.getMainWindow().getScaledWidth()-width*3,20,width,width,"0",new GuiInventorySlotButtonPressable(0)));
		//shoulders
		inventoryButtons.put(1,new GuiInventorySlotButton(minecraft,minecraft.getMainWindow().getScaledWidth()-width*3,45,width,width,"1",new GuiInventorySlotButtonPressable(1)));
		//neckl
		inventoryButtons.put(2,new GuiInventorySlotButton(minecraft,minecraft.getMainWindow().getScaledWidth()-width*3,70,width,width,"2",new GuiInventorySlotButtonPressable(2)));
		//ears
		inventoryButtons.put(3,new GuiInventorySlotButton(minecraft,minecraft.getMainWindow().getScaledWidth()-width*3,95,width,width,"3",new GuiInventorySlotButtonPressable(3)));
		//forearms
		inventoryButtons.put(4,new GuiInventorySlotButton(minecraft,minecraft.getMainWindow().getScaledWidth()-width*3,120,width,width,"4",new GuiInventorySlotButtonPressable(4)));
		//arms
		inventoryButtons.put(5,new GuiInventorySlotButton(minecraft,minecraft.getMainWindow().getScaledWidth()-width*3,145,width,width,"5",new GuiInventorySlotButtonPressable(5)));
		//hands
		inventoryButtons.put(6,new GuiInventorySlotButton(minecraft,minecraft.getMainWindow().getScaledWidth()-width*3,170,width,width,"6",new GuiInventorySlotButtonPressable(6)));
		//waist
		inventoryButtons.put(7,new GuiInventorySlotButton(minecraft,minecraft.getMainWindow().getScaledWidth()-width*3,195,width,width,"7",new GuiInventorySlotButtonPressable(7)));
		//head
		inventoryButtons.put(8,new GuiInventorySlotButton(minecraft,minecraft.getMainWindow().getScaledWidth()-width*4,20,width,width,"8",new GuiInventorySlotButtonPressable(8)));
		//chest
		inventoryButtons.put(9,new GuiInventorySlotButton(minecraft,minecraft.getMainWindow().getScaledWidth()-width*4,45,width,width,"9",new GuiInventorySlotButtonPressable(9)));
		//legs
		inventoryButtons.put(10,new GuiInventorySlotButton(minecraft,minecraft.getMainWindow().getScaledWidth()-width*4,70,width,width,"10",new GuiInventorySlotButtonPressable(10)));
		//feet
		inventoryButtons.put(11,new GuiInventorySlotButton(minecraft,minecraft.getMainWindow().getScaledWidth()-width*4,95,width,width,"11",new GuiInventorySlotButtonPressable(11)));
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onRenderGameOverlay(RenderGameOverlayEvent.Text event)
	{
		if (event.isCanceled())
			return;
		
		// not in game check
		if (minecraft.player == null)
			return;
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onRenderGameOverlayPost(RenderGameOverlayEvent.Post event)
	{
		if (event.isCanceled())
			return;

		if (!(minecraft.currentScreen instanceof InventoryScreen))
			return;

		if (event.getType().equals(ElementType.ALL))
			return;
		
		// not in game check
		if (minecraft.player == null)
			return;
		
	}
	
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onRenderContainerScreen(GuiContainerEvent.DrawForeground event) {
		if (!(event.getGuiContainer() instanceof InventoryScreen))
			return;

		// check is widget hover here
		for(GuiInventorySlotButton widget : this.inventoryButtons.values())
		{
			if (widget.IsMouseOverButton())
				widget.tryRenderItemStackHover(event.getGuiContainer(), widget.getItemStack());
		}
	}
	
	
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onRenderGui(InitGuiEvent.Post event) {
		if (!(event.getGui() instanceof InventoryScreen))
			return;

		UpdateInventoryButtons();
		addSlots(event);
		addSlotCloseButtons(event);
	}
	
	private Collection<GuiInventorySlotButton> getInventorySlotButton()
	{
		return inventoryButtons.values();
	}

	private void addSlotCloseButtons(Post event) {

		// Inventory slots
		// fingers
		event.addWidget(new Button(minecraft.getMainWindow().getScaledWidth()-width*3+20,20,5,5,"x",new GuiInventorySlotUnequipButtonPressable(0)));
		//shoulders
		event.addWidget(new Button(minecraft.getMainWindow().getScaledWidth()-width*3+20,45,5,5,"x",new GuiInventorySlotUnequipButtonPressable(1)));
		//neckl
		event.addWidget(new Button(minecraft.getMainWindow().getScaledWidth()-width*3+20,70,5,5,"x",new GuiInventorySlotUnequipButtonPressable(2)));
		//ears
		event.addWidget(new Button(minecraft.getMainWindow().getScaledWidth()-width*3+20,95,5,5,"x",new GuiInventorySlotUnequipButtonPressable(3)));
		//forearms
		event.addWidget(new Button(minecraft.getMainWindow().getScaledWidth()-width*3+20,120,5,5,"x",new GuiInventorySlotUnequipButtonPressable(4)));
		//arms
		event.addWidget(new Button(minecraft.getMainWindow().getScaledWidth()-width*3+20,145,5,5,"x",new GuiInventorySlotUnequipButtonPressable(5)));
		//hands
		event.addWidget(new Button(minecraft.getMainWindow().getScaledWidth()-width*3+20,170,5,5,"x",new GuiInventorySlotUnequipButtonPressable(6)));
		//waist
		event.addWidget(new Button(minecraft.getMainWindow().getScaledWidth()-width*3+20,195,5,5,"x",new GuiInventorySlotUnequipButtonPressable(7)));
		//head
		event.addWidget(new Button(minecraft.getMainWindow().getScaledWidth()-width*3+20,195,5,5,"x",new GuiInventorySlotUnequipButtonPressable(8)));
		//chest
		event.addWidget(new Button(minecraft.getMainWindow().getScaledWidth()-width*3+20,195,5,5,"x",new GuiInventorySlotUnequipButtonPressable(9)));
		//legs
		event.addWidget(new Button(minecraft.getMainWindow().getScaledWidth()-width*3+20,195,5,5,"x",new GuiInventorySlotUnequipButtonPressable(10)));
		//feet
		event.addWidget(new Button(minecraft.getMainWindow().getScaledWidth()-width*3+20,195,5,5,"x",new GuiInventorySlotUnequipButtonPressable(11)));
	}

	private void addSlots(Post event) {
		event.addWidget(new GuiReagentButton(minecraft.getMainWindow().getScaledWidth()-width-2,20,width+1,width+1,"R",new GuiAddItemToReagentsButtonPressable()));
		event.addWidget(new GuiSpellbookButton(minecraft.getMainWindow().getScaledWidth()-width-2,40,width+1,width+1,"S",new GuiAddItemToSpellbookButtonPressable()));
		event.addWidget(new GuiCraftButton(minecraft.getMainWindow().getScaledWidth()-width-2,60,width+1,width+1,"C",new GuiOpenCraftBButtonPressable()));
		
		for(GuiInventorySlotButton button : getInventorySlotButton())
		{
			event.addWidget(button);
		}
	}
}
