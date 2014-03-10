package com.censkh.heist.gui;

import org.bukkit.inventory.ItemStack;

public class GuiShopIcon {
	
	private final int price;
	private final GuiIcon icon;
	private final ItemStack stack;
	
	public GuiShopIcon(GuiIcon icon,ItemStack stack, int price) {
		this.icon = icon;
		this.stack = stack;
		this.price = price;
	}
	
	public ItemStack getStack() {
		return stack;
	}
	public GuiIcon getIcon() {
		return icon;
	}
	public int getPrice() {
		return price;
	}
	
}
