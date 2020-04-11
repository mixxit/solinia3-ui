package com.solinia.solinia3ui;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.io.DataInputStream;
import java.io.IOException;

import com.solinia.solinia3ui.InvalidPacketException;
import com.solinia.solinia3ui.solinia3ui;
import com.solinia.solinia3ui.Models.ISoliniaPacket;
import com.solinia.solinia3ui.Models.TrackingChoice;

import io.netty.buffer.ByteBufInputStream;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class PacketTrackingChoices implements ISoliniaPacket {
	private List<TrackingChoice> trackingChoices = new ArrayList<TrackingChoice>();

	PacketTrackingChoices(PacketBuffer buf) throws RuntimeException
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

		List<TrackingChoice> trackingChoices = new ArrayList<TrackingChoice>();
		
		String[] dataArray = data.split("\\^");
		for(int i = 0; i < dataArray.length; i++)
		{
			String[] trackingArray = dataArray[i].split("\\|",-1);
			TrackingChoice trackingChoice = new TrackingChoice();
			trackingChoice.Distance = Integer.parseInt(trackingArray[0]);
			trackingChoice.Color = trackingArray[1];
			trackingChoice.Name = trackingArray[2];
			trackingChoice.Id = trackingArray[3];
			
			trackingChoices.add(trackingChoice);
		}
		
		this.trackingChoices = trackingChoices;
	}
	
	public List<TrackingChoice> getTrackingChoices()
	{
		return this.trackingChoices;
	}

	
	public String toPacketData()
	{
		String packetData = "";
		for(int i = 0; i < this.trackingChoices.size(); i++)
		{
			packetData +=
					this.trackingChoices.get(i).Distance + "|" +
					this.trackingChoices.get(i).Color + "|" +
					this.trackingChoices.get(i).Name + "|" +
					this.trackingChoices.get(i).Id + "^";
		}
		return packetData;
	}

	public void fromData(List<TrackingChoice> trackingChoices) {
		this.trackingChoices = trackingChoices;
	}
	
	public void encode(PacketBuffer buf)
    {
    	buf.writeString(toPacketData());
    }
	
	public void handle(Supplier<NetworkEvent.Context> context)
	{
		context.get().enqueueWork(() -> solinia3ui.openTrackingWindow(this.trackingChoices));
    	context.get().setPacketHandled(true);
	}
}