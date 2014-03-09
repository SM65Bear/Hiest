package com.censkh.hiest.gun;

public class GunCooldownTicket {
	
	private final Gun gun;
	private int ticks;
	
	public GunCooldownTicket(Gun gun, int ticks) {
		this.gun = gun;
		this.ticks = ticks;
	}
	
	public Gun getGun() {
		return gun;
	}

	public int getTicks() {
		return ticks;
	}

	public void setTicks(int ticks) {
		this.ticks = ticks;
	}
	
}
