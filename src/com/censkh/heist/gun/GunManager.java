package com.censkh.heist.gun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.censkh.heist.ammo.AmmoManager;
import com.censkh.heist.util.SoundData;

public class GunManager {

	private static GunManager instance;
	private final List<Gun> guns = new ArrayList<Gun>();
	private final HashMap<Player, List<GunCooldownTicket>> cooldowns = new HashMap<Player, List<GunCooldownTicket>>();
	private final List<Player> zoomed = new ArrayList<Player>();

	public GunManager() {
		instance = this;

		// -= Assult Rifles =- \\

		addGun(new Gun(301,"M4", new ItemStack(Material.DIAMOND_SPADE), new GunData() {
			{
				setRarity(ItemRarity.BASIC);
				setAmmo(AmmoManager.getInstance().AMMO_556);
				setRecoil(1f);
				setZoom(2);
				setMagazineSize(60);
				setDamage(4d);
				setAccuracy(0.15f);
				setRateOfFire(4);
				setType(ItemType.ASSAULT);
			}
		}));

		addGun(new Gun(302,"ACR", new ItemStack(Material.IRON_SPADE), new GunData() {
			{
				setRarity(ItemRarity.PERFECT);
				setAmmo(AmmoManager.getInstance().AMMO_556);
				setRecoil(1f);
				setZoom(2);
				setMagazineSize(60);
				setDamage(3.5d);
				setAccuracy(0.1f);
				setRateOfFire(3);
				setType(ItemType.ASSAULT);
			}
		}));

		addGun(new Gun(303,"Ak47", new ItemStack(Material.WOOD_SPADE), new GunData() {
			{
				setShootSound(new SoundData(Sound.EXPLODE, 2f, 2f));
				setRarity(ItemRarity.RARE);
				setAmmo(AmmoManager.getInstance().AMMO_556);
				setRecoil(1f);
				setZoom(3);
				setMagazineSize(28);
				setAccuracy(0.2f);
				setBurst(1);
				setDamage(3d);
				setReloadTime(2 * 20);
				setRateOfFire(2);
				setType(ItemType.ASSAULT);
			}
		}));

		addGun(new Gun(304,"Scar-H", new ItemStack(Material.GOLD_AXE), new GunData() {
			{
				setShootSound(new SoundData(Sound.EXPLODE, 2f, 1.5f));
				setRarity(ItemRarity.ELITE);
				setAmmo(AmmoManager.getInstance().AMMO_9MM);
				setRecoil(1f);
				setZoom(2);
				setMagazineSize(30);
				setAccuracy(0.15f);
				setBurst(1);
				setDamage(2.5d);
				setReloadTime(3 * 20);
				setRateOfFire(4);
				setZoomModifier(2f);
				setType(ItemType.ASSAULT);
			}
		}));

		// -= ShotGuns =- \\

		addGun(new Gun(310,"M3", new ItemStack(Material.WOOD_PICKAXE), new GunData() {
			{
				setRarity(ItemRarity.RARE);
				setAmmo(AmmoManager.getInstance().AMMO_SHOTGUN_SHELLS);
				setRecoil(1f);
				setZoom(0);
				setMagazineSize(20);
				setAccuracy(0.5f);
				setBurst(5);
				setDamage(3d);
				setReloadTime(3 * 18);
				setRateOfFire(8);
				setType(ItemType.SHOTGUNS);
			}
		}));

		addGun(new Gun(311,"M1014", new ItemStack(Material.SHEARS), new GunData() {
			{
				setRarity(ItemRarity.BASIC);
				setAmmo(AmmoManager.getInstance().AMMO_SHOTGUN_SHELLS);
				setRecoil(1f);
				setZoom(0);
				setMagazineSize(20);
				setAccuracy(0.5f);
				setBurst(5);
				setDamage(3d);
				setReloadTime(3 * 18);
				setRateOfFire(8);
				setType(ItemType.SHOTGUNS);
			}
		}));

		addGun(new Gun(312,"Model 1887", new ItemStack(Material.DIAMOND_AXE), new GunData() {
			{
				setRarity(ItemRarity.BASIC);
				setAmmo(AmmoManager.getInstance().AMMO_SHOTGUN_SHELLS);
				setRecoil(1f);
				setZoom(0);
				setMagazineSize(20);
				setAccuracy(0.5f);
				setBurst(3);
				setDamage(4d);
				setReloadTime(3 * 18);
				setRateOfFire(15);
				setType(ItemType.SHOTGUNS);
			}
		}));

		addGun(new Gun(313,"AA-12", new ItemStack(Material.DIAMOND_PICKAXE), new GunData() {
			{
				setRarity(ItemRarity.RARE);
				setAmmo(AmmoManager.getInstance().AMMO_SHOTGUN_SHELLS);
				setRecoil(1f);
				setZoom(0);
				setMagazineSize(10);
				setAccuracy(0.5f);
				setBurst(2);
				setDamage(4d);
				setReloadTime(3 * 18);
				setRateOfFire(1);
				setType(ItemType.SHOTGUNS);
			}
		}));

		// -= Heavy Machineguns =- \\

		addGun(new Gun(320,"RPG", new ItemStack(Material.GOLD_SPADE), new GunData() {
			{
				setRarity(ItemRarity.RARE);
				setAmmo(AmmoManager.getInstance().AMMO_ROCKET);
				setRecoil(1f);
				setZoom(3);
				setMagazineSize(2);
				setRateOfFire(40);
				setReloadTime(6 * 20);
				setDamage(25d);
				setAccuracy(0.01f);
				setType(ItemType.SPECIAL);
			}
		}));

		// -= Hand Guns =- \\

		addGun(new Gun(330,"Desert Eagle", new ItemStack(Material.STONE_HOE), new GunData() {
			{
				setShootSound(new SoundData(Sound.ITEM_BREAK, 2f, 2f));
				setRarity(ItemRarity.RARE);
				setAmmo(AmmoManager.getInstance().AMMO_556);
				setRecoil(1f);
				setZoom(2);
				setMagazineSize(16);
				setAccuracy(0.2f);
				setBurst(1);
				setDamage(2.5d);
				setReloadTime(20);
				setRateOfFire(3);
				setType(ItemType.HANDGUN);
			}
		}));

		addGun(new Gun(331,"P250", new ItemStack(Material.IRON_HOE), new GunData() {
			{
				setShootSound(new SoundData(Sound.ITEM_BREAK, 2f, 2f));
				setRarity(ItemRarity.BASIC);
				setAmmo(AmmoManager.getInstance().AMMO_556);
				setRecoil(1f);
				setZoom(2);
				setMagazineSize(16);
				setAccuracy(0.2f);
				setBurst(1);
				setDamage(2.5d);
				setReloadTime(20);
				setRateOfFire(3);
				setType(ItemType.HANDGUN);
			}
		}));

		addGun(new Gun(332,"M9", new ItemStack(Material.IRON_PICKAXE), new GunData() {
			{
				setShootSound(new SoundData(Sound.ITEM_BREAK, 2f, 2f));
				setRarity(ItemRarity.BASIC);
				setAmmo(AmmoManager.getInstance().AMMO_556);
				setRecoil(1f);
				setZoom(2);
				setMagazineSize(16);
				setAccuracy(0.2f);
				setBurst(1);
				setDamage(2.5d);
				setReloadTime(20);
				setRateOfFire(3);
				setType(ItemType.HANDGUN);
			}
		}));

		addGun(new Gun(333,"Golden Magnum", new ItemStack(Material.GOLD_HOE), new GunData() {
			{
				setRarity(ItemRarity.ELITE);
				setAmmo(AmmoManager.getInstance().AMMO_9MM);
				setRecoil(1f);
				setZoom(2);
				setMagazineSize(6);
				setAccuracy(0.12f);
				setDamage(6d);
				setRateOfFire(20);
				setReloadTime(3 * 20);
				setType(ItemType.HANDGUN);
			}
		}));
		// -= Sniper Rifles =- \\

		addGun(new Gun(340,"Intervention", new ItemStack(Material.WOOD_HOE), new GunData() {
			{
				setShootSound(new SoundData(Sound.EXPLODE, 2f, 1.5f));
				setRarity(ItemRarity.ELITE);
				setAmmo(AmmoManager.getInstance().AMMO_M2100);
				setRecoil(1f);
				setZoom(7);
				setMagazineSize(6);
				setAccuracy(0.3f);
				setDamage(6d);
				setRateOfFire(25);
				setZoomModifier(4f);
				setReloadTime(2 * 20);
				setType(ItemType.SNIPER);
			}
		}));

		addGun(new Gun(341,"Barret .50cal", new ItemStack(Material.STONE_AXE), new GunData() {
			{
				setShootSound(new SoundData(Sound.EXPLODE, 2f, 1.5f));
				setRarity(ItemRarity.BASIC);
				setAmmo(AmmoManager.getInstance().AMMO_M2100);
				setRecoil(1f);
				setZoom(7);
				setMagazineSize(6);
				setAccuracy(0.35f);
				setDamage(9d);
				setRateOfFire(12);
				setZoomModifier(2f);
				setReloadTime(2 * 20);
				setType(ItemType.SNIPER);
			}
		}));

		addGun(new Gun(342,"M40A3", new ItemStack(Material.STONE_PICKAXE), new GunData() {
			{
				setShootSound(new SoundData(Sound.EXPLODE, 2f, 1.5f));
				setRarity(ItemRarity.PERFECT);
				setAmmo(AmmoManager.getInstance().AMMO_M2100);
				setRecoil(1f);
				setZoom(7);
				setMagazineSize(6);
				setAccuracy(0.3f);
				setDamage(4.2d);
				setRateOfFire(20);
				setZoomModifier(4f);
				setReloadTime(2 * 20);
				setType(ItemType.SNIPER);
			}
		}));

		addGun(new Gun(343,"KALASHNIKOV", new ItemStack(Material.IRON_AXE), new GunData() {
			{
				setShootSound(new SoundData(Sound.EXPLODE, 2f, 1.5f));
				setRarity(ItemRarity.RARE);
				setAmmo(AmmoManager.getInstance().AMMO_M2100);
				setRecoil(1f);
				setZoom(7);
				setMagazineSize(6);
				setAccuracy(0.2f);
				setDamage(6d);
				setRateOfFire(15);
				setZoomModifier(4f);
				setReloadTime(2 * 20);
				setType(ItemType.SNIPER);
			}
		}));

		// -= Light Machineguns =- \\

		addGun(new Gun(350,"P250", new ItemStack(Material.DIAMOND_HOE), new GunData() {
			{
				setRarity(ItemRarity.RARE);
				setShootSound(new SoundData(Sound.CLICK, 2f, 1.5f));
				setAmmo(AmmoManager.getInstance().AMMO_9MM);
				setRecoil(1f);
				setZoom(2);
				setMagazineSize(60);
				setRateOfFire(1);
				setReloadTime(4 * 20);
				setBurst(1);
				setDamage(2.5d);
				setAccuracy(0.1f);
				setType(ItemType.LIGHT);
			}
		}));

		addGun(new Gun(351,"Ump45", new ItemStack(Material.GOLD_PICKAXE), new GunData() {
			{
				setShootSound(new SoundData(Sound.CLICK, 2f, 1.5f));
				setRarity(ItemRarity.RARE);
				setAmmo(AmmoManager.getInstance().AMMO_9MM);
				setRecoil(1f);
				setZoom(2);
				setMagazineSize(60);
				setRateOfFire(1);
				setReloadTime(4 * 20);
				setBurst(1);
				setDamage(3.2d);
				setAccuracy(0.12f);
				setType(ItemType.LIGHT);
			}
		}));

		addGun(new Gun(352,"MP5", new ItemStack(Material.WOOD_AXE), new GunData() {
			{
				setRarity(ItemRarity.BASIC);
				setShootSound(new SoundData(Sound.CLICK, 2f, 1.5f));
				setAmmo(AmmoManager.getInstance().AMMO_9MM);
				setRecoil(1f);
				setZoom(2);
				setMagazineSize(60);
				setRateOfFire(1);
				setReloadTime(4 * 20);
				setBurst(1);
				setDamage(2.5d);
				setAccuracy(0.15f);
				setType(ItemType.LIGHT);
			}
		}));

		addGun(new Gun(353,"Uzi", new ItemStack(Material.STONE_SPADE), new GunData() {
			{
				setRarity(ItemRarity.BASIC);
				setShootSound(new SoundData(Sound.CLICK, 2f, 1.5f));
				setAmmo(AmmoManager.getInstance().AMMO_9MM);
				setRecoil(1f);
				setZoom(3);
				setMagazineSize(120);
				setRateOfFire(2);
				setReloadTime(4 * 20);
				setBurst(2);
				setDamage(2d);
				setAccuracy(0.3f);
				setType(ItemType.LIGHT);
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

	public Gun getGun(int id) {
		for (Gun gun : guns) {
			if (gun.getId() == id) {
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
