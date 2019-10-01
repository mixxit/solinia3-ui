package com.solinia.solinia3ui;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.function.Supplier;

import io.netty.buffer.ByteBufInputStream;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class PacketEffects implements ISoliniaPacket {
	Effects effects = new Effects();
	
	PacketEffects(PacketBuffer buf) throws RuntimeException
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
	
	public Effects getEffects()
	{
		return this.effects;
	}
	
	public void fromPacketData(String data) throws InvalidPacketException
	{
		if (data == null)
			throw new InvalidPacketException("Packet data is empty");

		// now pages
		this.effects = new Effects();
		
		if (data.equals(""))
			return;
		
		String[] dataArray = data.split("\\^",-1);
		
		for(int i = 0; i < dataArray.length; i++)
		{
			String[] effectArray = dataArray[i].split("\\|",-1);
			int SpellId = Integer.parseInt(effectArray[0]);
			int Icon = Integer.parseInt(effectArray[1]);
			int NewIcon = Integer.parseInt(effectArray[2]);
			int MemIcon = Integer.parseInt(effectArray[3]);
			String Name = effectArray[4];
			this.effects.effectSlots.put(SpellId, new EffectSlot(SpellId,Icon,MemIcon,NewIcon,Name));
		}
	}
	
	public String toPacketData()
	{
		String packetData = "";
		boolean first = true;
		for(Map.Entry<Integer, EffectSlot> entry : this.effects.effectSlots.entrySet())
		{
			if (first)
				first = false;
			else
				packetData += "^";
			
			packetData += 
					+ entry.getValue().SpellId + "|" 
					+ entry.getValue().Icon + "|" 
					+ entry.getValue().NewIcon + "|" 
					+ entry.getValue().MemIcon + "|" 
					+ entry.getValue().Name;
		}
		
		return packetData;
	}
	
	public void fromData(Effects effects) {
		this.effects = effects;
	}
	
	public void encode(PacketBuffer buf)
    {
    	buf.writeString(toPacketData());
    }
	
	public void handle(Supplier<NetworkEvent.Context> context)
	{
		context.get().enqueueWork(() -> ClientState.getInstance().setEffects(this.effects));
    	context.get().setPacketHandled(true);
	}
}
