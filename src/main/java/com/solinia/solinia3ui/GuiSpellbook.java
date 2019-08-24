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
		this.addButton(this.leftPageButton = new Button(baseX + 5,baseY + 70,20,20, "< " + previousPageNo, new GuiSpellChangePageButtonPressable()));
		
		this.addButton(this.spellItemButton1 = new GuiSpellIconButton(baseX + 41,baseY + 13,20,20,this._spellbookData.getNewIcon(1)+"^"+this._spellbookData.getSpellName(1), new GuiSpellIconButtonPressable(1,this._spellbookData.getSpellId(1))));
		this.addButton(this.spellItemButton2 = new GuiSpellIconButton(baseX + 87,baseY + 13,20,20,this._spellbookData.getNewIcon(2)+"^"+this._spellbookData.getSpellName(2), new GuiSpellIconButtonPressable(2,this._spellbookData.getSpellId(2))));
		this.addButton(this.spellItemButton3 = new GuiSpellIconButton(baseX + 41,baseY + 50,20,20,this._spellbookData.getNewIcon(3)+"^"+this._spellbookData.getSpellName(3), new GuiSpellIconButtonPressable(3,this._spellbookData.getSpellId(3))));
		this.addButton(this.spellItemButton4 = new GuiSpellIconButton(baseX + 87,baseY + 50,20,20,this._spellbookData.getNewIcon(4)+"^"+this._spellbookData.getSpellName(4), new GuiSpellIconButtonPressable(4,this._spellbookData.getSpellId(4))));
		this.addButton(this.spellItemButton5 = new GuiSpellIconButton(baseX + 41,baseY + 86,20,20,this._spellbookData.getNewIcon(5)+"^"+this._spellbookData.getSpellName(5), new GuiSpellIconButtonPressable(5,this._spellbookData.getSpellId(5))));
		this.addButton(this.spellItemButton6 = new GuiSpellIconButton(baseX + 87,baseY + 86,20,20,this._spellbookData.getNewIcon(6)+"^"+this._spellbookData.getSpellName(6), new GuiSpellIconButtonPressable(6,this._spellbookData.getSpellId(6))));
		this.addButton(this.spellItemButton7 = new GuiSpellIconButton(baseX + 41,baseY + 122,20,20,this._spellbookData.getNewIcon(7)+"^"+this._spellbookData.getSpellName(7), new GuiSpellIconButtonPressable(7,this._spellbookData.getSpellId(7))));
		this.addButton(this.spellItemButton8 = new GuiSpellIconButton(baseX + 87,baseY + 122,20,20,this._spellbookData.getNewIcon(8)+"^"+this._spellbookData.getSpellName(8), new GuiSpellIconButtonPressable(8,this._spellbookData.getSpellId(8))));
		
		//Page 2
		this.addButton(this.spellItemButton9 = new GuiSpellIconButton(baseX + 148,baseY + 13,20,20,this._spellbookData.getNewIcon(9)+"^"+this._spellbookData.getSpellName(9), new GuiSpellIconButtonPressable(9,this._spellbookData.getSpellId(9))));
		this.addButton(this.spellItemButton10 = new GuiSpellIconButton(baseX + 193,baseY + 13,20,20,this._spellbookData.getNewIcon(10)+"^"+this._spellbookData.getSpellName(10), new GuiSpellIconButtonPressable(10,this._spellbookData.getSpellId(10))));
		this.addButton(this.spellItemButton11 = new GuiSpellIconButton(baseX + 148,baseY + 50,20,20,this._spellbookData.getNewIcon(11)+"^"+this._spellbookData.getSpellName(11), new GuiSpellIconButtonPressable(11,this._spellbookData.getSpellId(11))));
		this.addButton(this.spellItemButton12 = new GuiSpellIconButton(baseX + 193,baseY + 50,20,20,this._spellbookData.getNewIcon(12)+"^"+this._spellbookData.getSpellName(12), new GuiSpellIconButtonPressable(12,this._spellbookData.getSpellId(12))));
		this.addButton(this.spellItemButton13 = new GuiSpellIconButton(baseX + 148,baseY + 86,20,20,this._spellbookData.getNewIcon(13)+"^"+this._spellbookData.getSpellName(13), new GuiSpellIconButtonPressable(13,this._spellbookData.getSpellId(13))));
		this.addButton(this.spellItemButton14 = new GuiSpellIconButton(baseX + 193,baseY + 86,20,20,this._spellbookData.getNewIcon(14)+"^"+this._spellbookData.getSpellName(14), new GuiSpellIconButtonPressable(14,this._spellbookData.getSpellId(14))));
		this.addButton(this.spellItemButton15 = new GuiSpellIconButton(baseX + 148,baseY + 122,20,20,this._spellbookData.getNewIcon(15)+"^"+this._spellbookData.getSpellName(15), new GuiSpellIconButtonPressable(15,this._spellbookData.getSpellId(15))));
		this.addButton(this.spellItemButton16 = new GuiSpellIconButton(baseX + 193,baseY + 122,20,20,this._spellbookData.getNewIcon(16)+"^"+this._spellbookData.getSpellName(16), new GuiSpellIconButtonPressable(16,this._spellbookData.getSpellId(16))));

		this.addButton(this.closeBookButton = new Button(baseX + 223,baseY + 3,10,10, "x", new GuiSpellCloseBookButtonPressable()));
		
		this.addButton(this.rightPageButton = new Button( baseX + 230,baseY + 70,20,20,nextPageNo + " >", new GuiSpellChangePageButtonPressable()));
	}

	public int getSelectedSpellId() {
		return this._spellbookData.getSpellId(ClientState.getInstance().getSelectedSpellSlot());
	}
}
