package com.censkh.heist.gun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.entity.Player;

public class GunManager {

	private static GunManager instance;
	private final HashMap<Player, List<GunCooldownTicket>> cooldowns = new HashMap<Player, List<GunCooldownTicket>>();
	private final List<Player> zoomed = new ArrayList<Player>();

	public GunManager() {
		instance = this;
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

	public static GunManager getInstance() {
		return instance;
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
