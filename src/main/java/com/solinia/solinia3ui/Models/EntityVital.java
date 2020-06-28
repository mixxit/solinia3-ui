package com.solinia.solinia3ui.Models;

public class EntityVital {
	float healthPercent = 0.0F;
	float manaPercent = 0.0F;
	int entityId;
	String name = "";
	int level = 0;
	float xpPercent = 0.0F;

	public EntityVital(float healthPercent, float manaPercent, int entityId, String name, int level, float xpPercent) {
		this.healthPercent = healthPercent;
		this.manaPercent = manaPercent;
		this.entityId = entityId;
		this.name = name;
		this.level = level;
		this.xpPercent = xpPercent;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getEntityId()
	{
		return this.entityId;
	}
	
	public int getLevel()
	{
		return this.level;
	}
	
	public float getManaPercent()
	{
		return this.manaPercent;
	}
	
	public float getHealthPercent()
	{
		return this.healthPercent;
	}
	
	public float getExperiencePercent()
	{
		return this.xpPercent;
	}
	

}
