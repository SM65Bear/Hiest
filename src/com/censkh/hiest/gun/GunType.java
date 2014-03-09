package com.censkh.hiest.gun;

public enum GunType {
	HEAVY("Heavy"), ASSULT("Assault"), SNIPER("Sniper"), HANDGUN("Handgun");
	
	private final String name;
	
	private GunType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
