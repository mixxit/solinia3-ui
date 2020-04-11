package com.solinia.solinia3ui.Handlers;

import com.solinia.solinia3ui.ClientState;
import com.solinia.solinia3ui.solinia3ui;

import net.minecraft.client.Minecraft;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteract;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EntityEventHandler {
	Minecraft minecraft;
	public EntityEventHandler(Minecraft minecraft)
	{
		this.minecraft = minecraft;
	}
	@SubscribeEvent(priority = EventPriority.LOWEST, receiveCanceled = true)
	public void onGui(EntityJoinWorldEvent event)
	{
		if (event.isCanceled())
			return;
		
		if (event.getEntity() == null)
			return;
		
		if (this.minecraft.player == null)
			return;
		
		if (event.getEntity().getEntityId() != this.minecraft.player.getEntityId())
			return;
		
		ClientState.getInstance().Reset();
		
		solinia3ui.LOGGER.info("Ive joined the world");
		SendPluginVersion();
	}
	
	@SubscribeEvent(priority = EventPriority.LOWEST, receiveCanceled = true)
	public void onEntityInteractEvent(EntityInteract  event)
	{
		if (event.isCanceled())
			return;
		
		// not in game check
		if (this.minecraft.player == null)
			return;

	}

	private void SendPluginVersion() {
		try {
			solinia3ui.LOGGER.info("/iamversion " + ClientState.getInstance().getModVersion());
			this.minecraft.player.sendChatMessage("/solinia3core:iamversion " + ClientState.getInstance().getModVersion());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
