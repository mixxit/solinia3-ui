package com.solinia.solinia3ui;

import java.util.function.Supplier;

import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public interface ISoliniaPacket {
	String toPacketData();
	void fromPacketData(String data) throws InvalidPacketException;
	void handle(Supplier<NetworkEvent.Context> context);
	void encode(PacketBuffer buf);
}
