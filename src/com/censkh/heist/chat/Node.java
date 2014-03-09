package com.censkh.heist.chat;

import org.bukkit.ChatColor;

public enum Node {
	SERVER_NAME(ChatColor.BLUE + "Heist"), INSTANCE_MESSAGE_COLOUR(ChatColor.YELLOW + ""), INSTANCE_NAME_COLOUR(ChatColor.GOLD + ""),INVENTORY_NAME_PREFIX(ChatColor.DARK_BLUE + "Menu | " +ChatColor.RESET);

	private final String string;

	private Node(String string) {
		this.string = string;
	}

	public String getString() {
		return string;
	}
	
	@Override
	public String toString() {
		return getString();
	}

}
