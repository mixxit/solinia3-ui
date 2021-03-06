package com.solinia.solinia3ui;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.function.Supplier;

import com.solinia.solinia3ui.InvalidPacketException;
import com.solinia.solinia3ui.solinia3ui;
import com.solinia.solinia3ui.Models.CharacterCreation;
import com.solinia.solinia3ui.Models.ISoliniaPacket;
import com.solinia.solinia3ui.Models.RaceChoice;

import io.netty.buffer.ByteBufInputStream;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class PacketOpenCharacterCreation implements ISoliniaPacket {
	CharacterCreation characterCreation = new CharacterCreation();
	
	PacketOpenCharacterCreation(PacketBuffer buf) throws RuntimeException
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
	
	public CharacterCreation getCharacterCreation()
	{
		return this.characterCreation;
	}
	
	public void fromPacketData(String data) throws InvalidPacketException
	{
		if (data == null)
			throw new InvalidPacketException("Packet data is empty");

		// now pages
		this.characterCreation = new CharacterCreation();
		
		if (data.equals(""))
			return;
		
		String[] dataArray = data.split("\\^",-1);
		
		for(int i = 0; i < dataArray.length; i++)
		{
			String[] effectArray = dataArray[i].split("\\|",-1);
			int RaceId = Integer.parseInt(effectArray[0]);
			int ClassId = Integer.parseInt(effectArray[1]);
			String RaceName = effectArray[2];
			String ClassName = effectArray[3];
			String RaceShort = effectArray[4];
			String ClassShort = effectArray[5];
			String RaceDescription = effectArray[6];
			String ClassDescription = effectArray[7];

			int STR = Integer.parseInt(effectArray[8]);
			int STA = Integer.parseInt(effectArray[9]);
			int AGI = Integer.parseInt(effectArray[10]);
			int DEX = Integer.parseInt(effectArray[11]);
			int INT = Integer.parseInt(effectArray[12]);
			int WIS = Integer.parseInt(effectArray[13]);
			int CHA = Integer.parseInt(effectArray[14]);
			String Alignment = effectArray[15];

			this.characterCreation.raceChoices.put(RaceName +"_"+ClassName, new RaceChoice(RaceId,ClassId,RaceName,ClassName,RaceShort,ClassShort,RaceDescription,ClassDescription,STR,STA,AGI,DEX,INT,WIS,CHA, Alignment));
		}
	}
	
	public String toPacketData()
	{
		String packetData = "";
		boolean first = true;
		for(Map.Entry<String, RaceChoice> entry : this.characterCreation.raceChoices.entrySet())
		{
			if (first)
				first = false;
			else
				packetData += "^";
			
			packetData += 
					+ entry.getValue().RaceId + "|" 
					+ entry.getValue().ClassId + "|" 
					+ entry.getValue().RaceName + "|" 
					+ entry.getValue().ClassName + "|" 
					+ entry.getValue().RaceShort + "|"
					+ entry.getValue().ClassShort + "|"
					+ entry.getValue().RaceDescription + "|"
					+ entry.getValue().ClassDescription + "|"
					+ entry.getValue().STR + "|"
					+ entry.getValue().STA + "|"
					+ entry.getValue().AGI + "|"
					+ entry.getValue().DEX + "|"
					+ entry.getValue().INT + "|"
					+ entry.getValue().WIS + "|"
					+ entry.getValue().CHA + "|"
					+ entry.getValue().Alignment
					;
		}
		
		return packetData;
	}
	
	public void fromData(CharacterCreation characterCreation) {
		this.characterCreation = characterCreation;
	}
	
	public void encode(PacketBuffer buf)
    {
    	buf.writeString(toPacketData());
    }
	
	public void handle(Supplier<NetworkEvent.Context> context)
	{
		context.get().enqueueWork(() -> solinia3ui.openCharacterCreation(this.characterCreation));
    	context.get().setPacketHandled(true);
	}
}