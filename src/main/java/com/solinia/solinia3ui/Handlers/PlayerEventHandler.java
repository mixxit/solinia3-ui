package com.solinia.solinia3ui.Handlers;

import java.util.Map;

import com.solinia.solinia3ui.ClientState;
import com.solinia.solinia3ui.solinia3ui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ChannelManager;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.SoundEngine;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

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
		//solinia3ui.LOGGER.info("Detected playsound event" + event.getSound().getSoundLocation().getPath());
		
		// cancel vanilla music
		if (!event.getSound().getSoundLocation().getNamespace().equals("solinia3ui"))
		{
			//solinia3ui.LOGGER.info("Cancelled vanilla music event" + event.getSound().getSoundLocation().getPath());
			event.setResultSound(null);
			return;
		}
		
		String zoneMusic = ClientState.getInstance().zoneMusic;
		boolean isZoneMusicPlaying = !(zoneMusic == null || zoneMusic.equals(""));
		
		try
		{
			SoundEngine soundEngine = ObfuscationReflectionHelper.getPrivateValue(net.minecraft.client.audio.SoundHandler.class, Minecraft.getInstance().getSoundHandler(), "field_147694_f");
			Map<ISound, ChannelManager.Entry> playingSounds = ObfuscationReflectionHelper.getPrivateValue(net.minecraft.client.audio.SoundEngine.class, soundEngine, "field_217942_m");
			
			if (!event.getSound().getSoundLocation().getPath().equals(zoneMusic))
			{
				// Why are we trying to play some zone music we are not in?
				solinia3ui.LOGGER.info("im being asked to play " + event.getSound().getSoundLocation().getPath() + " which is not the zone music " + zoneMusic);
				event.setResultSound(null);
				return;
			}
			
			for(ISound sound : playingSounds.keySet())
			{
				if (!sound.getCategory().equals(SoundCategory.MUSIC))
					continue;
				
				if (!isZoneMusicPlaying)
				{
					// No zone music is playing so we should stop all playing music
					soundEngine.sndHandler.stop(sound);
					continue;
				}
				
				if (!sound.getSoundLocation().getPath().equals(zoneMusic))
				{
					// Why are we trying to play some zone music we are not in?
					solinia3ui.LOGGER.info("i found playing music " + sound.getSoundLocation().getPath() + " which is not the zone music " + zoneMusic + " so im stopping it");
					soundEngine.sndHandler.stop(sound);
					continue;
				}
				
				// if we are being requested to play this sound and it is already playing then just cancel the request and let the play continue
				if (sound.getSound().getSoundLocation().equals(event.getSound().getSoundLocation()))
				{
					event.setResultSound(null);
					solinia3ui.LOGGER.info("Im already playing " + sound.getSoundLocation().getPath() + " so i will ignore request to play " + event.getSound().getSoundLocation().getPath());
					return;
				}
				
				
			}
	
			} catch (Exception e)
			{
				e.printStackTrace();
				return;
			}
		
		
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
