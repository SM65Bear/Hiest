package com.censkh.heist.ammo;

import org.bukkit.Material;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.WitherSkull;
import org.bukkit.inventory.ItemStack;

public class AmmoRocket extends Ammo {

	@Override
	public ItemStack createStack() {
		return new ItemStack(Material.FIREBALL);
	}

	@Override
	public Class<? extends Projectile> getType() {
		return WitherSkull.class;
	}

	@Override
	public double getTravelSpeed() {
		return 5d;
	}

	@Override
	public int getLifetime() {
		return 60;
	}
	
	@Override
	public String getName() {
		return "Ammo Rocket";
	}

}
