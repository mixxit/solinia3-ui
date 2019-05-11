package com.solinia.solinia3ui;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraftforge.client.event.InputEvent.KeyInputEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("solinia3ui")
public class solinia3ui {
	// Directly reference a log4j logger.
	private static final Logger LOGGER = LogManager.getLogger();
	private KeyBinds keyBinds = new KeyBinds();

	public solinia3ui() {
		// Register the setup method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		// Register the enqueueIMC method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
		// Register the processIMC method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
		// Register the doClientStuff method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

		// Register ourselves for server and other game events we are interested in
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event) {
		// some preinit code
		LOGGER.info("HELLO FROM PREINIT");
		LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
		keyBinds.registerKeyBinds();
	}

	private void doClientStuff(final FMLClientSetupEvent event) {
		// do something that can only be done on the client
		LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
	}

	private void enqueueIMC(final InterModEnqueueEvent event) {
		// some example code to dispatch IMC to another mod
		//InterModComms.sendTo("examplemod", "helloworld", () -> {LOGGER.info("Hello world from the MDK");
		//	return "Hello world";
		//});
	}

	private void processIMC(final InterModProcessEvent event) {
		// some example code to receive and process InterModComms from other mods
		//LOGGER.info("Got IMC {}",event.getIMCStream().map(m -> m.getMessageSupplier().get()).collect(Collectors.toList()));
	}

	// You can use SubscribeEvent and let the Event Bus discover methods to call
	@SubscribeEvent
	public void onServerStarting(FMLServerStartingEvent event) {
		// do something when the server starts
		LOGGER.info("HELLO from server starting");
	}

	// You can use EventBusSubscriber to automatically subscribe events on the
	// contained class (this is subscribing to the MOD
	// Event bus for receiving Registry Events)
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {
		@SubscribeEvent
		public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
			// register a new block here
			LOGGER.info("HELLO from Register Block");
		}
	}

	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onKeyEvent(KeyInputEvent event) {
		if (event.isCanceled())
			return;
		
		if (event.getAction() != 1)
			return;
		
		checkKeys();
	}

	private void checkKeys() {
		if (keyBinds.targetnearestnpc.isPressed())
			targetNearestNpc();
		if (keyBinds.toggleautoattack.isPressed())
			toggleAutoAttack();
		if (keyBinds.canceltarget.isPressed())
			cancelTarget();
		if (keyBinds.targetself.isPressed())
			targetSelf();
		if (keyBinds.togglesitstand.isPressed())
			toggleSitStand();
		if (keyBinds.targetteammember1.isPressed())
			targetTeamMember(1);
		if (keyBinds.targetteammember2.isPressed())
			targetTeamMember(2);
		if (keyBinds.targetteammember3.isPressed())
			targetTeamMember(3);
		if (keyBinds.targetteammember4.isPressed())
			targetTeamMember(4);
		if (keyBinds.targetteammember5.isPressed())
			targetTeamMember(5);
		if (keyBinds.castspell1.isPressed())
			castSpell(1);
		if (keyBinds.castspell2.isPressed())
			castSpell(2);
		if (keyBinds.castspell3.isPressed())
			castSpell(3);
		if (keyBinds.castspell4.isPressed())
			castSpell(4);
		if (keyBinds.castspell5.isPressed())
			castSpell(5);
		if (keyBinds.castspell6.isPressed())
			castSpell(6);
		if (keyBinds.castspell7.isPressed())
			castSpell(7);
		if (keyBinds.castspell8.isPressed())
			castSpell(8);
		if (keyBinds.consider.isPressed())
			consider();
		if (keyBinds.targetpet.isPressed())
			targetPet();
	}

	private static void toggleSitStand() {
		Minecraft.getInstance().player.sendChatMessage("/sit");
		LOGGER.info("Sitting");
	}

	private static void targetPet() {
		Minecraft.getInstance().player.sendChatMessage("/target pet");
		LOGGER.info("Targetting pet");
	}

	private static void consider() {
		Minecraft.getInstance().player.sendChatMessage("/consider");
		LOGGER.info("Considering");
	}

	private static void castSpell(int i) {
		Minecraft.getInstance().player.sendChatMessage("/castslot " + i);
		LOGGER.info("Casting spell slot " + i);
	}

	private static void targetTeamMember(int i) {
		Minecraft.getInstance().player.sendChatMessage("/target " + i);
		LOGGER.info("Targetting team member " + i);
	}

	private static void targetSelf() {
		Minecraft.getInstance().player.sendChatMessage("/target self");
		LOGGER.info("Chat message sent");
	}

	private static void cancelTarget() {
		Minecraft.getInstance().player.sendChatMessage("/target clear");
		LOGGER.info("Clearing target");
	}

	private static void toggleAutoAttack() {
		LOGGER.info("Auto attacking");
	}

	private static void targetNearestNpc() {
		LOGGER.info("Targetting nearest npc");
	}
}
