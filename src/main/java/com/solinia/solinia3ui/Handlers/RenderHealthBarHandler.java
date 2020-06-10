package com.solinia.solinia3ui.Handlers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

import org.lwjgl.opengl.GL11;

import com.mojang.blaze3d.platform.GlStateManager;
import com.solinia.solinia3ui.ClientState;
import com.solinia.solinia3ui.Models.HealthBarConfig;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public class RenderHealthBarHandler {
	List<LivingEntity> renderedEntities = new ArrayList<>();
	
	/* NO LONGER WORKS IN 1.15.2
	 @SubscribeEvent
	 public void renderNamePlate(RenderLivingEvent.Specials.Pre event) {
		 event.setCanceled(true);
	 }
	*/
	
	@SubscribeEvent
	public void onRenderWorldLastTwo(RenderWorldLastEvent event) {
		
	}
	 
	 
	
	@SubscribeEvent
	public void onRenderWorldLast(RenderWorldLastEvent event) {
		renderNamePlates(event);
		
	}

	private void renderNamePlates(RenderWorldLastEvent event) {
		/* Needs updating for 1.15.2
		try
		{
			Minecraft mc = Minecraft.getInstance();
	
			if((!HealthBarConfig.renderInF1 && !Minecraft.isGuiEnabled()) || !HealthBarConfig.draw)
				return;
	
			Entity cameraEntity = mc.getRenderViewEntity();
			BlockPos renderingVector = cameraEntity.getPosition();
			Frustum frustum = new Frustum();
	
			float partialTicks = event.getPartialTicks();
			double viewX = cameraEntity.lastTickPosX + (cameraEntity.getPosX() - cameraEntity.lastTickPosX) * partialTicks;
			double viewY = cameraEntity.lastTickPosY + (cameraEntity.getPosY() - cameraEntity.lastTickPosY) * partialTicks;
			double viewZ = cameraEntity.lastTickPosZ + (cameraEntity.getPosZ() - cameraEntity.lastTickPosZ) * partialTicks;
			frustum.setPosition(viewX, viewY, viewZ);
			
				ClientWorld client = mc.world;
				Int2ObjectMap<Entity> entitiesById = ObfuscationReflectionHelper.getPrivateValue(ClientWorld.class, client, "field_217429_b");
				for(Entity entity : entitiesById.values()) {
					if (entity != null && entity instanceof LivingEntity && entity != mc.player && entity.isInRangeToRender3d(renderingVector.getX(), renderingVector.getY(), renderingVector.getZ()) && (entity.ignoreFrustumCheck || frustum.isBoundingBoxInFrustum(entity.getBoundingBox())) && entity.isAlive() && entity.getRecursivePassengers().isEmpty())
						renderHealthBar((LivingEntity) entity, partialTicks, cameraEntity);
				}
		} catch (Exception e)
		{
			e.printStackTrace();
		}*/
	}



	public void renderHealthBar(LivingEntity passedEntity, float partialTicks, Entity viewPoint) {
		/* Needs updating for 1.15.2
		Stack<LivingEntity> ridingStack = new Stack<>();
		
		LivingEntity entity = passedEntity;
		ridingStack.push(entity);

		while(entity.getRidingEntity() != null && entity.getRidingEntity() instanceof LivingEntity) {
			entity = (LivingEntity) entity.getRidingEntity();
			ridingStack.push(entity);
		}

		Minecraft mc = Minecraft.getInstance();
		
		float pastTranslate = 0F;
		while(!ridingStack.isEmpty()) {
			entity = ridingStack.pop();
			boolean boss = !entity.isNonBoss();

			String entityID = entity.getEntityString();	
			
			processing: {
				float distance = passedEntity.getDistance(viewPoint);
				if(distance > HealthBarConfig.maxDistance || !passedEntity.canEntityBeSeen(viewPoint) || entity.isInvisible()) 
					break processing;
				if(!HealthBarConfig.showOnBosses && !boss)
					break processing;
				if(!HealthBarConfig.showOnPlayers && entity instanceof PlayerEntity)
					break processing;

				double x = passedEntity.lastTickPosX + (passedEntity.getPosX() - passedEntity.lastTickPosX) * partialTicks;
				double y = passedEntity.lastTickPosY + (passedEntity.getPosY() - passedEntity.lastTickPosY) * partialTicks;
				double z = passedEntity.lastTickPosZ + (passedEntity.getPosZ() - passedEntity.lastTickPosZ) * partialTicks;

				float scale = 0.026666672F;
				
				EntityRendererManager renderManager = Minecraft.getInstance().getRenderManager();
				double renderPosX = ObfuscationReflectionHelper.getPrivateValue(EntityRendererManager.class, renderManager, "field_78725_b");
				double renderPosY = ObfuscationReflectionHelper.getPrivateValue(EntityRendererManager.class, renderManager, "field_78726_c");
				double renderPosZ = ObfuscationReflectionHelper.getPrivateValue(EntityRendererManager.class, renderManager, "field_78723_d");

				GlStateManager.pushMatrix();
				GlStateManager.translatef((float) (x - renderPosX), (float) (y - renderPosY + passedEntity.getHeight() + HealthBarConfig.heightAbove), (float) (z - renderPosZ));
				GL11.glNormal3f(0.0F, 1.0F, 0.0F);
				GlStateManager.rotatef(-renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
				GlStateManager.rotatef(renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
				GlStateManager.scalef(-scale, -scale, scale);
				boolean lighting = GL11.glGetBoolean(GL11.GL_LIGHTING);
				GlStateManager.disableLighting();
				GlStateManager.depthMask(false);
				GlStateManager.disableDepthTest();
				GlStateManager.disableTexture();
				GlStateManager.enableBlend();
				GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				Tessellator tessellator = Tessellator.getInstance();
				BufferBuilder buffer = tessellator.getBuffer();

				float padding = 0;//HealthBarConfig.backgroundPadding;
				int bgHeight = 1;//HealthBarConfig.backgroundHeight;
				int barHeight = 8;//HealthBarConfig.barHeight;
				float size =1;// HealthBarConfig.plateSize;

				
				GlStateManager.translatef(0F, pastTranslate, 0F);
				
				float fontSize = 1F;
				String name = entity.getDisplayName().getFormattedText();
				for(ITextComponent sibling : entity.getDisplayName().getSiblings())
				{
					name = sibling.getString();
				}
				
				if(entity.hasCustomName())
				{
					if (entity instanceof LivingEntity && entity.hasCustomName())
					{
						ITextComponent textName = entity.getCustomName();
						for(ITextComponent sibling : textName.getSiblings())
						{
							name = sibling.getString();
						}
					}
				}
				
				int targetEntityId = 0;
				
				if (ClientState.getInstance().getEntityVital(-1) != null && ClientState.getInstance().getEntityVital(-1).getEntityId() > 0)
				{
					targetEntityId = ClientState.getInstance().getEntityVital(-1).getEntityId();
					
					//event.getEntity().getEntityId() == ClientState.getInstance().getEntityVital(-1).getEntityId()
				}
				
				if (entity.getEntityId() == targetEntityId)
				name = "> "+name+" <";
					
				float namel = mc.fontRenderer.getStringWidth(name) * fontSize;
				if(namel + 20 > size * 2)
					size = namel / 2F + 6F;
				
				int colr=0;
				int colg=0;
				int colb=0;
				
				
				
				if (entity.getEntityId() == targetEntityId)
				{
					colr=0;
					colg=255;
					colb=0;
				}
				
				// Background
				if(HealthBarConfig.drawBackground) {
					buffer.begin(7, DefaultVertexFormats.POSITION_COLOR);
					buffer.pos(-size - padding, -bgHeight, 0.0D).color(colr, colg, colb, 64).endVertex();
					buffer.pos(-size - padding, barHeight + padding, 0.0D).color(colr, colg, colb, 64).endVertex();
					buffer.pos(size + padding, barHeight + padding, 0.0D).color(colr, colg, colb, 64).endVertex();
					buffer.pos(size + padding, -bgHeight, 0.0D).color(colr, colg, colb, 64).endVertex();
					tessellator.draw();
				}
				
				GlStateManager.enableTexture();
				
				GlStateManager.pushMatrix();
				GlStateManager.translatef(-size, 0F, 0F);
				GlStateManager.scalef(fontSize, fontSize, fontSize);
				mc.fontRenderer.drawString(name, 6, 0, 0xFFFFFF);

				GlStateManager.pushMatrix();
				float s1 = 0.75F;
				GlStateManager.scalef(s1, s1, s1);
				
			
 				GlStateManager.popMatrix();
 				
 				GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
				int off = 0;

				s1 = 0.5F;
				GlStateManager.scalef(s1, s1, s1);
				GlStateManager.translatef(size / (fontSize * s1) * 2 - 16, 0F, 0F);
				mc.textureManager.bindTexture(AtlasTexture.LOCATION_BLOCKS_TEXTURE);
				
				GlStateManager.popMatrix();

				GlStateManager.disableBlend();
				GlStateManager.enableDepthTest();
				GlStateManager.depthMask(true);
				if(lighting)
					GlStateManager.enableLighting();
				GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
				GlStateManager.popMatrix();
				
				pastTranslate -= bgHeight + barHeight + padding;
			}
		}
		*/
	}
	
}
