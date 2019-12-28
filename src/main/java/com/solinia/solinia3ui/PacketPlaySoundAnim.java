package com.solinia.solinia3ui;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.function.Supplier;

import io.netty.buffer.ByteBufInputStream;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class PacketPlaySoundAnim implements ISoliniaPacket {
	private int soundAnim = 0;

	PacketPlaySoundAnim(PacketBuffer buf) throws RuntimeException
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
		
		int soundAnim = Integer.parseInt(dataArray[0]);
		
		this.soundAnim = soundAnim;
	}
	
	public int getSoundAnim()
	{
		return this.soundAnim;
	}

	
	public String toPacketData()
	{
		String packetData = "";
		packetData += getSoundAnim() + "^";
		return packetData;
	}

	public void fromData(int soundAnim) {
		this.soundAnim = soundAnim;
	}
	
	public void encode(PacketBuffer buf)
    {
    	buf.writeString(toPacketData());
    }
	
	public void handle(Supplier<NetworkEvent.Context> context)
	{
		context.get().enqueueWork(() -> ClientState.getInstance().playSoundAnim(this.soundAnim));
    	context.get().setPacketHandled(true);
	}
}