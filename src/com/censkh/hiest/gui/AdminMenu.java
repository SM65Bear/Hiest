package com.censkh.hiest.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.censkh.hiest.gun.Gun;
import com.censkh.hiest.gun.GunManager;
import com.censkh.hiest.gun.GunType;

public class AdminMenu extends GuiMenu {

	public AdminMenu() {
		super("Admin Menu");
	}

	@Override
	public List<GuiIcon> initIcons() {
		List<GuiIcon> icons = new ArrayList<GuiIcon>();
		for (GunType t: GunType.values()){
			final GunType type = t;
			
			icons.add(new GuiIcon(type.name(), new ItemStack(Material.GOLD_AXE)) {
				
				@Override
				public void run(Player player) {
					GuiMenuManager.getInstance().getMenu(type.name()).open(player);
					
				}
			});
			
		}
		return icons;
	}

	@Override
	public int getSize() {
		return 9*6;
	}

}
