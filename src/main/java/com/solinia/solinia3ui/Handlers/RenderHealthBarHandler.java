package com.solinia.solinia3ui.Handlers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.solinia.solinia3ui.ClientState;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.entity.player.RemoteClientPlayerEntity;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Matrix4f;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.Team;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.world.BossInfo.Color;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.RenderNameplateEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class RenderHealthBarHandler {
	/*private MatrixStack matrixStack;
	  
	  private Matrix4f matrix;
	  
	  private IRenderTypeBuffer renderBuffer;
	  
	  private FontRenderer fontRenderer;
	  
	  private String displayName;
	  
	  private float strHalfWidth;
	  
	  private int packedLight;
	  
	  private Team teamThem;
	  
	  private AbstractClientPlayerEntity entityPE;
	  
	  private Team teamMine;
	  
	  private Scoreboard scoreboard;
	  
	  private ScoreObjective scoreobjective;
	  
	  private boolean canRenderName = false;
	  
	  private boolean isVisible = true;
	  
	  private boolean isStanding = true;
	  
	  private double renderHeight = 0.0D;
	  
	  private double distanceSq = 0.0D;
	  
	  private float health = 1.0F;
	  
	  private float healthInv = 0.0F;
	  
	  private float strR = 255.0F;
	  
	  private float strG = 255.0F;
	  
	  private float strB = 255.0F;
	  
	  private float strA = 255.0F;
	  
	  private float strScaleV = 255.0F;
	  
	  private int strRGBA = -1;
	  
	  private int strRGBAFaded = 553648127;
	  
	  private float bgR = 0.0F;
	  
	  private float bgG = 0.0F;
	  
	  private float bgB = 0.0F;
	  
	  private float bgScaleV = 0.0F;
	  
	  private boolean doAprilFools;
	  
	  private Style obfuscated = (new Style()).setObfuscated(Boolean.valueOf(true));
	  */

	  private boolean vanillaMobs;
	  
	  private boolean vanillaScoreboards;
	  
	private Class<?> playerClass;

	private int nameMaxR;
	  
	  private int nameMaxG;
	  
	  private int nameMaxB;
	  
	  private int nameMaxA;
	  
	  private float nameMaxV;
	  
	  private int nameMinR;
	  
	  private int nameMinG;
	  
	  private int nameMinB;
	  
	  private int nameMinA;
	  
	  private float nameMinV;
	  
	  private int plateMaxR;
	  
	  private int plateMaxG;
	  
	  private int plateMaxB;
	  
	  private int plateMaxA;
	  
	  private float plateMaxV;
	  
	  private int plateMinR;
	  
	  private int plateMinG;
	  
	  private int plateMinB;
	  
	  private int plateMinA;
	  
	  private float plateMinV;
	  
	  private boolean isPaused = false;
	
	  @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	  public void onPause(GuiOpenEvent event) {
	    if (event.getGui() instanceof net.minecraft.client.gui.screen.IngameMenuScreen && !isPaused) {
	      isPaused = true;
	    } else if (isPaused && event.getGui() == null) {
	      cacheConfig();
	      isPaused = false;
	    } else if (event.getGui() instanceof net.minecraft.client.gui.screen.MainMenuScreen) {
	      cacheConfig();
	    } 
	  }
	  
	  public void cacheConfig() {
	    playerClass = (AbstractClientPlayerEntity.class);
	    vanillaScoreboards = ((Boolean)true).booleanValue();
	    vanillaMobs = ((Boolean)false).booleanValue();
	    nameMaxR = 255;
	    nameMaxG = 255;
	    nameMaxB = 255;
	    nameMaxA = (int)Math.round(((Double)1.0D * 255.0D));
	    nameMaxV = getVibrancy(nameMaxR, nameMaxG, nameMaxB);
	    nameMinR = 0;
	    nameMinG = 0;
	    nameMinB = 0;
	    nameMinA = (int)Math.round(((Double)0.25D * 255.0D));
	    nameMinV = getVibrancy(nameMinR, nameMinG, nameMinB);
	    plateMaxR = 0;
	    plateMaxG = 0;
	    plateMaxB = 0;
	    plateMaxA = (int)Math.round(((Double)0.25D * 255.0D));
	    plateMaxV = getVibrancy(plateMaxR, plateMaxG, plateMaxB);
	    plateMinR = 0;
	    plateMinG = 0;
	    plateMinB = 0;
	    plateMinA = (int)Math.round(((Double)0.25D * 255.0D));
	    plateMinV = getVibrancy(plateMinR, plateMinG, plateMinB);
	  }
	  
	  public float getVibrancy(int R, int G, int B) {
	    if (R >= G && R >= B)
	      return R; 
	    if (G >= B)
	      return G; 
	    return B;
	  }
	  
	  public float getVibrancy(float R, float G, float B) {
	    if (R >= G && R >= B)
	      return R; 
	    if (G >= B)
	      return G; 
	    return B;
	  }
	  
	  @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	  public void onRenderNameplate(RenderNameplateEvent event) {
	    if ((event.hasResult() && event.getResult() == Event.Result.DENY) || !(event.getEntity() instanceof LivingEntity))
	      return; 
	    
	    try
	    {
	    	EntityRendererManager rendererManager = event.getEntityRenderer().getRenderManager();
	    	
		    LivingEntity entityLE = (LivingEntity)event.getEntity();
		    ClientPlayerEntity entityMe = (Minecraft.getInstance()).player;
		    boolean isVisible = !entityLE.isInvisibleToPlayer((PlayerEntity)entityMe);
		    boolean isStanding = !entityLE.isDiscrete();
		    double distanceSq = rendererManager.squareDistanceTo((Entity)entityLE);
		    boolean canRenderName = false;
		    if (distanceSq < (isStanding ? 4096.0D : 1024.0D)) {
		      if (entityLE != entityMe && entityLE.getTeam() != null) {
		    	  Team teamThem = entityLE.getTeam();
		    	  Team teamMine = entityMe.getTeam();
		    	  canRenderName = true;
		      } else {
		    	  canRenderName = (Minecraft.isGuiEnabled() && isVisible && !entityLE.isBeingRidden());
		      } 
		      if (canRenderName && (playerClass.isInstance(entityLE) || (entityLE.hasCustomName() && (entityLE.isCustomNameVisible() || entityLE == rendererManager.pointedEntity)))) {
		    	  MatrixStack matrixStack = event.getMatrixStack();
		    	  IRenderTypeBuffer renderBuffer = event.getRenderTypeBuffer();
		    	  int packedLight = event.getPackedLight();
		    	  FontRenderer fontRenderer = rendererManager.getFontRenderer();
		    	  double renderHeight = entityLE.getHeight() + 0.5D;
		    	  float health = entityLE.getHealth() / entityLE.getMaxHealth();
		    	  float healthInv = 1.0F - health;
		    	  float strR = nameMaxR * health + nameMinR * healthInv;
		    	  float strG = nameMaxG * health + nameMinG * healthInv;
		    	  float strB = nameMaxB * health + nameMinB * healthInv;
		    	  float strA = nameMaxA * health + nameMinA * healthInv;
		    	  float strScaleV = (nameMaxV * health + nameMinV * healthInv) / getVibrancy(strR, strG, strB);
		    	  int strRGBA = java.awt.Color.white.getRGB();
		    	  int strRGBAFaded = ((int)((strA < 32.1F) ? 4.1F : (strA * 0.1255F)) & 0xFF) << 24 | strRGBA;
		    	  float bgR = plateMaxR * health + plateMinR * healthInv;
		    	  float bgG = plateMaxG * health + plateMinG * healthInv;
		    	  float bgB = plateMaxB * health + plateMinB * healthInv;
		    	  float bgScaleV = (plateMaxV * health + plateMinV * healthInv) / getVibrancy(bgR, bgG, bgB);
		        int tmpbgRGBA = ((int)(plateMaxA * health + plateMinA * healthInv) & 0xFF) << 24 | ((int)(bgR * bgScaleV) & 0xFF) << 16 | ((int)(bgG * bgScaleV) & 0xFF) << 8 | (int)(bgB * bgScaleV) & 0xFF;

		        int targetEntityId = 0;
		        if (ClientState.getInstance().getEntityVital(-1) != null && ClientState.getInstance().getEntityVital(-1).getEntityId() > 0)
					targetEntityId = ClientState.getInstance().getEntityVital(-1).getEntityId();

		        java.awt.Color baseCol = java.awt.Color.GRAY;
		        if (entityLE.getEntityId() == targetEntityId)
		        {
		        	baseCol = java.awt.Color.green;
		        }
		        
		        tmpbgRGBA = new java.awt.Color(baseCol.getRed(), baseCol.getGreen(), baseCol.getBlue(), 80).getRGB();
		        
		        if (entityLE instanceof AbstractClientPlayerEntity) {
		        	AbstractClientPlayerEntity entityPE = (AbstractClientPlayerEntity)entityLE;
		          if (distanceSq < 100.0D) {
		            Scoreboard scoreboard = entityPE.getWorldScoreboard();
		            ScoreObjective scoreobjective = scoreboard.getObjectiveInDisplaySlot(2);
		            if (scoreobjective != null) {
		              if (vanillaScoreboards) {
		                drawNameplate(packedLight, renderHeight, isStanding, renderBuffer, rendererManager, fontRenderer, matrixStack, scoreboard.getOrCreateScore(entityPE.getGameProfile().getName(), scoreobjective).getScorePoints() + " " + scoreobjective.getDisplayName().getFormattedText(), isStanding ? -1 : 553648127, 553648127, 1073741824);
		              } else {
		                drawNameplate(packedLight, renderHeight, isStanding, renderBuffer, rendererManager, fontRenderer, matrixStack, scoreboard.getOrCreateScore(entityPE.getGameProfile().getName(), scoreobjective).getScorePoints() + " " + scoreobjective.getDisplayName().getUnformattedComponentText(), strRGBA, strRGBAFaded, tmpbgRGBA);
		              } 
		              renderHeight += 0.25875D;
		            } 
		          } 
		          
		          String displayName = entityPE.getDisplayName().getFormattedText();
		          if (entityPE.getCustomName() != null)
		        	  displayName = entityPE.getCustomName().getFormattedText();
	
		          if (entityPE.getEntityId() == targetEntityId)
		        	  displayName = ClientState.getInstance().getEntityVital(-1).getName();
		          
		          if (entityPE.getEntityId() == targetEntityId)
		        	  displayName = ">" + displayName + "<";
		          
		          drawNameplate(packedLight, renderHeight, isStanding, renderBuffer, rendererManager, fontRenderer, matrixStack, displayName, strRGBA, strRGBAFaded, tmpbgRGBA);
		        } else if (vanillaMobs) {
		          drawNameplate(packedLight, renderHeight, isStanding, renderBuffer, rendererManager, fontRenderer, matrixStack, event.getContent(), isStanding ? -1 : 553648127, 553648127, 1073741824);
		        } else {
			        String displayName = entityLE.getDisplayName().getFormattedText();
			        if (entityLE.getCustomName() != null)
			        	displayName = entityLE.getCustomName().getUnformattedComponentText();
			        
			        if (entityLE.getEntityId() == targetEntityId)
			        	  displayName = ClientState.getInstance().getEntityVital(-1).getName();
			        
		          if (entityLE.getEntityId() == targetEntityId)
		        	  displayName = ">" + displayName + "<";
	
		          drawNameplate(packedLight, renderHeight, isStanding, renderBuffer, rendererManager, fontRenderer, matrixStack, displayName, strRGBA, strRGBAFaded, tmpbgRGBA);
		        } 
		        event.setResult(Event.Result.DENY);
		      } 
		    } 
	    } catch (Exception e)
	    {
	    	e.printStackTrace();
	    }
	  }
	  
	  private String formatName(String name, Style style) {
	    return (new StringTextComponent(name)).setStyle(style).getFormattedText();
	  }
	  
	  private void renderString(String name, int color, boolean isStanding) {}
	  
	  private void drawNameplate(int packedLight, double renderHeight, boolean isStanding, IRenderTypeBuffer renderBuffer, EntityRendererManager rendererManager, FontRenderer fontRenderer, MatrixStack matrixStack, String str, int strRGBA, int strRGBAFaded, int bgRGBA) {
	    matrixStack.push();
	    matrixStack.translate(0.0D, renderHeight, 0.0D);
	    matrixStack.rotate(rendererManager.getCameraOrientation());
	    matrixStack.scale(-0.025F, -0.025F, 0.025F);
	    Matrix4f matrix = matrixStack.getLast().getMatrix();
	    float strHalfWidth = (-fontRenderer.getStringWidth(str) / 2);
	    fontRenderer.renderString(str, strHalfWidth, 0.0F, strRGBAFaded, false, matrix, renderBuffer, isStanding, bgRGBA, packedLight);
	    if (isStanding)
	      fontRenderer.renderString(str, strHalfWidth, 0.0F, strRGBA, false, matrix, renderBuffer, false, 0, packedLight); 
	    matrixStack.pop();
	  }
	  
	  private void drawNameplate(String str, int strRGBA, int strRGBAFaded, int plateR, int plateG, int plateB, int plateA) {}
}
