package com.censkh.heist.throwable;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import com.censkh.heist.gun.ItemType;

public class FragGrenade extends Throwable {

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
	public String getName() {
		return "Frag Grenade";
	}

	@Override
	public float getSpeedMultiplier() {
		return 3f;
	}

	@Override
	public ItemType getType() {
		return ItemType.EXPLOSIVES;
	}

}
