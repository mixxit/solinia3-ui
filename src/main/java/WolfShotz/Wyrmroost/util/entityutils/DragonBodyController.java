package WolfShotz.Wyrmroost.util.entityutils;

import WolfShotz.Wyrmroost.content.entities.dragon.AbstractDragonEntity;
import net.minecraft.entity.ai.controller.BodyController;
import net.minecraft.util.math.MathHelper;

/**
 * Created by WolfShotz - 8/26/19 - 16:12
 * <p>
 * Class Responsible for disallowing rotation while sitting, sleeping, etc
 */
public class DragonBodyController extends BodyController
{
    private AbstractDragonEntity dragon;
    
    public DragonBodyController(AbstractDragonEntity dragon)
    {
        super(dragon);
        this.dragon = dragon;
    }
    
    @Override
    public void updateRenderAngles()
    {
        // No rotations while sitting or sleeping
        if (dragon.isSleeping()) return;
        
        super.updateRenderAngles();
    }
}
