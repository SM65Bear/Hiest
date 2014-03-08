package com.censkh.hiest;

import org.bukkit.Material;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.WitherSkull;
import org.bukkit.inventory.ItemStack;

public class AmmoRocket extends Ammo {

	@Override
	public ItemStack createStack() {
		return new ItemStack(Material.SNOW_BALL);
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
	

}
