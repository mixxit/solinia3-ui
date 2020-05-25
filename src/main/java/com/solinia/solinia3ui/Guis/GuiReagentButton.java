package com.solinia.solinia3ui.Guis;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.lwjgl.opengl.GL11;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.platform.GlStateManager;
import com.solinia.solinia3ui.solinia3ui;
import com.solinia.solinia3ui.Models.SpellIconLocation;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;

public class GuiReagentButton extends Button{
	protected static final ResourceLocation UTILITYREAGENT = new ResourceLocation( solinia3ui.MOD_ID, "textures/gui/utility.png");
	private int spellIcon;
	HashMap<Integer, SpellIconLocation> spellIconLocations = new HashMap<Integer,SpellIconLocation>();
	Minecraft minecraft;
	List<String> popupText = new ArrayList<String>();
	
	public GuiReagentButton(int widthIn, int heightIn, int x, int y, String text, Button.IPressable onPress) {
		super(widthIn, heightIn, x, y, text, onPress);
		this.minecraft = Minecraft.getInstance();
		
		popupText = Lists.newArrayList();
		popupText.add("Drop reagents here");
	      
		setSpellIconResourceLocations();
	}
	
	public GuiSpellIconButtonPressable getOnPress()
	{
		if (this.onPress instanceof GuiSpellIconButtonPressable)
			return (GuiSpellIconButtonPressable)this.onPress;
		
		return null;
	}
	
	
	@Override
	public void render(int posX, int posY, float partialTicks) {
		if (!this.visible)
			return;
		
		try
		{
			this.spellIcon = 4;
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
		
		if (this.spellIcon > 0)
		{
			SpellIconLocation location = spellIconLocations.get(this.spellIcon);
			if (location != null)
			{
				Minecraft.getInstance().getTextureManager().bindTexture(location.loc);
				this.blit(this.x, this.y, location.point.x, location.point.y, this.width, this.height);
			}
		}
		
		this.renderBg(Minecraft.getInstance(), posX, posY);
	}
		
    private int _spellIconsPerFile = 36;
	private static Point _spellIconStart = new Point(0, 0);
    private static Point _spellIconPadding = new Point (0, 0);
    private static int _spellFileHeightArea = 128;
    private static int _spellFileWidthArea = 128;
    
	public SpellIconLocation setSpellIconResourceLocations() {
		for (int spellIconSheet = 0; spellIconSheet < 100; spellIconSheet++)
        {
			if (UTILITYREAGENT == null)
				continue;
			
			int _x = _spellIconStart.x;
            int _y = _spellIconStart.y;
            int _iconIndex = 0;
            
            while ((_y + this.height) < _spellFileHeightArea)
            {
            	int foundNewIconId = ((spellIconSheet * _spellIconsPerFile) + _iconIndex);

            	this.spellIconLocations.put(foundNewIconId,new SpellIconLocation(UTILITYREAGENT,new Point(_x,_y)));
            	
            	_iconIndex++;
                _x += this.width + _spellIconPadding.x;

                if ((_x + this.width) >= _spellFileWidthArea)
                {
                    _x = _spellIconStart.x;
                    _y += this.height + _spellIconPadding.y;
                }
            }
        }
		
		return null;
	}


	public List<String> getPopupText() {
		return this.popupText;
	}
}
