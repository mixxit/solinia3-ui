package com.solinia.solinia3ui;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.gameevent.TickEvent.RenderTickEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("solinia3ui")
public class solinia3ui {
	// Directly reference a log4j logger.
	private static final Logger LOGGER = LogManager.getLogger();

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
		registerKeyBinds();
	}

	private void registerKeyBinds() {
		// TODO Auto-generated method stub
		KeyBinds.register();
	}

	private void doClientStuff(final FMLClientSetupEvent event) {
		// do something that can only be done on the client
		LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
	}

	private void enqueueIMC(final InterModEnqueueEvent event) {
		// some example code to dispatch IMC to another mod
		InterModComms.sendTo("examplemod", "helloworld", () -> {
			LOGGER.info("Hello world from the MDK");
			return "Hello world";
		});
	}

	private void processIMC(final InterModProcessEvent event) {
		// some example code to receive and process InterModComms from other mods
		LOGGER.info("Got IMC {}",
				event.getIMCStream().map(m -> m.getMessageSupplier().get()).collect(Collectors.toList()));
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
	public static void onKeyEvent(RenderTickEvent event) {
		checkKeys();
	}

	private static void checkKeys() {
		if (KeyBinds.targetnearestnpc.isPressed())
			targetNearestNpc();
		if (KeyBinds.toggleautoattack.isPressed())
			toggleAutoAttack();
		if (KeyBinds.canceltarget.isPressed())
			cancelTarget();
		if (KeyBinds.targetself.isPressed())
			targetSelf();
		if (KeyBinds.togglesitstand.isPressed())
			toggleSitStand();
		if (KeyBinds.targetteammember1.isPressed())
			targetTeamMember(1);
		if (KeyBinds.targetteammember2.isPressed())
			targetTeamMember(2);
		if (KeyBinds.targetteammember3.isPressed())
			targetTeamMember(3);
		if (KeyBinds.targetteammember4.isPressed())
			targetTeamMember(4);
		if (KeyBinds.targetteammember5.isPressed())
			targetTeamMember(5);
		if (KeyBinds.castspell1.isPressed())
			castSpell(1);
		if (KeyBinds.castspell2.isPressed())
			castSpell(2);
		if (KeyBinds.castspell3.isPressed())
			castSpell(3);
		if (KeyBinds.castspell4.isPressed())
			castSpell(4);
		if (KeyBinds.castspell5.isPressed())
			castSpell(5);
		if (KeyBinds.castspell6.isPressed())
			castSpell(6);
		if (KeyBinds.castspell7.isPressed())
			castSpell(7);
		if (KeyBinds.castspell8.isPressed())
			castSpell(8);
		if (KeyBinds.castspell9.isPressed())
			castSpell(9);
		if (KeyBinds.castspell0.isPressed())
			castSpell(0);
		if (KeyBinds.consider.isPressed())
			consider();
		if (KeyBinds.targetpet.isPressed())
			targetPet();
	}

	private static void toggleSitStand() {
		Minecraft.getInstance().player.sendChatMessage("/sit");
	}

	private static void targetPet() {
		Minecraft.getInstance().player.sendChatMessage("/target pet");
	}

	private static void consider() {
		Minecraft.getInstance().player.sendChatMessage("/consider");
	}

	private static void castSpell(int i) {
		Minecraft.getInstance().player.sendChatMessage("/castslot " + i);
	}

	private static void targetTeamMember(int i) {
		Minecraft.getInstance().player.sendChatMessage("/target " + i);
		
	}

	private static void targetSelf() {
		Minecraft.getInstance().player.sendChatMessage("/target self");
	}

	private static void cancelTarget() {
		Minecraft.getInstance().player.sendChatMessage("/target clear");
	}

	private static void toggleAutoAttack() {
		Minecraft.getInstance().player.sendChatMessage("/autoattack");
	}

	private static void targetNearestNpc() {
		Minecraft.getInstance().player.sendChatMessage("/target nearestnpc");
	}
}
