package com.solinia.solinia3ui.Handlers;

import com.solinia.solinia3ui.ClientState;

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
		
		if (ClientState.getInstance().getEntityVital(-1) != null && ClientState.getInstance().getEntityVital(-1).getEntityId() > 0 && event.getEntity().getEntityId() == ClientState.getInstance().getEntityVital(-1).getEntityId())
		{
			if (!event.getEntity().isGlowing())
			event.getEntity().setGlowing(true);
		} else {
			if (event.getEntity().isGlowing())
			event.getEntity().setGlowing(false);
		}
	}

}
