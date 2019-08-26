package com.solinia.solinia3ui;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.NetworkEvent.ServerCustomPayloadEvent;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.netty.buffer.ByteBuf;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("solinia3ui")
public class solinia3ui {
	// Directly reference a log4j logger.
	public static final Logger LOGGER = LogManager.getLogger();
	
	private RenderGuiHandler renderGuiHandler = new RenderGuiHandler();
	private KeyInputHandler keyInputHandler = new KeyInputHandler();
	private RenderLivingHandler renderLivingHandler = new RenderLivingHandler();
	
	private static final String PROTOCOL_VERSION = Integer.toString(1);
	public static SimpleChannel channelToClient = NetworkRegistry.ChannelBuilder
			.named(new ResourceLocation("solinia3core", "toclient"))
			.clientAcceptedVersions(PROTOCOL_VERSION::equals)
            .serverAcceptedVersions(PROTOCOL_VERSION::equals)
            .networkProtocolVersion(() -> PROTOCOL_VERSION)
.simpleChannel();
	
	public solinia3ui() {
		// Register the setup method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		// Register the enqueueIMC method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
		// Register the processIMC method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
		// Register the doClientStuff method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
		// load complete
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::loadComplete);

		// Register ourselves for server and other game events we are interested in
		MinecraftForge.EVENT_BUS.register(renderGuiHandler);
		MinecraftForge.EVENT_BUS.register(keyInputHandler);
		MinecraftForge.EVENT_BUS.register(renderLivingHandler);
	}
	
	public void onPacketData(final ServerCustomPayloadEvent event) {
	    final ByteBuf payload = event.getPayload();
	    byte[] bytes;
	    int length = payload.readableBytes();

	    if (payload.hasArray()) {
	        bytes = payload.array();
	    } else {
	        bytes = new byte[length];
	        payload.getBytes(payload.readerIndex(), bytes);
	    }

	    LOGGER.info("PacketHandler onPacketData " + bytes.toString());
	}
	
	private void loadComplete(final FMLLoadCompleteEvent event)
	{
		LOGGER.info("HELLO FROM LOADCOMPLETEEVENT");
		changeKeyBindings();
	}
	
	private void changeKeyBindings() {
		// replace all hotkey keybinds
		for(int i = 0; i < Minecraft.getInstance().gameSettings.keyBindsHotbar.length; i++)
			Minecraft.getInstance().gameSettings.keyBindsHotbar[i] = new Solinia3UIKeyBinding(Minecraft.getInstance().gameSettings.keyBindsHotbar[i]);
	}

	private void setup(final FMLCommonSetupEvent event) {
		// some preinit code
		LOGGER.info("HELLO FROM PREINIT");
		LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
		ClientState.getInstance().getKeyBinds().registerKeyBinds();
        channelToClient.registerMessage(Solinia3UIPacketDiscriminators.VITALS, PacketMobVitals.class, PacketMobVitals::encode, PacketMobVitals::new, PacketMobVitals::handle);
        channelToClient.registerMessage(Solinia3UIPacketDiscriminators.CASTINGPERCENT, PacketCastingPercent.class, PacketCastingPercent::encode, PacketCastingPercent::new, PacketCastingPercent::handle);
        channelToClient.registerMessage(Solinia3UIPacketDiscriminators.SPELLBOOKPAGE, PacketOpenSpellbook.class, PacketOpenSpellbook::encode, PacketOpenSpellbook::new, PacketOpenSpellbook::handle);
        channelToClient.registerMessage(Solinia3UIPacketDiscriminators.MEMORISEDSPELLS, PacketMemorisedSpells.class, PacketMemorisedSpells::encode, PacketMemorisedSpells::new, PacketMemorisedSpells::handle);
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

	
	public static void openSpellBook(final SpellbookPage SpellbookPage) {
		if (SpellbookPage == null)
			return;
		
		StringTextComponent textComponent = new StringTextComponent("Test");
		Runnable rn = () -> Minecraft.getInstance().displayGuiScreen(new GuiSpellbook(textComponent, SpellbookPage));
		Minecraft.getInstance().runImmediately(rn);
	}

}
