package WolfShotz.Wyrmroost.util.entityutils.client.model;

import WolfShotz.Wyrmroost.util.entityutils.client.animation.ModelAnimator;
import com.google.common.collect.Maps;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Map;

public class AdvancedLivingEntityModel<T extends Entity> extends EntityModel<T>
{
    public T entity;
    public float globalSpeed = 0.5f;
    private float movementScale = 1.0F;
    private final Map<String, Pair<Integer, Integer>> modelTextureMap = Maps.newHashMap();
    
    public AdvancedLivingEntityModel() {}
    
    public void updateDefaultPose()
    {
        boxList.stream()
                .filter(AdvancedRendererModel.class::isInstance)
                .forEach((model) -> ((AdvancedRendererModel) model).updateDefaultPose());
    }
    
    protected void setTextureOffset(String partName, int x, int y)
    {
        modelTextureMap.put(partName, Pair.of(x, y));
    }
    
    public Pair<Integer, Integer> getTextureOffset(String partName)
    {
        return modelTextureMap.get(partName);
    }
    
    public void resetToDefaultPose()
    {
        boxList.stream()
                .filter(AdvancedRendererModel.class::isInstance)
                .forEach((model) -> ((AdvancedRendererModel) model).resetToDefaultPose());
    }
    
    public void faceTarget(float yaw, float pitch, float rotationDivisor, AdvancedRendererModel... boxes)
    {
        float actualRotationDivisor = rotationDivisor * (float) boxes.length;
        float yawAmount = yaw / 57.295776F / actualRotationDivisor;
        float pitchAmount = pitch / 57.295776F / actualRotationDivisor;
        AdvancedRendererModel[] var8 = boxes;
        int var9 = boxes.length;
        
        for (int var10 = 0; var10 < var9; ++var10)
        {
            AdvancedRendererModel box = var8[var10];
            box.rotateAngleY += yawAmount;
            box.rotateAngleX += pitchAmount;
        }
    }
    
    public void chainSwing(AdvancedRendererModel[] boxes, float speed, float degree, double rootOffset, float swing, float swingAmount)
    {
        float offset = this.calculateChainOffset(rootOffset, boxes);
        
        for (int index = 0; index < boxes.length; ++index)
            boxes[index].rotateAngleY += this.calculateChainRotation(speed, degree, swing, swingAmount, offset, index);
    }
    
    public void chainWave(AdvancedRendererModel[] boxes, float speed, float degree, double rootOffset, float swing, float swingAmount)
    {
        float offset = this.calculateChainOffset(rootOffset, boxes);
        
        for (int index = 0; index < boxes.length; ++index)
            boxes[index].rotateAngleX += this.calculateChainRotation(speed, degree, swing, swingAmount, offset, index);
        
    }
    
    public void chainFlap(AdvancedRendererModel[] boxes, float speed, float degree, double rootOffset, float swing, float swingAmount)
    {
        float offset = this.calculateChainOffset(rootOffset, boxes);
        
        for (int index = 0; index < boxes.length; ++index)
        {
            boxes[index].rotateAngleZ += this.calculateChainRotation(speed, degree, swing, swingAmount, offset, index);
        }
        
    }
    
    private float calculateChainRotation(float speed, float degree, float swing, float swingAmount, float offset, int boxIndex)
    {
        return MathHelper.cos(swing * speed * this.movementScale + offset * (float) boxIndex) * swingAmount * degree * this.movementScale;
    }
    
    private float calculateChainOffset(double rootOffset, AdvancedRendererModel... boxes)
    {
        return (float) (rootOffset * 3.141592653589793D / (double) (2 * boxes.length));
    }
    
    public float getMovementScale()
    {
        return this.movementScale;
    }
    
    public void setMovementScale(float movementScale)
    {
        this.movementScale = movementScale;
    }
    
    public void walk(AdvancedRendererModel box, float speed, float degree, boolean invert, float offset, float weight, float walk, float walkAmount)
    {
        box.walk(speed, degree, invert, offset, weight, walk, walkAmount);
    }
    
    public void flap(AdvancedRendererModel box, float speed, float degree, boolean invert, float offset, float weight, float flap, float flapAmount)
    {
        box.flap(speed, degree, invert, offset, weight, flap, flapAmount);
    }
    
    public void swing(AdvancedRendererModel box, float speed, float degree, boolean invert, float offset, float weight, float swing, float swingAmount)
    {
        box.swing(speed, degree, invert, offset, weight, swing, swingAmount);
    }
    
    public void bob(AdvancedRendererModel box, float speed, float degree, boolean bounce, float f, float f1)
    {
        box.bob(speed, degree, bounce, f, f1);
    }
    
    public float moveBox(float speed, float degree, boolean bounce, float f, float f1)
    {
        return bounce? -MathHelper.abs(MathHelper.sin(f * speed) * f1 * degree) : MathHelper.sin(f * speed) * f1 * degree - f1 * degree;
    }
    
    public void setRotateAngle(AdvancedRendererModel model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void rotate(ModelAnimator animator, AdvancedRendererModel model, float x, float y, float z)
    {
        animator.rotate(model, (float) Math.toRadians(x), (float) Math.toRadians(y), (float) Math.toRadians(z));
    }
    
    public void rotateMinus(ModelAnimator animator, AdvancedRendererModel model, float x, float y, float z)
    {
        animator.rotate(model, (float) Math.toRadians(x) - model.defaultRotationX, (float) Math.toRadians(y) - model.defaultRotationY, (float) Math.toRadians(z) - model.defaultRotationZ);
    }
    
    public void idleAnim(float frame)
    {
    }
}
