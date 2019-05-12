package com.solinia.solinia3ui;

import org.apache.logging.log4j.Logger;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class RenderGuiHandler {
	private solinia3ui plugin;

	public RenderGuiHandler(solinia3ui plugin) {
		this.plugin = plugin;
	}

	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onRenderGameOverlayEvent(RenderGameOverlayEvent.Post event) {
		if (event.isCanceled())
			return;
		
		new GuiSpellSlots(Minecraft.getInstance());
	}

}
