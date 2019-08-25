package com.solinia.solinia3ui;

import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class RenderLivingHandler {
	@SubscribeEvent
	public void onRenderLiving(RenderLivingEvent.Post event)
	{
		if (ClientState.getInstance().getTargetUUID() != null && event.getEntity().getUniqueID().equals(ClientState.getInstance().getTargetUUID()))
		{
			if (!event.getEntity().isGlowing())
			event.getEntity().setGlowing(true);
		} else {
			if (event.getEntity().isGlowing())
			event.getEntity().setGlowing(false);
		}
	}

}
