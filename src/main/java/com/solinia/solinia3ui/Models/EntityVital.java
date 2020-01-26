package com.solinia.solinia3ui.Models;

public class EntityVital {
	float healthPercent = 0.0F;
	float manaPercent = 0.0F;
	int entityId;
	String name = "";

	public EntityVital(float healthPercent, float manaPercent, int entityId, String name) {
		this.healthPercent = healthPercent;
		this.manaPercent = manaPercent;
		this.entityId = entityId;
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getEntityId()
	{
		return this.entityId;
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
