package com.censkh.hiest.throwable;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public abstract class Throwable {

	private final ItemStack stack;

	public Throwable() {
		this.stack = bake(createStack());
	}

	private ItemStack bake(ItemStack stack) {
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName(ChatColor.GREEN + getName());
		meta.setLore(Arrays.asList(ChatColor.DARK_GRAY + getName()));
		stack.setItemMeta(meta);
		return stack;
	}

	public abstract int getLifetime();

	public abstract void onRemoved(Location location);

	public abstract ItemStack createStack();

	public abstract String getName();

	public abstract float getSpeedMultiplier();

	public void shoot(LivingEntity entity) {
		Projectile p = entity.launchProjectile(Snowball.class);
		Item item = entity.getWorld().dropItem(entity.getLocation(), getStack(64));
		item.setPickupDelay(5);
		item.setVelocity(p.getVelocity().normalize().multiply(getSpeedMultiplier()));
		p.remove();
		ThrowableManager.getInstance().add(item);
	}

	public boolean isStack(ItemStack item) {
		ItemMeta meta = item.getItemMeta();
		if (meta.hasLore()) {
			if (ChatColor.stripColor(meta.getLore().get(meta.getLore().size() - 1)).equals(getName())) {
				return true;
			}
		}
		return false;
	}

	public ItemStack getStack() {
		return getStack(1);
	}

	public ItemStack getStack(int i) {
		ItemStack clone = stack.clone();
		clone.setAmount(i);
		return clone;
	}

}
