package com.solinia.solinia3ui;

import net.minecraft.network.PacketBuffer;
import java.io.DataInputStream;
import java.io.IOException;
import io.netty.buffer.ByteBufInputStream;

// Great examples at https://github.com/gigaherz/ToolBelt/tree/master/src/main/java/gigaherz/toolbelt/network
public class PacketRequestGenericMessage<T extends ISoliniaPacket> {
	public String message;
    public PacketRequestGenericMessage(PacketBuffer buf) throws RuntimeException
    {
    	this.message = "";
    	
    	try(DataInputStream stream = new DataInputStream(new ByteBufInputStream(buf)))
    	{
        	this.message = stream.readUTF();
    	} catch (IOException e) {
    		throw new RuntimeException("impossible", e);
		}
    	
    }

}
