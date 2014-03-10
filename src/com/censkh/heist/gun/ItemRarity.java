package com.censkh.heist.gun;

import org.bukkit.ChatColor;

public enum ItemRarity {
	BASIC("Basic", ChatColor.WHITE, 0), RARE("Rare", ChatColor.YELLOW, 1), ELITE("Elite", ChatColor.GOLD, 3), PERFECT("Perfect", ChatColor.LIGHT_PURPLE, 2);

	private final String name;
	private final ChatColor color;
	private final int tier;

	private ItemRarity(String name, ChatColor color, int tier) {
		this.name = name;
		this.color = color;
		this.tier = tier;
	}

	public String getName() {
		return name;
	}

	public ChatColor getColor() {
		return color;
	}

	public int getTier() {
		return tier;
	}

}
