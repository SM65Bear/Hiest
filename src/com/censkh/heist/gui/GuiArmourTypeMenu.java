package com.censkh.heist.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.censkh.heist.item.ItemManager;
import com.censkh.heist.item.ItemType;
import com.censkh.heist.item.UniqueItem;

public class GuiArmourTypeMenu extends GuiAdminSubmenu {

	public GuiArmourTypeMenu() {
		super("Masks");
	}

	@Override
	public List<GuiIcon> initIcons() {
		List<GuiIcon> icons = new ArrayList<GuiIcon>();
		int i = 0;
		for (UniqueItem it : ItemManager.getInstance().getItems(ItemType.ARMOUR)) {
			final UniqueItem item = it;
			icons.add(new GuiIcon(item.getName(), new ItemStack(item.getStack()), i) {

				@Override
				public void run(Player player) {
					player.getInventory().addItem(item.getStack());
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
