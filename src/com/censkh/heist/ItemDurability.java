package com.censkh.heist;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ItemDurability {

	private static final HashMap<Material, Integer> durabilityValues = new HashMap<Material, Integer>();

	static {
		int md = 1562;
		durabilityValues.put(Material.DIAMOND_AXE, md);
		durabilityValues.put(Material.DIAMOND_SWORD, md);
		durabilityValues.put(Material.DIAMOND_SPADE, md);
		durabilityValues.put(Material.DIAMOND_PICKAXE, md);
		durabilityValues.put(Material.DIAMOND_HOE, md);
		md = 251;
		durabilityValues.put(Material.IRON_AXE, md);
		durabilityValues.put(Material.IRON_SWORD, md);
		durabilityValues.put(Material.IRON_SPADE, md);
		durabilityValues.put(Material.IRON_PICKAXE, md);
		durabilityValues.put(Material.IRON_HOE, md);
		md = 132;
		durabilityValues.put(Material.STONE_AXE, md);
		durabilityValues.put(Material.STONE_SWORD, md);
		durabilityValues.put(Material.STONE_SPADE, md);
		durabilityValues.put(Material.STONE_PICKAXE, md);
		durabilityValues.put(Material.STONE_HOE, md);
		md = 60;
		durabilityValues.put(Material.WOOD_AXE, md);
		durabilityValues.put(Material.WOOD_SWORD, md);
		durabilityValues.put(Material.WOOD_SPADE, md);
		durabilityValues.put(Material.WOOD_PICKAXE, md);
		durabilityValues.put(Material.WOOD_HOE, md);
		md = 33;
		durabilityValues.put(Material.GOLD_AXE, md);
		durabilityValues.put(Material.GOLD_SWORD, md);
		durabilityValues.put(Material.GOLD_SPADE, md);
		durabilityValues.put(Material.GOLD_PICKAXE, md);
		durabilityValues.put(Material.GOLD_HOE, md);
	}

	public static ItemStack setDurability(ItemStack stack, float d) {
		int maxDur = getMaxDurability(stack.getType());
		short dur = (short) (Math.floor(maxDur * d));
		stack.setDurability((short) (maxDur - dur));
		return stack;
	}

	public static int getMaxDurability(Material material) {
		if (durabilityValues.containsKey(material)) {
			return durabilityValues.get(material);
		}
		return 0;
	}

	public static HashMap<Material, Integer> getDurabilityValues() {
		return durabilityValues;
	}

}
