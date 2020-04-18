package com.solinia.solinia3ui;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundList;
import net.minecraft.client.audio.SoundListSerializer;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.solinia.solinia3ui.Guis.GuiCharacterCreation;
import com.solinia.solinia3ui.Guis.GuiSpellbook;
import com.solinia.solinia3ui.Guis.GuiTrackingWindow;
import com.solinia.solinia3ui.Handlers.EntityEventHandler;
import com.solinia.solinia3ui.Handlers.KeyInputHandler;
import com.solinia.solinia3ui.Handlers.PlayerEventHandler;
import com.solinia.solinia3ui.Handlers.RenderGuiHandler;
import com.solinia.solinia3ui.Handlers.RenderInventoryHandler;
import com.solinia.solinia3ui.Handlers.RenderLivingHandler;
import com.solinia.solinia3ui.Models.CharacterCreation;
import com.solinia.solinia3ui.Models.ClientProxy;
import com.solinia.solinia3ui.Models.Solinia3UIKeyBinding;
import com.solinia.solinia3ui.Models.SpellbookPage;
import com.solinia.solinia3ui.Models.TrackingChoice;
import com.solinia.solinia3ui.races.CanariWyvernEntity;
import com.solinia.solinia3ui.races.LizardmanEntity;
import com.solinia.solinia3ui.races.OWDrakeEntity;

import io.netty.buffer.ByteBuf;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("solinia3ui")
public class solinia3ui {
	// Directly reference a log4j logger.
	public static final Logger LOGGER = LogManager.getLogger();
	public static final List<SoundEvent> soundEvents = new ArrayList<SoundEvent>();
	public static CommonProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);
	public static String MOD_ID = "solinia3ui";
	
	private RenderGuiHandler renderGuiHandler = new RenderGuiHandler(Minecraft.getInstance());
	private RenderInventoryHandler renderInventoryHandler = new RenderInventoryHandler(Minecraft.getInstance());
	private KeyInputHandler keyInputHandler = new KeyInputHandler();
	private RenderLivingHandler renderLivingHandler = new RenderLivingHandler();
	private EntityEventHandler entityEventHandler = new EntityEventHandler(Minecraft.getInstance());
	private PlayerEventHandler playerEventHandler = new PlayerEventHandler();
	
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
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		
		// Register ourselves for server and other game events we are interested in
		MinecraftForge.EVENT_BUS.register(renderGuiHandler);
		MinecraftForge.EVENT_BUS.register(renderInventoryHandler);
		MinecraftForge.EVENT_BUS.register(keyInputHandler);
		MinecraftForge.EVENT_BUS.register(renderLivingHandler);
		MinecraftForge.EVENT_BUS.register(entityEventHandler);
		MinecraftForge.EVENT_BUS.register(playerEventHandler);
		
		createSoundEvents();
	}
	
	private void createSoundEvents() {
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"char_creation"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"deathfist_citadel"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"enchanted_lands"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"everfrost"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"feerott"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"permafrost"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"qeynos"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"qeynos_catacombs"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"runnyeye"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"temple_of_cazicthule"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"thundering_steppes"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"tower_of_the_drafling"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"wailing_caves"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"commonlands"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"majdul"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"you_walk_this_earth_alone"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"in_the_amazonas"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"south_ro"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"descent"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"eqn1"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"eqn2"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"eqn3"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"eqn4"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"eqn5"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"eqn6"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"eqn7"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"eqn8"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"lisg_tavern"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"mermaidstolostboys"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"sacred_order"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"sb_beyondgoodandevil"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"sb_eidolon"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"sb_freedom"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"sb_jade"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"sb_littlebigadventure"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"sb_patagonia"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"sb_theblackwaltz"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"sb_thegatesofsigil"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"sb_theillusionist"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"sb_theoryofmachines"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"sb_thereisaplace"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"bs_instinct"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"per_augury"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"per_desert"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"per_wuxia"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"sb_encounter"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"sb_fury"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"sb_marchofmidnight"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"sb_soar"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"sb_thingsthatkeepushere"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"tl_peacefulsanctuary"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"wb_lightindarkplaces"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"wb_spacesbetween"));
		solinia3ui.soundEvents.add(createSoundEvent(solinia3ui.MOD_ID,"wb_thefall"));
	}
	
	private SoundEvent createSoundEvent(String mod, String name)
	{
		ResourceLocation location = new ResourceLocation(mod, name);
		return new SoundEvent(location);
	}

	private static final ParameterizedType TYPE = new ParameterizedType()
    {
        public Type[] getActualTypeArguments()
        {
            return new Type[] {String.class, SoundList.class};
        }
        public Type getRawType()
        {
            return Map.class;
        }
        public Type getOwnerType()
        {
            return null;
        }
    };
    
    public RenderInventoryHandler getRenderInventoryHandler()
    {
    	return this.renderInventoryHandler;
    }
	
	protected static Map<String, SoundList> getSoundMap(InputStream stream)
    {
        Map map;
        final Gson GSON = (new GsonBuilder()).registerTypeAdapter(SoundList.class, new SoundListSerializer()).create();
        
        try
        {
            map = (Map)GSON.fromJson((Reader)(new InputStreamReader(stream)), TYPE);
        }
        finally
        {
            IOUtils.closeQuietly(stream);
        }

        return map;
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
		
		proxy.preInit();
        channelToClient.registerMessage(Solinia3UIPacketDiscriminators.VITALS, PacketMobVitals.class, PacketMobVitals::encode, PacketMobVitals::new, PacketMobVitals::handle);
		channelToClient.registerMessage(Solinia3UIPacketDiscriminators.SPELLBOOKPAGE, PacketOpenSpellbook.class, PacketOpenSpellbook::encode, PacketOpenSpellbook::new, PacketOpenSpellbook::handle);
        channelToClient.registerMessage(Solinia3UIPacketDiscriminators.CASTINGPERCENT, PacketCastingPercent.class, PacketCastingPercent::encode, PacketCastingPercent::new, PacketCastingPercent::handle);
        channelToClient.registerMessage(Solinia3UIPacketDiscriminators.MEMORISEDSPELLS, PacketMemorisedSpells.class, PacketMemorisedSpells::encode, PacketMemorisedSpells::new, PacketMemorisedSpells::handle);
        channelToClient.registerMessage(Solinia3UIPacketDiscriminators.EQUIPSLOTS, PacketEquipSlots.class, PacketEquipSlots::encode, PacketEquipSlots::new, PacketEquipSlots::handle);
        channelToClient.registerMessage(Solinia3UIPacketDiscriminators.EFFECTS, PacketEffects.class, PacketEffects::encode, PacketEffects::new, PacketEffects::handle);
        channelToClient.registerMessage(Solinia3UIPacketDiscriminators.CHARCREATION, PacketOpenCharacterCreation.class, PacketOpenCharacterCreation::encode, PacketOpenCharacterCreation::new, PacketOpenCharacterCreation::handle);
        channelToClient.registerMessage(Solinia3UIPacketDiscriminators.PLAYSOUNDANIM, PacketPlaySoundAnim.class, PacketPlaySoundAnim::encode, PacketPlaySoundAnim::new, PacketPlaySoundAnim::handle);
        channelToClient.registerMessage(Solinia3UIPacketDiscriminators.INZONE, PacketInZone.class, PacketInZone::encode, PacketInZone::new, PacketInZone::handle);
        channelToClient.registerMessage(Solinia3UIPacketDiscriminators.TRACKING, PacketTrackingChoices.class, PacketTrackingChoices::encode, PacketTrackingChoices::new, PacketTrackingChoices::handle);
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
		
		@SubscribeEvent
	    public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event)
	    {
			event.getRegistry().register(EntityType.Builder.<LizardmanEntity>create(LizardmanEntity::new, EntityClassification.MONSTER).setTrackingRange(32).size(1f, 1f).build("lizardman").setRegistryName(solinia3ui.MOD_ID, "lizardman"));
			event.getRegistry().register(EntityType.Builder.<OWDrakeEntity>create(OWDrakeEntity::new, EntityClassification.MONSTER).setTrackingRange(32).size(3f, 3f).build("owdrake").setRegistryName(solinia3ui.MOD_ID, "owdrake"));
			event.getRegistry().register(EntityType.Builder.<CanariWyvernEntity>create(CanariWyvernEntity::new, EntityClassification.MONSTER).setTrackingRange(32).size(3f, 3f).build("canariwyvern").setRegistryName(solinia3ui.MOD_ID, "canariwyvern"));
	    }
		
		@SubscribeEvent
		public void onRegisterSounds(RegistryEvent.Register<SoundEvent> event) {
			for(SoundEvent soundEvent : solinia3ui.soundEvents)
			{
				event.getRegistry().register(soundEvent);
				solinia3ui.LOGGER.info("Registered new Sound: " + soundEvent.getName());
			}
		}
		/*
		@ForgeSubscribe
		public void onBackgroundSound(PlayBackgroundMusicEvent par1PlayBackgroundMusicEvent) {
			SoundPoolEntry var1 = par1PlayBackgroundMusicEvent.manager.soundPoolMusic.getRandomSoundFromSoundPool("ml.outdoor");

			if(var1 != null) {
				solinia3ui.LOGGER.info("Play!");
				par1PlayBackgroundMusicEvent.result = par1PlayBackgroundMusicEvent.manager.soundPoolMusic.getRandomSoundFromSoundPool("ml.outdoor");
			} else {
				solinia3ui.LOGGER.info("Load!");
				par1PlayBackgroundMusicEvent.manager.soundPoolMusic.addSound("ml/outdoor.ogg", new File(Minecraft.getMinecraft().getMinecraftDir(), "resources/MusicLoops/Outdoor.ogg"));
				this.onBackgroundSound(par1PlayBackgroundMusicEvent);
			}
		}*/
	}

	
	public static void openSpellBook(final SpellbookPage SpellbookPage) {
		if (SpellbookPage == null)
			return;
		
		StringTextComponent textComponent = new StringTextComponent("Test");
		Runnable rn = () -> Minecraft.getInstance().displayGuiScreen(new GuiSpellbook(textComponent, SpellbookPage));
		Minecraft.getInstance().runImmediately(rn);
	}

	public static void openCharacterCreation(CharacterCreation characterCreation) {
		if (characterCreation == null)
			return;
		
		// if already in then dont open
		if (Minecraft.getInstance().currentScreen instanceof GuiCharacterCreation)
			return;
		
		StringTextComponent textComponent = new StringTextComponent("CharacterCreation");
		Runnable rn = () -> Minecraft.getInstance().displayGuiScreen(new GuiCharacterCreation(textComponent, characterCreation));
		Minecraft.getInstance().runImmediately(rn);
	}

	public static void openTrackingWindow(List<TrackingChoice> trackingChoices) {
		//System.out.println("received tracking message");

		
		if (trackingChoices == null)
			return;
		
		// if already in then dont open
		if (Minecraft.getInstance().currentScreen instanceof GuiTrackingWindow)
			return;
		
		StringTextComponent textComponent = new StringTextComponent("Tracking");
		Runnable rn = () -> Minecraft.getInstance().displayGuiScreen(new GuiTrackingWindow(textComponent, trackingChoices));
		Minecraft.getInstance().runImmediately(rn);
	}

}
