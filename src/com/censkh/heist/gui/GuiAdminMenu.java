package com.censkh.heist.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GuiAdminMenu extends GuiMenu {

	public GuiAdminMenu() {
		super("Admin");
	}

	@Override
	public List<GuiIcon> initIcons() {
		List<GuiIcon> icons = new ArrayList<GuiIcon>();
		icons.add(new GuiIcon("Guns", new ItemStack(Material.DIAMOND_SPADE), 2) {

			@Override
			public void run(Player player) {
				GuiMenuManager.getInstance().GUN_TYPE.open(player);
			}
		});
		icons.add(new GuiIcon("Money", new ItemStack(Material.GOLD_INGOT), 3) {

			@Override
			public void run(Player player) {

			}
		});
		icons.add(new GuiIcon("Warps", new ItemStack(Material.PORTAL), 4) {

			@Override
			public void run(Player player) {

			}
		});
		icons.add(new GuiIcon("Ammo", new ItemStack(Material.EGG), 5) {

			@Override
			public void run(Player player) {
				GuiMenuManager.getInstance().AMMO_TYPE.open(player);

			}
		});
		icons.add(new GuiIcon("Armour", new ItemStack(Material.LEATHER_HELMET), 7) {

			@Override
			public void run(Player player) {
				GuiMenuManager.getInstance().ARMOUR_TYPE.open(player);

			}
		});
		icons.add(new GuiIcon("Drugs", new ItemStack(Material.SUGAR), 6) {

			@Override
			public void run(Player player) {
				GuiMenuManager.getInstance().DRUG_TYPE.open(player);

			}
		});
		return icons;
	}

	@Override
	public int getSize() {
		return 9 * 6;
	}

}
