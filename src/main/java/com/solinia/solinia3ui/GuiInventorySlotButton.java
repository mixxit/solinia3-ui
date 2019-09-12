package com.solinia.solinia3ui;

import java.awt.Point;

import org.lwjgl.opengl.GL11;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;

public class GuiInventorySlotButton extends Button {
	public GuiInventorySlotButton(int widthIn, int heightIn, int x, int y, String text, Button.IPressable onPress) {
		super(widthIn, heightIn, x, y, text, onPress);
	}

	protected static final ResourceLocation GUI_SLOTS_TEXTURES = new ResourceLocation("solinia3ui", "textures/gui/invslots.png");
	private int slotIcon;
	
	@Override
	public void render(int mouseX, int mouseY, float partialTicks) {
		if (!this.visible)
			return;
		
		if (getMessage().isEmpty())
			return;
		
		String displayIconStr = this.getMessage();
		try
		{
			this.slotIcon = Integer.parseInt(displayIconStr);
		} catch (Exception e)
		{
			return;
		}
		
		int j = 14737632;
		if (packedFGColor != 0) {
			j = packedFGColor;
		} else if (!this.active) {
			j = 10526880;
		} else if (this.isHovered()) {
			j = 16777120;
		}
		
		GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		
		if (this.slotIcon > -1)
		{
			Minecraft.getInstance().getTextureManager().bindTexture(GUI_SLOTS_TEXTURES);
			Point position = getSlotIconPosition(this.slotIcon);
			this.blit(this.x, this.y, position.y,position.x, this.width, this.width-1);
		}
		
		this.renderBg(Minecraft.getInstance(), mouseX, mouseY);
		String displayString = getSlotNameById(this.slotIcon);
		this.drawStringCenteredScale(Minecraft.getInstance().fontRenderer, displayString, this.x + this.width /2,this.y + (this.height - 8) + Minecraft.getInstance().fontRenderer.FONT_HEIGHT, 0.5f, j);

		if (ClientState.getInstance() == null || ClientState.getInstance().getEquipSlots() == null)
			return;
				
		net.minecraft.client.renderer.ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
		
		renderSlotIcon(this.slotIcon);
		
	}
	
	public void renderSlotIcon(int slotId)
	{
		switch(slotId)
		{
			case 0:
				if (ClientState.getInstance().getEquipSlots().getFingersItemStack() != null)
					Minecraft.getInstance().getItemRenderer().renderItemIntoGUI(ClientState.getInstance().getEquipSlots().getFingersItemStack(),Minecraft.getInstance().mainWindow.getScaledWidth()-width*3,20);
				break;
			case 1:
				if (ClientState.getInstance().getEquipSlots().getShouldersItemStack() != null)
					Minecraft.getInstance().getItemRenderer().renderItemIntoGUI(ClientState.getInstance().getEquipSlots().getShouldersItemStack(),Minecraft.getInstance().mainWindow.getScaledWidth()-width*3,45);
				break;
			case 2:
				if (ClientState.getInstance().getEquipSlots().getNeckItemStack() != null)
					Minecraft.getInstance().getItemRenderer().renderItemIntoGUI(ClientState.getInstance().getEquipSlots().getNeckItemStack(),Minecraft.getInstance().mainWindow.getScaledWidth()-width*3,70);
			case 3:
				if (ClientState.getInstance().getEquipSlots().getEarsItemStack() != null)
					Minecraft.getInstance().getItemRenderer().renderItemIntoGUI(ClientState.getInstance().getEquipSlots().getEarsItemStack(),Minecraft.getInstance().mainWindow.getScaledWidth()-width*3,95);
				break;
			case 4:
				if (ClientState.getInstance().getEquipSlots().getForearmsItemStack() != null)
					Minecraft.getInstance().getItemRenderer().renderItemIntoGUI(ClientState.getInstance().getEquipSlots().getForearmsItemStack(),Minecraft.getInstance().mainWindow.getScaledWidth()-width*3,120);
				break;
			case 5:
				if (ClientState.getInstance().getEquipSlots().getArmsItemStack() != null)
					Minecraft.getInstance().getItemRenderer().renderItemIntoGUI(ClientState.getInstance().getEquipSlots().getArmsItemStack(),Minecraft.getInstance().mainWindow.getScaledWidth()-width*3,145);
				break;
			case 6:
				if (ClientState.getInstance().getEquipSlots().getHandsItemStack() != null)
					Minecraft.getInstance().getItemRenderer().renderItemIntoGUI(ClientState.getInstance().getEquipSlots().getHandsItemStack(),Minecraft.getInstance().mainWindow.getScaledWidth()-width*3,170);
				break;
			case 7:
				if (ClientState.getInstance().getEquipSlots().getWaistItemStack() != null)
					Minecraft.getInstance().getItemRenderer().renderItemIntoGUI(ClientState.getInstance().getEquipSlots().getWaistItemStack(),Minecraft.getInstance().mainWindow.getScaledWidth()-width*3,195);
				break;
			default:
				break;
		}
	}
	
	private Point getSlotIconPosition(int slotIconId) {
		int slotSize = 20;
		switch(slotIconId)
		{
			case 0:
				return new Point(2*slotSize,1*slotSize); // FINGER 3x2
			case 1:
				return new Point(1*slotSize,0*slotSize); // SHOULDER 2x1
			case 2:
				return new Point(0*slotSize,1*slotSize); // NECK 1x2
			case 3:
				return new Point(0*slotSize,0*slotSize); // EAR 1x1
			case 4:
				return new Point(1*slotSize,3*slotSize); // FOREARMS 2x4
			case 5:
				return new Point(1*slotSize,1*slotSize); // ARMS 2x2
			case 6:
				return new Point(2*slotSize,0*slotSize); // HANDS 3x1
			case 7:
				return new Point(1*slotSize,4*slotSize); // WAIST 2x5
			default:
				return new Point(2*slotSize,1*slotSize); // FINGER 3x2
		}
	}


	public String getSlotNameById(int slotId)
	{
		switch(slotId)
		{
		case 0:
			return "Fingers";
		case 1:
			return "Shoulders";
		case 2:
			return "Neck";
		case 3:
			return "Ears";
		case 4:
			return "Forearms";
		case 5:
			return "Arms";
		case 6:
			return "Hands";
		case 7:
			return "Waist";
			default:
				return "";
				
		}
	}
	
	public void drawStringCenteredScale(FontRenderer fontRendererIn, String text, int x, int y, float size, int color) {
        GL11.glScalef(size,size,size);
        float mSize = (float)Math.pow(size,-1);
        this.drawCenteredString(fontRendererIn,text,Math.round(x / size),Math.round(y / size),color);
        GL11.glScalef(mSize,mSize,mSize);
    }
}
