package com.solinia.solinia3ui;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemFrameEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.InputEvent.KeyInputEvent;
import net.minecraftforge.client.event.InputEvent.MouseInputEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class KeyInputHandler {
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onKeyInputEvent(KeyInputEvent event) {
		if (event.isCanceled())
			return;
		
		// not in game check
		if (Minecraft.getInstance().player == null)
			return;

		//System.out.println("DEBUGKEY: " + event.getScanCode() + " " + event.getAction() + " " + event.getKey() + " " + event.getModifiers());
		
		if (event.getAction() != 1)
			return;
		
		ClientState.getInstance().attemptUseModKeybinds();
	}
	
	@SubscribeEvent(priority = EventPriority.LOWEST, receiveCanceled = true)
	public void onMouseInputEvent(MouseInputEvent event)
	{
		if (event.isCanceled())
			return;
		
		// not in game check
		if (Minecraft.getInstance().player == null)
			return;
		
		if (event.getButton() != 1)
			return;
		
		if (event.getAction() != 1)
			return;
		
		if (!isInScreen())
			tryRightClickNpcAndSendToServer();
	}
	
	private void tryRightClickNpcAndSendToServer() {
		Entity entity = Minecraft.getInstance().getRenderViewEntity();
		if (entity != null)
		{
			// distance
			double distance = 200D;
			boolean flag = false;
			RayTraceResult raycast = entity.func_213324_a(distance, Minecraft.getInstance().getRenderPartialTicks(), false);
			if (raycast != null)
			{
				Vec3d vec3d = entity.getEyePosition(Minecraft.getInstance().getRenderPartialTicks());
				double d1 = distance;
				if (distance > 3.0D)
					flag = true;

				d1 = d1 * d1;
				if (raycast != null) {
		               d1 = raycast.getHitVec().squareDistanceTo(vec3d);
		            }
				
				Vec3d vec3d1 = entity.getLook(1.0F);
	            Vec3d vec3d2 = vec3d.add(vec3d1.x * distance, vec3d1.y * distance, vec3d1.z * distance);
	            AxisAlignedBB axisalignedbb = entity.getBoundingBox().expand(vec3d1.scale(distance)).grow(1.0D, 1.0D, 1.0D);
	            EntityRayTraceResult entityraytraceresult = ProjectileHelper.func_221273_a(entity, vec3d, vec3d2, axisalignedbb, (p_215312_0_) -> {
	               return !p_215312_0_.isSpectator() && p_215312_0_.canBeCollidedWith();
	            }, d1);
				
	            if (entityraytraceresult != null && entityraytraceresult instanceof EntityRayTraceResult) {
	                Entity entity1 = entityraytraceresult.getEntity();
		    		Minecraft.getInstance().player.sendChatMessage("/solinia3core:rightclickentity " + entity1.getEntityId());
		    	} else {
		    		Minecraft.getInstance().player.sendChatMessage("/solinia3core:rightclickentity 0");
		    	}
			} else {
	    		Minecraft.getInstance().player.sendChatMessage("/solinia3core:rightclickentity 0");
	    	}
		} else {
			Minecraft.getInstance().player.sendChatMessage("/solinia3core:rightclickentity 0");
		}
		
	}

	private boolean isInScreen() {
		return Minecraft.getInstance().currentScreen != null;
	}
}
