package com.censkh.heist.item;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public abstract class UniqueItem {
	
	private final int id;
	
	public UniqueItem(int id) {
		this.id = id;
	}
	
	public abstract ItemStack getStack(int i);
	
	public ItemStack getStack() {
		return getStack(1);
	}

	public int getId() {
		return id;
	}
	
	public String getIdent() {
		return "Item #" + getId();
	}
	
	public boolean isStack(ItemStack item) {
		ItemMeta meta = item.getItemMeta();
		if (meta.hasLore()) {
			if (ChatColor.stripColor(meta.getLore().get(meta.getLore().size() - 1)).equals(getIdent())) {
				return true;
			}
		}
		return false;
	}
	
}
