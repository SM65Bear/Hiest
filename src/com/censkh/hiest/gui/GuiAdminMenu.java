package com.censkh.hiest.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GuiAdminMenu extends GuiMenu {

	public GuiAdminMenu() {
		super("" + ChatColor.WHITE + ChatColor.BOLD + "The Hiest " + ChatColor.AQUA + ChatColor.BOLD + "$" + ChatColor.YELLOW + " [Panel]");
	}

	@Override
	public List<GuiIcon> initIcons() {
		List<GuiIcon> icons = new ArrayList<GuiIcon>();
		icons.add(new GuiIcon("Gun Menu", new ItemStack(Material.DIAMOND_SPADE)) {

			@Override
			public void run(Player player) {
				GuiMenuManager.getInstance().GUN_TYPE.open(player);
			}
		});
		icons.add(new GuiIcon("Money", new ItemStack(Material.DIAMOND_SPADE)) {

			@Override
			public void run(Player player) {
				GuiMenuManager.getInstance().GUN_TYPE.open(player);
			}
		});
		icons.add(new GuiIcon("Warps", new ItemStack(Material.PORTAL)) {

			@Override
			public void run(Player player) {

			}
		});
		return icons;
	}

	@Override
	public int getSize() {
		return 9 * 6;
	}

}
