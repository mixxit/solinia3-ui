package com.solinia.solinia3ui;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class PacketHandler {
	private static final String PROTOCOL_VERSION = Integer.toString(1);
	private static final SimpleChannel HANDLER = NetworkRegistry.ChannelBuilder
			.named(new ResourceLocation("solinia3ui", "main_channel"))
			.clientAcceptedVersions(PROTOCOL_VERSION::equals)
			.serverAcceptedVersions(PROTOCOL_VERSION::equals)
			.networkProtocolVersion(() -> PROTOCOL_VERSION)
.simpleChannel();
	
	//https://github.com/sinkillerj/ProjectE/blob/mc1.13.x/src/main/java/moze_intel/projecte/network/PacketHandler.java
	
	public static void register()
	{
		int packetId = 0;
		HANDLER.registerMessage(packetId++, PacketRequestMemSpells.class, PacketRequestMemSpells::encode, PacketRequestMemSpells::decode, PacketRequestMemSpells.Handler::handle);
	}
	
	// Examples based on https://github.com/sinkillerj/ProjectE/blob/mc1.13.x/src/main/java/moze_intel/projecte/network/PacketHandler.java

	public static void sendNonLocal(Object msg, EntityPlayerMP player)
	{
		if (player.server.isDedicatedServer() || !player.getGameProfile().getName().equals(player.server.getServerOwner()))
		{
			HANDLER.sendTo(msg, player.connection.netManager, NetworkDirection.PLAY_TO_CLIENT);
		}
	}

	public static void sendToServer(Object msg)
	{
		HANDLER.sendToServer(msg);
	}
	
	public static void sendTo(Object msg, EntityPlayerMP player)
	{
		if (!(player instanceof FakePlayer))
		{
			HANDLER.sendTo(msg, player.connection.netManager, NetworkDirection.PLAY_TO_CLIENT);
		}
	}
}
