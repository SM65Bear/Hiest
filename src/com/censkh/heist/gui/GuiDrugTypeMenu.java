package com.censkh.heist.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.censkh.heist.drug.Drug;
import com.censkh.heist.drug.DrugManager;

public class GuiDrugTypeMenu extends GuiMenu {

	public GuiDrugTypeMenu() {
		super("Drugs");
	}

	@Override
	public List<GuiIcon> initIcons() {
		List<GuiIcon> icons = new ArrayList<GuiIcon>();
		int i = 0;
		for (Drug d : DrugManager.getInstance().getDrugs()) {
			final Drug drug = d;

			icons.add(new GuiIcon(drug.getName(), new ItemStack(drug.getStack()), i) {

				@Override
				public void run(Player player) {
					player.getInventory().addItem(drug.getStack());
				}
			});
			i++;
			icons.add(new GuiIcon("Back", new ItemStack(Material.ARROW), getSize() - 1) {

				@Override
				public void run(Player player) {
					GuiMenuManager.getInstance().ADMIN.open(player);
				}
			});
		}
		return icons;
	}

	@Override
	public int getSize() {
		return 9 * 6;
	}

}
