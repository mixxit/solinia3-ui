package com.solinia.solinia3ui;

import net.minecraft.client.Minecraft;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.function.Supplier;

import io.netty.buffer.ByteBufUtil;

// Great examples at https://github.com/gigaherz/ToolBelt/tree/master/src/main/java/gigaherz/toolbelt/network
public class PacketRequestGenericMessage {
	public String message;
	
	public PacketRequestGenericMessage(String message)
    {
    	this.message = message;
    }

    public PacketRequestGenericMessage(PacketBuffer buf)
    {
    	try
    	{
	    	byte[] rawData = ByteBufUtil.getBytes(buf);
	    	if (rawData.length < 6)
	    		this.message = "";
	    	else
	    		this.message = new String(Arrays.copyOfRange(rawData,3,rawData.length),StandardCharsets.UTF_8);
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
    	GenericPacketMessage message = GenericPacketMessage.fromJson(this.message);
    	
    	if (message.SpellbookPage != null)
	    	System.out.println("Received spellbook page: " + this.message);
			context.get().enqueueWork(() -> solinia3ui.openSpellBook(message.SpellbookPage));
    	
	    if (message.MemorisedSpellSlots != null)
	    {
	    	System.out.println("Received memorised spells: " + this.message);
	    	context.get().enqueueWork(() -> solinia3ui.updateMemorisedSpells(message.MemorisedSpellSlots));
	    }
    	
    	context.get().enqueueWork(() -> Minecraft.getInstance().player.resetCooldown());
    	context.get().setPacketHandled(true);
    }
}
