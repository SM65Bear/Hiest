package com.censkh.heist;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ItemUtil {

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
		md = -1;
		durabilityValues.put(Material.SHEARS, 239);
		durabilityValues.put(Material.CARROT_STICK, 26);
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

	public static boolean isSimilar(ItemStack stack, ItemStack other) {
		if (stack.getItemMeta().hasLore() || other.getItemMeta().hasLore()) {
			if (stack.getItemMeta().hasLore() && other.getItemMeta().hasLore()) {
				return stack.getItemMeta().getLore().get(stack.getItemMeta().getLore().size() - 1).equals(other.getItemMeta().getLore().get(other.getItemMeta().getLore().size() - 1));
			}
			return false;
		}
		if (stack.getItemMeta().hasDisplayName() || other.getItemMeta().hasDisplayName()) {
			if (stack.getItemMeta().hasDisplayName() && other.getItemMeta().hasDisplayName()) {
				return stack.getItemMeta().getDisplayName().equals(other.getItemMeta().getDisplayName());
			}
			return false;
		}
		return stack.getType() == other.getType();
	}

	public static int getItemCount(Inventory inventory, ItemStack stack) {
		int i = 0;
		for (ItemStack s : inventory.all(stack.getType()).values()) {
			if (isSimilar(stack, s)) {
				i += s.getAmount();
			}
		}
		return i;
	}
}
