package com.solinia.solinia3ui.Guis;

import com.solinia.solinia3ui.Models.TrackingChoice;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.list.ExtendedList;
import net.minecraft.util.text.TextFormatting;

public class GuiTrackingTextList extends ExtendedList<GuiTrackingTextList.RowEntry> {
	private final int listWidth;

    private GuiTrackingWindow parent;

    public GuiTrackingTextList(GuiTrackingWindow parent, int listWidth)
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
        parent.buildTrackingList(this::addEntry, trackingchoice->new RowEntry(trackingchoice, this.parent));
    }
    
    public Screen getParent() {
    	return this.parent;
    }

    @Override
    protected void renderBackground()
    {
        this.parent.renderBackground();
    }
    
    class RowEntry extends ExtendedList.AbstractListEntry<RowEntry> { 
        private final GuiTrackingWindow parent;
        private final TrackingChoice trackingchoice;
        
        RowEntry(TrackingChoice trackingchoice, GuiTrackingWindow parent) {
            this.trackingchoice = trackingchoice;
            this.parent = parent;
        }
        
        public String getTrackingChoiceName()
        {
        	return getTrackingChoice().Name;
        }
        
        public String getTrackingChoiceId()
        {
        	return getTrackingChoice().Id;
        }
        
        public TrackingChoice getTrackingChoice()
        {
        	return this.trackingchoice;
        }

        @Override
        public void render(int entryIdx, int top, int left, int entryWidth, int entryHeight, int mouseX, int mouseY, boolean p_194999_5_, float partialTicks)
        {
        	TextFormatting colour = TextFormatting.WHITE;
            
            /*if (this.race.Alignment.equals("EVIL"))
            	colour = TextFormatting.RED;*/
        	
            FontRenderer font = this.parent.getMinecraft().fontRenderer;
            font.drawString(font.trimStringToWidth(colour+getTrackingChoiceName()+TextFormatting.RESET, listWidth),left + 3, top + 2, 0xFFFFFF);
        }

        @Override
        public boolean mouseClicked(double p_mouseClicked_1_, double p_mouseClicked_3_, int p_mouseClicked_5_)
        {
            parent.setSelected(this);
            GuiTrackingTextList.this.setSelected(this);
            return false;
        }
    }

}
