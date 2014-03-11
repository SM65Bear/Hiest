package com.censkh.heist.ammo;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.entity.Projectile;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.censkh.heist.item.ItemType;
import com.censkh.heist.item.UniqueItem;

public abstract class Ammo extends UniqueItem {
	
	private final ItemStack stack;

	public Ammo(int id,String name) {
		super(id,name);
		stack = createStack();
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName(ChatColor.GREEN + getName() + " Magazine");
		meta.setLore(Arrays.asList(ChatColor.DARK_GRAY + getIdent()));
		stack.setItemMeta(meta);
	}

	public abstract ItemStack createStack();

	public abstract Class<? extends Projectile> getProjectileType();

	public abstract int getLifetime();
	
	@Override
	public ItemStack getStack(int i) {
		ItemStack clone = stack.clone();
		clone.setAmount(i);
		return clone;
	}
	
	@Override
	public ItemType getType() {
		return ItemType.AMMO;
	}

}
