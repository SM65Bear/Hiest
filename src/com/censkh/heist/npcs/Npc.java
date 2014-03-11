package com.censkh.heist.npcs;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import com.censkh.heist.gui.GuiMenuManager;
import com.censkh.heist.listener.EventListener;

public class Npc extends EventListener {
	
	@EventHandler
	public void gunDealer(PlayerInteractEntityEvent event) {
		Entity entity = event.getRightClicked();
		if (entity instanceof LivingEntity) {
			LivingEntity e = (LivingEntity) entity;
			if (e.getCustomName() != null) {
				String name = ChatColor.stripColor(e.getCustomName());
				if (name.equalsIgnoreCase("Blackmarket Gun Dealer")) {
					GuiMenuManager.getInstance().BLACK_MARKET_GUNS.open(event.getPlayer());
				}
				event.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void armourDealer(PlayerInteractEntityEvent event) {
		Entity entity = event.getRightClicked();
		if (entity instanceof LivingEntity) {
			LivingEntity e = (LivingEntity) entity;
			if (e.getCustomName() != null) {
				String name = ChatColor.stripColor(e.getCustomName());
				if (name.equalsIgnoreCase("Blackmarket Armour Dealer")) {
					GuiMenuManager.getInstance().BLACK_MARKET_GUNS.open(event.getPlayer());
				}
				event.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void drugsDealer(PlayerInteractEntityEvent event) {
		Entity entity = event.getRightClicked();
		if (entity instanceof LivingEntity) {
			LivingEntity e = (LivingEntity) entity;
			if (e.getCustomName() != null) {
				String name = ChatColor.stripColor(e.getCustomName());
				if (name.equalsIgnoreCase("Blackmarket Drug Dealer")) {
					GuiMenuManager.getInstance().BLACK_MARKET_DRUGS.open(event.getPlayer());
				}
				event.setCancelled(true);
			}
		}
	}
	@EventHandler
	public void maskDealer(PlayerInteractEntityEvent event) {
		Entity entity = event.getRightClicked();
		if (entity instanceof LivingEntity) {
			LivingEntity e = (LivingEntity) entity;
			if (e.getCustomName() != null) {
				String name = ChatColor.stripColor(e.getCustomName());
				if (name.equalsIgnoreCase("Agent")) {
					GuiMenuManager.getInstance().BLACK_MARKET_AGENT.open(event.getPlayer());
				}
				event.setCancelled(true);
			}
		}
	}
}
