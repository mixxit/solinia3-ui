package com.solinia.solinia3ui.Models;

import com.solinia.solinia3ui.ClientState;
import com.solinia.solinia3ui.CommonProxy;
import com.solinia.solinia3ui.races.CanariWyvernEntity;
import com.solinia.solinia3ui.races.CanariWyvernRenderer;
import com.solinia.solinia3ui.races.LizardmanEntity;
import com.solinia.solinia3ui.races.LizardmanRenderer;
import com.solinia.solinia3ui.races.OWDrakeEntity;
import com.solinia.solinia3ui.races.OWDrakeRenderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	@Override
	public void preInit() {
		RenderingRegistry.registerEntityRenderingHandler(LizardmanEntity.class, LizardmanRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(OWDrakeEntity.class, OWDrakeRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(CanariWyvernEntity.class, CanariWyvernRenderer::new);
		
		ClientState.getInstance().getKeyBinds().registerKeyBinds();
	}
}
