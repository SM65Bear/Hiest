package com.censkh.hiest.gun;

import org.bukkit.Material;

public enum GunType {
	HEAVY("Heavy",Material.WOOD_PICKAXE), ASSAULT("Assault",Material.WOOD_SPADE), SNIPER("Sniper",Material.WOOD_HOE), HANDGUN("Handgun",Material.IRON_HOE);
	
	private final String name;
	private final Material type;
	
	private GunType(String name,Material type) {
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public Material getType() {
		return type;
	}

}
