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
		
		if (event.getAction() != 1)
			return;
		
		if (!isInScreen())
			sendRightClickPacket();
	}
	
	private void sendRightClickPacket() {
		Minecraft.getInstance().player.sendChatMessage("/solinia3core:rightclickentity");
	}

	private boolean isInScreen() {
		return Minecraft.getInstance().currentScreen != null;
	}
}
