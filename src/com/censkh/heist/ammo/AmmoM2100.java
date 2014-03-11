package com.censkh.heist.ammo;

import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Projectile;
import org.bukkit.inventory.ItemStack;

public class AmmoM2100 extends Ammo {
	
	public AmmoM2100() {
		super(402,"Ammo M2100");
	}
	
	@Override
	public ItemStack createStack() {
		return new ItemStack(Material.INK_SACK, 1, (short) 2);
	}

	@Override
	public Class<? extends Projectile> getProjectileType() {
		return Arrow.class;
	}

	@Override
	public int getLifetime() {
		return 60;
	}

}
