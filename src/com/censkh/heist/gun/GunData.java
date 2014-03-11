package com.censkh.heist.gun;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import com.censkh.heist.ammo.Ammo;
import com.censkh.heist.item.ItemManager;
import com.censkh.heist.item.ItemRarity;
import com.censkh.heist.util.SoundData;

public class GunData {

	private float recoil = 1f;
	private int zoom = 1;
	private int magazineSize = 50;
	private double damage = 3.5;
	private float accuracy = 0.1f;
	private int burst = 1;
	private int reloadTime = 2 * 20;
	private int rateOfFire = 4;
	private float zoomModifier = 1f;
	private Ammo ammo = ItemManager.getInstance().AMMO_556;
	private WeaponType type = WeaponType.ASSAULT;
	private ItemRarity rarity = ItemRarity.BASIC;
	private SoundData shootSound = new SoundData(Sound.EXPLODE, 2f, 3f);
	private double bulletTravelSpeed = 4.5d;

	public List<String> toLore() {
		String p = ChatColor.GRAY + "";
		List<String> lore = new ArrayList<String>();
		lore.add(p + "Damage: " + getDamage());
		if (getDamage() != getAimedInDamage())
			lore.add(p + "Aimed In Damage: " + getAimedInDamage());
		lore.add(p + "Accuracy: " + getAccuracyPercent());
		if (!getAimedInAccuracyPercent().equals(getAccuracyPercent()))
			lore.add(p + "Aimed In Accuracy: " + getAimedInAccuracyPercent());
		lore.add(p + getRarity().getColor() + getRarity().getName() + " (Tier " + (getRarity().getTier() + 1) + ")");
		return lore;
	}

	public double getAimedInDamage() {
		return getZoomModifier() * getDamage();
	}

	public String getAccuracyPercent() {
		return (100 - (int) (100f * getAccuracy())) + "%";
	}

	public String getAimedInAccuracyPercent() {
		return (100 - (int) (100f * (getAccuracy() / getZoomModifier()))) + "%";
	}

	public float getRecoil() {
		return recoil;
	}

	public void setRecoil(float recoil) {
		this.recoil = recoil;
	}

	public int getZoom() {
		return zoom;
	}

	public void setZoom(int zoom) {
		this.zoom = zoom;
	}

	public int getMagazineSize() {
		return magazineSize;
	}

	public void setMagazineSize(int magazineSize) {
		this.magazineSize = magazineSize;
	}

	public double getDamage() {
		return damage;
	}

	public void setDamage(double damage) {
		this.damage = damage;
	}

	public float getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(float accuracy) {
		this.accuracy = accuracy;
	}

	public int getBurst() {
		return burst;
	}

	public void setBurst(int burst) {
		this.burst = burst;
	}

	public int getReloadTime() {
		return reloadTime;
	}

	public void setReloadTime(int reloadTime) {
		this.reloadTime = reloadTime;
	}

	public int getRateOfFire() {
		return rateOfFire;
	}

	public void setRateOfFire(int rateOfFire) {
		this.rateOfFire = rateOfFire;
	}

	public float getZoomModifier() {
		return zoomModifier;
	}

	public void setZoomModifier(float zoomModifier) {
		this.zoomModifier = zoomModifier;
	}

	public void useSecondary(Player player, GunStack stack) {

	}

	public Ammo getAmmo() {
		return ammo;
	}

	public void setAmmo(Ammo ammo) {
		this.ammo = ammo;
	}

	public ItemRarity getRarity() {
		return rarity;
	}

	public void setRarity(ItemRarity rarity) {
		this.rarity = rarity;
	}

	public SoundData getShootSound() {
		return shootSound;
	}

	public void setShootSound(SoundData shootSound) {
		this.shootSound = shootSound;
	}

	public WeaponType getType() {
		return type;
	}

	public void setType(WeaponType type) {
		this.type = type;
	}

	public double getBulletTravelSpeed() {
		return bulletTravelSpeed;
	}

	public void setBulletTravelSpeed(double bulletTravelSpeed) {
		this.bulletTravelSpeed = bulletTravelSpeed;
	}

}
