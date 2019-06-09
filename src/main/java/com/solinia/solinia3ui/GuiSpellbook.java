package com.solinia.solinia3ui;

import java.util.Arrays;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiLabel;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class GuiSpellbook extends GuiScreen {
	protected final int xSize = 256;
	protected final int ySize = 168;
	
	private GuiSpellIconButton spellItemButton1;
	private GuiSpellIconButton spellItemButton2;
	private GuiSpellIconButton spellItemButton3;
	private GuiSpellIconButton spellItemButton4;
	private GuiSpellIconButton spellItemButton5;
	private GuiSpellIconButton spellItemButton6;
	private GuiSpellIconButton spellItemButton7;
	private GuiSpellIconButton spellItemButton8;
	private GuiSpellIconButton spellItemButton9;
	private GuiSpellIconButton spellItemButton10;
	private GuiSpellIconButton spellItemButton11;
	private GuiSpellIconButton spellItemButton12;
	private GuiSpellIconButton spellItemButton13;
	private GuiSpellIconButton spellItemButton14;
	private GuiSpellIconButton spellItemButton15;
	private GuiSpellIconButton spellItemButton16;
	
	private String screenTitle = "Spellbook";
	private SpellBookData _spellbookData;
	public static final ResourceLocation spellbookUi = new ResourceLocation( "solinia3ui", "textures/gui/spellbook.png" );

	public GuiSpellbook(SpellBookData spellBookData) {
		this._spellbookData = spellBookData;
	}

	@Override
	public void render(int mouseX, int mouseY, float partialTicks)
    {
        mc.getTextureManager().bindTexture(spellbookUi);
        int x = (width - this.xSize) / 2;
		int y = (height - this.ySize) / 2;
		drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
        
        
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
	
	public void initGui()
	{
		int baseX = (width - this.xSize) / 2;
		int baseY = (height - this.ySize) / 2;
		
		this.buttons.clear();

		//Page 1
		this.buttons.add(this.spellItemButton1 = new GuiSpellIconButton(1000,baseX + 41,baseY + 13,20,20,getSpellName(1),getSpellIcon(1)));
		this.buttons.add(this.spellItemButton2 = new GuiSpellIconButton(1000,baseX + 87,baseY + 13,20,20,getSpellName(2),getSpellIcon(2)));
		this.buttons.add(this.spellItemButton3 = new GuiSpellIconButton(1000,baseX + 41,baseY + 50,20,20,getSpellName(3),getSpellIcon(3)));
		this.buttons.add(this.spellItemButton4 = new GuiSpellIconButton(1000,baseX + 87,baseY + 50,20,20,getSpellName(4),getSpellIcon(4)));
		this.buttons.add(this.spellItemButton5 = new GuiSpellIconButton(1000,baseX + 41,baseY + 86,20,20,getSpellName(5),getSpellIcon(5)));
		this.buttons.add(this.spellItemButton6 = new GuiSpellIconButton(1000,baseX + 87,baseY + 86,20,20,getSpellName(6),getSpellIcon(6)));
		this.buttons.add(this.spellItemButton7 = new GuiSpellIconButton(1000,baseX + 41,baseY + 122,20,20,getSpellName(7),getSpellIcon(7)));
		this.buttons.add(this.spellItemButton8 = new GuiSpellIconButton(1000,baseX + 87,baseY + 122,20,20,getSpellName(8),getSpellIcon(8)));

		//Page 2
		this.buttons.add(this.spellItemButton9 = new GuiSpellIconButton(1000,baseX + 148,baseY + 13,20,20,getSpellName(9),getSpellIcon(9)));
		this.buttons.add(this.spellItemButton10 = new GuiSpellIconButton(1000,baseX + 193,baseY + 13,20,20,getSpellName(10),getSpellIcon(10)));
		this.buttons.add(this.spellItemButton11 = new GuiSpellIconButton(1000,baseX + 148,baseY + 50,20,20,getSpellName(11),getSpellIcon(11)));
		this.buttons.add(this.spellItemButton12 = new GuiSpellIconButton(1000,baseX + 193,baseY + 50,20,20,getSpellName(12),getSpellIcon(12)));
		this.buttons.add(this.spellItemButton13 = new GuiSpellIconButton(1000,baseX + 148,baseY + 86,20,20,getSpellName(13),getSpellIcon(13)));
		this.buttons.add(this.spellItemButton14 = new GuiSpellIconButton(1000,baseX + 193,baseY + 86,20,20,getSpellName(14),getSpellIcon(14)));
		this.buttons.add(this.spellItemButton15 = new GuiSpellIconButton(1000,baseX + 148,baseY + 122,20,20,getSpellName(15),getSpellIcon(15)));
		this.buttons.add(this.spellItemButton16 = new GuiSpellIconButton(1000,baseX + 193,baseY + 122,20,20,getSpellName(16),getSpellIcon(16)));
	}
}
