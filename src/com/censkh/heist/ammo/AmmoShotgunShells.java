package com.censkh.heist.ammo;

import org.bukkit.Material;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Projectile;
import org.bukkit.inventory.ItemStack;

public class AmmoShotgunShells extends Ammo {

	@Override
	public ItemStack createStack() {
		return new ItemStack(Material.EGG);
	}

	@Override
	public Class<? extends Projectile> getType() {
		return Egg.class;
	}

	@Override
	public double getTravelSpeed() {
		return 4;
	}

	@Override
	public int getLifetime() {
		return 10;
	}
	
	@Override
	public String getName() {
		return "Ammo Shotgun";
	}

}
