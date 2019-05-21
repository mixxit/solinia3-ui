package com.solinia.solinia3ui;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.item.Item;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import net.minecraftforge.fml.server.ServerLifecycleHooks;
import java.util.function.Supplier;

public class PacketRequestMemSpells {
	public static void encode(PacketRequestMemSpells pkt, PacketBuffer buf) {}

	public static PacketRequestMemSpells decode(PacketBuffer buf) {
		return new PacketRequestMemSpells();
	}

	public static class Handler
	{
		public static void handle(PacketRequestMemSpells message, Supplier<NetworkEvent.Context> ctx)
		{
			ctx.get().enqueueWork(() -> Minecraft.getInstance().player.resetCooldown());
			ctx.get().setPacketHandled(true);
		}
}
}
