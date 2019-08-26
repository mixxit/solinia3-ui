package com.solinia.solinia3ui;

import java.util.UUID;

public class EntityVital {
	float healthPercent = 0.0F;
	float manaPercent = 0.0F;
	UUID uniqueId = null;
	String name = "";

	public EntityVital(float healthPercent, float manaPercent, UUID uniqueId, String name) {
		this.healthPercent = healthPercent;
		this.manaPercent = manaPercent;
		this.uniqueId = uniqueId;
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public UUID getUniqueId()
	{
		return this.uniqueId;
	}
	
	public float getManaPercent()
	{
		return this.manaPercent;
	}
	
	public float getHealthPercent()
	{
		return this.healthPercent;
	}
	

}
