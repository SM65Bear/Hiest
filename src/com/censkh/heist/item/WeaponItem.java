package com.censkh.heist.item;

import com.censkh.heist.gun.WeaponType;

public abstract class WeaponItem extends UniqueItem {

	public WeaponItem(int id, String name) {
		super(id, name);
	}
	
	public abstract WeaponType getWeaponType();

}
