package com.censkh.heist.throwable;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import com.censkh.heist.gun.WeaponType;

public class FragGrenade extends Throwable {

	public FragGrenade() {
		super(500,"Frag Grenade");
	}

	@Override
	public int getLifetime() {
		return 20 * 4;
	}

	@Override
	public void onRemoved(Location location) {
		location.getWorld().createExplosion(location, 3f);
	}

	@Override
	public ItemStack createStack() {
		return new ItemStack(Material.NETHER_BRICK_ITEM);
	}

	@Override
	public float getSpeedMultiplier() {
		return 3f;
	}

	@Override
	public WeaponType getWeaponType() {
		return WeaponType.EXPLOSIVES;
	}

}
