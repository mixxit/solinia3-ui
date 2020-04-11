package com.solinia.solinia3ui;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.JsonToNBT;

public class ItemStackUtils {
	
	public static ItemStack convertBase64JsonToItemStack(String base64) {
		try {
			String json = new String(Base64.getDecoder().decode(base64),"utf-8");
			//String json = new String(base64.(base64.getBytes()));
			return convertJsonToItemStack(json);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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

		try {
			String encodedBytes = Base64.getEncoder().encodeToString(json.getBytes("utf-8"));
		    return encodedBytes;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
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
