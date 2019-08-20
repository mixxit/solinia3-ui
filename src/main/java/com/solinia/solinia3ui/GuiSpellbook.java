package com.solinia.solinia3ui;

import net.minecraft.client.gui.screen.Screen;
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
	private SpellBookData _spellbookData;
	public static final ResourceLocation spellbookUi = new ResourceLocation( "solinia3ui", "textures/gui/spellbook.png" );

	public GuiSpellbook(ITextComponent textComponent, SpellBookData spellBookData) {
		super(textComponent);
		this._spellbookData = spellBookData;
	}

	@Override
	public void render(int mouseX, int mouseY, float partialTicks)
    {
        getMinecraft().getTextureManager().bindTexture(spellbookUi);
        int x = (width - this.xSize) / 2;
		int y = (height - this.ySize) / 2;
		blit(x, y, 0, 0, this.xSize, this.ySize);
		loadGui();
        
        //this.drawDefaultBackground();
        //this.drawCenteredString(this.fontRenderer, this.screenTitle, this.width / 2, 5, 16777215);
        super.render(mouseX, mouseY, partialTicks);
    }
	
	public String getSpellName(int spellSlot)
	{
		switch(spellSlot)
		{
			case 1:
				return this._spellbookData.SpellSlot1Name;
			case 2:
				return this._spellbookData.SpellSlot2Name;
			case 3:
				return this._spellbookData.SpellSlot3Name;
			case 4:
				return this._spellbookData.SpellSlot4Name;
			case 5:
				return this._spellbookData.SpellSlot5Name;
			case 6:
				return this._spellbookData.SpellSlot6Name;
			case 7:
				return this._spellbookData.SpellSlot7Name;
			case 8:
				return this._spellbookData.SpellSlot8Name;
			case 9:
				return this._spellbookData.SpellSlot9Name;
			case 10:
				return this._spellbookData.SpellSlot10Name;
			case 11:
				return this._spellbookData.SpellSlot11Name;
			case 12:
				return this._spellbookData.SpellSlot12Name;
			case 13:
				return this._spellbookData.SpellSlot13Name;
			case 14:
				return this._spellbookData.SpellSlot14Name;
			case 15:
				return this._spellbookData.SpellSlot15Name;
			case 16:
				return this._spellbookData.SpellSlot16Name;
			default:
				return "";
		}
	}
	
	public int getSpellIcon(int spellSlot)
	{
		switch(spellSlot)
		{
			case 1:
				return this._spellbookData.SpellSlot1Icon;
			case 2:
				return this._spellbookData.SpellSlot2Icon;
			case 3:
				return this._spellbookData.SpellSlot3Icon;
			case 4:
				return this._spellbookData.SpellSlot4Icon;
			case 5:
				return this._spellbookData.SpellSlot5Icon;
			case 6:
				return this._spellbookData.SpellSlot6Icon;
			case 7:
				return this._spellbookData.SpellSlot7Icon;
			case 8:
				return this._spellbookData.SpellSlot8Icon;
			case 9:
				return this._spellbookData.SpellSlot9Icon;
			case 10:
				return this._spellbookData.SpellSlot10Icon;
			case 11:
				return this._spellbookData.SpellSlot11Icon;
			case 12:
				return this._spellbookData.SpellSlot12Icon;
			case 13:
				return this._spellbookData.SpellSlot13Icon;
			case 14:
				return this._spellbookData.SpellSlot14Icon;
			case 15:
				return this._spellbookData.SpellSlot15Icon;
			case 16:
				return this._spellbookData.SpellSlot16Icon;
			default:
				return 0;
		}
	}
	
	public int getNewIcon(int spellSlot)
	{
		switch(spellSlot)
		{
			case 1:
				return this._spellbookData.SpellSlot1NewIcon;
			case 2:
				return this._spellbookData.SpellSlot2NewIcon;
			case 3:
				return this._spellbookData.SpellSlot3NewIcon;
			case 4:
				return this._spellbookData.SpellSlot4NewIcon;
			case 5:
				return this._spellbookData.SpellSlot5NewIcon;
			case 6:
				return this._spellbookData.SpellSlot6NewIcon;
			case 7:
				return this._spellbookData.SpellSlot7NewIcon;
			case 8:
				return this._spellbookData.SpellSlot8NewIcon;
			case 9:
				return this._spellbookData.SpellSlot9NewIcon;
			case 10:
				return this._spellbookData.SpellSlot10NewIcon;
			case 11:
				return this._spellbookData.SpellSlot11NewIcon;
			case 12:
				return this._spellbookData.SpellSlot12NewIcon;
			case 13:
				return this._spellbookData.SpellSlot13NewIcon;
			case 14:
				return this._spellbookData.SpellSlot14NewIcon;
			case 15:
				return this._spellbookData.SpellSlot15NewIcon;
			case 16:
				return this._spellbookData.SpellSlot16NewIcon;
			default:
				return 0;
		}
	} 
	
	public void loadGui()
	{
		int baseX = (width - this.xSize) / 2;
		int baseY = (height - this.ySize) / 2;
		
		this.buttons.clear();
		
		int previousPageNo = this._spellbookData.PageNo - 1;
		if (previousPageNo < 0)
			previousPageNo = 0;

		int nextPageNo = this._spellbookData.PageNo + 1;

		//Page 1
		this.addButton(this.leftPageButton = new Button(baseX + 5,baseY + 70,20,20, "< " + previousPageNo, null));
		
		this.addButton(this.spellItemButton1 = new GuiSpellIconButton(baseX + 41,baseY + 13,20,20,getNewIcon(1)+"^"+getSpellName(1), new GuiSpellIconButtonPressable()));
		this.addButton(this.spellItemButton2 = new GuiSpellIconButton(baseX + 87,baseY + 13,20,20,getNewIcon(2)+"^"+getSpellName(2), new GuiSpellIconButtonPressable()));
		this.addButton(this.spellItemButton3 = new GuiSpellIconButton(baseX + 41,baseY + 50,20,20,getNewIcon(3)+"^"+getSpellName(3), new GuiSpellIconButtonPressable()));
		this.addButton(this.spellItemButton4 = new GuiSpellIconButton(baseX + 87,baseY + 50,20,20,getNewIcon(4)+"^"+getSpellName(4), new GuiSpellIconButtonPressable()));
		this.addButton(this.spellItemButton5 = new GuiSpellIconButton(baseX + 41,baseY + 86,20,20,getNewIcon(5)+"^"+getSpellName(5), new GuiSpellIconButtonPressable()));
		this.addButton(this.spellItemButton6 = new GuiSpellIconButton(baseX + 87,baseY + 86,20,20,getNewIcon(6)+"^"+getSpellName(6), new GuiSpellIconButtonPressable()));
		this.addButton(this.spellItemButton7 = new GuiSpellIconButton(baseX + 41,baseY + 122,20,20,getNewIcon(7)+"^"+getSpellName(7), new GuiSpellIconButtonPressable()));
		this.addButton(this.spellItemButton8 = new GuiSpellIconButton(baseX + 87,baseY + 122,20,20,getNewIcon(8)+"^"+getSpellName(8), new GuiSpellIconButtonPressable()));
		
		//Page 2
		this.addButton(this.spellItemButton9 = new GuiSpellIconButton(baseX + 148,baseY + 13,20,20,getNewIcon(9)+"^"+getSpellName(9), new GuiSpellIconButtonPressable()));
		this.addButton(this.spellItemButton10 = new GuiSpellIconButton(baseX + 193,baseY + 13,20,20,getNewIcon(10)+"^"+getSpellName(10), new GuiSpellIconButtonPressable()));
		this.addButton(this.spellItemButton11 = new GuiSpellIconButton(baseX + 148,baseY + 50,20,20,getNewIcon(11)+"^"+getSpellName(11), new GuiSpellIconButtonPressable()));
		this.addButton(this.spellItemButton12 = new GuiSpellIconButton(baseX + 193,baseY + 50,20,20,getNewIcon(12)+"^"+getSpellName(12), new GuiSpellIconButtonPressable()));
		this.addButton(this.spellItemButton13 = new GuiSpellIconButton(baseX + 148,baseY + 86,20,20,getNewIcon(13)+"^"+getSpellName(13), new GuiSpellIconButtonPressable()));
		this.addButton(this.spellItemButton14 = new GuiSpellIconButton(baseX + 193,baseY + 86,20,20,getNewIcon(14)+"^"+getSpellName(14), new GuiSpellIconButtonPressable()));
		this.addButton(this.spellItemButton15 = new GuiSpellIconButton(baseX + 148,baseY + 122,20,20,getNewIcon(15)+"^"+getSpellName(15), new GuiSpellIconButtonPressable()));
		this.addButton(this.spellItemButton16 = new GuiSpellIconButton(baseX + 193,baseY + 122,20,20,getNewIcon(16)+"^"+getSpellName(16), new GuiSpellIconButtonPressable()));

		this.addButton(this.closeBookButton = new Button(baseX + 223,baseY + 3,10,10, "x", new GuiSpellCloseBookButtonPressable()));
		
		this.addButton(this.rightPageButton = new Button( baseX + 230,baseY + 70,20,20,nextPageNo + " >", new GuiSpellChangePageButtonPressable()));
	}
}
