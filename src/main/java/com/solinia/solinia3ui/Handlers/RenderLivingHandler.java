package com.solinia.solinia3ui.Handlers;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class RenderLivingHandler {
	@SubscribeEvent
	public void onRenderLiving(RenderLivingEvent.Post event)
	{
		if (event.isCanceled())
			return;
		
		// not in game check
		if (Minecraft.getInstance().player == null)
			return;
	}

}
