package com.censkh.heist.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import com.censkh.heist.drug.Drug;
import com.censkh.heist.drug.DrugManager;
import com.censkh.heist.gui.GuiMenuManager;
import com.censkh.heist.gun.Gun;
import com.censkh.heist.gun.GunManager;
import com.censkh.heist.gun.GunStack;
import com.censkh.heist.throwable.Throwable;
import com.censkh.heist.throwable.ThrowableManager;

public class PlayerEventListener extends EventListener {

	@EventHandler
	public void onPlayerDropItemEvent(PlayerDropItemEvent event) {
		Gun gun = GunManager.getInstance().getGun(event.getItemDrop().getItemStack());
		if (gun != null) {
			GunStack stack = new GunStack(event.getItemDrop().getItemStack());
			if (!stack.isFull()) {
				event.getPlayer().setItemInHand(stack.reload(event.getPlayer()).write(event.getItemDrop().getItemStack()));
				event.getItemDrop().remove();
			} else {
			}
		}
	}

	@EventHandler
	public void onPlayerItemHeldEvent(PlayerItemHeldEvent event) {
		if (event.getNewSlot() != event.getPreviousSlot()) {
			GunManager.getInstance().setZoomed(event.getPlayer(), false);
		}
	}

	@EventHandler
	public void onPlayerToggleSneakEvent(PlayerToggleSneakEvent event) {
		if (event.getPlayer().isSneaking()) {
			if (event.getPlayer().getItemInHand() != null) {
				Gun gun = GunManager.getInstance().getGun(event.getPlayer().getItemInHand());
				if (gun != null) {
					GunStack stack = new GunStack(event.getPlayer().getItemInHand());
					gun.getData().useSecondary(event.getPlayer(), stack);
				}
			}
		}
	}

	@EventHandler
	public void onPlayerInteractEntityEvent(PlayerInteractEntityEvent event) {
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

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerInteractEvent(PlayerInteractEvent event) {
		if (event.getItem() != null) {
			Gun gun = GunManager.getInstance().getGun(event.getItem());
			if (gun != null) {
				event.setCancelled(true);
				event.setUseInteractedBlock(Result.DENY);
				event.setUseItemInHand(Result.DENY);
				if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
					event.getPlayer().setItemInHand(gun.shoot(event.getPlayer(), event.getItem()));
					event.getPlayer().updateInventory();
				} else {
					GunManager.getInstance().setZoomed(event.getPlayer(), !GunManager.getInstance().isZoomed(event.getPlayer()));
				}
			} else {
				Throwable throwable = ThrowableManager.getInstance().getThrowable(event.getItem());
				if (throwable != null) {
					event.setCancelled(true);
					event.setUseInteractedBlock(Result.DENY);
					event.setUseItemInHand(Result.DENY);
					throwable.shoot(event.getPlayer());
					event.getPlayer().getInventory().removeItem(throwable.getStack());
				} else {
					Drug drug = DrugManager.getInstance().getDrug(event.getItem());
					if (drug != null) {
						event.setCancelled(true);
						event.setUseInteractedBlock(Result.DENY);
						event.setUseItemInHand(Result.DENY);
						drug.apply(event.getPlayer());
						event.getPlayer().getInventory().removeItem(drug.getStack());
					}
				}
			}
		}
	}

}
