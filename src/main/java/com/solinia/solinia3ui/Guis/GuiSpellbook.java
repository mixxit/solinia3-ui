package com.solinia.solinia3ui.Guis;

import java.awt.Color;
import java.util.List;

import org.lwjgl.opengl.GL11;

import com.google.common.collect.Lists;
import com.solinia.solinia3ui.ClientState;
import com.solinia.solinia3ui.solinia3ui;
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
	
	//private String screenTitle = "Spellbook";
	public static final ResourceLocation spellbookUi = new ResourceLocation( solinia3ui.MOD_ID, "textures/gui/spellbook.png" );

	public GuiSpellbook(ITextComponent textComponent) {
		super(textComponent);
	}
	
	public SpellbookPage getSpellBookPage()
	{
		return ClientState.getInstance().getSpellbookPage();
	}
	
	@Override
	public void init(Minecraft p_init_1_, int p_init_2_, int p_init_3_) {
		super.init(p_init_1_, p_init_2_, p_init_3_);
		loadGui();
	}

	@Override
	public void render(int posX, int posY, float partialTicks)
    {
		if (this.getSpellBookPage() == null)
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
        
        //this.drawDefaultBackground();
        //this.drawCenteredString(this.fontRenderer, this.screenTitle, this.width / 2, 5, 16777215);
        super.render(posX, posY, partialTicks);
        
        for (Widget button : this.getButtons())
        {
        	try
        	{
	        	if (!(button instanceof GuiSpellIconButton))
	        		continue;

	        	
	        	GuiSpellIconButton spellButton = (GuiSpellIconButton)button;
	        	spellButton.setFGColor(Color.WHITE.getRGB());
	        	if (spellButton.getOnPress() != null)
	        	{
	        		if (ClientState.getInstance().getSelectedSpellSlot() == spellButton.getOnPress().getSpellBookSlotId())
	        		{
	    	        	spellButton.setFGColor(Color.RED.getRGB());
	        		}
	        	}
	        		
	        	if (spellButton.IsMouseOverButton())
	    		{
	    			renderTooltip(spellButton.getPopupText(),
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
	
	public List<Widget> getButtons()
	{
		return this.buttons;
	}
	
	public void loadGui()
	{
		ClientState.getInstance().setSelectedSpellSlot(-1);
		
		if (this.getSpellBookPage() == null)
		{
			ClientState.getInstance().setSelectedSpellSlot(-1);
			// TODO Auto-generated method stub
			Minecraft.getInstance().player.closeScreen();
			return;
		}
		
		int baseX = (width - this.xSize) / 2;
		int baseY = (height - this.ySize) / 2;
		
		this.leftPageButton = null;
		this.spellItemButton1 = null;
		this.spellItemButton2 = null;
		this.spellItemButton3 = null;
		this.spellItemButton4 = null;
		this.spellItemButton5 = null;
		this.spellItemButton6 = null;
		this.spellItemButton7 = null;
		this.spellItemButton8 = null;
		this.spellItemButton9 = null;
		this.spellItemButton10 = null;
		this.spellItemButton11 = null;
		this.spellItemButton12 = null;
		this.spellItemButton13 = null;
		this.spellItemButton14 = null;
		this.spellItemButton15 = null;
		this.spellItemButton16 = null;
		this.closeBookButton = null;
		this.rightPageButton = null;
		this.getButtons().clear();
		
		int previousPageNo = this.getSpellBookPage().PageNo - 1;
		if (previousPageNo < 0)
			previousPageNo = 0;

		int nextPageNo = this.getSpellBookPage().PageNo + 1;
		
		//Page 1
		this.addButton(this.leftPageButton = new Button(baseX + 5,baseY + 70,20,20, "< " + previousPageNo, (button) -> { ClientState.getInstance().tryOpenSpelbookNextPrevious();}));
		
		this.addButton(this.spellItemButton1 = new GuiSpellIconButton(this.minecraft,baseX + 41,baseY + 13,20,20,this.getSpellBookPage().getSlotNewIcon(1)+"^"+this.getSpellBookPage().getSlotName(1)+"^"+this.getSpellBookPage().getSlotLevel(1)+"^"+this.getSpellBookPage().getSlotDescription(1), new GuiSpellIconButtonPressable(1,this.getSpellBookPage().getSlotId(1))));
		this.addButton(this.spellItemButton2 = new GuiSpellIconButton(this.minecraft,baseX + 87,baseY + 13,20,20,this.getSpellBookPage().getSlotNewIcon(2)+"^"+this.getSpellBookPage().getSlotName(2)+"^"+this.getSpellBookPage().getSlotLevel(2)+"^"+this.getSpellBookPage().getSlotDescription(2), new GuiSpellIconButtonPressable(2,this.getSpellBookPage().getSlotId(2))));
		this.addButton(this.spellItemButton3 = new GuiSpellIconButton(this.minecraft,baseX + 41,baseY + 50,20,20,this.getSpellBookPage().getSlotNewIcon(3)+"^"+this.getSpellBookPage().getSlotName(3)+"^"+this.getSpellBookPage().getSlotLevel(3)+"^"+this.getSpellBookPage().getSlotDescription(3), new GuiSpellIconButtonPressable(3,this.getSpellBookPage().getSlotId(3))));
		this.addButton(this.spellItemButton4 = new GuiSpellIconButton(this.minecraft,baseX + 87,baseY + 50,20,20,this.getSpellBookPage().getSlotNewIcon(4)+"^"+this.getSpellBookPage().getSlotName(4)+"^"+this.getSpellBookPage().getSlotLevel(4)+"^"+this.getSpellBookPage().getSlotDescription(4), new GuiSpellIconButtonPressable(4,this.getSpellBookPage().getSlotId(4))));
		this.addButton(this.spellItemButton5 = new GuiSpellIconButton(this.minecraft,baseX + 41,baseY + 86,20,20,this.getSpellBookPage().getSlotNewIcon(5)+"^"+this.getSpellBookPage().getSlotName(5)+"^"+this.getSpellBookPage().getSlotLevel(5)+"^"+this.getSpellBookPage().getSlotDescription(5), new GuiSpellIconButtonPressable(5,this.getSpellBookPage().getSlotId(5))));
		this.addButton(this.spellItemButton6 = new GuiSpellIconButton(this.minecraft,baseX + 87,baseY + 86,20,20,this.getSpellBookPage().getSlotNewIcon(6)+"^"+this.getSpellBookPage().getSlotName(6)+"^"+this.getSpellBookPage().getSlotLevel(6)+"^"+this.getSpellBookPage().getSlotDescription(6), new GuiSpellIconButtonPressable(6,this.getSpellBookPage().getSlotId(6))));
		this.addButton(this.spellItemButton7 = new GuiSpellIconButton(this.minecraft,baseX + 41,baseY + 122,20,20,this.getSpellBookPage().getSlotNewIcon(7)+"^"+this.getSpellBookPage().getSlotName(7)+"^"+this.getSpellBookPage().getSlotLevel(7)+"^"+this.getSpellBookPage().getSlotDescription(7), new GuiSpellIconButtonPressable(7,this.getSpellBookPage().getSlotId(7))));
		this.addButton(this.spellItemButton8 = new GuiSpellIconButton(this.minecraft,baseX + 87,baseY + 122,20,20,this.getSpellBookPage().getSlotNewIcon(8)+"^"+this.getSpellBookPage().getSlotName(8)+"^"+this.getSpellBookPage().getSlotLevel(8)+"^"+this.getSpellBookPage().getSlotDescription(8), new GuiSpellIconButtonPressable(8,this.getSpellBookPage().getSlotId(8))));
		
		//Page 2
		this.addButton(this.spellItemButton9 = new GuiSpellIconButton(this.minecraft,baseX + 148,baseY + 13,20,20,this.getSpellBookPage().getSlotNewIcon(9)+"^"+this.getSpellBookPage().getSlotName(9)+"^"+this.getSpellBookPage().getSlotLevel(9)+"^"+this.getSpellBookPage().getSlotDescription(9), new GuiSpellIconButtonPressable(9,this.getSpellBookPage().getSlotId(9))));
		this.addButton(this.spellItemButton10 = new GuiSpellIconButton(this.minecraft,baseX + 193,baseY + 13,20,20,this.getSpellBookPage().getSlotNewIcon(10)+"^"+this.getSpellBookPage().getSlotName(10)+"^"+this.getSpellBookPage().getSlotLevel(10)+"^"+this.getSpellBookPage().getSlotDescription(10), new GuiSpellIconButtonPressable(10,this.getSpellBookPage().getSlotId(10))));
		this.addButton(this.spellItemButton11 = new GuiSpellIconButton(this.minecraft,baseX + 148,baseY + 50,20,20,this.getSpellBookPage().getSlotNewIcon(11)+"^"+this.getSpellBookPage().getSlotName(11)+"^"+this.getSpellBookPage().getSlotLevel(11)+"^"+this.getSpellBookPage().getSlotDescription(11), new GuiSpellIconButtonPressable(11,this.getSpellBookPage().getSlotId(11))));
		this.addButton(this.spellItemButton12 = new GuiSpellIconButton(this.minecraft,baseX + 193,baseY + 50,20,20,this.getSpellBookPage().getSlotNewIcon(12)+"^"+this.getSpellBookPage().getSlotName(12)+"^"+this.getSpellBookPage().getSlotLevel(12)+"^"+this.getSpellBookPage().getSlotDescription(12), new GuiSpellIconButtonPressable(12,this.getSpellBookPage().getSlotId(12))));
		this.addButton(this.spellItemButton13 = new GuiSpellIconButton(this.minecraft,baseX + 148,baseY + 86,20,20,this.getSpellBookPage().getSlotNewIcon(13)+"^"+this.getSpellBookPage().getSlotName(13)+"^"+this.getSpellBookPage().getSlotLevel(13)+"^"+this.getSpellBookPage().getSlotDescription(13), new GuiSpellIconButtonPressable(13,this.getSpellBookPage().getSlotId(13))));
		this.addButton(this.spellItemButton14 = new GuiSpellIconButton(this.minecraft,baseX + 193,baseY + 86,20,20,this.getSpellBookPage().getSlotNewIcon(14)+"^"+this.getSpellBookPage().getSlotName(14)+"^"+this.getSpellBookPage().getSlotLevel(14)+"^"+this.getSpellBookPage().getSlotDescription(14), new GuiSpellIconButtonPressable(14,this.getSpellBookPage().getSlotId(14))));
		this.addButton(this.spellItemButton15 = new GuiSpellIconButton(this.minecraft,baseX + 148,baseY + 122,20,20,this.getSpellBookPage().getSlotNewIcon(15)+"^"+this.getSpellBookPage().getSlotName(15)+"^"+this.getSpellBookPage().getSlotLevel(15)+"^"+this.getSpellBookPage().getSlotDescription(15), new GuiSpellIconButtonPressable(15,this.getSpellBookPage().getSlotId(15))));
		this.addButton(this.spellItemButton16 = new GuiSpellIconButton(this.minecraft,baseX + 193,baseY + 122,20,20,this.getSpellBookPage().getSlotNewIcon(16)+"^"+this.getSpellBookPage().getSlotName(16)+"^"+this.getSpellBookPage().getSlotLevel(16)+"^"+this.getSpellBookPage().getSlotDescription(16), new GuiSpellIconButtonPressable(16,this.getSpellBookPage().getSlotId(16))));

		this.addButton(this.closeBookButton = new Button(baseX + 223,baseY + 3,10,10, "x", new GuiSpellCloseBookButtonPressable()));
		this.addButton(this.rightPageButton = new Button( baseX + 230,baseY + 70,20,20,nextPageNo + " >", (button) -> {	ClientState.getInstance().tryOpenSpelbookNextPage();}));
	}

	public int getSelectedSpellId() {
		return this.getSpellBookPage().getSlotId(ClientState.getInstance().getSelectedSpellSlot());
	}

	public void updatePage() {
		ClientState.getInstance().setSelectedSpellSlot(-1);
		this.loadGui();
	}
}
