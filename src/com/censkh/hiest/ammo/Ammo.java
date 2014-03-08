package com.censkh.hiest;

import org.bukkit.entity.Projectile;
import org.bukkit.inventory.ItemStack;

public abstract class Ammo {
	
	public static final Ammo556 AMMO_556 = new Ammo556();
	public static final AmmoRocket AMMO_ROCKET = new AmmoRocket();
	public static final AmmoM2100 AMMO_M2100 = new AmmoM2100();
	public static final AmmoShotgunShells AMMO_SHOTGUN_SHELLS = new AmmoShotgunShells();
	public static final Ammo9MM AMMO_9MM = new Ammo9MM();
	
	private final ItemStack stack;
	
	public Ammo() {
		stack = createStack();
	}
	
	public abstract ItemStack createStack();
	public abstract Class<? extends Projectile> getType();
	public abstract double getTravelSpeed();
	public abstract int getLifetime();

	public ItemStack getStack() {
		return getStack(1);
	}

	public ItemStack getStack(int i) {
		ItemStack clone = stack.clone();
		clone.setAmount(i);
		return clone;
	}

}
