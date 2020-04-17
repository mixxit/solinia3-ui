package com.solinia.solinia3ui.Guis;

import java.awt.Point;
import java.util.List;

import org.lwjgl.opengl.GL11;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.platform.GlStateManager;
import com.solinia.solinia3ui.ClientState;
import com.solinia.solinia3ui.solinia3ui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class GuiInventorySlotButton extends Button {
	Minecraft minecraft;
	public GuiInventorySlotButton(Minecraft minecraft, int widthIn, int heightIn, int x, int y, String text, Button.IPressable onPress) {
		super(widthIn, heightIn, x, y, text, onPress);
		this.minecraft = minecraft;
		
	}

	protected static final ResourceLocation GUI_SLOTS_TEXTURES = new ResourceLocation(solinia3ui.MOD_ID, "textures/gui/invslots.png");
	private int slotIcon;
	
	@Override
	public void render(int posX, int posY, float partialTicks) {
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
			this.minecraft.getTextureManager().bindTexture(GUI_SLOTS_TEXTURES);
			Point position = getSlotIconPosition(this.slotIcon);
			this.blit(this.x, this.y, position.y,position.x, this.width, this.width-1);
		}
		
		this.renderBg(this.minecraft, posX, posY);
		String displayString = getSlotNameById(this.slotIcon);
		this.drawStringCenteredScale(this.minecraft.fontRenderer, displayString, this.x + this.width /2,this.y + (this.height - 8) + this.minecraft.fontRenderer.FONT_HEIGHT, 0.5f, j);

		if (ClientState.getInstance() == null || ClientState.getInstance().getEquipSlots() == null)
			return;
				
		renderSlotIcon(this.slotIcon);
	}
	
	public void tryRenderItemStackHover(Screen screen, ItemStack itemStack)
	{
		if (itemStack == null)
			return;
		
		try
		{
		
		List<ITextComponent> list = itemStack.getTooltip(this.minecraft.player, this.minecraft.gameSettings.advancedItemTooltips ? ITooltipFlag.TooltipFlags.ADVANCED : ITooltipFlag.TooltipFlags.NORMAL);
	      List<String> list1 = Lists.newArrayList();

	      for(ITextComponent itextcomponent : list) {
	    	  //System.out.println(itextcomponent.getFormattedText());
	         list1.add(itextcomponent.getFormattedText());
	      }
	      
		screen.renderTooltip(list1,
					-300+(int)Math.round(minecraft.mouseHelper.getMouseX() * (double)minecraft.mainWindow.getScaledWidth() / (double)minecraft.mainWindow.getWidth()),
					-75+(int)Math.round(minecraft.mouseHelper.getMouseY() * (double)minecraft.mainWindow.getScaledHeight() / (double)minecraft.mainWindow.getHeight())
				);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public boolean IsMouseOverButton()
	{
		return this.isMouseOver(
				(int)Math.round(this.minecraft.mouseHelper.getMouseX() * (double)this.minecraft.mainWindow.getScaledWidth() / (double)this.minecraft.mainWindow.getWidth()),
				(int)Math.round(this.minecraft.mouseHelper.getMouseY() * (double)this.minecraft.mainWindow.getScaledHeight() / (double)this.minecraft.mainWindow.getHeight()));
				
	}
	
	public ItemStack getItemStack()
	{
		switch(this.slotIcon)
		{
			case 0:
				return ClientState.getInstance().getEquipSlots().getFingersItemStack();
			case 1:
				return ClientState.getInstance().getEquipSlots().getShouldersItemStack();
			case 2:
				return ClientState.getInstance().getEquipSlots().getNeckItemStack();
			case 3:
				return ClientState.getInstance().getEquipSlots().getEarsItemStack();
			case 4:
				return ClientState.getInstance().getEquipSlots().getForearmsItemStack();
			case 5:
				return ClientState.getInstance().getEquipSlots().getArmsItemStack();
			case 6:
				return ClientState.getInstance().getEquipSlots().getHandsItemStack();
			case 7:
				return ClientState.getInstance().getEquipSlots().getWaistItemStack();
			default:
				return null;
		}
	}
	
	public void renderSlotIcon(int slotId)
	{
		switch(slotId)
		{
			case 0:
				if (ClientState.getInstance().getEquipSlots().getFingersItemStack() != null)
				{
					this.minecraft.getItemRenderer().renderItemIntoGUI(ClientState.getInstance().getEquipSlots().getFingersItemStack(),this.minecraft.mainWindow.getScaledWidth()-width*3,20);
				}
				break;
			case 1:
				if (ClientState.getInstance().getEquipSlots().getShouldersItemStack() != null)
				{
					this.minecraft.getItemRenderer().renderItemIntoGUI(ClientState.getInstance().getEquipSlots().getShouldersItemStack(),this.minecraft.mainWindow.getScaledWidth()-width*3,45);
				}
				break;
			case 2:
				if (ClientState.getInstance().getEquipSlots().getNeckItemStack() != null)
				{
					this.minecraft.getItemRenderer().renderItemIntoGUI(ClientState.getInstance().getEquipSlots().getNeckItemStack(),this.minecraft.mainWindow.getScaledWidth()-width*3,70);
				}
			case 3:
				if (ClientState.getInstance().getEquipSlots().getEarsItemStack() != null)
				{
					this.minecraft.getItemRenderer().renderItemIntoGUI(ClientState.getInstance().getEquipSlots().getEarsItemStack(),this.minecraft.mainWindow.getScaledWidth()-width*3,95);
				}
				break;
			case 4:
				if (ClientState.getInstance().getEquipSlots().getForearmsItemStack() != null)
				{
					this.minecraft.getItemRenderer().renderItemIntoGUI(ClientState.getInstance().getEquipSlots().getForearmsItemStack(),this.minecraft.mainWindow.getScaledWidth()-width*3,120);
				}
				break;
			case 5:
				if (ClientState.getInstance().getEquipSlots().getArmsItemStack() != null)
				{
					this.minecraft.getItemRenderer().renderItemIntoGUI(ClientState.getInstance().getEquipSlots().getArmsItemStack(),this.minecraft.mainWindow.getScaledWidth()-width*3,145);
				}
				break;
			case 6:
				if (ClientState.getInstance().getEquipSlots().getHandsItemStack() != null)
				{
					this.minecraft.getItemRenderer().renderItemIntoGUI(ClientState.getInstance().getEquipSlots().getHandsItemStack(),this.minecraft.mainWindow.getScaledWidth()-width*3,170);
				}
				break;
			case 7:
				if (ClientState.getInstance().getEquipSlots().getWaistItemStack() != null)
				{
					this.minecraft.getItemRenderer().renderItemIntoGUI(ClientState.getInstance().getEquipSlots().getWaistItemStack(),this.minecraft.mainWindow.getScaledWidth()-width*3,195);
				}
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
