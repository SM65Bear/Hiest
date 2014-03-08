package com.censkh.hiest;

import org.bukkit.Material;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.inventory.ItemStack;

public class Ammo9MM extends Ammo {

	@Override
	public ItemStack createStack() {
		return new ItemStack(Material.SNOW_BALL);
	}

	@Override
	public Class<? extends Projectile> getType() {
		return Snowball.class;
	}

	@Override
	public double getTravelSpeed() {
		return 6d;
	}

	@Override
	public int getLifetime() {
		return 5;
	}
	

}
