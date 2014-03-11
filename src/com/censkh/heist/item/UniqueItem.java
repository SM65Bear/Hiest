package com.censkh.heist.item;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public abstract class UniqueItem {
	
	private final int id;
	private final String name;
	
	public UniqueItem(int id,String name) {
		this.id = id;
		this.name = name;
		ItemManager.getInstance().addItem(this);
	}
	
	public abstract ItemStack getStack(int i);
	public abstract ItemType getType();
	
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

	public String getName() {
		return name;
	}
	
}
