package com.solinia.solinia3ui.Guis;

import static net.minecraft.util.StringUtils.stripControlCodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.mojang.blaze3d.platform.GlStateManager;
import com.solinia.solinia3ui.ClientState;
import com.solinia.solinia3ui.solinia3ui;
import com.solinia.solinia3ui.Models.Bond;
import com.solinia.solinia3ui.Models.CharacterCreation;
import com.solinia.solinia3ui.Models.Flaw;
import com.solinia.solinia3ui.Models.Ideal;
import com.solinia.solinia3ui.Models.RaceChoice;
import com.solinia.solinia3ui.Models.Trait;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.RenderComponentsUtil;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.list.ExtendedList;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.gui.ScrollPanel;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.fml.loading.StringUtils;

public class GuiCharacterCreation extends Screen {
	
	private GuiRaceTextList raceList;
	private List<RaceChoice> races;
	
	private GuiRaceTextList.RaceEntry raceSelected = null;
	private final List<RaceChoice> unsortedRaces;
	private int listWidth;
    private SortType sortType = SortType.A_TO_Z;
	private InfoPanel raceInfo, classInfo, personalityInfo;
    private int buttonMargin = 1;
    private boolean sortedRaces = false;
    private Button nextIdeal, nextTrait, nextTrait2, nextBond, nextFlaw, nextGender;
    
    private Ideal currentIdeal;
    private Trait currentTrait1;
    private Trait currentTrait2;
    private Bond currentBond;
    private Flaw currentFlaw;
    private String currentGender = "MALE";

    private TextFieldWidget textForename, textLastname;

	public GuiCharacterCreation(ITextComponent textComponent, CharacterCreation characterCreation) {
		super(textComponent);
		this.races = Collections.unmodifiableList(new ArrayList<RaceChoice>(characterCreation.raceChoices.values()));
		solinia3ui.LOGGER.info("Loading race list of: " + races.size());
		this.unsortedRaces = Collections.unmodifiableList(this.races);
		
		currentIdeal = ClientState.getInstance().ideals.get(0);
		currentTrait1 = ClientState.getInstance().traits.get(0);
		currentTrait2 = ClientState.getInstance().traits.get(1);
		currentBond = ClientState.getInstance().bonds.get(0);
		currentFlaw = ClientState.getInstance().flaws.get(0);
	}
	
	public void setSelected(GuiRaceTextList.RaceEntry entry)
    {
        this.raceSelected = entry == this.raceSelected ? null : entry;
        updateCache();
    }
	
    private enum SortType implements Comparator<RaceChoice>
    {
        A_TO_Z{ @Override protected int compare(String name1, String name2){ return name1.compareTo(name2); }};

        Button button;
        @Override
		public int compare(RaceChoice o1, RaceChoice o2) {
            String name1 = StringUtils.toLowerCase(stripControlCodes(o1.RaceShort + "_" + o1.ClassShort));
            String name2 = StringUtils.toLowerCase(stripControlCodes(o2.RaceShort + "_" + o2.ClassShort));
            return compare(name1, name2);
        }
        
        protected int compare(String name1, String name2) {
			// TODO Auto-generated method stub
			return 0;
		}

		String getButtonText() {
            return I18n.format(StringUtils.toLowerCase(name()));
        }
    }
    
	@Override
    public void init()
    {
        for (RaceChoice race : races)
        {
            listWidth = Math.max(listWidth,this.getMinecraft().fontRenderer.getStringWidth(race.RaceName + " " + race.ClassName) + 10);
            //listWidth = Math.max(listWidth,this.getMinecraft().fontRenderer.getStringWidth(MavenVersionStringHelper.artifactVersionToString(mod.getVersion())) + 5);
    		solinia3ui.LOGGER.info("Init with race");
       }
        listWidth = Math.max(Math.min(listWidth, width/3), 100);
        //listWidth += listWidth % numButtons != 0 ? (numButtons - listWidth % numButtons) : 0;

        
		this.raceList = new GuiRaceTextList(this, listWidth);
        this.raceList.setLeftPos(6);
        int infoHeight = 60;
        int infoWidth = this.width - this.listWidth - 20;
        this.classInfo = new InfoPanel(this.minecraft, infoWidth/2-10, infoHeight+20, 10, 10);
        this.raceInfo = new InfoPanel(this.minecraft, infoWidth/2, infoHeight+20, 10, 10+(infoWidth/2));
        this.personalityInfo = new InfoPanel(this.minecraft, infoWidth, 110, 100, 10);
        
        this.textForename = new TextFieldWidget(this.getMinecraft().fontRenderer, raceList.getWidth() + 8, this.height - 22, 60, 16, "Name");
        this.textForename.setText("Name");
        this.textForename.setMaxStringLength(7);
        children.add(this.textForename);
        
        this.textLastname = new TextFieldWidget(this.getMinecraft().fontRenderer, raceList.getWidth() + 8 + 60 + 8, this.height - 22, 60, 16, "Surname");
        this.textLastname.setText("Surname");
        this.textLastname.setMaxStringLength(7);
        children.add(this.textLastname);
        
        this.textForename.setFocused2(false);
        this.textLastname.setFocused2(false);
        this.textForename.setCanLoseFocus(true);
        this.textLastname.setCanLoseFocus(true);
        
        int personalityButtonWidth = 60;
        this.addButton(this.nextIdeal = new Button(6, this.height - 72, personalityButtonWidth, 20,
                "Ideal >", b -> nextIdeal()));
        this.addButton(this.nextGender = new Button(6 + personalityButtonWidth + 5, this.height - 72, personalityButtonWidth, 20,
                "Gender >", b -> nextGender()));
        this.addButton(this.nextTrait = new Button(6, this.height - 48, personalityButtonWidth, 20,"1st Trait >", b -> nextFirstTrait()));
        this.addButton(this.nextTrait2 = new Button(6 + personalityButtonWidth + 5 , this.height - 48, personalityButtonWidth, 20,"2nd Trait >", b -> nextSecondTrait()));
        this.addButton(this.nextBond = new Button(6 + personalityButtonWidth + 5 , this.height - 24, personalityButtonWidth, 20,
                "Bond >", b -> nextBond()));
        this.addButton(this.nextFlaw = new Button(6, this.height - 24, personalityButtonWidth, 20,
                "Flaw >", b -> nextFlaw()));
        
        int createButtonWidth = Math.min(infoWidth/2, 100);
        
        this.addButton(new Button(raceList.getWidth() + 8 + 60 + 8 + 60 + 8, this.height - 24, createButtonWidth, 20,
                "Create Character", b -> createCharacter()));

        children.add(raceList);
        children.add(classInfo);
        children.add(raceInfo);
        children.add(personalityInfo);
        
        //final int width = listWidth / numButtons;
        //int x = 6, y = 10;
        //addButton(SortType.NORMAL.button = new Button(x, y, width - buttonMargin, 20, SortType.NORMAL.getButtonText(), b -> resortRaces(SortType.NORMAL)));
        //x += width + buttonMargin;
        //addButton(SortType.A_TO_Z.button = new Button(x, y, width - buttonMargin, 20, SortType.A_TO_Z.getButtonText(), b -> resortRaces(SortType.A_TO_Z)));
        //x += width + buttonMargin;
        //addButton(SortType.Z_TO_A.button = new Button(x, y, width - buttonMargin, 20, SortType.Z_TO_A.getButtonText(), b -> resortRaces(SortType.Z_TO_A)));
        resortRaces(SortType.A_TO_Z);
        updateCache();
    }
		
	private void nextGender() {
		if (this.currentGender == null)
		{
			this.currentGender = "MALE";
			updateCache();
			return;
		}
		
		if (this.currentGender.equals("MALE"))
		{
			this.currentGender = "FEMALE";
		} else {
			this.currentGender = "MALE";
		}
		updateCache();
	}

	private void createCharacter() {
		if (!ValidCharacterName())
		{
			this.textForename.setText("Invalid");
			this.textLastname.setText("Name");
		} else {
			if (raceSelected == null || raceSelected.getRaceChoice() == null)
				return;
			createCharacter(raceSelected.getRaceChoice().RaceId, raceSelected.getRaceChoice().ClassId, this.currentGender, this.currentIdeal.id, this.currentTrait1.id, this.currentTrait2.id, this.currentFlaw.id, this.currentBond.id, this.textForename.getText(), this.textLastname.getText());
		}
	}

	private boolean ValidCharacterName() {
		if (this.textForename == null || this.textLastname == null)
			return false;
		
		if (this.textForename.getText().equals("") || this.textLastname.getText().equals(""))
			return false;

		if (this.textForename.getText().equals("Invalid") || this.textLastname.getText().equals("Name"))
			return false;

		if (this.textForename.getText().equals("Name") || this.textLastname.getText().equals("Surname"))
			return false;
		
		if (this.textForename.getText().equals("Forename") || this.textLastname.getText().equals("Lastname"))
			return false;
		
		if (!IsNewNameValidFormat(this.textForename.getText(),this.textLastname.getText()))
			return false;
		
		return true;
	}
	
	public boolean IsNewNameValidFormat(String forename, String lastname)
	{
		boolean isForeNameValid = forename.chars().allMatch(Character::isLetter);
		boolean isLastNameValid = lastname.chars().allMatch(Character::isLetter);
		
		if (!isForeNameValid)
			return false;
		
		if (!isLastNameValid && !lastname.equals(""))
			return false;
		
		String newname = forename;
		if (!lastname.equals(""))
			newname = forename + "_" + lastname;
		
		final String nametest = newname;
		
		if (forename.length() < 3)
			return false;
		
		if (nametest.length() < 3 || nametest.length() > 15)
			return false;
		
		return true;
	}

	private void nextFlaw() {
		int foundIndex = -1;
		
		for (int i = 0; i < ClientState.getInstance().flaws.size(); i++)
		{
			Flaw flaw = ClientState.getInstance().flaws.get(i);
			if (this.currentFlaw == null)
			{
				this.currentFlaw = flaw;
				updateCache();
				return;
			}
			
			if (flaw.id == this.currentFlaw.id)
			{
				foundIndex = i;
				break;
			}
		}
		
		for (int i = 0; i < ClientState.getInstance().flaws.size(); i++)
		{
			Flaw flaw = ClientState.getInstance().flaws.get(i);
			
			if (i > foundIndex)
			{
				this.currentFlaw = flaw;
				updateCache();
				return;
			}
		}
	}

	private void nextBond() {
		int foundIndex = -1;
		
		for (int i = 0; i < ClientState.getInstance().bonds.size(); i++)
		{
			Bond bond = ClientState.getInstance().bonds.get(i);
			if (this.currentBond == null)
			{
				this.currentBond = bond;
				updateCache();
				return;
			}
			
			if (bond.id == this.currentBond.id)
			{
				foundIndex = i;
				break;
			}
		}
		
		for (int i = 0; i < ClientState.getInstance().bonds.size(); i++)
		{
			Bond bond = ClientState.getInstance().bonds.get(i);
			if (foundIndex < (ClientState.getInstance().bonds.size()-1) && i > foundIndex)
			{			
				this.currentBond = bond;
				updateCache();
				return;
			}
			
			if (foundIndex == (ClientState.getInstance().bonds.size()-1) && i < foundIndex)
			{
				this.currentBond = bond;
				updateCache();
				return;
			}
		}
	}

	private void nextSecondTrait() {
		int foundIndex = -1;
		
		for (int i = 0; i < ClientState.getInstance().traits.size(); i++)
		{
			Trait trait = ClientState.getInstance().traits.get(i);
			if (this.currentTrait2 == null)
			{
				this.currentTrait2 = trait;
				updateCache();
				return;
			}
			
			if (trait.id == this.currentTrait2.id)
			{
				foundIndex = i;
				break;
			}
		}
			
		for (int i = 0; i < ClientState.getInstance().traits.size(); i++)
		{
			Trait trait = ClientState.getInstance().traits.get(i);
			if (this.currentTrait1 != null)
				if (trait.id == this.currentTrait1.id)
					continue;
			
			if (foundIndex < (ClientState.getInstance().traits.size()-1) && i > foundIndex)
			{			
				this.currentTrait2 = trait;
				updateCache();
				return;
			}
			
			if (foundIndex == (ClientState.getInstance().traits.size()-1) && i < foundIndex)
			{
				this.currentTrait2 = trait;
				updateCache();
				return;
			}
		}
	}

	private void nextFirstTrait() {
		int foundIndex = -1;
		
		for (int i = 0; i < ClientState.getInstance().traits.size(); i++)
		{
			Trait trait = ClientState.getInstance().traits.get(i);
			if (this.currentTrait1 == null)
			{
				this.currentTrait1 = trait;
				updateCache();
				return;
			}
			
			if (trait.id == this.currentTrait1.id)
			{
				foundIndex = i;
				break;
			}
		}
		
		for (int i = 0; i < ClientState.getInstance().traits.size(); i++)
		{
			Trait trait = ClientState.getInstance().traits.get(i);
			if (this.currentTrait2 != null)
				if (trait.id == this.currentTrait2.id)
					continue;
			
			if (foundIndex < (ClientState.getInstance().traits.size()-1) && i > foundIndex)
			{			
				this.currentTrait1 = trait;
				updateCache();
				return;
			}
			
			if (foundIndex == (ClientState.getInstance().traits.size()-1) && i < foundIndex)
			{
				this.currentTrait1 = trait;
				updateCache();
				return;
			}
		}
	}

	private void nextIdeal() {
		int foundIndex = -1;
		
		for (int i = 0; i < ClientState.getInstance().ideals.size(); i++)
		{
			Ideal ideal = ClientState.getInstance().ideals.get(i);
			if (this.currentIdeal == null)
			{
				this.currentIdeal = ideal;
				updateCache();
				return;
			}
			
			if (ideal.id == this.currentIdeal.id)
			{
				foundIndex = i;
				break;
			}
		}
			
		for (int i = 0; i < ClientState.getInstance().ideals.size(); i++)
		{
			Ideal ideal = ClientState.getInstance().ideals.get(i);
			if (foundIndex < (ClientState.getInstance().ideals.size()-1) && i > foundIndex)
			{			
				this.currentIdeal = ideal;
				updateCache();
				return;
			}
			
			if (foundIndex == (ClientState.getInstance().ideals.size()-1) && i < foundIndex)
			{
				this.currentIdeal = ideal;
				updateCache();
				return;
			}
		}
	}

	private void createCharacter(int raceid, int classid, String gender, int idealid, int firsttraitid, int secondtraitid, int flawid, int bondid, String forename, String lastname)
	{
		Minecraft.getInstance().player.sendChatMessage("/solinia3core:createcharacterfull " + raceid + " " + classid + " " + gender + " " + idealid + " " + firsttraitid + " " + secondtraitid + " " + flawid + " " + bondid + " " + forename + " " + lastname);
		Minecraft.getInstance().player.closeScreen();
	}

	public <T extends ExtendedList.AbstractListEntry<T>> void buildRaceList(Consumer<T> listViewConsumer, Function<RaceChoice, T> newEntry)
	{
        races.forEach(race->listViewConsumer.accept(newEntry.apply(race)));
    }
	
	@Override
    public void render(int mouseX, int mouseY, float partialTicks)
    {
        this.raceList.render(mouseX, mouseY, partialTicks);
        if (this.raceInfo != null)
            this.raceInfo.render(mouseX, mouseY, partialTicks);
        if (this.classInfo != null)
            this.classInfo.render(mouseX, mouseY, partialTicks);
        if (this.personalityInfo != null)
            this.personalityInfo.render(mouseX, mouseY, partialTicks);
        
        if (this.textForename != null)
        	this.textForename.render(mouseX, mouseY, partialTicks);
        if (this.textLastname != null)
        	this.textLastname.render(mouseX, mouseY, partialTicks);

        super.render(mouseX, mouseY, partialTicks);
    }
	
	private void updateCache()
    {
		solinia3ui.LOGGER.info("Updating cache");
		
        if (this.raceSelected == null) {
            this.raceInfo.clearInfo();
            this.classInfo.clearInfo();
            this.personalityInfo.clearInfo();
            return;
        }
        List<String> raceLines = new ArrayList<>();
        List<String> classLines = new ArrayList<>();
        TextFormatting colour = TextFormatting.WHITE;
        
        if (raceSelected.getRaceChoice().Alignment.equals("EVIL"))
        	colour = TextFormatting.RED;
        if (raceSelected.getRaceChoice().Alignment.equals("NEUTRAL"))
        	colour = TextFormatting.YELLOW;
        if (raceSelected.getRaceChoice().Alignment.equals("GOOD"))
        	colour = TextFormatting.GREEN;
        
        classLines.add(colour + raceSelected.getRaceChoice().ClassName + TextFormatting.RESET);
        classLines.add(raceSelected.getRaceChoice().ClassDescription);
        raceLines.add(colour + raceSelected.getRaceChoice().RaceName + TextFormatting.RESET + " Alignment: " + colour + raceSelected.getRaceChoice().Alignment + TextFormatting.RESET);
        raceLines.add("STR: " + raceSelected.getRaceChoice().STR + " STA: " + raceSelected.getRaceChoice().STA + " AGI: " + raceSelected.getRaceChoice().AGI + " DEX: " + raceSelected.getRaceChoice().DEX + " INT: " + raceSelected.getRaceChoice().INT + " WIS: " + raceSelected.getRaceChoice().WIS + " CHA: " + raceSelected.getRaceChoice().CHA);
        raceLines.add(raceSelected.getRaceChoice().RaceDescription);
        //lines.add(ForgeI18n.parseMessage("fml.menu.mods.info.version", MavenVersionStringHelper.artifactVersionToString(selectedMod.getVersion())));
        

        raceInfo.setInfo(raceLines);
        classInfo.setInfo(classLines);
        
        List<String> personalityLines = new ArrayList<>();
        personalityLines.add("Gender: " + this.currentGender);
        personalityLines.add("Ideal: " + this.currentIdeal.description);
        personalityLines.add("First Trait: " + this.currentTrait1.description);
        personalityLines.add("Second Trait: " + this.currentTrait2.description);
        personalityLines.add("Flaw: " + this.currentFlaw.description);
        personalityLines.add("Bond: " + this.currentBond.description);

        personalityInfo.setInfo(personalityLines);
    }
	
	@Override
    public void tick()
    {
        raceList.setSelected(raceSelected);
        if (this.textForename != null)
        	this.textForename.tick();
        	
        if (this.textLastname != null)
        	this.textLastname.tick();
        	
        if (!sortedRaces)
        {
            reloadRaces();
            races.sort(sortType);
            raceList.refreshList();
            if (raceSelected != null)
            {
            	raceSelected = raceList.children().stream().filter(e -> e.getRaceClassTitle().equals(raceSelected.getRaceClassTitle())).findFirst().orElse(null);
                updateCache();
            }
            sortedRaces = true;
        }
    }
	
	private void reloadRaces()
    {
        this.races = this.unsortedRaces.stream().collect(Collectors.toList());
    }
	
	
	private void resortRaces(SortType newSort)
    {
        this.sortType = newSort;

        for (SortType sort : SortType.values())
        {
            if (sort.button != null)
                sort.button.active = sortType != sort;
        }
        sortedRaces = false;
    }
	
	class InfoPanel extends ScrollPanel {
        private List<ITextComponent> lines = Collections.emptyList();

        InfoPanel(Minecraft mcIn, int widthIn, int heightIn, int topIn, int leftIn)
        {
            super(mcIn, widthIn, heightIn, topIn, raceList.getLeft() + leftIn);
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
                    ret.addAll(RenderComponentsUtil.splitText(chat, maxTextLength, GuiCharacterCreation.this.font, false, true));
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
                    GuiCharacterCreation.this.font.drawString(line.getFormattedText(), left + 4, relativeY, 0xFFFFFF);
                    GlStateManager.disableAlphaTest();
                    GlStateManager.disableBlend();
                }
                relativeY += font.FONT_HEIGHT;
            }

            final ITextComponent component = findTextLine(mouseX, mouseY);
            if (component!=null) {
            	GuiCharacterCreation.this.renderComponentHoverEffect(component, mouseX, mouseY);
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
                    k += GuiCharacterCreation.this.font.getStringWidth(((StringTextComponent)part).getText());
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
            	GuiCharacterCreation.this.handleComponentClicked(component);
                return true;
            }
            return super.mouseClicked(mouseX, mouseY, button);
        }

        @Override
        protected void drawBackground() {
        }
    }
}
