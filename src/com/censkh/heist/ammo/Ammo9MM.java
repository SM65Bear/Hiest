package com.censkh.heist.ammo;

import org.bukkit.Material;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.inventory.ItemStack;

public class Ammo9MM extends Ammo {
	
	public Ammo9MM() {
		super(401,"Ammo 9MM");
	}
	
	@Override
	public ItemStack createStack() {
		return new ItemStack(Material.INK_SACK, 1, (short) 1);
	}

	@Override
	public Class<? extends Projectile> getProjectileType() {
		return Snowball.class;
	}

	@Override
	public int getLifetime() {
		return 5;
	}

}
