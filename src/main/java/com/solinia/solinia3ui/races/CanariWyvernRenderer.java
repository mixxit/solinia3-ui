package com.solinia.solinia3ui.races;

import javax.annotation.Nullable;

import com.solinia.solinia3ui.solinia3ui;

import WolfShotz.Wyrmroost.content.entities.dragon.AbstractDragonRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class CanariWyvernRenderer extends AbstractDragonRenderer<CanariWyvernEntity>
{
    public static final ResourceLocation MALE_RED = new ResourceLocation(solinia3ui.MOD_ID, "textures/entity/canariwyvern/body_mr.png");
    
    public CanariWyvernRenderer(EntityRendererManager manager)
    {
        super(manager, new CanariWyvernModel(), 1.35f);
    }
    
    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(CanariWyvernEntity canari)
    {
        return MALE_RED;
    }
}