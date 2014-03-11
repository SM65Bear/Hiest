package com.censkh.heist.drug;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import com.censkh.heist.BuffData;

public class DrugManager {

	private static DrugManager instance;
	private final List<Drug> drugs = new ArrayList<Drug>();

	public DrugManager() {
		instance = this;

		addDrug(new Drug(600, "Cocane", new ItemStack(Material.SUGAR), new DrugData() {
			{
				addBuff(new BuffData(PotionEffectType.SPEED, 20 * 3, 0));
			}
		}));
		addDrug(new Drug(601, "Crack", new ItemStack(Material.SUGAR), new DrugData() {
			{
				addBuff(new BuffData(PotionEffectType.SPEED, 20 * 3, 0));
			}
		}));
		addDrug(new Drug(602, "Canabis", new ItemStack(Material.SUGAR), new DrugData() {
			{
				addBuff(new BuffData(PotionEffectType.SPEED, 20 * 3, 0));
			}
		}));
		addDrug(new Drug(603, "Herobrine/Heroin", new ItemStack(Material.SUGAR), new DrugData() {
			{
				addBuff(new BuffData(PotionEffectType.SPEED, 20 * 3, 0));
			}
		}));

	}

	public Drug addDrug(Drug drug) {
		drugs.add(drug);
		return drug;
	}

	public static DrugManager getInstance() {
		return instance;
	}

	public static void setInstance(DrugManager instance) {
		DrugManager.instance = instance;
	}

	public List<Drug> getDrugs() {
		return drugs;
	}

	public Drug getDrug(ItemStack stack) {
		for (Drug drug : getDrugs()) {
			if (drug.isStack(stack)) {
				return drug;
			}
		}
		return null;
	}

	public Drug getDrug(String name) {
		for (Drug drug : getDrugs()) {
			if (drug.getName().equals(name)) {
				return drug;
			}
		}
		return null;
	}

}
