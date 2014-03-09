package com.censkh.hiest.ammo;

import org.bukkit.Material;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.inventory.ItemStack;

public class Ammo556 extends Ammo {

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
		return 3.5d;
	}

	@Override
	public int getLifetime() {
		return 15;
	}

}
