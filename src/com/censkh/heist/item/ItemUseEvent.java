package com.censkh.heist.item;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class ItemUseEvent extends Event implements Cancellable {

	private static final HandlerList handlers = new HandlerList();

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

	private boolean cancelled;
	private UniqueItem item;
	private final ItemUseType type;
	private final Player player;
	private ItemStack stack;
	private EntityDamageByEntityEvent damageEvent = null;

	public ItemUseEvent(UniqueItem item, ItemUseType type, Player player, ItemStack stack) {
		this.item = item;
		this.type = type;
		this.player = player;
		this.stack = stack;
	}

	@Override
	public boolean isCancelled() {
		return cancelled;
	}

	@Override
	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

	public UniqueItem getItem() {
		return item;
	}

	public void setItem(UniqueItem item) {
		this.item = item;
	}

	public ItemUseType getType() {
		return type;
	}

	public Player getPlayer() {
		return player;
	}

	public ItemStack getStack() {
		return stack;
	}

	public void setStack(ItemStack stack) {
		this.stack = stack;
	}

	public EntityDamageByEntityEvent getDamageEvent() {
		return damageEvent;
	}

	public void setDamageEvent(EntityDamageByEntityEvent damageEvent) {
		this.damageEvent = damageEvent;
	}

}
