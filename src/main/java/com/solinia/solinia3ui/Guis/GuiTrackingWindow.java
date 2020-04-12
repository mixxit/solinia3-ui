package com.solinia.solinia3ui.Guis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.mojang.blaze3d.platform.GlStateManager;
import com.solinia.solinia3ui.solinia3ui;
import com.solinia.solinia3ui.Models.TrackingChoice;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.RenderComponentsUtil;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.list.ExtendedList;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.gui.ScrollPanel;
import net.minecraftforge.common.ForgeHooks;

public class GuiTrackingWindow extends Screen {
	
	private GuiTrackingTextList trackingList;
	private List<TrackingChoice> trackingchoices;
	
	private GuiTrackingTextList.RowEntry trackingSelected = null;
	private final List<TrackingChoice> unsortedTrackingChoices;
	private int listWidth;
    private int buttonMargin = 1;
    private boolean sortedTrackingChoices = false;

	public GuiTrackingWindow(ITextComponent textComponent, List<TrackingChoice> trackingChoices) {
		super(textComponent);
		this.trackingchoices = Collections.unmodifiableList(trackingChoices);
		solinia3ui.LOGGER.info("Loading race list of: " + trackingchoices.size());
		this.unsortedTrackingChoices = Collections.unmodifiableList(this.trackingchoices);
	}
	
	public void setSelected(GuiTrackingTextList.RowEntry entry)
    {
        this.trackingSelected = entry == this.trackingSelected ? null : entry;
        updateCache();
    }
    
	@Override
    public void init()
    {
        for (TrackingChoice trackingChoice : trackingchoices)
        {
            listWidth = Math.max(listWidth,this.getMinecraft().fontRenderer.getStringWidth(trackingChoice.Name + " " + trackingChoice.Color) + 10);
            //listWidth = Math.max(listWidth,this.getMinecraft().fontRenderer.getStringWidth(MavenVersionStringHelper.artifactVersionToString(mod.getVersion())) + 5);
    		solinia3ui.LOGGER.info("Init with race");
       }
        listWidth = Math.max(Math.min(listWidth, width/3), 100);
        //listWidth += listWidth % numButtons != 0 ? (numButtons - listWidth % numButtons) : 0;

        
		this.trackingList = new GuiTrackingTextList(this, listWidth);
        this.trackingList.setLeftPos(6);
        int infoHeight = 60;
        int infoWidth = this.width - this.listWidth - 20;

        int createButtonWidth = Math.min(infoWidth/2, 100);
        
        this.addButton(new Button(trackingList.getWidth() + 8 + 60 + 8 + 60 + 8, this.height - 24, createButtonWidth, 20,
                "Track Target", b -> trackTarget()));

        children.add(trackingList);
        updateCache();
    }
		

	private void trackTarget() {
		if (this.trackingSelected == null || this.trackingSelected.getTrackingChoiceId() == null || this.trackingSelected.getTrackingChoice().equals(""))
			return;
		
		System.out.println("Tracking target: " + this.trackingSelected.getTrackingChoiceId());
		Minecraft.getInstance().player.sendChatMessage("/solinia3core:track " + this.trackingSelected.getTrackingChoiceId());
		Minecraft.getInstance().player.closeScreen();
	}

	public <T extends ExtendedList.AbstractListEntry<T>> void buildTrackingList(Consumer<T> listViewConsumer, Function<TrackingChoice, T> newEntry)
	{
		trackingchoices.forEach(race->listViewConsumer.accept(newEntry.apply(race)));
    }
	
	@Override
    public void render(int mouseX, int mouseY, float partialTicks)
    {
        this.trackingList.render(mouseX, mouseY, partialTicks);
        super.render(mouseX, mouseY, partialTicks);
    }
	
	private void updateCache()
    {
		solinia3ui.LOGGER.info("Updating cache");
        TextFormatting colour = TextFormatting.WHITE;
        
        if (trackingSelected != null && trackingSelected.getTrackingChoice() != null)
        if (trackingSelected.getTrackingChoice().Color.equals("RED"))
        	colour = TextFormatting.RED;
    }
	
	@Override
    public void tick()
    {
        trackingList.setSelected(trackingSelected);

        if (!sortedTrackingChoices)
        {
            reloadTrackingChoices();
            trackingList.refreshList();
            if (trackingSelected != null)
            {
            	trackingSelected = trackingList.children().stream().filter(e -> ((Integer)e.getTrackingChoice().Distance).equals((Integer)trackingSelected.getTrackingChoice().Distance)).findFirst().orElse(null);
                updateCache();
            }
            sortedTrackingChoices = true;
        }
    }
	
	private void reloadTrackingChoices()
    {
        this.trackingchoices = this.unsortedTrackingChoices.stream().collect(Collectors.toList());
    }
	
	class InfoPanel extends ScrollPanel {
        private List<ITextComponent> lines = Collections.emptyList();

        InfoPanel(Minecraft mcIn, int widthIn, int heightIn, int topIn, int leftIn)
        {
            super(mcIn, widthIn, heightIn, topIn, trackingList.getLeft() + leftIn);
        }

        void setInfo(List<String> lines)
        {
        	solinia3ui.LOGGER.info("Set panel info lines");
            this.lines = resizeContent(lines);
        }

        void clearInfo()
        {
            this.lines = Collections.emptyList();
        }

        private List<ITextComponent> resizeContent(List<String> lines)
        {
            List<ITextComponent> ret = new ArrayList<ITextComponent>();
            for (String line : lines)
            {
                if (line == null)
                {
                    ret.add(null);
                    continue;
                }

                ITextComponent chat = ForgeHooks.newChatWithLinks(line, false);
                int maxTextLength = this.width - 12;
                if (maxTextLength >= 0)
                {
                    ret.addAll(RenderComponentsUtil.splitText(chat, maxTextLength, GuiTrackingWindow.this.font, false, true));
                }
            }
            return ret;
        }

        @Override
        public int getContentHeight() 
        {
            int height = 50;
            height += (lines.size() * font.FONT_HEIGHT);
            if (height < this.bottom - this.top - 8)
                height = this.bottom - this.top - 8;
            return height;
        }

        @Override
        protected int getScrollAmount()
        {
            return font.FONT_HEIGHT /2;
        }

        @Override
        protected void drawPanel(int entryRight, int relativeY, Tessellator tess, int mouseX, int mouseY)
        {
            for (ITextComponent line : lines)
            {
                if (line != null)
                {
                    GlStateManager.enableBlend();
                    GuiTrackingWindow.this.font.drawString(line.getFormattedText(), left + 4, relativeY, 0xFFFFFF);
                    GlStateManager.disableAlphaTest();
                    GlStateManager.disableBlend();
                }
                relativeY += font.FONT_HEIGHT;
            }

            final ITextComponent component = findTextLine(mouseX, mouseY);
            if (component!=null) {
            	GuiTrackingWindow.this.renderComponentHoverEffect(component, mouseX, mouseY);
            }
        }

        private ITextComponent findTextLine(final int mouseX, final int mouseY) {
            double offset = (mouseY - top) + border + scrollDistance + 1;
            if (offset <= 0)
                return null;

            int lineIdx = (int) (offset / font.FONT_HEIGHT);
            if (lineIdx >= lines.size() || lineIdx < 1)
                return null;

            ITextComponent line = lines.get(lineIdx-1);
            if (line != null)
            {
                int k = left + border;
                for (ITextComponent part : line) {
                    if (!(part instanceof StringTextComponent))
                        continue;
                    k += GuiTrackingWindow.this.font.getStringWidth(((StringTextComponent)part).getText());
                    if (k >= mouseX)
                    {
                        return part;
                    }
                }
            }
            return null;
        }

        @Override
        public boolean mouseClicked(final double mouseX, final double mouseY, final int button) {
            final ITextComponent component = findTextLine((int) mouseX, (int) mouseY);
            if (component != null) {
            	GuiTrackingWindow.this.handleComponentClicked(component);
                return true;
            }
            return super.mouseClicked(mouseX, mouseY, button);
        }

        @Override
        protected void drawBackground() {
        }
    }
}
