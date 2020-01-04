package com.solinia.solinia3ui;

import com.solinia.solinia3ui.races.LizardmanEntity;
import com.solinia.solinia3ui.races.LizardmanRenderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	@Override
	public void preInit() {
		RenderingRegistry.registerEntityRenderingHandler(LizardmanEntity.class, LizardmanRenderer::new);
		
		ClientState.getInstance().getKeyBinds().registerKeyBinds();
	}
}
