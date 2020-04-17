package com.solinia.solinia3ui.races;

import WolfShotz.Wyrmroost.content.entities.dragon.AbstractDragonRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

import com.solinia.solinia3ui.solinia3ui;

public class OWDrakeRenderer extends AbstractDragonRenderer<OWDrakeEntity>
{
	private static final ResourceLocation MALE_COM = new ResourceLocation(solinia3ui.MOD_ID, "textures/entity/owdrake/male_com.png");
	private static final ResourceLocation CHILD_COM = new ResourceLocation(solinia3ui.MOD_ID, "textures/entity/owdrake/child_com.png");

    public OWDrakeRenderer(EntityRendererManager manager)
    {
        super(manager, new OWDrakeModel(), 1.6f);
    }
    
    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(OWDrakeEntity drake)
    {
        if (drake.isChild())
        {
            return CHILD_COM;
        }

        return MALE_COM;
    }
    
}
