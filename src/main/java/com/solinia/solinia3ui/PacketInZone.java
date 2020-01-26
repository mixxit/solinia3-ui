package com.solinia.solinia3ui;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.function.Supplier;

import com.solinia.solinia3ui.Models.ISoliniaPacket;

import io.netty.buffer.ByteBufInputStream;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class PacketInZone implements ISoliniaPacket {
	private int zoneId = 0;
	private String zoneMusic = "";
	
	PacketInZone(PacketBuffer buf) throws RuntimeException
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
		if (dataArray.length < 2)
			throw new InvalidPacketException("Packet data missing elements");
		
		this.zoneId = Integer.parseInt(dataArray[0]);
		this.zoneMusic = dataArray[1];
	}
	
	public int getZoneId()
	{
		return this.zoneId;
	}

	public String getZoneMusic()
	{
		return this.zoneMusic;
	}
	
	public String toPacketData()
	{
		String packetData = "";
		
		packetData += getZoneId() 
				+ "^" + getZoneMusic();
		return packetData;
	}
	
	public void encode(PacketBuffer buf)
    {
    	buf.writeString(toPacketData());
    }
	
	public void handle(Supplier<NetworkEvent.Context> context)
	{
		context.get().enqueueWork(() -> ClientState.getInstance().setZoneData(this.zoneId,this.zoneMusic));
    	context.get().setPacketHandled(true);
	}
}
