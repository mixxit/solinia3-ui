package com.solinia.solinia3ui;

import java.util.concurrent.ConcurrentHashMap;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.InventoryScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class RenderInventoryHandler {

	public ConcurrentHashMap<Integer,Button> inventoryButtons = new ConcurrentHashMap<Integer,Button>();
	int width = 20;

	public RenderInventoryHandler()
	{
		inventoryButtons.put(0,new Button(Minecraft.getInstance().mainWindow.getScaledWidth()-width,20,width,width,"Spell",null));
		inventoryButtons.put(1,new Button(Minecraft.getInstance().mainWindow.getScaledWidth()-width,40,width,width,"Reagent",null));
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onRenderGui(GuiScreenEvent.DrawScreenEvent.Post event) {
		if (!(event.getGui() instanceof InventoryScreen))
			return;
		
		
		
		for(int i = 0; i < inventoryButtons.size(); i++)
		{
			inventoryButtons.get(i).render(Minecraft.getInstance().mainWindow.getScaledWidth()-width,inventoryButtons.size()*i,1);
		}
	}
}
