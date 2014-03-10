package com.censkh.heist.ammo;

import org.bukkit.Material;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.inventory.ItemStack;

public class Ammo556 extends Ammo {

	public Ammo556() {
		super(400);
	}

	@Override
	public ItemStack createStack() {
		return new ItemStack(Material.INK_SACK, 1, (short) 0);
	}

	@Override
	public Class<? extends Projectile> getType() {
		return Snowball.class;
	}

	@Override
	public int getLifetime() {
		return 15;
	}

	@Override
	public String getName() {
		return "Ammo 556";
	}

}
