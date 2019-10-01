package com.solinia.solinia3ui;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.function.Supplier;

import io.netty.buffer.ByteBufInputStream;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class PacketMemorisedSpells implements ISoliniaPacket {
	MemorisedSpells memorisedSpells = new MemorisedSpells();
	
	PacketMemorisedSpells(PacketBuffer buf) throws RuntimeException
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
	
	public MemorisedSpells getMemorisedSpells()
	{
		return this.memorisedSpells;
	}
	
	public void fromPacketData(String data) throws InvalidPacketException
	{
		if (data == null)
			throw new InvalidPacketException("Packet data is empty");

		// now pages
		this.memorisedSpells = new MemorisedSpells();
		
		if (data.equals(""))
			return;
		
		String[] dataArray = data.split("\\^",-1);
		
		for(int i = 0; i < dataArray.length; i++)
		{
			String[] spellArray = dataArray[i].split("\\|",-1);
			int slotNo = Integer.parseInt(spellArray[0]);
			int Id = Integer.parseInt(spellArray[1]);
			int Icon = Integer.parseInt(spellArray[2]);
			int NewIcon = Integer.parseInt(spellArray[3]);
			int MemIcon = Integer.parseInt(spellArray[4]);
			String Name = spellArray[5];
			this.memorisedSpells.setSlot(slotNo,Id,Icon,NewIcon,MemIcon,Name);
		}
	}
	
	public String toPacketData()
	{
		String packetData = "";
		boolean first = true;
		for(int i = 1; i <= 16; i++)
		{
			if (this.memorisedSpells.getSlotId(i) < 1)
				continue;
			
			if (first)
				first = false;
			else
				packetData += "^";
			
			packetData += i + "|"
					+ this.memorisedSpells.getSlotId(i) + "|" 
					+ this.memorisedSpells.getSlotIcon(i)+ "|" 
					+ this.memorisedSpells.getSlotNewIcon(i)+ "|" 
					+ this.memorisedSpells.getSlotMemIcon(i)+ "|" 
					+ this.memorisedSpells.getSlotName(i);
		}
		
		return packetData;
	}
	
	public void fromData(MemorisedSpells memorisedSpells) {
		this.memorisedSpells = memorisedSpells;
	}
	
	public void encode(PacketBuffer buf)
    {
    	buf.writeString(toPacketData());
    }
	
	public void handle(Supplier<NetworkEvent.Context> context)
	{
		context.get().enqueueWork(() -> ClientState.getInstance().setMemorisedSpells(this.memorisedSpells));
    	context.get().setPacketHandled(true);
	}

}
