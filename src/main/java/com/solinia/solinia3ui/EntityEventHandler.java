package com.solinia.solinia3ui;

import net.minecraft.client.Minecraft;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EntityEventHandler {
	@SubscribeEvent(priority = EventPriority.LOWEST, receiveCanceled = true)
	public void onGui(EntityJoinWorldEvent event)
	{
		if (event.isCanceled())
			return;
		
		if (event.getEntity() == null)
			return;
		
		if (Minecraft.getInstance().player == null)
			return;
		
		if (!event.getEntity().getUniqueID().toString().equals(Minecraft.getInstance().player.getUniqueID().toString()))
			return;
		
		System.out.println("Ive joined the world");
		SendPluginVersion();
	}

	private void SendPluginVersion() {
		try {
			System.out.println("/iamversion " + ClientState.getInstance().getModVersion());
			Minecraft.getInstance().player.sendChatMessage("/iamversion " + ClientState.getInstance().getModVersion());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
