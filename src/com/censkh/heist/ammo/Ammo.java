package com.censkh.heist.ammo;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.entity.Projectile;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public abstract class Ammo {

	private final ItemStack stack;

	public Ammo() {
		stack = createStack();
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName(ChatColor.GREEN + getName() + " Magazine");
		meta.setLore(Arrays.asList(ChatColor.DARK_GRAY + getName()));
		stack.setItemMeta(meta);
	}

	public abstract ItemStack createStack();

	public abstract Class<? extends Projectile> getType();

	public abstract double getTravelSpeed();

	public abstract int getLifetime();

	public abstract String getName();

	public ItemStack getStack() {
		return getStack(1);
	}

	public ItemStack getStack(int i) {
		ItemStack clone = stack.clone();
		clone.setAmount(i);
		return clone;
	}

}
