package com.censkh.hiest.gun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.censkh.hiest.SoundData;
import com.censkh.hiest.ammo.Ammo;

public class GunManager {

	private static GunManager instance;
	private final List<Gun> guns = new ArrayList<Gun>();
	private final HashMap<Player, List<GunCooldownTicket>> cooldowns = new HashMap<Player, List<GunCooldownTicket>>();
	private final List<Player> zoomed = new ArrayList<Player>();

	public GunManager() {
		instance = this;
		addGun(new Gun("M4", new ItemStack(Material.DIAMOND_SPADE), new GunData() {
			{
				setAmmo(Ammo.AMMO_556);
				setRecoil(1f);
				setZoom(2);
				setMagazineSize(60);
				setDamage(4d);
				setAccuracy(0.15f);
				setRateOfFire(4);
			}
		}));
		addGun(new Gun("M3", new ItemStack(Material.WOOD_PICKAXE), new GunData() {
			{
				setAmmo(Ammo.AMMO_SHOTGUN_SHELLS);
				setRecoil(1f);
				setZoom(0);
				setMagazineSize(20);
				setAccuracy(0.5f);
				setBurst(5);
				setDamage(3d);
				setReloadTime(3 * 18);
				setRateOfFire(8);
			}
		}));
		addGun(new Gun("Scar-H", new ItemStack(Material.GOLD_AXE), new GunData() {
			{
				setShootSound(new SoundData(Sound.ITEM_BREAK, 2f, 1.5f));
				setRarity(ItemRarity.ELITE);
				setAmmo(Ammo.AMMO_9MM);
				setRecoil(1f);
				setZoom(2);
				setMagazineSize(30);
				setAccuracy(0.15f);
				setBurst(1);
				setDamage(2.5d);
				setReloadTime(3 * 20);
				setRateOfFire(4);
				setZoomModifier(2f);
			}
		}));
		addGun(new Gun("Ak47", new ItemStack(Material.WOOD_SPADE), new GunData() {
			{
				setShootSound(new SoundData(Sound.ITEM_BREAK, 2f, 2f));
				setRarity(ItemRarity.RARE);
				setAmmo(Ammo.AMMO_556);
				setRecoil(1f);
				setZoom(3);
				setMagazineSize(28);
				setAccuracy(0.2f);
				setBurst(1);
				setDamage(3d);
				setReloadTime(2 * 20);
				setRateOfFire(2);
				setType(GunType.ASSULT);
			}
		}));
		addGun(new Gun("P250", new ItemStack(Material.IRON_HOE), new GunData() {
			{
				setAmmo(Ammo.AMMO_556);
				setRecoil(1f);
				setZoom(2);
				setMagazineSize(16);
				setAccuracy(0.2f);
				setBurst(1);
				setDamage(3d);
				setReloadTime(20);
				setRateOfFire(3);
				setType(GunType.HANDGUN);
			}
		}));
		addGun(new Gun("Intervention", new ItemStack(Material.WOOD_HOE), new GunData() {
			{
				setRarity(ItemRarity.ELITE);
				setAmmo(Ammo.AMMO_M2100);
				setRecoil(1f);
				setZoom(7);
				setMagazineSize(6);
				setAccuracy(0.3f);
				setDamage(6d);
				setRateOfFire(25);
				setZoomModifier(6f);
				setReloadTime(2 * 20);
				setType(GunType.SNIPER);
			}
		}));
		addGun(new Gun("Golden Magnum", new ItemStack(Material.GOLD_HOE), new GunData() {
			{
				setRarity(ItemRarity.ELITE);
				setAmmo(Ammo.AMMO_9MM);
				setRecoil(1f);
				setZoom(2);
				setMagazineSize(6);
				setAccuracy(0.12f);
				setDamage(6d);
				setRateOfFire(20);
				setReloadTime(3 * 20);
			}
		}));
		addGun(new Gun("RPG", new ItemStack(Material.GOLD_SPADE), new GunData() {
			{
				setRarity(ItemRarity.RARE);
				setAmmo(Ammo.AMMO_ROCKET);
				setRecoil(1f);
				setZoom(3);
				setMagazineSize(2);
				setRateOfFire(40);
				setReloadTime(6 * 20);
				setDamage(25d);
				setAccuracy(0.01f);
				setType(GunType.HEAVY);
			}
		}));
		addGun(new Gun("Uzi", new ItemStack(Material.STONE_SPADE), new GunData() {
			{
				setShootSound(new SoundData(Sound.BLAZE_HIT, 2f, 1.5f));
				setAmmo(Ammo.AMMO_9MM);
				setRecoil(1f);
				setZoom(3);
				setMagazineSize(90);
				setRateOfFire(2);
				setReloadTime(4 * 20);
				setBurst(1);
				setDamage(2d);
				setAccuracy(0.3f);
			}

			@Override
			public void useSecondary(Player player, GunStack stack) {
				player.sendMessage("hello world");
			}
		}));
	}

	public Gun getGun(ItemStack stack) {
		for (Gun gun : guns) {
			if (gun.isStack(stack)) {
				return gun;
			}
		}
		return null;
	}

	public Gun getGun(String name) {
		for (Gun gun : guns) {
			if (gun.getName().equals(name)) {
				return gun;
			}
		}
		return null;
	}

	public void update() {
		List<Player> keyRemoveList = new ArrayList<Player>();
		for (Player player : getCooldowns().keySet()) {
			List<GunCooldownTicket> cooldowns = getCooldowns().get(player);
			if (cooldowns == null) {
				keyRemoveList.add(player);
			} else if (cooldowns.size() == 0) {
				keyRemoveList.add(player);
			} else {
				List<GunCooldownTicket> removeList = new ArrayList<GunCooldownTicket>();
				for (GunCooldownTicket ticket : cooldowns) {
					ticket.setTicks(ticket.getTicks() - 1);
					if (ticket.getTicks() <= 0) {
						removeList.add(ticket);
					}
				}
				for (GunCooldownTicket r : removeList) {
					cooldowns.remove(r);
				}
				getCooldowns().put(player, cooldowns);
			}
		}
		for (Player r : keyRemoveList) {
			getCooldowns().remove(r);
		}
	}

	private void addGun(Gun gun) {
		guns.add(gun);
	}

	public static GunManager getInstance() {
		return instance;
	}

	public List<Gun> getGuns() {
		return guns;
	}

	public int getGunCooldown(Player player, Gun gun) {
		if (getCooldowns().containsKey(player)) {
			for (GunCooldownTicket ticket : getCooldowns().get(player)) {
				if (ticket.getGun().equals(gun)) {
					return ticket.getTicks();
				}
			}
		}
		return 0;
	}

	public void setGunCooldown(Player player, Gun gun, int ticks) {
		if (!getCooldowns().containsKey(player)) {
			getCooldowns().put(player, new ArrayList<GunCooldownTicket>());
		}
		List<GunCooldownTicket> cooldowns = getCooldowns().get(player);
		if (getGunCooldown(player, gun) == 0) {
			cooldowns.add(new GunCooldownTicket(gun, ticks));
		} else {
			for (GunCooldownTicket c : cooldowns) {
				if (c.getGun().equals(gun)) {
					c.setTicks(ticks);
				}
			}
		}
		getCooldowns().put(player, cooldowns);
	}

	public boolean isZoomed(Player player) {
		return getZoomed().contains(player);
	}

	public void setZoomed(Player player, boolean zoomed) {
		if (getZoomed().contains(player) && !zoomed) {
			getZoomed().remove(player);
		} else if (!getZoomed().contains(player) && zoomed) {
			getZoomed().add(player);
		}
	}

	public HashMap<Player, List<GunCooldownTicket>> getCooldowns() {
		return cooldowns;
	}

	public List<Player> getZoomed() {
		return zoomed;
	}

}
