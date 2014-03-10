package com.censkh.heist.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GuiItemGive extends GuiMenu {

	public GuiItemGive() {
		super("Items");
	}

	@Override
	public List<GuiIcon> initIcons() {
		List<GuiIcon> icons = new ArrayList<GuiIcon>();
		icons.add(new GuiIcon("Gapple", new ItemStack(Material.GOLDEN_APPLE), 2) {

			@Override
			public void run(Player player) {
				player.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE));
				player.sendMessage("You Gave Yourself a Golden Apple!");

			}
		});
		return icons;
	}

	@Override
	public int getSize() {
		return 9 * 6;
	}

}
