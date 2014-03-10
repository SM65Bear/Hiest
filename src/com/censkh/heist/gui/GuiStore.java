package com.censkh.heist.gui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public abstract class GuiStore extends GuiMenu {

	private HashMap<Integer, GuiShopIcon> store;

	public GuiStore(String name) {
		super(name);

	}

	public abstract HashMap<ItemStack, Integer> initStore();

	@Override
	public List<GuiIcon> initIcons() {
		List<GuiIcon> icons = new ArrayList<GuiIcon>();
		HashMap<ItemStack, Integer> store = initStore();
		int i = 0;
		for (ItemStack s : store.keySet()) {
			final ItemStack stack = s.clone();
			final String name;
			if (stack.getItemMeta().hasDisplayName()) {
				name = stack.getItemMeta().getDisplayName();
			} else {
				name = stack.getType().name().substring(0, 1) + stack.getType().name().substring(1).toLowerCase();
			}
			final int price = store.get(stack);
			if (this.store == null) {
				this.store = new HashMap<Integer, GuiShopIcon>();
			}
			GuiIcon icon = new GuiIcon("Buy " + ChatColor.stripColor(name) + " ($" + price + ")", stack, i) {

				@Override
				public void run(Player player) {
					player.getInventory().addItem(stack);
					player.sendMessage("You have bought a " + name + ".");
				}
			};
			icons.add(icon);
			this.store.put(i, new GuiShopIcon(icon, stack, price));
			i++;
		}
		return icons;
	}

	public HashMap<Integer, GuiShopIcon> getStore() {
		return store;
	}

}
