package com.solinia.solinia3ui;

import org.apache.logging.log4j.Logger;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.InputEvent.KeyInputEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class KeyInputHandler {
	private solinia3ui plugin;

	public KeyInputHandler(solinia3ui plugin) {
		this.plugin = plugin;
	}

	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onKeyInputEvent(KeyInputEvent event) {
		if (event.isCanceled())
			return;
		
		if (event.getAction() != 1)
			return;
		
		checkKeys();
	}

	private void checkKeys() {
		if (plugin.keyBinds.targetnearestnpc.isPressed())
			targetNearestNpc();
		if (plugin.keyBinds.toggleautoattack.isPressed())
			toggleAutoAttack();
		if (plugin.keyBinds.canceltarget.isPressed())
			cancelTarget();
		if (plugin.keyBinds.targetself.isPressed())
			targetSelf();
		if (plugin.keyBinds.togglesitstand.isPressed())
			toggleSitStand();
		if (plugin.keyBinds.targetteammember1.isPressed())
			targetTeamMember(1);
		if (plugin.keyBinds.targetteammember2.isPressed())
			targetTeamMember(2);
		if (plugin.keyBinds.targetteammember3.isPressed())
			targetTeamMember(3);
		if (plugin.keyBinds.targetteammember4.isPressed())
			targetTeamMember(4);
		if (plugin.keyBinds.targetteammember5.isPressed())
			targetTeamMember(5);
		if (plugin.keyBinds.castspell1.isPressed())
			castSpell(1);
		if (plugin.keyBinds.castspell2.isPressed())
			castSpell(2);
		if (plugin.keyBinds.castspell3.isPressed())
			castSpell(3);
		if (plugin.keyBinds.castspell4.isPressed())
			castSpell(4);
		if (plugin.keyBinds.castspell5.isPressed())
			castSpell(5);
		if (plugin.keyBinds.castspell6.isPressed())
			castSpell(6);
		if (plugin.keyBinds.castspell7.isPressed())
			castSpell(7);
		if (plugin.keyBinds.castspell8.isPressed())
			castSpell(8);
		if (plugin.keyBinds.consider.isPressed())
			consider();
		if (plugin.keyBinds.targetpet.isPressed())
			targetPet();
	}

	private static void toggleSitStand() {
		Minecraft.getInstance().player.sendChatMessage("/sit");
		solinia3ui.LOGGER.info("Sitting");
	}

	private static void targetPet() {
		Minecraft.getInstance().player.sendChatMessage("/target pet");
		solinia3ui.LOGGER.info("Targetting pet");
	}

	private static void consider() {
		Minecraft.getInstance().player.sendChatMessage("/consider");
		solinia3ui.LOGGER.info("Considering");
	}

	private static void castSpell(int i) {
		Minecraft.getInstance().player.sendChatMessage("/castslot " + i);
		solinia3ui.LOGGER.info("Casting spell slot " + i);
	}

	private static void targetTeamMember(int i) {
		Minecraft.getInstance().player.sendChatMessage("/target " + i);
		solinia3ui.LOGGER.info("Targetting team member " + i);
	}

	private static void targetSelf() {
		Minecraft.getInstance().player.sendChatMessage("/target self");
		solinia3ui.LOGGER.info("Chat message sent");
	}

	private static void cancelTarget() {
		Minecraft.getInstance().player.sendChatMessage("/target clear");
		solinia3ui.LOGGER.info("Clearing target");
	}

	private static void toggleAutoAttack() {
		Minecraft.getInstance().player.sendChatMessage("/autoattack");
		solinia3ui.LOGGER.info("Auto attacking");
	}

	private static void targetNearestNpc() {
		Minecraft.getInstance().player.sendChatMessage("/target nearestnpc");
		solinia3ui.LOGGER.info("Targetting nearest npc");
	}
}
