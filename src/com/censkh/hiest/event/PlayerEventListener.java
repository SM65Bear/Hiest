package com.censkh.hiest.event;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Event.Result;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import com.censkh.hiest.gun.Gun;
import com.censkh.hiest.gun.GunManager;
import com.censkh.hiest.gun.GunStack;
import com.censkh.hiest.throwable.Throwable;
import com.censkh.hiest.throwable.ThrowableManager;

public class PlayerEventListener extends EventListener  {
	
	@EventHandler
	public void onPlayerDropItemEvent(PlayerDropItemEvent event) {
		Gun gun = GunManager.getInstance().getGun(event.getItemDrop().getItemStack());
		if (gun != null) {
			GunStack stack = new GunStack(event.getItemDrop().getItemStack());
			if (!stack.isFull()) {
				event.getPlayer().setItemInHand(stack.reload().write());
				event.getPlayer().sendMessage(ChatColor.GRAY + "Reloading...");
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
			if (event.getPlayer().getItemInHand()!=null) {
				Gun gun = GunManager.getInstance().getGun(event.getPlayer().getItemInHand());
				if (gun!=null) {
					GunStack stack = new GunStack(event.getPlayer().getItemInHand());
					gun.getData().useSecondary(event.getPlayer(), stack);
				}
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
				}
			}
		}
	}
	
}
