package com.censkh.heist.item;

import org.bukkit.inventory.ItemStack;

public abstract class GenericItem extends UniqueItem {
	
	private final ItemStack stack;
	
	public GenericItem(int id, String name,ItemStack stack) {
		super(id, name);
		this.stack = stack.clone();
	}

	@Override
	public ItemStack getStack(int i) {
		ItemStack clone = stack.clone();
		clone.setAmount(i);
		return clone;
	}

}
