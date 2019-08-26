package com.solinia.solinia3ui;

public class PartyWindowPlayer {
	public String Name = "";
	public double HealthPercent = 0D;
	public double ManaPercent = 0D;
	
	public PartyWindowPlayer Clone()
	{
		PartyWindowPlayer player = new PartyWindowPlayer();
		player.Name = this.Name;
		player.HealthPercent = this.HealthPercent;
		player.ManaPercent = this.ManaPercent;
		return player;
	}
}
