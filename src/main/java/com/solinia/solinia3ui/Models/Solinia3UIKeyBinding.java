package com.solinia.solinia3ui.Models;

import com.solinia.solinia3ui.ClientState;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.InputMappings;

public class Solinia3UIKeyBinding extends net.minecraft.client.settings.KeyBinding {
	public Solinia3UIKeyBinding(KeyBinding key)
	{
		super(key.getKeyDescription(), key.getKeyConflictContext(), key.getKeyModifier(), key.getKey(), key.getKeyCategory());
	}
	
	public Solinia3UIKeyBinding(String description, net.minecraftforge.client.settings.IKeyConflictContext keyConflictContext, net.minecraftforge.client.settings.KeyModifier keyModifier, final InputMappings.Type inputType, final int keyCode, String category) {
		super(description, keyConflictContext, keyModifier, inputType.getOrMakeInput(keyCode), category);
	}

	@Override
	public boolean isPressed() {
		boolean realIsPressed = super.isPressed();
		if (ClientState.getInstance().isModKeyBind())
		{
			return false;
		}
			
		return realIsPressed;
	}
}
