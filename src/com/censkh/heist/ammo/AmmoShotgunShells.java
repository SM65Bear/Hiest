package com.censkh.heist.ammo;

import org.bukkit.Material;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Projectile;
import org.bukkit.inventory.ItemStack;

public class AmmoShotgunShells extends Ammo {

	public AmmoShotgunShells() {
		super(404,"Ammo Shotgun");
	}

	@Override
	public ItemStack createStack() {
		return new ItemStack(Material.INK_SACK, 1, (short) 4);
	}

	@Override
	public Class<? extends Projectile> getProjectileType() {
		return Egg.class;
	}

	@Override
	public int getLifetime() {
		return 10;
	}

}
