package WolfShotz.Wyrmroost.content.entities.dragon;

import WolfShotz.Wyrmroost.util.ModUtils;
import WolfShotz.Wyrmroost.util.QuikMaths;
import WolfShotz.Wyrmroost.util.entityutils.DragonBodyController;
import WolfShotz.Wyrmroost.util.entityutils.ai.DragonLookController;
import WolfShotz.Wyrmroost.util.entityutils.client.animation.Animation;
import WolfShotz.Wyrmroost.util.entityutils.client.animation.IAnimatedObject;
import com.google.common.collect.Lists;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.controller.BodyController;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.IDataSerializer;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.apache.commons.lang3.tuple.Pair;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

/**
 * Created by WolfShotz 7/10/19 - 21:36
 * This is where the magic happens. Here be our Dragons!
 */
public abstract class AbstractDragonEntity extends MonsterEntity implements IAnimatedObject
{
    // Dragon Entity Animations
    public int animationTick;
    public Animation animation = NO_ANIMATION;
    public static Animation SLEEP_ANIMATION;
    public static Animation WAKE_ANIMATION;

    public int shouldFlyThreshold = 3;
    public int sleepCooldown;
    public List<String> immunes = Lists.newArrayList();

    public AbstractDragonEntity(EntityType<? extends AbstractDragonEntity> dragon, World world)
    {
        super(dragon, world);

        lookController = new DragonLookController(this);
        stepHeight = 1;
    }

    /**
     * Register the AI Goals
     */
    @Override
    protected void registerGoals()
    {
        goalSelector.addGoal(1, new SwimGoal(this));
    }

    /**
     * Needed because the field is private >.>
     */
    @Override
    protected BodyController createBodyController()
    {
        return new DragonBodyController(this);
    }

    // ================================
    //           Entity NBT
    // ================================

       /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void tick()
    {
        super.tick();

        if (getAnimation() != NO_ANIMATION)
        {
            ++animationTick;
            if (animationTick >= animation.getDuration()) setAnimation(NO_ANIMATION);
        }
    }

    /**
     * Get all entities in a given range in front of this entity and damage all within it
     */
    public void attackInFront(int radius)
    {
        AxisAlignedBB size = getBoundingBox();
        AxisAlignedBB aabb = size.offset(QuikMaths.calculateYawAngle(renderYawOffset, 0, size.getXSize() / 2)).grow(radius);
        attackInAABB(aabb);
    }

    /**
     * Beat up probably innocent creatures in a given aabb
     *
     * @param aabb good example: getBoundingBox().offset(QuikMaths.calculateYawAngle(renderYawOffset, 0, getBounding().getXSize() / 2));
     */
    public void attackInAABB(AxisAlignedBB aabb)
    {
        List<LivingEntity> livingEntities = world.getEntitiesWithinAABB(LivingEntity.class, aabb, found -> found != this && getPassengers().stream().noneMatch(found::equals));

        if (livingEntities.isEmpty()) return;
        livingEntities.forEach(this::attackEntityAsMob);
    }
    /**
     * Effects to play when the dragon is 'Special'
     * Default to white sparkles around the body.
     * Can be overriden to do custom effects.
     */
    public void doSpecialEffects()
    {
        if (ticksExisted % 25 == 0)
        {
            double x = posX + getWidth() * (getRNG().nextGaussian() * 0.5d);
            double y = posY + getHeight() * (getRNG().nextDouble());
            double z = posZ + getWidth() * (getRNG().nextGaussian() * 0.5d);
            world.addParticle(ParticleTypes.END_ROD, x, y, z, 0, 0.05f, 0);
        }
    }


    /**
     * Try teleporting to a pos after a search for a safe location
     */
    public boolean tryTeleportToPos(BlockPos pos)
    {
        AxisAlignedBB aabb = getBoundingBox();
        double growX = aabb.maxX - aabb.minX;
        double growY = aabb.maxY - aabb.minY;
        double growZ = aabb.maxZ - aabb.minZ;
        AxisAlignedBB potentialAABB = new AxisAlignedBB(pos).grow(growX, 0, growZ).expand(0, growY, 0);

        for (int i = 0; i <= 4; ++i)
        {
            for (int l = 0; l <= 4; ++l)
            {
                if ((i < 1 || l < 1 || i > 3 || l > 3) && ModUtils.isBoxSafe(potentialAABB, world) && (!world.getBlockState(pos.down()).isAir(world, pos)))
                {
                    setPosition(pos.getX(), pos.getY(), pos.getZ());
                    clearAI();

                    return true;
                }
            }
        }

        getBoundingBox().expand(0.1, 0.1, 0.1);

        return false;
    }

    /**
     * Public access version of {@link Entity#setRotation}
     */
    public void setRotation(float yaw, float pitch)
    {
        this.rotationYaw = yaw % 360.0F;
        this.rotationPitch = pitch % 360.0F;
    }

    /**
     * Handle eating. (Effects, healing, breeding etc)
     */
    public void eat(@Nullable ItemStack stack)
    {
        if (stack != null && !stack.isEmpty())
        {
            stack.shrink(1);
            if (getHealth() < getMaxHealth()) heal(Math.max((int) getMaxHealth() / 5, 6));
            if (stack.getItem().isFood())
            {
                try
                { // Surrounding in try catch block. checking for null doesnt seem to work...
                    List<Pair<EffectInstance, Float>> effects = Objects.requireNonNull(stack.getItem().getFood()).getEffects();
                    if (!effects.isEmpty() && effects.stream().noneMatch(e -> e.getLeft() == null)) // Apply food effects if it has any
                        effects.forEach(e -> addPotionEffect(e.getLeft()));
                }
                catch (Exception ignore) {}
            }
            playSound(SoundEvents.ENTITY_GENERIC_EAT, 1f, 1f);
            if (world.isRemote)
            {
                Vec3d mouth = getApproximateMouthPos();

                for (int i = 0; i < 11; ++i)
                {
                    Vec3d vec3d1 = new Vec3d(((double) rand.nextFloat() - 0.5D) * 0.1D, Math.random() * 0.1D + 0.1D, ((double) rand.nextFloat() - 0.5D) * 0.1D);
                    vec3d1 = vec3d1.rotatePitch(-rotationPitch * (QuikMaths.PI / 180f));
                    vec3d1 = vec3d1.rotateYaw(-rotationYaw * (QuikMaths.PI / 180f));
                    world.addParticle(new ItemParticleData(ParticleTypes.ITEM, stack), mouth.x, mouth.y, mouth.z, vec3d1.x, vec3d1.y, vec3d1.z);
                }
            }
        }
    }
    /**
     * Add health to the current amount
     */
    @Override
    public void heal(float healAmount)
    {
        super.heal(healAmount);

        if (world.isRemote)
        {
            for (int i = 0; i < getWidth() * 5; ++i)
            {
                double x = posX + (getRNG().nextGaussian() * getWidth()) / 1.5d;
                double y = posY + getRNG().nextDouble() * (getRNG().nextDouble() + 2d);
                double z = posZ + (getRNG().nextGaussian() * getWidth()) / 1.5d;
                world.addParticle(ParticleTypes.HAPPY_VILLAGER, x, y, z, 0, 0, 0);
            }
        }
    }

    /**
     * Clear any AI tasks that might still be running
     */
    public void clearAI()
    {
        isJumping = false;
        navigator.clearPath();
        setAttackTarget(null);
    }

    /**
     * is big boi dragon doing anything?
     */
    public boolean isIdling()
    {
        return getNavigator().noPath()
                && getAttackTarget() == null
                && !isInWaterOrBubbleColumn();
    }

    /**
     * A universal getter for the position of the mouth on the dragon.
     * This is prone to be inaccurate, but can serve good enough for most things
     * If a more accurate position is needed, best to override and adjust accordingly.
     *
     * @return An approximate position of the mouth of the dragon
     */
    public Vec3d getApproximateMouthPos()
    {
        return QuikMaths.calculateYawAngle(renderYawOffset, 0, (getWidth() / 2) + 0.5d).add(posX, posY + getEyeHeight() - 0.15d, posZ);
    }

    /**
     * Get all entities in this entities bounding box increased by a range
     */
    public List<Entity> getEntitiesNearby(double radius)
    {
        return world.getEntitiesWithinAABB(LivingEntity.class, getBoundingBox().grow(radius), found -> found != this && getPassengers().stream().noneMatch(found::equals));
    }

    /**
     * Get all entities excluding certain ones in this entities bounding box increased by a range
     */
    public List<Entity> getEntitiesNearby(double radius, Entity instanceExclusion)
    {
        return world.getEntitiesInAABBexcluding(instanceExclusion, getBoundingBox().grow(radius), found -> getPassengers().stream().noneMatch(found::equals));
    }

    /**
     * Add additional motion to current velocity
     */
    public void addMotion(Vec3d vec3d)
    {
        setMotion(getMotion().add(vec3d));
    }

    /**
     * Add additional motion to current velocity
     */
    public void addMotion(double x, double y, double z)
    {
        setMotion(getMotion().add(x, y, z));
    }

    /**
     * Nuff' said
     */
    @Override
    public void playAmbientSound()
    {
        if (!isSleeping()) super.playAmbientSound();
    }

    /**
     * Set a damage source immunity
     */
    public void setImmune(DamageSource source)
    {
        immunes.add(source.getDamageType());
    }

    /**
     * Whether or not the dragon is immune to the source or not
     */
    private boolean isImmune(DamageSource source)
    {
        return !immunes.isEmpty() && immunes.contains(source.getDamageType());
    }

    /**
     * Are we immune to this damage source?
     */
    @Override
    public boolean isInvulnerableTo(DamageSource source)
    {
        return super.isInvulnerableTo(source) || isImmune(source);
    }

    /**
     * Perform a one-shot attack
     */
    public void performGenericAttack()
    {
    }

    /**
     * Perform a continuous special attack, e.g. Fire breathing
     *
     * @param shouldContinue True = continue attacking | False = interrupt / stop attack
     */
    public void performSpecialAttack(boolean shouldContinue)
    {
    }

    /**
     * Get the current tick time for the playing animation
     */
    @Override
    public int getAnimationTick()
    {
        return animationTick;
    }

    /**
     * Set the animation tick for the playing animation
     */
    @Override
    public void setAnimationTick(int tick)
    {
        animationTick = tick;
    }

    /**
     * Get the current playing animation
     */
    @Override
    public Animation getAnimation()
    {
        return animation;
    }

    /**
     * Set an animation
     */
    @Override
    public void setAnimation(Animation animation)
    {
        if (animation == null) animation = NO_ANIMATION;
        setAnimationTick(0);
        this.animation = animation;
    }

    /**
     * Is no active animation playing currently?
     */
    public boolean noActiveAnimation()
    {
        return getAnimation() == NO_ANIMATION || getAnimationTick() == 0;
    }

    // ================================

    /**
     * Create a boolean data Parameter
     */
    public static <T> DataParameter<T> createKey(IDataSerializer<T> serializer)
    {
        return EntityDataManager.createKey(AbstractDragonEntity.class, serializer);
    }
}
