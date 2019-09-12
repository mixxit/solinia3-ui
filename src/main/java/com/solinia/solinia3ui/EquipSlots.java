package com.solinia.solinia3ui;

import net.minecraft.item.ItemStack;

public class EquipSlots {
	public String FingersItemBase64;
	public String ShouldersItemBase64;
	public String NeckItemBase64;
	public String EarsItemBase64;
	public String ForearmsItemBase64;
	public String ArmsItemBase64;
	public String HandsItemBase64;
	public String WaistItemBase64;
	
	public ItemStack getSlotAsItemStack(int slotIndex)
	{
		if (slotIndex < 0 || slotIndex > 7)
			return null;
		
		String slotBase64 = this.getSlotByIndex(slotIndex);
		if (slotBase64 == null || slotBase64.isEmpty())
			return null;
		
		return ItemStackUtils.convertBase64JsonToItemStack(slotBase64);
	}
	
	public void setSlotByIndex(int i, String base64)
	{
		if (base64.equals("null"))
			base64 = null;
		
		switch(i)
		{
			case 0:
				this.FingersItemBase64 = base64;
				break;
			case 1:
				this.ShouldersItemBase64 = base64;
				break;
			case 2:
				this.NeckItemBase64 = base64;
				break;
			case 3:
				this.EarsItemBase64 = base64;
				break;
			case 4:
				this.ForearmsItemBase64 = base64;
				break;
			case 5:
				this.ArmsItemBase64 = base64;
				break;
			case 6:
				this.HandsItemBase64 = base64;
				break;
			case 7:
				this.WaistItemBase64 = base64;
				break;
			default:
				break;
		}
	}
	
	public String getSlotByIndex(int i)
	{
		switch(i)
		{
			case 0:
				return this.FingersItemBase64;
			case 1:
				return this.ShouldersItemBase64;
			case 2:
				return this.NeckItemBase64;
			case 3:
				return this.EarsItemBase64;
			case 4:
				return this.ForearmsItemBase64;
			case 5:
				return this.ArmsItemBase64;
			case 6:
				return this.HandsItemBase64;
			case 7:
				return this.WaistItemBase64;
			default:
				return null;
		}
	}

	public ItemStack getFingersItemStack() {
		if (getSlotByIndex(0) == null)
			return null;
		
		// TODO Auto-generated method stub
		return getSlotAsItemStack(0);
	}

	public ItemStack getShouldersItemStack() {
		// TODO Auto-generated method stub
		if (getSlotByIndex(1) == null)
			return null;

		return getSlotAsItemStack(1);
	}

	public ItemStack getNeckItemStack() {
		// TODO Auto-generated method stub
		if (getSlotByIndex(2) == null)
			return null;

		return getSlotAsItemStack(2);
	}

	public ItemStack getEarsItemStack() {
		// TODO Auto-generated method stub
		if (getSlotByIndex(3) == null)
			return null;

		return getSlotAsItemStack(3);
	}

	public ItemStack getForearmsItemStack() {
		// TODO Auto-generated method stub
		if (getSlotByIndex(4) == null)
			return null;

		return getSlotAsItemStack(4);
	}

	public ItemStack getArmsItemStack() {
		// TODO Auto-generated method stub
		if (getSlotByIndex(5) == null)
			return null;

		return getSlotAsItemStack(5);
	}

	public ItemStack getHandsItemStack() {
		// TODO Auto-generated method stub
		if (getSlotByIndex(6) == null)
			return null;

		return getSlotAsItemStack(6);
	}

	public ItemStack getWaistItemStack() {
		// TODO Auto-generated method stub
		if (getSlotByIndex(7) == null)
			return null;
		
		

		return getSlotAsItemStack(7);
	}
}
