package com.censkh.heist.ammo;

import org.bukkit.Material;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.inventory.ItemStack;

public class AmmoInfinite extends Ammo {

	public AmmoInfinite() {
		super(400,"Ammo Infinite");
	}

	@Override
	public ItemStack createStack() {
		return new ItemStack(Material.INK_SACK, 1, (short) 15);
	}

	@Override
	public Class<? extends Projectile> getProjectileType() {
		return Snowball.class;
	}

	@Override
	public int getLifetime() {
		return 15;
	}

}
