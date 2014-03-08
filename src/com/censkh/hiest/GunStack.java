package com.censkh.hiest;

import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GunStack {

	private int loadedBullets = 0;
	private final Gun gun;
	private GunState state = GunState.EMPTY;
	private int amount = 1;
	private int reloadCountdown = 0;

	public GunStack(ItemStack stack) {
		this.gun = read(stack);
	}

	public GunStack(Gun gun) {
		this.gun = gun;
		setLoadedBullets(gun.getData().getMagazineSize());
	}

	public ItemStack write() {
		ItemStack stack = gun.getItemType();
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName(ChatColor.YELLOW + gun.getName());
		meta.setLore(Arrays.asList(new String[] {
				ChatColor.GRAY + "Bullets: " + getLoadedBullets() + " / " + gun.getData().getMagazineSize(),
				ChatColor.GRAY + (getState().name().substring(0, 1) + getState().name().toLowerCase().substring(1) + (getState() == GunState.RELOADING ? " - " + getReloadCountdown() : "")),
				ChatColor.DARK_GRAY + gun.getName()
		}));
		stack.setItemMeta(meta);
		stack.setAmount(getAmount());
		ItemDurability.setDurability(stack, getState() == GunState.RELOADING ? 1f - ((float) getReloadCountdown() / (float) getGun().getData().getReloadTime()) : (float) getLoadedBullets()
				/ (float) getGun().getData().getMagazineSize());
		return stack;
	}

	public Gun read(ItemStack stack) {
		ItemMeta meta = stack.getItemMeta();
		Gun gun = null;
		if (meta.hasLore()) {
			List<String> lore = meta.getLore();
			String gunName = ChatColor.stripColor(lore.get(lore.size() - 1));
			gun = GunManager.getInstance().getGun(gunName);
			String bullets = lore.get(lore.size() - 3);
			bullets = ChatColor.stripColor(bullets).substring("Bullets: ".length(), bullets.indexOf('/') - 3);
			loadedBullets = Integer.parseInt(bullets);
			String gunState = ChatColor.stripColor(lore.get(lore.size() - 2));
			setState(GunState.getState(gunState.toUpperCase()));
			if (getState() == GunState.RELOADING) {
				String countdownString = gunState.substring("Reloading - ".length());
				setReloadCountdown(Integer.parseInt(countdownString));
			}
		}
		setAmount(stack.getAmount());
		return gun;
	}

	public int getLoadedBullets() {
		return loadedBullets;
	}

	public void setLoadedBullets(int loadedBullets) {
		if (getState() == GunState.EMPTY && loadedBullets > 0) {
			setState(GunState.LOADED);
		}
		this.loadedBullets = loadedBullets;
		if (this.loadedBullets > getGun().getData().getMagazineSize()) {
			this.loadedBullets = getGun().getData().getMagazineSize();
		}
		if (this.loadedBullets <= 0) {
			this.loadedBullets = 0;
			this.state = GunState.EMPTY;
		}
	}

	public Gun getGun() {
		return gun;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public boolean canFire(Player player) {
		return getLoadedBullets() > 0 && getState() != GunState.RELOADING && GunManager.getInstance().getGunCooldown(player, gun) == 0;
	}

	public GunStack reload() {
		setReloadCountdown(getGun().getData().getReloadTime());
		setState(GunState.RELOADING);
		return this;
	}

	public GunState getState() {
		return state;
	}

	public void setState(GunState state) {
		this.state = state;
	}

	public boolean isFull() {
		return this.loadedBullets >= getGun().getData().getMagazineSize();
	}

	public int getReloadCountdown() {
		return reloadCountdown;
	}

	public void setReloadCountdown(int reloadCountdown) {
		this.reloadCountdown = reloadCountdown;
		if (getState() == GunState.RELOADING) {
			if (reloadCountdown <= 0) {
				setLoadedBullets(getGun().getData().getMagazineSize());
				setState(GunState.LOADED);
			}
		}
	}

}
