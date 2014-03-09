package com.censkh.hiest.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

import com.censkh.hiest.gun.Gun;
import com.censkh.hiest.gun.GunManager;
import com.censkh.hiest.gun.GunType;

public class GuiMenuManager {

	private static GuiMenuManager instance;
	private final List<GuiMenu> menus = new ArrayList<GuiMenu>();

	public final GunTypeMenu GUN_TYPE = (GunTypeMenu) addMenu(new GunTypeMenu());
	public final GuiAdminMenu ADMIN = (GuiAdminMenu) addMenu(new GuiAdminMenu());

	public GuiMenuManager() {
		instance = this;
		for (GunType t : GunType.values()) {
			final GunType type = t; 
			addMenu(new GuiMenu(type.getName()) {
				
				@Override
				public List<GuiIcon> initIcons() {
					List<GuiIcon> icons = new ArrayList<GuiIcon>();
					for (Gun g : GunManager.getInstance().getGuns()) {
						final Gun gun = g;
						if (gun.getData().getType() == type) {
							icons.add(new GuiIcon(gun.getName(), gun.getStack()) {

								@Override
								public void run(Player player) {
									player.getInventory().addItem(
											gun.getStack());
								}
							});
						}
					}
					return icons;
				}

				@Override
				public int getSize() {

					return (9 * 6);
				}
			});

		}

	}

	private GuiMenu addMenu(GuiMenu menu) {
		getMenus().add(menu);
		return menu;
	}

	public static GuiMenuManager getInstance() {
		return instance;
	}

	public List<GuiMenu> getMenus() {
		return menus;
	}

	public GuiMenu getMenu(String name) {
		for (GuiMenu menu : getMenus()) {
			if (menu.getName().equals(name)) {
				return menu;
			}
		}
		return null;
	}

}
