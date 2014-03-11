package com.censkh.heist.gun;

import org.bukkit.Material;

public enum WeaponType {
	SPECIAL("Special", Material.GOLD_SPADE), LIGHT("Light Machine Gun", Material.STONE_SPADE), ASSAULT("Assault", Material.WOOD_SPADE), SNIPER("Sniper", Material.WOOD_HOE), HANDGUN("Handgun",
			Material.IRON_HOE), SHOTGUNS("Shotguns", Material.WOOD_PICKAXE), EXPLOSIVES("Explosives", Material.NETHER_BRICK_ITEM);

	private final String name;
	private final Material type;

	private WeaponType(String name, Material type) {
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
