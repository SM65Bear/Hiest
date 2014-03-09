package com.censkh.hiest.gui;

import org.bukkit.Material;

public enum GuiPanelOptions {
	GUNS("Guns",Material.DIAMOND_SPADE), MONEY("Money",Material.WOOD_SPADE), WARP("Warps",Material.PORTAL), WHITTY("Whitty Likes Men",Material.SKULL);
	
	private final String name;
	private final Material type;
	
	private GuiPanelOptions(String name,Material type) {
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
