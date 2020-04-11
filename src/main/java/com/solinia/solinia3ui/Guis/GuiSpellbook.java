package com.solinia.solinia3ui.Guis;

import java.util.List;

import com.google.common.collect.Lists;
import com.solinia.solinia3ui.ClientState;
import com.solinia.solinia3ui.Models.SpellbookPage;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class GuiSpellbook extends Screen {
	protected final int xSize = 256;
	protected final int ySize = 168;
	
	private Button spellItemButton1;
	private Button spellItemButton2;
	private Button spellItemButton3;
	private Button spellItemButton4;
	private Button spellItemButton5;
	private Button spellItemButton6;
	private Button spellItemButton7;
	private Button spellItemButton8;
	private Button spellItemButton9;
	private Button spellItemButton10;
	private Button spellItemButton11;
	private Button spellItemButton12;
	private Button spellItemButton13;
	private Button spellItemButton14;
	private Button spellItemButton15;
	private Button spellItemButton16;

	private Button leftPageButton;
	private Button rightPageButton;
	private Button closeBookButton;
	
	private String screenTitle = "Spellbook";
	private SpellbookPage _SpellbookPage;
	public static final ResourceLocation spellbookUi = new ResourceLocation( "solinia3ui", "textures/gui/spellbook.png" );

	public GuiSpellbook(ITextComponent textComponent, SpellbookPage SpellbookPage) {
		super(textComponent);
		this._SpellbookPage = SpellbookPage;
	}

	@Override
	public void render(int posX, int posY, float partialTicks)
    {
		if (this._SpellbookPage == null)
		{
			ClientState.getInstance().setSelectedSpellSlot(-1);
			// TODO Auto-generated method stub
			Minecraft.getInstance().player.closeScreen();
			return;
		}
		
        getMinecraft().getTextureManager().bindTexture(spellbookUi);
        int x = (width - this.xSize) / 2;
		int y = (height - this.ySize) / 2;
		blit(x, y, 0, 0, this.xSize, this.ySize);
		loadGui();
        
        //this.drawDefaultBackground();
        //this.drawCenteredString(this.fontRenderer, this.screenTitle, this.width / 2, 5, 16777215);
        super.render(posX, posY, partialTicks);
        
        for (Widget button : this.buttons)
        {
        	try
        	{
	        	if (!(button instanceof GuiSpellIconButton))
	        		continue;
	        	
	        	GuiSpellIconButton spellButton = (GuiSpellIconButton)button;
	        	
	        	if (spellButton.IsMouseOverButton())
	    		{
	    			//List<ITextComponent> list = itemStack.getTooltip(this.minecraft.player, this.minecraft.gameSettings.advancedItemTooltips ? ITooltipFlag.TooltipFlags.ADVANCED : ITooltipFlag.TooltipFlags.NORMAL);
	    		      List<String> list1 = Lists.newArrayList();
	
	    		      /*for(ITextComponent itextcomponent : list) {
	    		         list1.add(itextcomponent.getFormattedText().replace("Â", ""));
	    		      }*/
	    		      list1.add(button.getMessage().split("\\^",-1)[1]);
	    		      list1.add("Level: " + button.getMessage().split("\\^",-1)[2]);
	    		      if (button.getMessage().split("\\^",-1).length > 3)
	    		    	  list1.add(button.getMessage().split("\\^",-1)[3]);
    		    	  list1.add("-------------------");
    		    	  list1.add("To memorise, left click this icon then");
    		    	  list1.add("left click in a memory slot in the top left");
	    		      
	    			minecraft.currentScreen.renderTooltip(list1,
	    						(int)Math.round(minecraft.mouseHelper.getMouseX() * (double)minecraft.mainWindow.getScaledWidth() / (double)minecraft.mainWindow.getWidth()),
	    						(int)Math.round(minecraft.mouseHelper.getMouseY() * (double)minecraft.mainWindow.getScaledHeight() / (double)minecraft.mainWindow.getHeight())
	    					);
	    		}
        	} catch (Exception e)
        	{
        		e.printStackTrace();
        	}
        }
    }
	
	
	public void loadGui()
	{
		if (this._SpellbookPage == null)
		{
			ClientState.getInstance().setSelectedSpellSlot(-1);
			// TODO Auto-generated method stub
			Minecraft.getInstance().player.closeScreen();
			return;
		}
		
		int baseX = (width - this.xSize) / 2;
		int baseY = (height - this.ySize) / 2;
		
		this.buttons.clear();
		
		int previousPageNo = this._SpellbookPage.PageNo - 1;
		if (previousPageNo < 0)
			previousPageNo = 0;

		int nextPageNo = this._SpellbookPage.PageNo + 1;

		//Page 1
		this.addButton(this.leftPageButton = new Button(baseX + 5,baseY + 70,20,20, "< " + previousPageNo, new GuiSpellChangePageButtonPressable()));
		
		this.addButton(this.spellItemButton1 = new GuiSpellIconButton(this.minecraft,baseX + 41,baseY + 13,20,20,this._SpellbookPage.getSlotNewIcon(1)+"^"+this._SpellbookPage.getSlotName(1)+"^"+this._SpellbookPage.getSlotLevel(1)+"^"+this._SpellbookPage.getSlotDescription(1), new GuiSpellIconButtonPressable(1,this._SpellbookPage.getSlotId(1))));
		this.addButton(this.spellItemButton2 = new GuiSpellIconButton(this.minecraft,baseX + 87,baseY + 13,20,20,this._SpellbookPage.getSlotNewIcon(2)+"^"+this._SpellbookPage.getSlotName(2)+"^"+this._SpellbookPage.getSlotLevel(2)+"^"+this._SpellbookPage.getSlotDescription(2), new GuiSpellIconButtonPressable(2,this._SpellbookPage.getSlotId(2))));
		this.addButton(this.spellItemButton3 = new GuiSpellIconButton(this.minecraft,baseX + 41,baseY + 50,20,20,this._SpellbookPage.getSlotNewIcon(3)+"^"+this._SpellbookPage.getSlotName(3)+"^"+this._SpellbookPage.getSlotLevel(3)+"^"+this._SpellbookPage.getSlotDescription(3), new GuiSpellIconButtonPressable(3,this._SpellbookPage.getSlotId(3))));
		this.addButton(this.spellItemButton4 = new GuiSpellIconButton(this.minecraft,baseX + 87,baseY + 50,20,20,this._SpellbookPage.getSlotNewIcon(4)+"^"+this._SpellbookPage.getSlotName(4)+"^"+this._SpellbookPage.getSlotLevel(4)+"^"+this._SpellbookPage.getSlotDescription(4), new GuiSpellIconButtonPressable(4,this._SpellbookPage.getSlotId(4))));
		this.addButton(this.spellItemButton5 = new GuiSpellIconButton(this.minecraft,baseX + 41,baseY + 86,20,20,this._SpellbookPage.getSlotNewIcon(5)+"^"+this._SpellbookPage.getSlotName(5)+"^"+this._SpellbookPage.getSlotLevel(5)+"^"+this._SpellbookPage.getSlotDescription(5), new GuiSpellIconButtonPressable(5,this._SpellbookPage.getSlotId(5))));
		this.addButton(this.spellItemButton6 = new GuiSpellIconButton(this.minecraft,baseX + 87,baseY + 86,20,20,this._SpellbookPage.getSlotNewIcon(6)+"^"+this._SpellbookPage.getSlotName(6)+"^"+this._SpellbookPage.getSlotLevel(6)+"^"+this._SpellbookPage.getSlotDescription(6), new GuiSpellIconButtonPressable(6,this._SpellbookPage.getSlotId(6))));
		this.addButton(this.spellItemButton7 = new GuiSpellIconButton(this.minecraft,baseX + 41,baseY + 122,20,20,this._SpellbookPage.getSlotNewIcon(7)+"^"+this._SpellbookPage.getSlotName(7)+"^"+this._SpellbookPage.getSlotLevel(7)+"^"+this._SpellbookPage.getSlotDescription(7), new GuiSpellIconButtonPressable(7,this._SpellbookPage.getSlotId(7))));
		this.addButton(this.spellItemButton8 = new GuiSpellIconButton(this.minecraft,baseX + 87,baseY + 122,20,20,this._SpellbookPage.getSlotNewIcon(8)+"^"+this._SpellbookPage.getSlotName(8)+"^"+this._SpellbookPage.getSlotLevel(8)+"^"+this._SpellbookPage.getSlotDescription(8), new GuiSpellIconButtonPressable(8,this._SpellbookPage.getSlotId(8))));
		
		//Page 2
		this.addButton(this.spellItemButton9 = new GuiSpellIconButton(this.minecraft,baseX + 148,baseY + 13,20,20,this._SpellbookPage.getSlotNewIcon(9)+"^"+this._SpellbookPage.getSlotName(9)+"^"+this._SpellbookPage.getSlotLevel(9)+"^"+this._SpellbookPage.getSlotDescription(9), new GuiSpellIconButtonPressable(9,this._SpellbookPage.getSlotId(9))));
		this.addButton(this.spellItemButton10 = new GuiSpellIconButton(this.minecraft,baseX + 193,baseY + 13,20,20,this._SpellbookPage.getSlotNewIcon(10)+"^"+this._SpellbookPage.getSlotName(10)+"^"+this._SpellbookPage.getSlotLevel(10)+"^"+this._SpellbookPage.getSlotDescription(10), new GuiSpellIconButtonPressable(10,this._SpellbookPage.getSlotId(10))));
		this.addButton(this.spellItemButton11 = new GuiSpellIconButton(this.minecraft,baseX + 148,baseY + 50,20,20,this._SpellbookPage.getSlotNewIcon(11)+"^"+this._SpellbookPage.getSlotName(11)+"^"+this._SpellbookPage.getSlotLevel(11)+"^"+this._SpellbookPage.getSlotDescription(11), new GuiSpellIconButtonPressable(11,this._SpellbookPage.getSlotId(11))));
		this.addButton(this.spellItemButton12 = new GuiSpellIconButton(this.minecraft,baseX + 193,baseY + 50,20,20,this._SpellbookPage.getSlotNewIcon(12)+"^"+this._SpellbookPage.getSlotName(12)+"^"+this._SpellbookPage.getSlotLevel(12)+"^"+this._SpellbookPage.getSlotDescription(12), new GuiSpellIconButtonPressable(12,this._SpellbookPage.getSlotId(12))));
		this.addButton(this.spellItemButton13 = new GuiSpellIconButton(this.minecraft,baseX + 148,baseY + 86,20,20,this._SpellbookPage.getSlotNewIcon(13)+"^"+this._SpellbookPage.getSlotName(13)+"^"+this._SpellbookPage.getSlotLevel(13)+"^"+this._SpellbookPage.getSlotDescription(13), new GuiSpellIconButtonPressable(13,this._SpellbookPage.getSlotId(13))));
		this.addButton(this.spellItemButton14 = new GuiSpellIconButton(this.minecraft,baseX + 193,baseY + 86,20,20,this._SpellbookPage.getSlotNewIcon(14)+"^"+this._SpellbookPage.getSlotName(14)+"^"+this._SpellbookPage.getSlotLevel(14)+"^"+this._SpellbookPage.getSlotDescription(14), new GuiSpellIconButtonPressable(14,this._SpellbookPage.getSlotId(14))));
		this.addButton(this.spellItemButton15 = new GuiSpellIconButton(this.minecraft,baseX + 148,baseY + 122,20,20,this._SpellbookPage.getSlotNewIcon(15)+"^"+this._SpellbookPage.getSlotName(15)+"^"+this._SpellbookPage.getSlotLevel(15)+"^"+this._SpellbookPage.getSlotDescription(15), new GuiSpellIconButtonPressable(15,this._SpellbookPage.getSlotId(15))));
		this.addButton(this.spellItemButton16 = new GuiSpellIconButton(this.minecraft,baseX + 193,baseY + 122,20,20,this._SpellbookPage.getSlotNewIcon(16)+"^"+this._SpellbookPage.getSlotName(16)+"^"+this._SpellbookPage.getSlotLevel(16)+"^"+this._SpellbookPage.getSlotDescription(16), new GuiSpellIconButtonPressable(16,this._SpellbookPage.getSlotId(16))));

		this.addButton(this.closeBookButton = new Button(baseX + 223,baseY + 3,10,10, "x", new GuiSpellCloseBookButtonPressable()));
		
		this.addButton(this.rightPageButton = new Button( baseX + 230,baseY + 70,20,20,nextPageNo + " >", new GuiSpellChangePageButtonPressable()));
	}

	public int getSelectedSpellId() {
		return this._SpellbookPage.getSlotId(ClientState.getInstance().getSelectedSpellSlot());
	}
}
