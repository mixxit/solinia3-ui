package com.solinia.solinia3ui.races;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.RavagerModel;
import net.minecraft.entity.monster.RavagerEntity;
import net.minecraft.entity.passive.fish.TropicalFishEntity;
import net.minecraft.util.ResourceLocation;

public class LizardmanRenderer extends MobRenderer<LizardmanEntity, LizardmanModel>
{
	private static final ResourceLocation field_217778_a = new ResourceLocation("solinia3ui", "textures/entity/lizardman/lizardman.png");

	   public LizardmanRenderer(EntityRendererManager renderManagerIn) {
	      super(renderManagerIn, new LizardmanModel(), 1.1F);
	   }

	   protected ResourceLocation getEntityTexture(RavagerEntity entity) {
	      return field_217778_a;
	   }

	@Override
	protected ResourceLocation getEntityTexture(LizardmanEntity entity) {
		// TODO Auto-generated method stub
		return field_217778_a;
	}
}