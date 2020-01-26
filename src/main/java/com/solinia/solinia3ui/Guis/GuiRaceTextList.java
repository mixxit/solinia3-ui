package com.solinia.solinia3ui.Guis;

import com.solinia.solinia3ui.Models.RaceChoice;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.list.ExtendedList;
import net.minecraft.util.text.TextFormatting;

public class GuiRaceTextList extends ExtendedList<GuiRaceTextList.RaceEntry> {
	private final int listWidth;

    private GuiCharacterCreation parent;

    public GuiRaceTextList(GuiCharacterCreation parent, int listWidth)
    {
        super(parent.getMinecraft(), listWidth, parent.height, 10, parent.height - 80 + 4, parent.getMinecraft().fontRenderer.FONT_HEIGHT + 4);
        this.parent = parent;
        this.listWidth = listWidth;
        this.refreshList();
    }

    @Override
    protected int getScrollbarPosition()
    {
        return this.listWidth;
    }

    @Override
    public int getRowWidth()
    {
        return this.listWidth;
    }

    void refreshList() {
        this.clearEntries();
        parent.buildRaceList(this::addEntry, race->new RaceEntry(race, this.parent));
    }
    
    public Screen getParent() {
    	return this.parent;
    }

    @Override
    protected void renderBackground()
    {
        this.parent.renderBackground();
    }
    
    class RaceEntry extends ExtendedList.AbstractListEntry<RaceEntry> { 
        private final GuiCharacterCreation parent;
        private final RaceChoice race;
        
        RaceEntry(RaceChoice race, GuiCharacterCreation parent) {
            this.race = race;
            this.parent = parent;
        }
        
        public String getRaceClassTitle()
        {
        	return getRaceChoice().RaceName + " " + this.race.ClassName;
        }
        
        public String getShortRaceDescription()
        {
        	if (getRaceChoice().RaceDescription.length() > 20)
        		return getRaceChoice().RaceDescription.substring(0,20);
        	return getRaceChoice().RaceDescription;
        }
        
        public RaceChoice getRaceChoice()
        {
        	return this.race;
        }
        
        public String getShortClassDescription()
        {
        	if (this.race.ClassDescription.length() > 20)
        		return this.race.ClassDescription.substring(0,20);
        	return this.race.ClassDescription;
        }

        @Override
        public void render(int entryIdx, int top, int left, int entryWidth, int entryHeight, int mouseX, int mouseY, boolean p_194999_5_, float partialTicks)
        {
        	TextFormatting colour = TextFormatting.WHITE;
            
            if (this.race.Alignment.equals("EVIL"))
            	colour = TextFormatting.RED;
            if (this.race.Alignment.equals("NEUTRAL"))
            	colour = TextFormatting.YELLOW;
            if (this.race.Alignment.equals("GOOD"))
            	colour = TextFormatting.GREEN;
        	
            FontRenderer font = this.parent.getMinecraft().fontRenderer;
            font.drawString(font.trimStringToWidth(colour+getRaceClassTitle()+TextFormatting.RESET, listWidth),left + 3, top + 2, 0xFFFFFF);
//            font.drawString(font.trimStringToWidth(getShortRaceDescription(), listWidth), left + 3 , top + 2 + font.FONT_HEIGHT, 0xCCCCCC);
//            font.drawString(font.trimStringToWidth(getShortClassDescription(), listWidth), left + 3 , top + 2 + (font.FONT_HEIGHT*2), 0xCCCCCC);
            /*if (vercheck.status.shouldDraw())
            {
                //TODO: Consider adding more icons for visualization
                Minecraft.getInstance().getTextureManager().bindTexture(VERSION_CHECK_ICONS);
                GlStateManager.color4f(1, 1, 1, 1);
                GlStateManager.pushMatrix();
                AbstractGui.blit(getRight() - (height / 2 + 4), GuiTextList.this.getTop() + (height / 2 - 4), vercheck.status.getSheetOffset() * 8, (vercheck.status.isAnimated() && ((System.currentTimeMillis() / 800 & 1)) == 1) ? 8 : 0, 8, 8, 64, 16);
                GlStateManager.popMatrix();
            }*/
        }

        @Override
        public boolean mouseClicked(double p_mouseClicked_1_, double p_mouseClicked_3_, int p_mouseClicked_5_)
        {
            parent.setSelected(this);
            GuiRaceTextList.this.setSelected(this);
            return false;
        }
    }

}
