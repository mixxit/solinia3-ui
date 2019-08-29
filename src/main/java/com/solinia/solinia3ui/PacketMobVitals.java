package com.solinia.solinia3ui;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.function.Supplier;

import io.netty.buffer.ByteBufInputStream;
import net.minecraft.client.Minecraft;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class PacketMobVitals implements ISoliniaPacket {
	private int partyMember = 0;
	private float healthPercent = 0F;
	private float manaPercent = 0F;
	private UUID uniqueId = null;
	private String name = "";
	
	PacketMobVitals(PacketBuffer buf) throws RuntimeException
    {
    	try(DataInputStream stream = new DataInputStream(new ByteBufInputStream(buf)))
    	{
        	fromPacketData(stream.readUTF());
    	} catch (IOException e) {
    		throw new RuntimeException("impossible", e);
		} catch (InvalidPacketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
	
	public void fromPacketData(String data) throws InvalidPacketException
	{
		if (data == null)
			throw new InvalidPacketException("Packet data is empty");

		if (!data.contains("^"))
			throw new InvalidPacketException("Packet data is wrong format");

		String[] dataArray = data.split("\\^",-1);
		//System.out.println("Mob Vitals: " + dataArray.length + " " + data);
		if (dataArray.length < 4)
			throw new InvalidPacketException("Packet data missing elements");
		
		int partyMember = Integer.parseInt(dataArray[0]);
		float healthPercent = Float.parseFloat(dataArray[1]);
		float manaPercent = Float.parseFloat(dataArray[2]);
		UUID uniqueId = null;
		try
		{
			uniqueId = UUID.fromString(dataArray[3]);
		} catch (Exception e)
		{
			// not valid UUID (ie null
		}
		String name = dataArray[4];
		
		this.partyMember = partyMember;
		this.healthPercent = healthPercent;
		this.manaPercent = manaPercent;
		this.uniqueId = uniqueId;
		this.name = name;
	}
	
	public int getPartyMember()
	{
		return this.partyMember;
	}

	public float getHealthPercent()
	{
		return this.healthPercent;
	}

	public float getManaPercent()
	{
		return this.manaPercent;
	}

	public UUID getUniqueId()
	{
		return this.uniqueId;
	}

	public String getName()
	{
		return this.name;
	}
	
	public String toPacketData()
	{
		String packetData = "";
		String uniqueString = "";
		if (this.getUniqueId() != null)
			uniqueString = this.getUniqueId().toString();
		
		packetData += getPartyMember() 
				+ "^" + getHealthPercent() 
				+ "^" + getManaPercent()
				+ "^" + uniqueString
				+ "^" + getName();
		return packetData;
	}
	
	public void encode(PacketBuffer buf)
    {
    	buf.writeString(toPacketData());
    }
	
	public void handle(Supplier<NetworkEvent.Context> context)
	{
		context.get().enqueueWork(() -> ClientState.getInstance().setEntityVital(this.partyMember, this.healthPercent, this.manaPercent, this.uniqueId, this.name));
		//context.get().enqueueWork(() -> Minecraft.getInstance().player.resetCooldown());
    	context.get().setPacketHandled(true);
	}
}
