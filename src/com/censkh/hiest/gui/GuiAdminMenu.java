package com.censkh.hiest.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GuiAdminMenu extends GuiMenu {

	public GuiAdminMenu() {
		super("" + ChatColor.WHITE + "The Hiest " + ChatColor.AQUA + "$" + ChatColor.YELLOW + " [Panel]");
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
		icons.add(new GuiIcon("Money", new ItemStack(Material.GOLD_INGOT)) {

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
		icons.add(new GuiIcon("Whitty_Likes_Men", new ItemStack(Material.SKULL)) {

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
