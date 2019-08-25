package com.solinia.solinia3ui;

import net.minecraftforge.client.event.InputEvent.KeyInputEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class KeyInputHandler {
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onKeyInputEvent(KeyInputEvent event) {
		if (event.isCanceled())
			return;
		
		//System.out.println("DEBUGKEY: " + event.getScanCode() + " " + event.getAction() + " " + event.getKey() + " " + event.getModifiers());
		
		if (event.getAction() != 1)
			return;
		
		ClientState.getInstance().attemptUseModKeybinds();
	}
}
