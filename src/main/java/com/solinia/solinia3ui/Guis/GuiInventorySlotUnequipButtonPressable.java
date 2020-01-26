package com.solinia.solinia3ui.Guis;

import com.solinia.solinia3ui.solinia3ui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.button.Button.IPressable;

public class GuiInventorySlotUnequipButtonPressable implements IPressable {
	private int slotId;
	
	public GuiInventorySlotUnequipButtonPressable(int slotId)
	{
		this.slotId = slotId;
	}
	
	@Override
	public void onPress(Button button) {
		try {
			solinia3ui.LOGGER.info("Received click for unequip slot: " + this.getSlotName());
			Minecraft.getInstance().player.sendChatMessage("/solinia3core:equip unequip " + this.getSlotName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
