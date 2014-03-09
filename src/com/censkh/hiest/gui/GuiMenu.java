package com.censkh.hiest.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import com.censkh.hiest.event.EventListener;

public abstract class GuiMenu extends EventListener {

	private final List<GuiIcon> icons = new ArrayList<GuiIcon>();
	private final String name;
	private Inventory inventory;

	public GuiMenu(String name) {
		this.name = name;
		this.icons.addAll(initIcons());
	}

	public abstract List<GuiIcon> initIcons();

	public abstract int getSize();

	public void open(Player player) {
		player.openInventory(getInventory());
	}

	private Inventory getInventory() {
		if (inventory == null) {
			inventory = Bukkit.createInventory(null, getSize(), getName());
			for (GuiIcon icon : getIcons()) {
				inventory.setItem(icon.getSlot(),icon.getStack());
			}
		}
		return inventory;
	}

	public List<GuiIcon> getIcons() {
		return icons;
	}

	public String getName() {
		return name;
	}

	public boolean isInventory(Inventory inventory) {
		if (inventory.getName().equals(getName())) {
			return true;
		}
		return false;
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		Inventory inventory = event.getView().getTopInventory();
		if (isInventory(event.getInventory())) {
			event.setResult(Result.DENY);
			if (event.getRawSlot() < inventory.getSize()) {

				if (event.getCurrentItem() != null) {
					if (event.getCurrentItem().getType() != Material.AIR) {
						if (isInventory(inventory)) {
							GuiIcon icon = getIcon(event.getRawSlot());
							if (icon != null) {
								icon.run((Player) event.getWhoClicked());
							}
						}
					}
				}
			}
		}
	}

	public GuiIcon getIcon(int i) {
		return getIcons().get(i);
	}

}
