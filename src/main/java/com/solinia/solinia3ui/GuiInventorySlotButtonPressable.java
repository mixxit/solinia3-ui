package com.solinia.solinia3ui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.button.Button.IPressable;
import net.minecraft.item.ItemStack;

public class GuiInventorySlotButtonPressable implements IPressable {
	private int slotId;
	
	public GuiInventorySlotButtonPressable(int slotId)
	{
		this.slotId = slotId;
	}
	
	@Override
	public void onPress(Button button) {
		ItemStack activeItemStack = Minecraft.getInstance().player.inventory.getItemStack();
		if (activeItemStack == null || activeItemStack.isEmpty())
		{
			System.out.println("Recieved onPress for empty item stack");
			try {
				Minecraft.getInstance().player.sendChatMessage("/solinia3core:equip unequip " + this.getSlotName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		} else {
			System.out.println("Recieved onPress for item stack");
			Minecraft.getInstance().player.sendChatMessage("/solinia3core:equip equip");			
		}
	}
	
	public String getSlotName() throws Exception
	{
		switch(this.slotId)
		{
		case 0:
			return "FINGERS";
		case 1:
			return "SHOULDERS";
		case 2:
			return "NECK";
		case 3:
			return "EARS";
		case 4:
			return "FOREARMS";
		case 5:
			return "ARMS";
		case 6:
			return "HANDS";
		case 7:
			return "WAIST";
			default:
				throw new Exception("Unknown slot");
		}
	}
}
