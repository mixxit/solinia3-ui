package com.solinia.solinia3ui;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import org.apache.commons.codec.binary.Base64;

import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.JsonToNBT;

public class ItemStackUtils {
	
	public static ItemStack convertBase64JsonToItemStack(String base64) {
		String json = new String(Base64.decodeBase64(base64.getBytes()));
		return convertJsonToItemStack(json);
    }

	public static ItemStack convertJsonToItemStack(String json) {
		try {
			CompoundNBT nbt = JsonToNBT.getTagFromJson(json);
			return ItemStack.read(nbt);
		} catch (CommandSyntaxException e) {
			// TODO Auto-generated catch block
			solinia3ui.LOGGER.info("Command syntax exception for json: " + json);
			e.printStackTrace();
		}
		
		return null;
    }
	
	public static String convertItemStackToBase64(ItemStack itemStack)
	{
		String json = convertItemStackToJson(itemStack);
        byte[] encodedBytes = Base64.encodeBase64(json.getBytes());
        return new String(encodedBytes);
	}
	
	public static String convertItemStackToJson(ItemStack itemStack) {
		CompoundNBT nbt = itemStack.serializeNBT();

		if(nbt == null) {
	        return null;
	      }
	      try {
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        CompressedStreamTools.writeCompressed(nbt, new DataOutputStream(baos));
	        return new String(baos.toByteArray());
	      } catch (Exception e) {
	    	  e.printStackTrace();
	      }
		
	      return null;
    }
}
