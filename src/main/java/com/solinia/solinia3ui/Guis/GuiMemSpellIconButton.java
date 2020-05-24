package com.solinia.solinia3ui.Guis;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.lwjgl.opengl.GL11;

import com.mojang.blaze3d.platform.GlStateManager;
import com.solinia.solinia3ui.solinia3ui;
import com.solinia.solinia3ui.Models.SpellIconLocation;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;

public class GuiMemSpellIconButton extends Button {

	protected static final ResourceLocation SPELLS01 = new ResourceLocation( solinia3ui.MOD_ID, "textures/gui/spells1.png");
	protected static final ResourceLocation SPELLS02 = new ResourceLocation( solinia3ui.MOD_ID, "textures/gui/spells2.png");
	protected static final ResourceLocation SPELLS03 = new ResourceLocation( solinia3ui.MOD_ID, "textures/gui/spells3.png");
	protected static final ResourceLocation SPELLS04 = new ResourceLocation( solinia3ui.MOD_ID, "textures/gui/spells4.png");
	protected static final ResourceLocation SPELLS05 = new ResourceLocation( solinia3ui.MOD_ID, "textures/gui/spells5.png");
	protected static final ResourceLocation SPELLS06 = new ResourceLocation( solinia3ui.MOD_ID, "textures/gui/spells6.png");
	protected static final ResourceLocation SPELLS07 = new ResourceLocation( solinia3ui.MOD_ID, "textures/gui/spells7.png");
	protected static final ResourceLocation WINDOWPIECES = new ResourceLocation( solinia3ui.MOD_ID, "textures/gui/window_pieces01");
	private int spellIcon;
	HashMap<Integer, SpellIconLocation> spellIconLocations = new HashMap<Integer,SpellIconLocation>();

	public GuiMemSpellIconButton(int widthIn, int heightIn, int x, int y, String text, Button.IPressable onPress) {
		super(widthIn, heightIn, x, y, text, onPress);
	}
		
	@Override
	public void render(int posX, int posY, float partialTicks) {
		if (!this.visible)
			return;
		
		if (!getMessage().contains("^"))
			return;
		
		String displayIconStr = this.getMessage().split("\\^",-1)[0];
		try
		{
			this.spellIcon = Integer.parseInt(displayIconStr);
		} catch (Exception e)
		{
			return;
		}
		
		int j = Color.WHITE.getRGB();
		
		GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		
		setSpellIconResourceLocations();
		SpellIconLocation location = spellIconLocations.get(this.spellIcon);
		if (location != null)
		{
			Minecraft.getInstance().getTextureManager().bindTexture(location.loc);
			this.blit(this.x, this.y, location.point.x, location.point.y, this.width, this.height);
		} else {
			// Grey box instead
			Minecraft.getInstance().getTextureManager().bindTexture(SPELLS07);
			this.blit(this.x, this.y, 20, 0, this.width, this.height);
		}
		
		this.renderBg(Minecraft.getInstance(), posX, posY);
		
		String displayString = "";
		if (this.getMessage().split("\\^",-1).length > 1)
			displayString = this.getMessage().split("\\^",-1)[1];
		this.drawStringCenteredScale(Minecraft.getInstance().fontRenderer, "ALT+" + displayString, this.x + this.width /2,this.y + (this.height - 8) + Minecraft.getInstance().fontRenderer.FONT_HEIGHT, 0.5f, j);
	}
	
	public void drawStringCenteredScale(FontRenderer fontRendererIn, String text, int x, int y, float size, int color) {
        GL11.glScalef(size,size,size);
        float mSize = (float)Math.pow(size,-1);
        this.drawCenteredString(fontRendererIn,text,Math.round(x / size),Math.round(y / size),color);
        GL11.glScalef(mSize,mSize,mSize);
    }
	
	public List<String> getSpellFiles()
	{
		List<String> files = new ArrayList<String>();
		files.add("spells01.png");
		files.add("spells02.png");
		files.add("spells03.png");
		files.add("spells04.png");
		files.add("spells05.png");
		files.add("spells06.png");
		files.add("spells07.png");
		return files;
	}
	
	public ResourceLocation getResourceLocationByString(String name)
	{
		switch (name)
		{
			case "spells1.png":
				return SPELLS01;
			case "spells2.png":
				return SPELLS02;
			case "spells3.png":
				return SPELLS03;
			case "spells4.png":
				return SPELLS04;
			case "spells5.png":
				return SPELLS05;
			case "spells6.png":
				return SPELLS06;
			case "spells7.png":
				return SPELLS07;
			default:
				return null;
			
		}
	}
	
    private int _spellIconsPerFile = 36;
	private static Point _spellIconStart = new Point(0, 0);
    private static Point _spellIconPadding = new Point (0, 0);
    private static int _spellFileHeightArea = 128;
    private static int _spellFileWidthArea = 128;
    
	public SpellIconLocation setSpellIconResourceLocations() {
		for (int spellIconSheet = 0; spellIconSheet < 100; spellIconSheet++)
        {
			ResourceLocation loc = getResourceLocationByString("spells" + (spellIconSheet + 1) + ".png");
			if (loc == null)
				continue;
			
			int _x = _spellIconStart.x;
            int _y = _spellIconStart.y;
            int _iconIndex = 0;
            
            while ((_y + this.height) < _spellFileHeightArea)
            {
            	int foundNewIconId = ((spellIconSheet * _spellIconsPerFile) + _iconIndex);

            	this.spellIconLocations.put(foundNewIconId,new SpellIconLocation(loc,new Point(_x,_y)));
            	
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
}
