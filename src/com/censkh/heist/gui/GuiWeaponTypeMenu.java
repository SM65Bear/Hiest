package com.censkh.heist.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.censkh.heist.gun.WeaponType;

public class GuiWeaponTypeMenu extends GuiAdminSubmenu {

	public GuiWeaponTypeMenu() {
		super("Weapons");
	}

	@Override
	public List<GuiIcon> initIcons() {
		List<GuiIcon> icons = new ArrayList<GuiIcon>();
		int i = 0;
		for (WeaponType t : WeaponType.values()) {
			final WeaponType type = t;

			icons.add(new GuiIcon(type.getName(), new ItemStack(type.getType()), i) {

				@Override
				public void run(Player player) {
					GuiMenuManager.getInstance().getMenu(type.getName()).open(player);

				}
			});
			i++;
		}
		return icons;
	}

	@Override
	public int getSize() {
		return 9 * 6;
	}

}
