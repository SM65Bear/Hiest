package com.censkh.heist.throwable;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.censkh.heist.item.ItemType;
import com.censkh.heist.item.ItemUseEvent;
import com.censkh.heist.item.WeaponItem;

public abstract class Throwable extends WeaponItem {

	private final ItemStack stack;

	public Throwable(int id,String name) {
		super(id,name);
		this.stack = bake(createStack());
	}

	private ItemStack bake(ItemStack stack) {
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName(ChatColor.GREEN + getName());
		meta.setLore(Arrays.asList(ChatColor.DARK_GRAY + getIdent()));
		stack.setItemMeta(meta);
		return stack;
	}

	public abstract int getLifetime();

	public abstract void onRemoved(Location location);

	public abstract ItemStack createStack();

	public abstract float getSpeedMultiplier();

	public void shoot(LivingEntity entity) {
		Projectile p = entity.launchProjectile(Snowball.class);
		Item item = entity.getWorld().dropItem(entity.getLocation(), getStack(64));
		item.setPickupDelay(5);
		item.setVelocity(p.getVelocity().normalize().multiply(getSpeedMultiplier()));
		p.remove();
		ThrowableManager.getInstance().add(item);
	}

	@Override
	public ItemStack getStack(int i) {
		ItemStack clone = stack.clone();
		clone.setAmount(i);
		return clone;
	}
	
	@Override
	public ItemType getType() {
		return ItemType.THROWABLE;
	}
	
	@Override
	public void onItemUseEvent(ItemUseEvent event) {
		shoot(event.getPlayer());
		event.getPlayer().getInventory().removeItem(getStack());
	}

}
