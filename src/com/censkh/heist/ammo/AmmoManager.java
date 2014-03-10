package com.censkh.heist.ammo;

import java.util.ArrayList;
import java.util.List;

public class AmmoManager {
	
	private static AmmoManager instance;
	private final List<Ammo> ammo = new ArrayList<Ammo>();
	
	public final Ammo556 AMMO_556 = (Ammo556) createAmmo(Ammo556.class);
	public final AmmoRocket AMMO_ROCKET = (AmmoRocket) createAmmo(AmmoRocket.class);
	public final AmmoM2100 AMMO_M2100 = (AmmoM2100) createAmmo(AmmoM2100.class);
	public final AmmoShotgunShells AMMO_SHOTGUN_SHELLS = (AmmoShotgunShells) createAmmo(AmmoShotgunShells.class);
	public final Ammo9MM AMMO_9MM = (Ammo9MM) createAmmo(Ammo9MM.class);
	
	public AmmoManager() {
		instance = this;
	}

	private Ammo createAmmo(Class<? extends Ammo> clazz) {
		Ammo ammo = null;
		try {
			ammo = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		this.ammo.add(ammo);
		return ammo;
	}

	public static AmmoManager getInstance() {
		return instance;
	}

	public List<Ammo> getAmmo() {
		return ammo;
	}
	
}
