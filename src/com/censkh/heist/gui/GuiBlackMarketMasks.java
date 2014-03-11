package com.censkh.heist.gui;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class GuiBlackMarketMasks extends GuiStore {

	public GuiBlackMarketMasks() {
		super("Black Market Guns");
	}

	@Override
	public HashMap<ItemStack, Integer> initStore() {
		HashMap<ItemStack, Integer> store = new HashMap<ItemStack, Integer>();
		store.put(new ItemStack(Material.LEATHER_HELMET), 100);
		store.put(new ItemStack(Material.CHAINMAIL_HELMET), 140);
		store.put(new ItemStack(Material.IRON_HELMET), 175);
		store.put(new ItemStack(Material.DIAMOND_HELMET), 200);
		return store;
	}

	@Override
	public int getSize() {
		return 1 * 6;
	}

}
