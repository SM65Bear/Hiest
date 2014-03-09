package com.censkh.hiest.gui;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public abstract class GuiIcon {

	private final ItemStack stack;
	private final String name;

	public GuiIcon(String name, ItemStack stack) {
		this.name = name;
		this.stack = bake(stack);
	}

	private ItemStack bake(ItemStack stack) {
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName(ChatColor.YELLOW + name);
		stack.setItemMeta(meta);
		return stack;
	}

	public abstract void run(Player player);

	public ItemStack getStack() {
		return stack.clone();
	}

	public String getName() {
		return name;
	}

}
