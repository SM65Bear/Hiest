package com.censkh.hiest.gun;

import org.bukkit.ChatColor;

public enum ItemRarity {
	BASIC("Basic", ChatColor.WHITE), RARE("Rare", ChatColor.YELLOW), ELITE("Elite", ChatColor.LIGHT_PURPLE), PERFECT("Perfect", ChatColor.GOLD);

	private final String name;
	private final ChatColor color;

	private ItemRarity(String name, ChatColor color) {
		this.name = name;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public ChatColor getColor() {
		return color;
	}

}
