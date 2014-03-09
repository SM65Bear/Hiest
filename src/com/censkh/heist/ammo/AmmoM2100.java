package com.censkh.heist.ammo;

import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Projectile;
import org.bukkit.inventory.ItemStack;

public class AmmoM2100 extends Ammo {

	@Override
	public ItemStack createStack() {
		return new ItemStack(Material.SNOW_BALL);
	}

	@Override
	public Class<? extends Projectile> getType() {
		return Arrow.class;
	}

	@Override
	public double getTravelSpeed() {
		return 6d;
	}

	@Override
	public int getLifetime() {
		return 60;
	}

}
