package com.solinia.solinia3ui;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.InputEvent.KeyInputEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class KeyInputHandler {

	public KeyBinds keyBinds = new KeyBinds();
	private solinia3ui _parent;
	public KeyInputHandler(solinia3ui parent)
	{
		_parent = parent;
	}

	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onKeyInputEvent(KeyInputEvent event) {
		if (event.isCanceled())
			return;
		
		System.out.println("DEBUGKEY: " + event.getScanCode() + " " + event.getAction() + " " + event.getKey() + " " + event.getModifiers());
		
		if (event.getAction() != 1)
			return;
		
		checkKeys();
	}

	private void checkKeys() {
		if (keyBinds.targetnearestnpc != null && keyBinds.targetnearestnpc.isPressed())
			targetNearestNpc();
		if (keyBinds.toggleautoattack != null && keyBinds.toggleautoattack.isPressed())
			toggleAutoAttack();
		if (keyBinds.canceltarget != null && keyBinds.canceltarget.isPressed())
			cancelTarget();
		if (keyBinds.targetself != null && keyBinds.targetself.isPressed())
			targetSelf();
		if (keyBinds.togglesitstand != null && keyBinds.togglesitstand.isPressed())
			toggleSitStand();
		if (keyBinds.targetteammember1 != null && keyBinds.targetteammember1.isPressed())
			targetTeamMember(1);
		if (keyBinds.targetteammember2 != null && keyBinds.targetteammember2.isPressed())
			targetTeamMember(2);
		if (keyBinds.targetteammember3 != null && keyBinds.targetteammember3.isPressed())
			targetTeamMember(3);
		if (keyBinds.targetteammember4 != null && keyBinds.targetteammember4.isPressed())
			targetTeamMember(4);
		if (keyBinds.targetteammember5 != null && keyBinds.targetteammember5.isPressed())
			targetTeamMember(5);
		if (keyBinds.castspell1 != null && keyBinds.castspell1.isPressed())
			castSpell(1);
		if (keyBinds.castspell2 != null && keyBinds.castspell2.isPressed())
			castSpell(2);
		if (keyBinds.castspell3 != null && keyBinds.castspell3.isPressed())
			castSpell(3);
		if (keyBinds.castspell4 != null && keyBinds.castspell4.isPressed())
			castSpell(4);
		if (keyBinds.castspell5 != null && keyBinds.castspell5.isPressed())
			castSpell(5);
		if (keyBinds.castspell6 != null && keyBinds.castspell6.isPressed())
			castSpell(6);
		if (keyBinds.castspell7 != null && keyBinds.castspell7.isPressed())
			castSpell(7);
		if (keyBinds.castspell8 != null && keyBinds.castspell8.isPressed())
			castSpell(8);
		if (keyBinds.consider != null && keyBinds.consider.isPressed())
			consider();
		if (keyBinds.targetpet != null && keyBinds.targetpet.isPressed())
			targetPet();
		if (keyBinds.openspellbook != null && keyBinds.openspellbook.isPressed())
			openSpellbook();
	}

	private void openSpellbook() {
		Minecraft.getInstance().player.sendChatMessage("/openspellbook");
		solinia3ui.LOGGER.info("Opening Spell Book");
	}
	
	private void toggleSitStand() {
		Minecraft.getInstance().player.sendChatMessage("/sit");
		solinia3ui.LOGGER.info("Sitting");
	}

	private void targetPet() {
		Minecraft.getInstance().player.sendChatMessage("/target pet");
		solinia3ui.LOGGER.info("Targetting pet");
	}

	private void consider() {
		Minecraft.getInstance().player.sendChatMessage("/consider");
		solinia3ui.LOGGER.info("Considering");
	}

	private void castSpell(int i) {
		Minecraft.getInstance().player.sendChatMessage("/castslot " + i);
		solinia3ui.LOGGER.info("Casting spell slot " + i);
	}

	private void targetTeamMember(int i) {
		Minecraft.getInstance().player.sendChatMessage("/target " + i);
		solinia3ui.LOGGER.info("Targetting team member " + i);
	}

	private void targetSelf() {
		Minecraft.getInstance().player.sendChatMessage("/target self");
		solinia3ui.LOGGER.info("Chat message sent");
	}

	private void cancelTarget() {
		Minecraft.getInstance().player.sendChatMessage("/target clear");
		solinia3ui.LOGGER.info("Clearing target");
	}

	private void toggleAutoAttack() {
		Minecraft.getInstance().player.sendChatMessage("/autoattack");
		solinia3ui.LOGGER.info("Auto attacking");
	}

	private void targetNearestNpc() {
		Minecraft.getInstance().player.sendChatMessage("/target nearestnpc");
		solinia3ui.LOGGER.info("Targetting nearest npc");
	}
}
