package com.solinia.solinia3ui;

import net.minecraft.client.Minecraft;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.function.Supplier;

import io.netty.buffer.ByteBufUtil;

// Great examples at https://github.com/gigaherz/ToolBelt/tree/master/src/main/java/gigaherz/toolbelt/network
public class PacketRequestOpenSpellbook {
	public String message;

    public PacketRequestOpenSpellbook(String message)
    {
    	this.message = message;
    }

    public PacketRequestOpenSpellbook(PacketBuffer buf)
    {
    	try
    	{
	    	byte[] rawData = ByteBufUtil.getBytes(buf);
	    	if (rawData.length < 6)
	    		this.message = "";
	    	else
	    		this.message = new String(Arrays.copyOfRange(rawData,5,rawData.length),StandardCharsets.UTF_8);
    	} catch (Exception e)
    	{
    		this.message = "";
    	}
    }

    public void encode(PacketBuffer buf)
    {
    	buf.writeString(this.message);
    }
    
    public void handle(Supplier<NetworkEvent.Context> context)
    {
    	System.out.println("received message: " + this.message);
    	context.get().enqueueWork(() -> Minecraft.getInstance().player.resetCooldown());
    	context.get().setPacketHandled(true);
    }
}
