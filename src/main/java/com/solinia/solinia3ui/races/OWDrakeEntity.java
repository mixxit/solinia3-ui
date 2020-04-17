package com.solinia.solinia3ui.races;

import WolfShotz.Wyrmroost.content.entities.dragon.AbstractDragonEntity;
import WolfShotz.Wyrmroost.util.QuikMaths;
import WolfShotz.Wyrmroost.util.entityutils.client.animation.Animation;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.OwnerHurtByTargetGoal;
import net.minecraft.entity.ai.goal.OwnerHurtTargetGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SaddleItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;
import java.util.*;

import static net.minecraft.entity.SharedMonsterAttributes.*;

/**
 * Created by WolfShotz 7/10/19 - 22:18
 */
public class OWDrakeEntity extends AbstractDragonEntity
{
    private static final UUID SPRINTING_ID = UUID.fromString("662A6B8D-DA3E-4C1C-8813-96EA6097278D");
    private static final AttributeModifier SPRINTING_SPEED_BOOST = (new AttributeModifier(SPRINTING_ID, "Sprinting speed boost", 1.15F, AttributeModifier.Operation.MULTIPLY_TOTAL)).setSaved(false);

    // Dragon Entity Animations
    public static final Animation SIT_ANIMATION = new Animation(15);
    public static final Animation STAND_ANIMATION = new Animation(15);
    public static final Animation GRAZE_ANIMATION = new Animation(35);
    public static final Animation HORN_ATTACK_ANIMATION = new Animation(15);
    public static final Animation ROAR_ANIMATION = new Animation(86);
    public static final Animation TALK_ANIMATION = new Animation(20);

    public OWDrakeEntity(EntityType<? extends OWDrakeEntity> type, World worldIn) {
    	super(type, worldIn);

        moveController = new MovementController(this);

        SLEEP_ANIMATION = new Animation(20);
        WAKE_ANIMATION = new Animation(15);
	   }

    /**
     * Set sprinting switch for Entity.
     */
    public void setSprinting(boolean sprinting)
    {
        if (isSprinting() == sprinting) return;

        IAttributeInstance attribute = getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);
        
        super.setSprinting(sprinting);
        
        if (attribute.getModifier(SPRINTING_ID) != null) attribute.removeModifier(SPRINTING_SPEED_BOOST);
        if (sprinting) attribute.applyModifier(SPRINTING_SPEED_BOOST);
    }
    

    // ================================
    
    @Override
    public void livingTick()
    {
        if (getAnimation() == ROAR_ANIMATION)
        {
            if (getAnimationTick() == 1)
                //playSound(WRSounds.OWDRAKE_ROAR.get(), 2.5f, 1f);
            if (getAnimationTick() == 15)
            {
                for (Entity e : getEntitiesNearby(5)) // Dont get too close now ;)
                {
                    if (e instanceof OWDrakeEntity) continue;
                    double angle = (QuikMaths.getAngle(posX, e.posX, posZ, e.posZ) + 90) * Math.PI / 180;
                    double x = 1.2 * (-Math.cos(angle));
                    double z = 1.2 * (-Math.sin(angle));
                    e.addVelocity(x, 0.4d, z);
                }
            }
            if (getAnimationTick() > 15)
            {
                for (Entity e : getEntitiesNearby(20, this))
                {
                    if (!(e instanceof LivingEntity) || e instanceof OWDrakeEntity) continue;
                    ((LivingEntity) e).addPotionEffect(new EffectInstance(Effects.SLOWNESS, 120));
                }
            }
        }
        
        if (getAnimation() == HORN_ATTACK_ANIMATION && getAnimationTick() == 8)
        {
            world.playSound(posX, posY, posZ, SoundEvents.ENTITY_IRON_GOLEM_ATTACK, SoundCategory.AMBIENT, 1f, 0.5f, false);
            AxisAlignedBB size = getBoundingBox();
            AxisAlignedBB aabb = size.offset(QuikMaths.calculateYawAngle(renderYawOffset, 0, size.getXSize() / 2)).grow(0.5d);
            attackInAABB(aabb);
//            ModUtils.getAllPosesInBB(aabb.shrink(0.5d), world).forEach(p ->
//                    world.getBlockState(p).removedByPlayer(world, p, null, false, null));
        }
        
        super.livingTick();
    }
    
    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag)
    {
        Biome biome = worldIn.getBiome(new BlockPos(this));
        return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }
        
    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn)
    {
        if (ticksExisted % 2 == 0) playSound(SoundEvents.ENTITY_COW_STEP, 0.3f, 1);
        
        super.playStepSound(pos, blockIn);
    }
    
    @Override
    public void playAmbientSound()
    {
        if (!isSleeping())
        {
            if (noActiveAnimation()) setAnimation(TALK_ANIMATION);
            super.playAmbientSound();
        }
    }
    
    @Override
    public void performGenericAttack()
    {
        setAnimation(HORN_ATTACK_ANIMATION);
    }
    
    @Override
    protected boolean isMovementBlocked()
    {
        return super.isMovementBlocked() || getAnimation() == ROAR_ANIMATION;
    }
    
    @Override
    protected int getExperiencePoints(PlayerEntity player)
    {
        return 2 + rand.nextInt(3);
    }
    
    @Override
    public Animation[] getAnimations()
    {
        return new Animation[]{NO_ANIMATION, GRAZE_ANIMATION, HORN_ATTACK_ANIMATION, SIT_ANIMATION, STAND_ANIMATION, SLEEP_ANIMATION, WAKE_ANIMATION, ROAR_ANIMATION};
    }
}
