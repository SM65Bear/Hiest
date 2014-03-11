package com.censkh.heist.listener;

import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import com.censkh.heist.drug.Drug;
import com.censkh.heist.gun.Gun;
import com.censkh.heist.gun.GunManager;
import com.censkh.heist.gun.GunStack;
import com.censkh.heist.item.ItemManager;
import com.censkh.heist.item.ItemType;
import com.censkh.heist.item.UniqueItem;
import com.censkh.heist.throwable.Throwable;

public class PlayerEventListener extends EventListener {

	@EventHandler
	public void onPlayerDropItemEvent(PlayerDropItemEvent event) {
		UniqueItem item = ItemManager.getInstance().getItem(event.getItemDrop().getItemStack());
		if (item != null) {
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
				UniqueItem item = ItemManager.getInstance().getItem(event.getPlayer().getItemInHand());
				if (item != null) {
					Gun gun = (Gun) item;
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
			UniqueItem item = ItemManager.getInstance().getItem(event.getItem());
			if (item != null) {
				if (item.getType() == ItemType.GUN) {
					Gun gun = (Gun) item;
					event.setCancelled(true);
					event.setUseInteractedBlock(Result.DENY);
					event.setUseItemInHand(Result.DENY);
					if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
						event.getPlayer().setItemInHand(gun.shoot(event.getPlayer(), event.getItem()));
						event.getPlayer().updateInventory();
					} else {
						GunManager.getInstance().setZoomed(event.getPlayer(), !GunManager.getInstance().isZoomed(event.getPlayer()));
					}
				} else if (item.getType() == ItemType.THROWABLE) {
					Throwable throwable = (Throwable) item;
					event.setCancelled(true);
					event.setUseInteractedBlock(Result.DENY);
					event.setUseItemInHand(Result.DENY);
					throwable.shoot(event.getPlayer());
					event.getPlayer().getInventory().removeItem(throwable.getStack());
				} else if (item.getType() == ItemType.DRUG) {
					Drug drug = (Drug) item;
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
