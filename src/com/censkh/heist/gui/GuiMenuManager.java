package com.censkh.heist.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.censkh.heist.gun.Gun;
import com.censkh.heist.gun.GunManager;
import com.censkh.heist.gun.ItemType;
import com.censkh.heist.throwable.Throwable;
import com.censkh.heist.throwable.ThrowableManager;

public class GuiMenuManager {

	private static GuiMenuManager instance;
	private final List<GuiMenu> menus = new ArrayList<GuiMenu>();

	public final GunTypeMenu GUN_TYPE = (GunTypeMenu) addMenu(new GunTypeMenu());
	public final GuiItemGive ITEMS = (GuiItemGive) addMenu(new GuiItemGive());
	public final GuiAdminMenu ADMIN = (GuiAdminMenu) addMenu(new GuiAdminMenu());

	public GuiMenuManager() {
		instance = this;
		for (ItemType t : ItemType.values()) {
			final ItemType type = t;
			addMenu(new GuiMenu(type.getName()) {

				@Override
				public List<GuiIcon> initIcons() {
					List<GuiIcon> icons = new ArrayList<GuiIcon>();
					int i = 0;
					for (Gun g : GunManager.getInstance().getGuns()) {
						final Gun gun = g;
						if (gun.getData().getType() == type) {
							icons.add(new GuiIcon(gun.getName(), gun.getStack(), i) {

								@Override
								public void run(Player player) {
									player.getInventory().addItem(gun.getStack());
								}
							});
							i++;
						}
					}
					for (Throwable t : ThrowableManager.getInstance().getThrowables()) {
						final Throwable throwable = t;
						if (throwable.getType() == type) {
							icons.add(new GuiIcon(throwable.getName(), throwable.getStack(), i) {

								@Override
								public void run(Player player) {
									player.getInventory().addItem(throwable.getStack());
								}
							});
							i++;
						}
					}
					icons.add(new GuiIcon("Back",new ItemStack(Material.ARROW),getSize()-1) {
						
						@Override
						public void run(Player player) {
							GuiMenuManager.getInstance().GUN_TYPE.open(player);
						}
					});
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
