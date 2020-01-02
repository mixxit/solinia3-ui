package com.solinia.solinia3ui;

import java.util.Map;

import org.apache.commons.lang3.reflect.FieldUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ChannelManager;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.SoundEngine;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PlayerEventHandler {
	@SubscribeEvent(priority = EventPriority.LOWEST, receiveCanceled = true)
	public void onPlayerInteractEvent(PlayerInteractEvent  event)
	{
		if (event.isCanceled())
			return;
		
		// not in game check
		if (Minecraft.getInstance().player == null)
			return;

	}
	
	@SubscribeEvent
	public void onServerStarting(PlaySoundEvent event) {
		if (!event.getSound().getCategory().equals(SoundCategory.MUSIC))
			return;
		solinia3ui.LOGGER.info("Detected playsound event" + event.getSound().getSoundLocation().getPath());
		
		// cancel vanilla music
		if (!event.getSound().getSoundLocation().getNamespace().equals("solinia3ui"))
		{
			solinia3ui.LOGGER.info("Cancelled vanilla music event" + event.getSound().getSoundLocation().getPath());
			event.setResultSound(null);
			return;
		}
		
		try
		{
		SoundEngine soundEngine = (SoundEngine)FieldUtils.readField(Minecraft.getInstance().getSoundHandler(),"sndManager",true);
		Map<ISound, ChannelManager.Entry> playingSounds = (Map<ISound, ChannelManager.Entry>)FieldUtils.readField(soundEngine,"playingSoundsChannel",true);
		for(ISound sound : playingSounds.keySet())
		{
			if (!sound.getCategory().equals(SoundCategory.MUSIC))
				continue;
			
			if (sound.getSound().getSoundLocation().equals(event.getSound().getSoundLocation()))
			{
				event.setResultSound(null);
				solinia3ui.LOGGER.info("Currently Playing " + sound.getSoundLocation().getPath() + " so i will ignore request to play " + event.getSound().getSoundLocation().getPath());
				return;
			} else {
				soundEngine.sndHandler.stop(sound);
			}
			
		}

		} catch (Exception e)
		{
			e.printStackTrace();
			return;
		}
		
		if(Minecraft.getInstance().getSoundHandler().isPlaying(event.getSound()))
		{
			event.setResultSound(null);
			solinia3ui.LOGGER.info("Cancelled event for sound that was already playing" + event.getSound().getSoundLocation().getPath());
			return;
		}
		
		// do something when the server starts
		solinia3ui.LOGGER.info("Detected music event" + event.getSound().getSoundLocation().getPath());
		
	}
	
	@SubscribeEvent(priority = EventPriority.LOWEST, receiveCanceled = true)
	public void onPlayerInteractEntityInteractEvent(PlayerInteractEvent.EntityInteract  event)
	{
		if (event.isCanceled())
			return;
		
		// not in game check
		if (Minecraft.getInstance().player == null)
			return;

		
	}
}
