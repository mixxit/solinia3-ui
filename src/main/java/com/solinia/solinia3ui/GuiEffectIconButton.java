package com.solinia.solinia3ui;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.lwjgl.opengl.GL11;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;

public class GuiEffectIconButton extends Button {
	protected static final ResourceLocation SPELLSSMALL01 = new ResourceLocation( "solinia3ui", "textures/gui/spells1small.png");
	protected static final ResourceLocation SPELLSSMALL02 = new ResourceLocation( "solinia3ui", "textures/gui/spells2small.png");
	protected static final ResourceLocation SPELLSSMALL03 = new ResourceLocation( "solinia3ui", "textures/gui/spells3small.png");
	protected static final ResourceLocation SPELLSSMALL04 = new ResourceLocation( "solinia3ui", "textures/gui/spells4small.png");
	protected static final ResourceLocation SPELLSSMALL05 = new ResourceLocation( "solinia3ui", "textures/gui/spells5small.png");
	protected static final ResourceLocation SPELLSSMALL06 = new ResourceLocation( "solinia3ui", "textures/gui/spells6small.png");
	protected static final ResourceLocation SPELLSSMALL07 = new ResourceLocation( "solinia3ui", "textures/gui/spells7small.png");
	private int spellIcon;
	private int spellId;
	HashMap<Integer, SpellIconLocation> spellIconLocations = new HashMap<Integer,SpellIconLocation>();
	private String spellName;

	public GuiEffectIconButton(int widthIn, int heightIn, int x, int y, String text, Button.IPressable onPress) {
		super(widthIn, heightIn, x, y, text, onPress);
		
		setSpellIconAndId(text);
	}
	
	public void setSpellIconAndId(String text)
	{
		String displayIconStr = text.split("\\^",-1)[0];
		String spellStr = text.split("\\^",-1)[1];
		String spellName = text.split("\\^",-1)[2];
		
		try
		{
			this.spellIcon = Integer.parseInt(displayIconStr);
			this.spellId = Integer.parseInt(spellStr);
			this.spellName = spellName;
		} catch (Exception e)
		{
			e.printStackTrace();
			return;
		}
	}
	
	@Override
	 public void setMessage(String message) {
		super.setMessage(message);
		
		this.setSpellIconAndId(message);
	}
	
	public int getSpellId()
	{
		return this.spellId;
	}
	
	public String getSpellName()
	{
		return this.spellName;
	}
	
	@Override
	public void render(int posX, int posY, float partialTicks) {
		if (!this.visible)
			return;
		
		if (!getMessage().contains("^"))
			return;
		
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
			setSpellIconResourceLocations();
			SpellIconLocation location = spellIconLocations.get(this.spellIcon);
			if (location != null)
			{
				Minecraft.getInstance().getTextureManager().bindTexture(location.loc);
				this.blit(this.x, this.y, location.point.x, location.point.y, this.width, this.height);
			}
		}
		
		this.renderBg(Minecraft.getInstance(), posX, posY);
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
		files.add("spells01small.png");
		files.add("spells02small.png");
		files.add("spells03small.png");
		files.add("spells04small.png");
		files.add("spells05small.png");
		files.add("spells06small.png");
		files.add("spells07small.png");
		return files;
	}
	
	public ResourceLocation getResourceLocationByString(String name)
	{
		switch (name)
		{
			case "spells1small.png":
				return SPELLSSMALL01;
			case "spells2small.png":
				return SPELLSSMALL02;
			case "spells3small.png":
				return SPELLSSMALL03;
			case "spells4small.png":
				return SPELLSSMALL04;
			case "spells5small.png":
				return SPELLSSMALL05;
			case "spells6small.png":
				return SPELLSSMALL06;
			case "spells7small.png":
				return SPELLSSMALL07;
			default:
				return null;
			
		}
	}
	
    private int _spellIconsPerFile = 36;
	private static Point _spellIconStart = new Point(0, 0);
    private static Point _spellIconPadding = new Point (0, 0);
    private static int _spellFileHeightArea = 64;
    private static int _spellFileWidthArea = 64;
    
	public SpellIconLocation setSpellIconResourceLocations() {
		for (int spellIconSheet = 0; spellIconSheet < 100; spellIconSheet++)
        {
			ResourceLocation loc = getResourceLocationByString("spells" + (spellIconSheet + 1) + "small.png");
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
