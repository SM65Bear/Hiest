package com.censkh.hiest.gui;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public abstract class GuiIcon {

	private final ItemStack stack;
	private final String name;

	public GuiIcon(String name, ItemStack stack) {
		this.name = name;
		this.stack = stack;
	}

	public abstract void run(Player player);

	public ItemStack getStack() {
		return stack.clone();
	}

	public String getName() {
		return name;
	}

}
