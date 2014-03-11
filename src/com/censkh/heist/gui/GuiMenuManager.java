package com.censkh.heist.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.censkh.heist.gun.WeaponType;
import com.censkh.heist.item.ItemManager;
import com.censkh.heist.item.UniqueItem;
import com.censkh.heist.item.WeaponItem;

public class GuiMenuManager {

	private static GuiMenuManager instance;
	private final List<GuiMenu> menus = new ArrayList<GuiMenu>();

	public final GuiGunTypeMenu GUN_TYPE = (GuiGunTypeMenu) addMenu(new GuiGunTypeMenu());
	public final GuiItemGive ITEMS = (GuiItemGive) addMenu(new GuiItemGive());
	public final GuiAdminMenu ADMIN = (GuiAdminMenu) addMenu(new GuiAdminMenu());
	public final GuiBlackMarketGuns BLACK_MARKET_GUNS = (GuiBlackMarketGuns) addMenu(new GuiBlackMarketGuns());
	public final GuiBlackMarketArmour BLACK_MARKET_ARMOUR= (GuiBlackMarketArmour) addMenu(new GuiBlackMarketArmour());
	public final GuiBlackMarketDrugs BLACK_MARKET_DRUGS = (GuiBlackMarketDrugs) addMenu(new GuiBlackMarketDrugs());
	public final GuiBlackMarketMasks BLACK_MARKET_AGENT = (GuiBlackMarketMasks) addMenu(new GuiBlackMarketMasks());
	public final GuiArmourTypeMenu ARMOUR_TYPE = (GuiArmourTypeMenu) addMenu(new GuiArmourTypeMenu());
	public final GuiAmmoTypeMenu AMMO_TYPE = (GuiAmmoTypeMenu) addMenu(new GuiAmmoTypeMenu());
	public final GuiDrugTypeMenu DRUG_TYPE = (GuiDrugTypeMenu) addMenu(new GuiDrugTypeMenu());

	public GuiMenuManager() {
		instance = this;
		for (WeaponType t : WeaponType.values()) {
			final WeaponType type = t;
			addMenu(new GuiMenu(type.getName()) {

				@Override
				public List<GuiIcon> initIcons() {
					List<GuiIcon> icons = new ArrayList<GuiIcon>();
					int i = 0;
					for (UniqueItem item : ItemManager.getInstance().getItems()) {
						if (item instanceof WeaponItem) {
							final WeaponItem w = (WeaponItem) item;
							if (w.getWeaponType() == type) {
								icons.add(new GuiIcon(w.getName(), w.getStack(), i) {

									@Override
									public void run(Player player) {
										player.getInventory().addItem(w.getStack());
									}
								});
								i++;
							}
						}
					}
					icons.add(new GuiIcon("Back", new ItemStack(Material.ARROW), getSize() - 1) {

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
