package com.solinia.solinia3ui;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.function.Supplier;

import com.solinia.solinia3ui.ClientState;
import com.solinia.solinia3ui.EquipSlots;
import com.solinia.solinia3ui.InvalidPacketException;
import com.solinia.solinia3ui.solinia3ui;
import com.solinia.solinia3ui.Models.ISoliniaPacket;

import io.netty.buffer.ByteBufInputStream;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class PacketEquipSlots implements ISoliniaPacket {
	EquipSlots equipSlots;
	
	PacketEquipSlots(PacketBuffer buf) throws RuntimeException
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
	
	public EquipSlots getEquipSlots()
	{
		return this.equipSlots;
	}
	
	public void encode(PacketBuffer buf)
    {
    	buf.writeString(toPacketData());
    }
	
	public void handle(Supplier<NetworkEvent.Context> context)
	{
		context.get().enqueueWork(() -> ClientState.getInstance().setEquipSlots(this.getEquipSlots()));
    	context.get().setPacketHandled(true);
	}
	
	public void fromPacketData(String data) throws InvalidPacketException
	{
		solinia3ui.LOGGER.info("Received equip slots data: " + data);
		
		if (data == null)
			throw new InvalidPacketException("Packet data is empty");

		// now pages
		this.equipSlots = new EquipSlots();

		if (data.equals(""))
			return;
		
		String[] dataArray = data.split("\\^",-1);
		if (dataArray.length < 11)
			throw new InvalidPacketException("Packet data missing elements");
		
		this.equipSlots.setSlotByIndex(0, dataArray[0]);
		this.equipSlots.setSlotByIndex(1, dataArray[1]);
		this.equipSlots.setSlotByIndex(2, dataArray[2]);
		this.equipSlots.setSlotByIndex(3, dataArray[3]);
		this.equipSlots.setSlotByIndex(4, dataArray[4]);
		this.equipSlots.setSlotByIndex(5, dataArray[5]);
		this.equipSlots.setSlotByIndex(6, dataArray[6]);
		this.equipSlots.setSlotByIndex(7, dataArray[7]);
		this.equipSlots.setSlotByIndex(8, dataArray[8]);
		this.equipSlots.setSlotByIndex(9, dataArray[9]);
		this.equipSlots.setSlotByIndex(10, dataArray[10]);
		this.equipSlots.setSlotByIndex(11, dataArray[11]);
	}
	
	public String toPacketData()
	{
		String packetData = "";
		boolean first = true;
		for(int i = 0; i < 12; i++)
		{
			String slotBase64 = "";
			slotBase64 = this.equipSlots.getSlotByIndex(i);
			
			if (first)
				first = false;
			else
				packetData += "^";
			
			packetData += slotBase64;
		}
		
		return packetData;
	}
	
	public void fromData(EquipSlots equipSlots) {
		this.equipSlots = equipSlots;
	}
}
