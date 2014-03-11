package com.censkh.heist.ammo;

import org.bukkit.Material;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.WitherSkull;
import org.bukkit.inventory.ItemStack;

public class AmmoRocket extends Ammo {

	public AmmoRocket() {
		super(403,"Ammo Rocket");
	}

	@Override
	public ItemStack createStack() {
		return new ItemStack(Material.INK_SACK, 1, (short) 3);
	}

	@Override
	public Class<? extends Projectile> getProjectileType() {
		return WitherSkull.class;
	}

	@Override
	public int getLifetime() {
		return 60;
	}
}
