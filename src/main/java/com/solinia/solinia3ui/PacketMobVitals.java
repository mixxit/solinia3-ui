package com.solinia.solinia3ui;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.function.Supplier;

import com.solinia.solinia3ui.ClientState;
import com.solinia.solinia3ui.InvalidPacketException;
import com.solinia.solinia3ui.Models.ISoliniaPacket;

import io.netty.buffer.ByteBufInputStream;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class PacketMobVitals implements ISoliniaPacket {
	private int partyMember = 0;
	private float healthPercent = 0F;
	private float manaPercent = 0F;
	private int entityId = 0;
	private String name = "";
	private int level = 0;
	
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
		//solinia3ui.LOGGER.info("Mob Vitals: " + dataArray.length + " " + data);
		if (dataArray.length < 4)
			throw new InvalidPacketException("Packet data missing elements");
		
		int partyMember = Integer.parseInt(dataArray[0]);
		float healthPercent = Float.parseFloat(dataArray[1]);
		float manaPercent = Float.parseFloat(dataArray[2]);
		int entityId = 0;
		try
		{
			entityId = Integer.parseInt(dataArray[3]);
		} catch (Exception e)
		{
			// not valid int (ie null
		}
		String name = dataArray[4];
		int level = Integer.parseInt(dataArray[5]);
		
		this.partyMember = partyMember;
		this.healthPercent = healthPercent;
		this.manaPercent = manaPercent;
		this.entityId = entityId;
		this.name = name;
		this.level = level;
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

	public int getEntityId()
	{
		return this.entityId;
	}

	public String getName()
	{
		return this.name;
	}
	
	public int getLevel()
	{
		return this.level;
	}
	
	public String toPacketData()
	{
		String packetData = "";
		String uniqueString = "";
		if (this.getEntityId() > 0)
			uniqueString = Integer.toString(getEntityId());
		
		packetData += getPartyMember() 
				+ "^" + getHealthPercent() 
				+ "^" + getManaPercent()
				+ "^" + uniqueString
				+ "^" + getName()
				+ "^" + getLevel()
				;
		return packetData;
	}
	
	public void encode(PacketBuffer buf)
    {
    	buf.writeString(toPacketData());
    }
	
	public void handle(Supplier<NetworkEvent.Context> context)
	{
		//solinia3ui.LOGGER.info("received new message mob vital");
		context.get().enqueueWork(() -> ClientState.getInstance().setEntityVital(this.partyMember, this.healthPercent, this.manaPercent, this.getEntityId(), this.name, this.level));
    	context.get().setPacketHandled(true);
	}
}
