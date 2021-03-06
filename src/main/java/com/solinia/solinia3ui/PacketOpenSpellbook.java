package com.solinia.solinia3ui;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.function.Supplier;

import com.solinia.solinia3ui.InvalidPacketException;
import com.solinia.solinia3ui.solinia3ui;
import com.solinia.solinia3ui.Models.ISoliniaPacket;
import com.solinia.solinia3ui.Models.SpellbookPage;

import io.netty.buffer.ByteBufInputStream;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class PacketOpenSpellbook implements ISoliniaPacket {
	private SpellbookPage spellbookPage;

	PacketOpenSpellbook(PacketBuffer buf) throws RuntimeException
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
	
	public SpellbookPage getSpellBookPage()
	{
		return this.spellbookPage;
	}
	
	public void fromPacketData(String data) throws InvalidPacketException
	{
		//solinia3ui.LOGGER.info("Found spell page:" + data);
		if (data == null)
			throw new InvalidPacketException("Packet data is empty");

		String[] dataArray = data.split("\\^");
		if (dataArray.length < 1)
			throw new InvalidPacketException("Packet data missing elements");
		
		int spellbookPage = Integer.parseInt(dataArray[0]);
		// now pages
		this.spellbookPage = new SpellbookPage();
		this.spellbookPage.PageNo = spellbookPage;
		
		for(int i = 1; i < dataArray.length; i++)
		{
			String[] spellArray = dataArray[i].split("\\|",-1);
			int slotNo = Integer.parseInt(spellArray[0]);
			int Id = Integer.parseInt(spellArray[1]);
			int Icon = Integer.parseInt(spellArray[2]);
			int NewIcon = Integer.parseInt(spellArray[3]);
			int MemIcon = Integer.parseInt(spellArray[4]);
			String Name = spellArray[5];
			int Level = Integer.parseInt(spellArray[6]);
			String slotDescription = "";
			if (dataArray[i].split("\\|",-1).length > 7)
				slotDescription = spellArray[7];
			this.spellbookPage.setSpellSlot(slotNo,Id,Icon,NewIcon,MemIcon,Name,Level,slotDescription);
		}
	}
	
	public String toPacketData()
	{
		String packetData = "" + this.spellbookPage.PageNo;
		for(int i = 1; i <= 16; i++)
		{
			if (this.spellbookPage.getSlotId(i) < 1)
				continue;
			
			packetData += "^" + i
					+ "|" + this.spellbookPage.getSlotId(i) 
					+ "|" + this.spellbookPage.getSlotIcon(i)
					+ "|" + this.spellbookPage.getSlotNewIcon(i)
					+ "|" + this.spellbookPage.getSlotMemIcon(i)
					+ "|" + this.spellbookPage.getSlotName(i)
					+ "|" + this.spellbookPage.getSlotLevel(i)
					+ "|" + this.spellbookPage.getSlotDescription(i)
				;
		}
		return packetData;
	}

	public void fromData(SpellbookPage spellbookPage) {
		this.spellbookPage = spellbookPage;
	}
	
	public void encode(PacketBuffer buf)
    {
    	buf.writeString(toPacketData());
    }
	
	public void handle(Supplier<NetworkEvent.Context> context)
	{		
		context.get().enqueueWork(() -> solinia3ui.openSpellbookWindow(this.spellbookPage));
    	context.get().setPacketHandled(true);
	}
}
