package com.solinia.solinia3ui.races;

import WolfShotz.Wyrmroost.content.entities.dragon.AbstractDragonEntity;
import WolfShotz.Wyrmroost.util.entityutils.client.animation.Animation;
import net.minecraft.entity.EntityType;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class CanariWyvernEntity extends AbstractDragonEntity
{
    public static final Animation FLAP_WINGS_ANIMATION = new Animation(22);
    public static final Animation CLEAN_FEATHERS_ANIMATION = new Animation(36);
    public static final Animation THREAT_ANIMATION = new Animation(40);

    public CanariWyvernEntity(EntityType<? extends AbstractDragonEntity> dragon, World world)
    {
        super(dragon, world);
    }

    @Override
    public void livingTick()
    {
        super.livingTick();

        if (!isSleeping() && noActiveAnimation())
        {
        	try
        	{
	            if (getRNG().nextInt(650) == 0) setAnimation(FLAP_WINGS_ANIMATION);
	            else if (getRNG().nextInt(350) == 0) setAnimation(CLEAN_FEATHERS_ANIMATION);
        	} catch (Exception e)
        	{
        		e.printStackTrace();
        	}
        }

        if (getAnimation() == FLAP_WINGS_ANIMATION)
        {
            if (animationTick == 5 || animationTick == 12) playSound(SoundEvents.ENTITY_PHANTOM_FLAP, 0.8f, 1.5f);
        }
    }

    @Override
    public WolfShotz.Wyrmroost.util.entityutils.client.animation.Animation[] getAnimations()
    {
        return new Animation[]{NO_ANIMATION, SLEEP_ANIMATION, WAKE_ANIMATION, FLAP_WINGS_ANIMATION, CLEAN_FEATHERS_ANIMATION, THREAT_ANIMATION};
    }
}
