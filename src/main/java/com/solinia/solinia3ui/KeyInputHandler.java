package com.solinia.solinia3ui;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Lists;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.event.InputEvent.KeyInputEvent;
import net.minecraftforge.client.event.InputEvent.MouseInputEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;
import net.minecraftforge.items.IItemHandler;
import org.apache.commons.lang3.ObjectUtils;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

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
		
		if (!isInScreen() && rightClickedNearEntity())
			sendRightClickEntityPack();
	}
	
	private void sendRightClickEntityPack() {
		Minecraft.getInstance().player.sendChatMessage("/solinia3core:rightclickentity");
	}
	
	public static <T extends Entity> T getClosest(List<T> entities, Entity to)
	{
		T ret = null;
		double dist = Double.MAX_VALUE;
		for (T t : entities)
		{
			double distance = t.getDistance(to);
			if (distance < dist)
			{
				dist = distance;
				ret = t;
			}
		}
		
		return ret;
	}
	
	//https://github.com/V0idWa1k3r/ExPetrum/blob/master/src/main/java/v0id/exp/util/Helpers.java#L123
	public static <T extends Entity>List<T> rayTraceEntities(World w, Vec3d pos, Vec3d ray, Optional<Predicate<T>> entityFilter, Class<T> entityClazz)
	{
		Vec3d end = pos.add(new Vec3d(1, 1, 1));
		AxisAlignedBB aabb = new AxisAlignedBB(pos.x, pos.y, pos.z, end.x, end.y, end.z).expand(ray.x, ray.y, ray.z);
		Vec3d checkVec = pos.add(ray);
		List<T> ret = Lists.newArrayList();
		for (T t : w.getEntitiesWithinAABB(entityClazz, aabb, entityFilter.orElse(Predicates.alwaysTrue())))
		{
			AxisAlignedBB entityBB = t.getBoundingBox();
			if (entityBB == null)
			{
				continue;
			}
			
			if (entityBB.intersects(Math.min(pos.x, checkVec.x), Math.min(pos.y, checkVec.y), Math.min(pos.z, checkVec.z), Math.max(pos.x, checkVec.x), Math.max(pos.y, checkVec.y), Math.max(pos.z, checkVec.z)))
			{
				ret.add(t);
			}
		}
		
		return ret;
	}

	private boolean rightClickedNearEntity() {
		if (isMouseOverNearEntity())
			return true;
		
		return false;
	}

	private boolean isMouseOverNearEntity() {
		Vec3d look = Minecraft.getInstance().player.getLookVec().scale(3);
		Vec3d pos = Minecraft.getInstance().player.getPositionVector();
		List<Entity> targets = rayTraceEntities(Minecraft.getInstance().player.world, pos.add(0, Minecraft.getInstance().player.getEyeHeight(), 0), look, Optional.of(e -> e != Minecraft.getInstance().player), Entity.class);
		Entity assumedToBeLookedAt = getClosest(targets, Minecraft.getInstance().player);
		if (assumedToBeLookedAt != null)
		{
			return true;
		}
		
		return false;
	}

	private boolean isInScreen() {
		return Minecraft.getInstance().currentScreen != null;
	}
}
